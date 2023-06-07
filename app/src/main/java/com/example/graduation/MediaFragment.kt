package com.example.graduation
import android.content.res.AssetFileDescriptor
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.graduation.databinding.FragmentMediaBinding
import android.media.MediaPlayer
import android.widget.Toast
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.graduation.databinding.FragmentProfileBinding
import com.google.android.material.imageview.ShapeableImageView
import java.util.concurrent.TimeUnit

class MediaFragment : Fragment() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private val binding by lazy {
        FragmentMediaBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.breathing) // Replace with your audio file
        handler = Handler()
        runnable = Runnable { updateSeekBar() }

        binding.pause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                //playPauseButton.text = "Play"
            } else {
                mediaPlayer.start()
                //playPauseButton.text = "Pause"
                updateSeekBar()
            }
        }

        binding.seekBar.max = mediaPlayer.duration
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                handler.removeCallbacks(runnable)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (mediaPlayer.isPlaying) {
                    updateSeekBar()
                }
            }
        })
    }

    private fun updateSeekBar() {
        binding.seekBar.progress = mediaPlayer.currentPosition
        binding.tvPass.text = getTimeString(mediaPlayer.currentPosition.toLong())
        binding.tvDue.text = getTimeString(mediaPlayer.duration.toLong() - mediaPlayer.currentPosition.toLong())
        handler.postDelayed(runnable, 1000) // Update every second
    }

    private fun getTimeString(millis: Long): String {
        val minutes = TimeUnit.MILLISECONDS.toMinutes(millis)
        val seconds = TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(minutes)
        return String.format("%02d:%02d", minutes, seconds)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
        handler.removeCallbacks(runnable)
    }
}



