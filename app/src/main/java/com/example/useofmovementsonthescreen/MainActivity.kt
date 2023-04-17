package com.example.useofmovementsonthescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.MotionEventCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.my_textView).setOnTouchListener { v, event ->
            val DEBUG_TAG : String = "évènement de vue détecté"
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // L'utilisateur a touché la vue
                    Toast.makeText(this, "Vous avez touché la vue !", Toast.LENGTH_SHORT).show()
                    Log.d(DEBUG_TAG, "Vous avez touché la vue !")
                }
                MotionEvent.ACTION_MOVE -> {
                    // L'utilisateur déplace son doigt sur la vue
                    Toast.makeText(this, "Vous avez déplacé son doigt sur la vue !", Toast.LENGTH_SHORT).show()
                    Log.d(DEBUG_TAG, "Vous avez déplacé son doigt sur la vue !")
                }
                MotionEvent.ACTION_UP -> {
                    // L'utilisateur a relâché la vue
                    Toast.makeText(this, "Vous avez relâché la vue !", Toast.LENGTH_SHORT).show()
                    Log.d(DEBUG_TAG, "Vous avez relâché la vue !")
                }
            }
            true
        }


    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        val DEBUG_TAG : String = "évènement détecté"
        val action: Int = MotionEventCompat.getActionMasked(event)

        return when (action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d(DEBUG_TAG, "Action was DOWN")
                true
            }
            MotionEvent.ACTION_MOVE -> {
                Log.d(DEBUG_TAG, "Action was MOVE")
                true
            }
            MotionEvent.ACTION_UP -> {
                Log.d(DEBUG_TAG, "Action was UP")
                true
            }
            MotionEvent.ACTION_CANCEL -> {
                Log.d(DEBUG_TAG, "Action was CANCEL")
                true
            }
            MotionEvent.ACTION_OUTSIDE -> {
                Log.d(DEBUG_TAG, "Movement occurred outside bounds of current screen element")
                true
            }
            else -> super.onTouchEvent(event)
        }
    }

}