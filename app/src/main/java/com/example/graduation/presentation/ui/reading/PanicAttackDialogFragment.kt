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
import com.example.graduation.databinding.DialogHavePanicBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PanicAttackDialogFragment(
    layoutId: Int = R.layout.dialog_have_panic,
) : ParentDialogFragment<DialogHavePanicBinding>(layoutId) {
    private val TAG = "PanicAttackDialogFra"
    override val bindingInflater: (LayoutInflater) -> DialogHavePanicBinding
        get() = DialogHavePanicBinding::inflate
    override val cancellable: Boolean
        get() = true
    override val listener: DialogInterface.OnCancelListener?
        get() = null
    override val dismiss: DialogInterface.OnDismissListener?
        get() = null

    private lateinit var onConfirmListener: () -> Unit
    private lateinit var onCancelListener: () -> Unit


    @SuppressLint("MissingPermission")
    override fun initializeComponents(view: View) {

        binding.run {
            tvConfirm.setOnClickListener {
                if (::onConfirmListener.isInitialized)
                    onConfirmListener.invoke()
            }

            tvCancel.setOnClickListener {
                if (::onCancelListener.isInitialized)
                    onCancelListener.invoke()
            }
        }

    }

    fun setOnConfirmListener(listener: () -> Unit) {
        onConfirmListener = listener
    }

    fun setOnCancelListener(listener: () -> Unit) {
        onCancelListener = listener
    }

}