package com.example.android.paintme

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.widget.Button
import com.github.dhaval2404.colorpicker.ColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var chngBgColor : Button
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myCanvasView : MyCanvasView = findViewById(R.id.myCanvas)
        setContentView(R.layout.activity_main)

        val fab=findViewById<FloatingActionButton>(R.id.floatingActionButton2)

        myCanvasView.contentDescription = getString(R.string.canvasContentDescription)

        chngBgColor = findViewById(R.id.bgChange)
        chngBgColor.setOnClickListener{
            ColorPickerDialog
                .Builder(this)        				// Pass Activity Instance
                .setTitle("Pick Theme")           	// Default "Choose Color"
                .setColorShape(ColorShape.SQAURE)   // Default ColorShape.CIRCLE
                .setDefaultColor(R.color.teal_200)     // Pass Default Color
                .setColorListener { color, colorHex ->
                    // Handle Color Selection
                    Log.d("Color",colorHex)
                    myCanvasView.changeBgColor(colorHex)


                }
                .show()
        }




        val canvas=findViewById<MyCanvasView>(R.id.Canvas)
        fab.setOnClickListener {
            canvas.clear()
        }
    }
}