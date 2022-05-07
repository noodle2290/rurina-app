package app.maeda.rurina.myroutinetimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //hourText: TextViewを使う準備
        val hourText: TextView = findViewById(R.id.hourText)
        //MainActivityから"hour"というキーワードでhourTextをもらう
        val hour = intent.getStringExtra("hour")
        Log.d(hour,"hour")
        //hourTextの字をTextViewに反映させる
        hourText.text = hour.toString()

        //minuteText: TextViewを使う準備
        val minuteText: TextView = findViewById(R.id.minuteText)
        //MainActivityから"minute"というキーワードでminuteTextをもらう
        val minute = intent.getStringExtra("minute")
        //minuteTextの字をTextViewに反映させる
        minuteText.text = minute.toString()

        //second: TextViewを使う準備
        val secondText: TextView = findViewById(R.id.secondText)
        //MainActivityから"second"というキーワードでsecondTextをもらう
        val second= intent.getStringExtra("second")
        //secondTextの字をTextViewに反映させる
        secondText.text = second.toString()

       //残り時間をセット
        var hoursTime:Int = hour!!.toInt()*3600000
        var minutesTime:Int = minute!!.toInt()*60000
        var secondsTime:Int = second!!.toInt()*1000
        var Time:Int = hoursTime+minutesTime+secondsTime
        //タイマーを設定する
//        val hoursTimer : CountDownTimer = object : CountDownTimer(hoursTime.toLong(),3600000)
//        val minutesTimer : CountDownTimer = object : CountDownTimer(minutesTime.toLong(),60000)
//        val secondsTimer : CountDownTimer = object : CountDownTimer(secondsTime.toLong(),1000)

    }
        //タイマーが終了するときに呼ばれる
        fun onFinish(){
       //ホーム画面に戻る
       //残り時間をリセットする


}
    }

