package com.example.graduation.presentation.ui

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothProfile
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanFilter
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorManager
import android.net.wifi.ScanResult
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import com.example.graduation.base.BaseFragment
import com.example.graduation.databinding.FragmentReadingBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class Reading : BaseFragment() {
    private val TAG = "ReadingScreen"
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

    private val requestCode = 1


    override fun getRootView(): View = binding.root


    override fun initVar() {
        checkBodySensorPermission()
    }

    override fun onEvent() {
    }

    override fun render() {
    }

    override fun navigate() {
    }

    override fun showEffect() {
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

    // Connect to the heart rate sensor
    private val bluetoothGattCallback = object : BluetoothGattCallback() {
        override fun onConnectionStateChange(gatt: BluetoothGatt?, status: Int, newState: Int) {
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                if (ActivityCompat.checkSelfPermission(
                        requireContext(),
                        Manifest.permission.BLUETOOTH_CONNECT
                    ) != PackageManager.PERMISSION_GRANTED
                ) {

                    return
                }
                gatt?.discoverServices()
            }
        }

        override fun onServicesDiscovered(gatt: BluetoothGatt?, status: Int) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                val heartRateService = gatt?.getService(UUID.fromString(HEART_RATE_SERVICE_UUID))
                val heartRateCharacteristic =
                    heartRateService?.getCharacteristic(
                        UUID.fromString(
                            HEART_RATE_CHARACTERISTIC_UUID
                        )
                    )
                if (heartRateCharacteristic != null) {
                   // gatt.setCharacteristicNotification(heartRateCharacteristic, true)
                }
            }
        }

        override fun onCharacteristicChanged(
            gatt: BluetoothGatt?,
            characteristic: BluetoothGattCharacteristic?
        ) {
            if (characteristic?.uuid == UUID.fromString(HEART_RATE_CHARACTERISTIC_UUID)) {
                val heartRate =
                    characteristic?.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT8, 1)
                Log.d(TAG, "Heart rate: $heartRate")
            }
        }
    }

    private fun connectToHeartRateSensor() {
        val bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        val bluetoothDevice = bluetoothAdapter.getRemoteDevice("heart_rate_sensor_mac_address")
        /* val bluetoothGatt = bluetoothDevice.connectGatt(requireContext(), false, bluetoothGattCallback)

        Log.d(TAG, "connectToHeartRateSensor: ${bluetoothGatt.device.name}")
    }

    // Handle the result of the permission request
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == PERMISSION_REQUEST_BODY_SENSORS && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            connectToHeartRateSensor()
        } else {

        }
    }*/


    }
}