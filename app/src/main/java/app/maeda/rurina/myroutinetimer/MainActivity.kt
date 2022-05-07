package app.maeda.rurina.myroutinetimer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pushButton: Button = findViewById(R.id.pushButton)
        //EditTextを使う準備
        val x: EditText = findViewById(R.id.x)
        //EditTextを使う準備
        val y: EditText = findViewById(R.id.y)
        //EditTextを使う準備
        val z: EditText = findViewById(R.id.z)



        //intentButtonクリック時にSecondActivityへ画面遷移
        pushButton.setOnClickListener {
            //x:EditTextに入れられた数字をhourTextと定義する
             val hourText = x.text.toString()
            if( x == null){
                var hourText = "00" }
            //y:EditTextに入れられた数字をminuteTextと定義する
            val minuteText = y.text.toString()
            //z:EditTextに入れられた数字をsecondTextと定義する
            val secondText = z.text.toString()



            //SecondActivityに画面遷移する準備
            val SecondPage = Intent(this, SecondActivity::class.java)
            //hourTextを”hour”というキーワードとしてSecondActivityに送る
            SecondPage.putExtra("hour", hourText)
            //minuteTextを”minute”というキーワードとしてSecondActivityに送る
            SecondPage.putExtra("minute", minuteText)
            //secondTextを”second”というキーワードとしてSecondActivityに送る
            SecondPage.putExtra("second", secondText)
            startActivity(SecondPage)}

    }
}








