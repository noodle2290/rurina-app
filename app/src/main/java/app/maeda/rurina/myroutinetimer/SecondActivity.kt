package app.maeda.rurina.myroutinetimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.core.view.isVisible
import app.maeda.rurina.myroutinetimer.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    private  lateinit var timer:CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        //MainActivityから"hour"というキーワードでhourTextをもらう
        val hour = intent.getLongExtra("hour",0)
        //hourTextの字をTextViewに反映させる
        binding.hourCountTextView.text = hour.toString().padStart(2, '0')

        //MainActivityから"minute"というキーワードでminuteTextをもらう
        val minute = intent.getLongExtra("minute",0)
        //minuteTextの字をTextViewに反映させる
        binding.minuteCountTextView.text = minute.toString().padStart(2, '0')

        //MainActivityから"second"というキーワードでsecondTextをもらう
        val second = intent.getLongExtra("second",0)
        //secondTextの字をTextViewに反映させる
        binding.secondCountTextView.text = second.toString().padStart(2, '0')

        var secondAll: Long = hour * 3600 + minute * 60 + second

        binding.stopButton.isVisible = false

        binding.startButton.setOnClickListener {
            binding.startButton.isVisible = false
            binding.stopButton.isVisible = true
            timer = object : CountDownTimer(secondAll * 1000, 1000) {
                override fun onFinish() {
                    binding.startButton.isVisible = true

                    secondAll = hour * 3600 + minute * 60 + second
                    binding.hourCountTextView.text = hour.toString().padStart(2, '0')
                    binding.minuteCountTextView.text = minute.toString().padStart(2, '0')
                    binding.secondCountTextView.text = second.toString().padStart(2, '0')
                }

                override fun onTick(millisUntilFinished: Long) {
                    secondAll--

                    binding.hourCountTextView.text = (secondAll / 3600).toString().padStart(2, '0')
                    binding.minuteCountTextView.text = ((secondAll % 3600) / 60).toString().padStart(2, '0')
                    binding.secondCountTextView.text = ((secondAll % 3600) % 60).toString().padStart(2, '0')
                }
            }
            timer.start()
        }

        binding.stopButton.setOnClickListener {
            binding.startButton.isVisible = true
            binding.stopButton.isVisible = false
            timer.cancel()
        }
    }
}

