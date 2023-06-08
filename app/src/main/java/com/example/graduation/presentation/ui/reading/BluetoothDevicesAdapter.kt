package com.example.graduation.presentation.ui.reading

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.content.Context
import android.content.pm.PackageManager
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.graduation.base.ViewBindingVH
import com.example.graduation.databinding.ItemBluetoothDeviceBinding

class BluetoothDevicesAdapter
constructor(private val mContext: Context) :
    RecyclerView.Adapter<ViewBindingVH<ItemBluetoothDeviceBinding>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewBindingVH<ItemBluetoothDeviceBinding> =
        ViewBindingVH.create(parent, ItemBluetoothDeviceBinding::inflate)

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    @SuppressLint("SetTextI18n", "MissingPermission")
    override fun onBindViewHolder(
        holder: ViewBindingVH<ItemBluetoothDeviceBinding>, position: Int
    ) {
        val item = differ.currentList[position]
        holder.binding.apply {
            tvDeviceName.text = item.name
            tvDeviceName.setOnClickListener {
                mListener.invoke(item)
            }
        }

    }


    private lateinit var mListener: (bluetoothDevice:BluetoothDevice)->Unit

    fun setOnItemClickListener(listener: (bluetoothDevice:BluetoothDevice)->Unit) {
        mListener = listener
    }

    private val callBack = object : DiffUtil.ItemCallback<BluetoothDevice>() {
        override fun areItemsTheSame(oldItem: BluetoothDevice, newItem: BluetoothDevice): Boolean {
            return if (ActivityCompat.checkSelfPermission(
                    mContext,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return false
            } else
                oldItem.uuids.contentEquals(newItem.uuids)
        }

        override fun areContentsTheSame(
            oldItem: BluetoothDevice,
            newItem: BluetoothDevice
        ): Boolean {
            return oldItem == newItem
        }
    }
    var differ = AsyncListDiffer(this, callBack)


}

