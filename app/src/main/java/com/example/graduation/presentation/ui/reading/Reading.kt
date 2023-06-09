package com.example.graduation.presentation.ui.reading

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.lifecycleScope
import com.example.graduation.base.BaseFragment
import com.example.graduation.databinding.FragmentReadingBinding
import com.example.graduation.util.serializable
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.lang.ref.WeakReference
import java.util.UUID

private val TAG = "ReadingScreen"

@AndroidEntryPoint
class Reading : BaseFragment() {
    private val binding by lazy {
        FragmentReadingBinding.inflate(layoutInflater)
    }
    val HEART_RATE_SERVICE_UUID = "0000180d-0000-1000-8000-00805f9b34fb"
    val HEART_RATE_CHARACTERISTIC_UUID = "00002a37-0000-1000-8000-00805f9b34fb"
    private val PERMISSION_REQUEST_BODY_SENSORS = 1
    private val permissions = arrayOf(
        Manifest.permission.BLUETOOTH,
        Manifest.permission.BLUETOOTH_ADMIN
    )

    private var devicesBoundDialogFragment: DevicesBoundDialogFragment? = null

    private lateinit var bluetoothAdapter: BluetoothAdapter
    private lateinit var devices: MutableList<BluetoothDevice>
    private lateinit var connectedThread: ConnectedThread
    private lateinit var handler: Handler

    private val REQUEST_ENABLE_BT = 1
    private val REQUEST_PERMISSION = 2
    override fun getRootView(): View = binding.root

