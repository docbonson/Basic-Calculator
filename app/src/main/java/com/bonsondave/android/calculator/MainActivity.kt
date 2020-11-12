package com.bonsondave.android.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    var isNewOp = true
    var oldNumber = ""
    var operator = "+"

    private lateinit var numberText: EditText
    private lateinit var btn1:Button
    private lateinit var btn2:Button
    private lateinit var btn3:Button
    private lateinit var btn4:Button
    private lateinit var btn5:Button
    private lateinit var btn6:Button
    private lateinit var btn7:Button
    private lateinit var btn8:Button
    private lateinit var btn9:Button
    private lateinit var btn0:Button
    private lateinit var btnDot:Button
    private lateinit var btnPlus:Button
    private lateinit var btnMinus:Button
    private lateinit var btnMultiply:Button
    private lateinit var btnDivide:Button
    private lateinit var btnPlusMinus:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberText = findViewById(R.id.edtText)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn0 = findViewById(R.id.btn0)
        btnDot = findViewById(R.id.btnDot)
        btnPlus = findViewById(R.id.btnPlus)
        btnMinus = findViewById(R.id.btnMinus)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        btnPlusMinus = findViewById(R.id.btnPlusMinus)


    }

    fun numberEvent(view: View) {

        if(isNewOp){
            numberText.setText("")
            isNewOp = false
        }
        var btnClick:String = numberText.text.toString()
        var btnSelect : Button = view as Button

        when(btnSelect.id) {
            btn1.id -> {btnClick += "1"}
            btn2.id -> {btnClick += "2"}
            btn3.id -> {btnClick += "3"}
            btn4.id -> {btnClick += "4"}
            btn5.id -> {btnClick += "5"}
            btn6.id -> {btnClick += "6"}
            btn7.id -> {btnClick += "7"}
            btn8.id -> {btnClick += "8"}
            btn9.id -> {btnClick += "9"}
            btn0.id -> {btnClick += "0"}
            btnDot.id -> {btnClick += "."}
            btnPlusMinus.id -> {btnClick = "-$btnClick"}
        }

        numberText.setText(btnClick)
    }

    fun operatorEvent(view: View) {
        isNewOp = true
        oldNumber = numberText.text.toString()
        var btnSelect :Button = view as Button

        when(btnSelect.id) {
            btnMultiply.id -> {operator = "*"}
            btnPlus.id -> {operator = "+"}
            btnMinus.id -> {operator = "-"}
            btnDivide.id -> {operator = "/"}
        }
    }

    fun equalEvent(view: View) {
        var newNumber = numberText.text.toString()
        var result = 0.0

        when(operator) {
            "+" -> {result = oldNumber.toDouble() + newNumber.toDouble()}
            "*" -> {result = oldNumber.toDouble() * newNumber.toDouble()}
            "-" -> {result = oldNumber.toDouble() - newNumber.toDouble()}
            "/" -> {result = oldNumber.toDouble() / newNumber.toDouble()}
        }
        numberText.setText(result.toString())
    }

    fun acEvent(view: View) {
        numberText.setText("0")
        isNewOp = true
    }

    fun percentEvent(view: View) {
        var number = numberText.text.toString().toDouble()/100
        numberText.setText(number.toString())
        isNewOp = true
    }
}