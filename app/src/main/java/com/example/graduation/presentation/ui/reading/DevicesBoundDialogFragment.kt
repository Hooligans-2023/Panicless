package com.example.graduation.presentation.ui.reading

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.example.graduation.R
import com.example.graduation.base.ParentDialogFragment
import com.example.graduation.databinding.DialogDevicesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DevicesBoundDialogFragment(
    layoutId: Int = R.layout.dialog_devices,
    val bluetoothDevice: List<BluetoothDevice>
) : ParentDialogFragment<DialogDevicesBinding>(layoutId) {
    private val TAG = "DevicesBoundDialogFragm"
    override val bindingInflater: (LayoutInflater) -> DialogDevicesBinding
        get() = DialogDevicesBinding::inflate
    override val cancellable: Boolean
        get() = true
    override val listener: DialogInterface.OnCancelListener?
        get() = null
    override val dismiss: DialogInterface.OnDismissListener?
        get() = null
    private val bluetoothDevicesAdapter by lazy { BluetoothDevicesAdapter(this@DevicesBoundDialogFragment.requireContext()) }

    private lateinit var mListener: (bluetoothDevice:BluetoothDevice)->Unit


    @SuppressLint("MissingPermission")
    override fun initializeComponents(view: View) {

        binding.apply {
            recycleDevices.apply {
                adapter = bluetoothDevicesAdapter

            }

        }
        bluetoothDevicesAdapter.differ.submitList(bluetoothDevice)
        bluetoothDevicesAdapter.setOnItemClickListener { bluetoothDevice ->
            Log.d(TAG, "initializeComponents: ${bluetoothDevice.name}")
            mListener.invoke(bluetoothDevice)
            dismissAllowingStateLoss()

        }
    }

    fun setOnItemSelectedListener(listener: (bluetoothDevice:BluetoothDevice)->Unit) {
        mListener = listener
    }

}