package com.example.luckyticket_kotlin

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun check(view: View){
        val ticket = findViewById<EditText>(R.id.digits).text
        val bulb = findViewById<ImageView>(R.id.bulb)

        val green = getDrawable(R.drawable.ic_green_bulb)
        val red = getDrawable(R.drawable.ic_red_bulb)

        var left = 0
        var right = 0

        if (ticket.length == 6){

            left = ticket.subSequence(0, 3).sumOf { it.code }
            right = ticket.subSequence(3, 6).sumOf { it.code }
            /*for (i in ticket.indices){
                if(i < 3) {
                    left += ticket[i].code
                } else{
                    right += ticket[i].code
                }
            }*/
            if(left == right){
                bulb.setImageDrawable(green)
                Toast.makeText(applicationContext, "Lucky", Toast.LENGTH_LONG).show()
            }
            else{
                bulb.setImageDrawable(red)
                Toast.makeText(applicationContext, "Unlucky", Toast.LENGTH_LONG).show()
            }
        }
        else{
            Toast.makeText(applicationContext, "Something went wrong. Try again!", Toast.LENGTH_LONG).show()
        }

    }
}