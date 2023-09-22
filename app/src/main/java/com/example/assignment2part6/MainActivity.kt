package com.example.assignment2part6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.assignment2part6.R.id.one_id


class MainActivity : AppCompatActivity() {

    lateinit var OneButton:Button
    lateinit var TwoButton:Button
    lateinit var ThreeButton:Button
    lateinit var FourButton:Button
    lateinit var FiveButton:Button
    lateinit var SixButton:Button
    lateinit var SevenButton:Button
    lateinit var EightButton:Button
    lateinit var NineButton:Button
    lateinit var AddButton:Button
    lateinit var SubtractButton:Button
    lateinit var MultiplyButton:Button
    lateinit var DivideButton:Button
    lateinit var EqualButton:Button
    lateinit var DecimalButton:Button
    lateinit var ZeroPointZero:Button
    lateinit var SqrtButton:Button
    lateinit var DisplayText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        OneButton = findViewById(one_id)
        TwoButton = findViewById(R.id.two_id)
        ThreeButton = findViewById(R.id.three_id)
        FourButton = findViewById(R.id.four_id)
        FiveButton = findViewById(R.id.five_id)
        SixButton = findViewById(R.id.six_id)
        SevenButton = findViewById(R.id.seven_id)
        EightButton = findViewById(R.id.eight_id)
        NineButton = findViewById(R.id.nine_id)
        AddButton = findViewById(R.id.add_id)
        SubtractButton = findViewById(R.id.subtract_id)
        MultiplyButton = findViewById(R.id.multiply_id)
        DivideButton = findViewById(R.id.divide_id)
        EqualButton = findViewById(R.id.equal_id)
        DecimalButton = findViewById(R.id.decimal_id)
        ZeroPointZero = findViewById(R.id.zero_point_zero_id)
        SqrtButton = findViewById(R.id.sqrt_id)
        DisplayText = findViewById(R.id.display_text_id)



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}