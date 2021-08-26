package com.example.luckyticket_kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        const val MAX_NUMBER_OF_DIGITS = 6
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCheckNumber = findViewById<Button>(R.id.btnCheckNumber)
        btnCheckNumber.setOnClickListener{
            checkTicket()
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun checkTicket(){
        val ticket = findViewById<EditText>(R.id.etTicketNumber).text
        val bulb = findViewById<ImageView>(R.id.imgBulb)

        val green = getDrawable(R.drawable.ic_green_bulb)
        val red = getDrawable(R.drawable.ic_red_bulb)

        if (ticket.length == MAX_NUMBER_OF_DIGITS){

            val left = ticket.subSequence(0, 3).sumOf { it.code }
            val right = ticket.subSequence(3, 6).sumOf { it.code }
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
            Toast.makeText(applicationContext, "Too short. Enter 6 digits", Toast.LENGTH_LONG).show()
        }

    }

}