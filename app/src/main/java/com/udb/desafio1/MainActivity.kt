package com.udb.desafio1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

lateinit var Plus : Button
lateinit var Minus : Button
lateinit var Multiply : Button
lateinit var Divide : Button
lateinit var Value1 : EditText
lateinit var Value2 : EditText
lateinit var Result : EditText

class MainActivity : AppCompatActivity() {
    var No1 : Float? = 0f
    var No2 : Float? = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Plus = findViewById(R.id.plus)
        Minus = findViewById(R.id.minus)
        Multiply = findViewById(R.id.multiply)
        Divide = findViewById(R.id.divide)
        Value1 = findViewById(R.id.firstValue)
        Value2 = findViewById(R.id.secondValue)
        Result = findViewById(R.id.resultValue)

        Plus.setOnClickListener {
            try {
                No1 = Value1.text.toString().toFloat()
                No2 = Value2.text.toString().toFloat()
            }
            catch (e:Exception){
                Result.setText(e.message)
                return@setOnClickListener
            }

        }
    }


}

class Operations{
    fun Sum (val1: Float, val2 : Float) : Float {
        return val1 + val2;
    }

    fun Minus (val1: Float, val2 : Float) : Float {
        return val1 - val2;
    }

    fun Multiply (val1: Float, val2 : Float) : Float {
        return val1 * val2;
    }

    fun Divide (val1: Float, val2 : Float) : Float? {
        return if (val2 == 0f) null;
        else val1 / val2;
    }
}