    private val enableBluetoothLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == BluetoothAdapter.STATE_ON) {
                setupBluetooth()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Bluetooth activation cancelled",
                    Toast.LENGTH_SHORT
                ).show()
                requireActivity().finish()
            }
        }

    override fun initVar() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.BLUETOOTH_CONNECT
            ) == PackageManager.PERMISSION_DENIED
        ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.BLUETOOTH_CONNECT),
                    2
                )
                return
            }
        }
        requestBluetoothScanPermission()
        checkBodySensorPermission()
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

        if (!bluetoothAdapter.isEnabled) {
            Log.e(TAG, "getBTPairedDevices , Bluetoot not enabled")
            val pairedDevices = bluetoothAdapter.bondedDevices
            Log.d(
                TAG,
                "getBTPairedDevices , Paired devices count = " + pairedDevices.size
            )
            enableBluetooth()
        } else {
            setupBluetooth()
        }
        handler = MyHandler(this)

    }

    private fun enableBluetooth() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.BLUETOOTH_ADMIN
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.BLUETOOTH_ADMIN),
                BLUETOOTH_PERMISSION_REQUEST_CODE
            )
        } else {
            val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            enableBluetoothLauncher.launch(enableBluetoothIntent)
        }
    }

    @SuppressLint("MissingPermission")
    override fun onEvent() {


    }

    @SuppressLint("MissingPermission")
    fun onSelectDevice() {
        devicesBoundDialogFragment?.setOnItemSelectedListener {
            val device = it

            Log.d(TAG, "onEvent: ${device.name}")
            connectToDevice(device)
        }

    }

    override fun render() {
    }


    private fun checkBodySensorPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.BODY_SENSORS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.BODY_SENSORS),
                PERMISSION_REQUEST_BODY_SENSORS
            )
        }
    }


    private fun setupBluetooth() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_PERMISSION
            )
            return
        }

        devices = mutableListOf()


        lifecycleScope.launch(Dispatchers.IO) {
            val pairedDevices = bluetoothAdapter.bondedDevices
            withContext(Dispatchers.Main) {
                if (pairedDevices.isNotEmpty()) {
                    devices.addAll(pairedDevices)
                    devicesBoundDialogFragment =
                        DevicesBoundDialogFragment(bluetoothDevice = devices)

                    //binding.deviceListView.adapter?.notifyDataSetChanged()
                    Log.d(TAG, "setupBluetooth:devices $devices")
                    Log.d(TAG, "setupBluetooth:devices ${devices[0].name}")
                    if (devicesBoundDialogFragment?.isAdded == false)
                        devicesBoundDialogFragment?.show(
                            childFragmentManager,
                            "DevicesBoundDialogFragment"
                        )
                    onSelectDevice()
                } else {
                    Toast.makeText(requireContext(), "No paired devices found", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun connectToDevice(device: BluetoothDevice) {
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val socket = device.createRfcommSocketToServiceRecord(MY_UUID)
                bluetoothAdapter.cancelDiscovery()
                socket.connect()
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        requireContext(),
                        "Connected to ${device.name}",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d(TAG, "connectToDevice: ${device.name}")
                    manageConnectedSocket(socket)
                }
            } catch (e: IOException) {
                withContext(Dispatchers.Main) {
                    Log.e(TAG, "connectToDevice:Socket connection failed ")
                    Toast.makeText(requireContext(), "Socket connection failed", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }


    private fun disconnectFromDevice() {
        connectedThread.cancel()
//        binding.disconnectButton.isEnabled = false
    }

    private fun manageConnectedSocket(socket: BluetoothSocket) {
        connectedThread = ConnectedThread(socket)
        connectedThread.start()
//        binding.disconnectButton.isEnabled = true
        startSendData()
    }

    private fun startSendData() {
        sendResetCommand()
        connectedThread.write("1".toByteArray())
        sendResetCommand()

//        repeat (5){
//        connectedThread.write("0".toByteArray())
//        sendResetCommand()
//        connectedThread.write("1".toByteArray())
//            }
    }

    private fun requestBluetoothScanPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.BLUETOOTH_SCAN
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.BLUETOOTH_SCAN),
                BLUETOOTH_PERMISSION_REQUEST_CODE
            )
        } else {
            // Permission already granted
            startBluetoothScan()
        }
    }

    private fun startBluetoothScan() {

    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == BLUETOOTH_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
                startBluetoothScan()
            } else {
                // Permission denied
                Toast.makeText(
                    requireContext(),
                    "Bluetooth scan permission denied",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


    private inner class ConnectedThread(private val socket: BluetoothSocket) : Thread() {

        private val inputStream: InputStream = socket.inputStream
        private val outputStream: OutputStream = socket.outputStream
        private val buffer: ByteArray = ByteArray(1024)

        override fun run() {
            var numBytes: Int

            while (true) {
                try {
                    numBytes = inputStream.read(buffer)
                    val readMsg = handler.obtainMessage(MESSAGE_READ, numBytes, -1, buffer.clone())
                    readMsg.sendToTarget()
                } catch (e: IOException) {
                    requireActivity().runOnUiThread {
                        Toast.makeText(
                            requireContext(),
                            "Input stream disconnected",
                            Toast.LENGTH_SHORT
                        ).show()
                        //disconnectFromDevice()
                    }
                    break
                }
            }
        }

        fun write(data: ByteArray) {
            try {
                outputStream.write(data)
            } catch (e: IOException) {
                requireActivity().runOnUiThread {
                    Toast.makeText(
                        requireContext(),
                        "Error occurred when sending data",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        fun cancel() {
            try {
                socket.close()
            } catch (e: IOException) {
                Toast.makeText(requireContext(), "Socket close failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun navigate() {
    }

    override fun showEffect() {
    }

    companion object {
        private val MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
        private const val MESSAGE_READ = 0
        private const val BLUETOOTH_PERMISSION_REQUEST_CODE = 1

    }

    private class MyHandler(fragment: Reading) : Handler() {
        private val fragmentRef: WeakReference<Reading> = WeakReference(fragment)

        override fun handleMessage(msg: Message) {
            val fragment = fragmentRef.get()
            fragment?.let {
                if (msg.what == MESSAGE_READ) {
                    val readBuffer = msg.obj as ByteArray
                    val readMessage = String(readBuffer, 0, msg.arg1)
                    val result = readMessage.split(" ")
                    if (result.size > 2)
                        fragment.binding.textNumHeart.text = "${result[0]}"
                    Log.d(TAG, "handleMessage: $readMessage")
                }
            }
        }
    }

    private fun sendResetCommand() {
        val resetCommand = "RESET" // Replace "RESET" with the appropriate reset command

        if (::connectedThread.isInitialized) {
            connectedThread.write(resetCommand.toByteArray())
        }
    }
}