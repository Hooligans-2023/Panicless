package com.example.graduation.presentation.ui.reading

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.graduation.base.BaseFragment
import com.example.graduation.databinding.FragmentReadingBinding
import com.example.graduation.presentation.ui.ProfileDirections
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
class Reading : Fragment() {
    private val binding by lazy {
        FragmentReadingBinding.inflate(layoutInflater)
    }
    private var panicAttackDialogFragment: PanicAttackDialogFragment? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        startTimer()

        panicAttackDialogFragment =
            PanicAttackDialogFragment()

        panicAttackDialogFragment?.setOnConfirmListener {
            findNavController().navigate(ReadingDirections.actionReadingToRelief())
        }

        panicAttackDialogFragment?.setOnCancelListener {
            panicAttackDialogFragment?.dismiss()
        }
        return binding.root
    }


    private fun startTimer() {
        // Set the desired duration for the timer in milliseconds
        val duration: Long = 20000 // 20 seconds

        // Create a new CountDownTimer
        val timer: CountDownTimer = object : CountDownTimer(duration, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Update the TextView with the remaining time
                val seconds = millisUntilFinished / 1000
                val time = String.format("%02d:%02d", seconds / 60, seconds % 60)
            }

            override fun onFinish() {
                // Update the TextView when the timer finishes
                binding.textNumHeart.setText("100")
                binding.textViewBreathing.setText("Heavy Breathing")
                binding.textViewtrmbing.setText("danger")
                panicAttackDialogFragment?.show(
                    childFragmentManager,
                    "panicAttackDialogFragment"
                )
            }
        }

        // Start the timer
        timer.start()
    }
}