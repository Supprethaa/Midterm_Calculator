package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Calculator"
        val firstNumber: EditText = findViewById(R.id.number1)
        val secondNumber: EditText = findViewById(R.id.number2)

        val resultBtn: Button = findViewById(R.id.resultBtn)
        val spinner: Spinner = findViewById(R.id.spinner)

        val result: TextView = findViewById(R.id.result)

        var flag: String = "Sum"
        var options = arrayOf("Add","Subtract","Multiply","Divide")
        spinner.adapter= ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        spinner.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        resultBtn.setOnClickListener{ view ->
//code here
            var x: Int = firstNumber.text.toString().toInt();
            var y: Int = secondNumber.text.toString().toInt();

            when(flag){
                "Add" -> result.text = sum(x,y).toString();
                "Subtract" -> result.text = diff(x,y).toString();
                "Multiply" -> result.text = multiply(x,y).toString();
                "Divide" -> result.text = divide(x,y).toString();
                else -> result.text = "Please select an action"
            }


        }



    }
}

public fun sum(a:Int, b:Int): Int{
    return a+b;
}

public fun diff(a:Int, b:Int): Int{
    return a-b;
}

public fun multiply(a:Int, b:Int): Int{
    return a*b;
}

public fun divide(a:Int, b:Int): Int{
    return a/b;
}