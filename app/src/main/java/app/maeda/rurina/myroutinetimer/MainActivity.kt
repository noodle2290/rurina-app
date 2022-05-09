package app.maeda.rurina.myroutinetimer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import app.maeda.rurina.myroutinetimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        //intentButtonクリック時にSecondActivityへ画面遷移
        binding.intentButton.setOnClickListener {
            //hour_input_text1に入れられた数字をhourTextと定義する

            val hourText = binding.hourInputText1.text.toString().toLongOrNull()
            //y:EditTextに入れられた数字をminuteTextと定義する
            val minuteText = binding.minuteInputText1.text.toString().toLongOrNull()
            //z:EditTextに入れられた数字をsecondTextと定義する
            val secondText = binding.secondInputText1.text.toString().toLongOrNull()



            //SecondActivityに画面遷移する準備
            val secondActivityIntent = Intent(this, SecondActivity::class.java)
            //hourTextを”hour”というキーワードとしてSecondActivityに送る
            secondActivityIntent.putExtra("hour", hourText)
            //minuteTextを”minute”というキーワードとしてSecondActivityに送る
            secondActivityIntent.putExtra("minute", minuteText)
            //secondTextを”second”というキーワードとしてSecondActivityに送る
            secondActivityIntent.putExtra("second", secondText)
            startActivity(secondActivityIntent)}
    }
}








