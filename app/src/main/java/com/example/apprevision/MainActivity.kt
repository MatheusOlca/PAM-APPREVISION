package com.example.apprevision

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var picker1Value : Int = 0
    var picker2Value : Int = 0
    var pickerMaxValue : Int = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numPicker1 : NumberPicker = findViewById(R.id.num_picker1)
        val numPicker2 : NumberPicker = findViewById(R.id.num_picker2)
        val toastButton : Button = findViewById(R.id.button)
        numPicker1.maxValue = pickerMaxValue
        numPicker2.maxValue = pickerMaxValue

        numPicker1.setOnValueChangedListener{ picker:NumberPicker, oldVal:Int, newVal:Int ->
            picker1Value = newVal
            compareValues()
        }
        numPicker2.setOnValueChangedListener{ picker:NumberPicker, oldVal:Int, newVal:Int ->
            picker2Value = newVal
            compareValues()
        }
        toastButton.setOnClickListener { toastResult() }
    }

    private fun compareValues(){
        val compareSymbol : TextView = findViewById(R.id.compare_symbol)
        val compareText : TextView = findViewById(R.id.compare_text)
        var symbolToText : String = "igual ao"
        if(picker1Value > picker2Value){
            compareSymbol.setText(">")
            symbolToText = "maior que o"
        }else if(picker1Value < picker2Value){
            compareSymbol.setText("<")
            symbolToText = "menor que o"
        }else{
            compareSymbol.setText("=")
        }
        compareText.setText("O 1° valor é "+symbolToText+" 2° Valor")
    }

    private fun toastResult(){
        var compareSymbol : String = "="
        var compareText : String = "igual ao"
        if(picker1Value > picker2Value){
            compareSymbol = ">"
            compareText = "maior que o"
        }else if(picker1Value < picker2Value){
            compareSymbol = "<"
            compareText = "menor que o"
        }
        Toast.makeText(this, "O 1° valor é "+compareText+" 2° valor\n"+picker1Value+" "+compareSymbol+" "+picker2Value, Toast.LENGTH_SHORT).show()
    }
}