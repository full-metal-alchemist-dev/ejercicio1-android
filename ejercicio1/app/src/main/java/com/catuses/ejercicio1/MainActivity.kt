package com.catuses.ejercicio1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val userInput = findViewById<TextView>(R.id.userInput)
        val passInput = findViewById<TextView>(R.id.passInput)
        var datos: String = ""
        var user: String = ""
        var pass: String = ""
        val button = findViewById<Button>(R.id.button)
        val rootView = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)

        button.setOnClickListener {
             user = userInput.text.toString()
             pass = passInput.text.toString()
            datos = "usurio: ["+user+"] "+" pass: ["+pass+"]"
            Snackbar.make(rootView, datos, Snackbar.LENGTH_SHORT).show()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}