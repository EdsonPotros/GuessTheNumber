package arvizu.edson.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var minValue = 0
    var maxValue = 100
    var num:  Int = 0
    var won = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guess: TextView = findViewById(R.id.guess)
        val down: Button = findViewById(R.id.down)
        val up: Button = findViewById(R.id.up)
        val generate: Button = findViewById(R.id.generate)
        val guessed: Button = findViewById(R.id.guessed)

        generate.setOnClickListener {
            num = Random.nextInt(minValue, maxValue)
            guess.setText(num.toString())
            generate.visibility = View.INVISIBLE
            guessed.visibility = View.VISIBLE
        }

        up.setOnClickListener {
            minValue = num
            if(checkingLimits()){
                num = Random.nextInt(minValue, maxValue)
                guess.setText(num.toString())
            }else{
                guess.setText("No puede ser me ganaste")
            }
        }

        down.setOnClickListener{
            maxValue = num
            if(checkingLimits()){
                num = Random.nextInt(minValue, maxValue)
                guess.setText(num.toString())
            }else{
                guess.setText("No puede ser me ganaste")
            }
        }

        guessed.setOnClickListener {
            if (!won) {
                guess.setText("Adiviné!! tu numero es el " + num)
                guess.setText("Play again")
                won = true
            }else{
                generate.visibility = View.VISIBLE
                guess.setText("Tap on generate to start")
                guessed.setText("Guessed")
                guessed.visibility = View.GONE
                resetValues()
            }
        }

    }

    fun resetValues(){
        minValue=0
        maxValue=100
        num=0
        won=false
    }

    fun checkingLimits(): Boolean{
        return minValue!=maxValue
    }


}