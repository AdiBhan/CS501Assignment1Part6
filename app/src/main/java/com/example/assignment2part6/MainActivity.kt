package com.example.assignment2part6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {


    // VIEWS
    lateinit var oneButton: Button
    lateinit var TwoButton: Button
    lateinit var ThreeButton: Button
    lateinit var FourButton: Button
    lateinit var FiveButton: Button
    lateinit var SixButton: Button
    lateinit var SevenButton: Button
    lateinit var EightButton: Button
    lateinit var NineButton: Button
    lateinit var AddButton: Button
    lateinit var SubtractButton: Button
    lateinit var MultiplyButton: Button
    lateinit var DivideButton: Button
    lateinit var EqualButton: Button
    lateinit var DecimalButton: Button
    lateinit var ZeroPointZero: TextView
    lateinit var SqrtButton: Button


    // STATE VARIABLES FOR OPERATION
    var currentAnswer: String = "0"
    var clickedOperation: Boolean = false
    var selectedOperation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        oneButton = findViewById(R.id.one_id)
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


        oneButton.setOnClickListener { view: View ->
            if (clickedOperation) {
                // Here, convert currentAnswer to float and then do your operations
                val currentFloat = currentAnswer.toFloat()
                currentAnswer =
                    currentOperation(selectedOperation, currentFloat, 1F, view).toString()
                ZeroPointZero.text = currentAnswer
            } else {
                if (currentAnswer == "0") {
                    currentAnswer = "1"
                } else {
                    currentAnswer += "1"
                }
                ZeroPointZero.text = currentAnswer
            }
        }

    }

    private fun currentOperation(
        operation: String,
        firstNum: Float,
        secondNum: Float,
        view: View
    ): Float {

        if (operation == "add") {
            return firstNum + secondNum
        }
        if (operation == "subtract") {
            return firstNum - secondNum
        }
        if (operation == "multiply") {
            return firstNum * secondNum
        }
        if (operation == "divide") {
            // Handling error checking where user tries to divide by zero
            if (secondNum == 0.0F) {
                Snackbar.make(
                    view,
                    "Error,you cannot divide by zero. Please try with a different number",
                    Snackbar.LENGTH_LONG
                ).show()
                return 0.0F
            } else {
                return firstNum / secondNum
            }
        }
        if (operation == "SQRT") {
            // Handling error checking where user tries to SQRT negative number
            if (firstNum < 0) {
                Snackbar.make(
                    view,
                    "Error, you cannot SQRT a number less than or equal to zero. Please restart and try again with a positive number!",
                    Snackbar.LENGTH_LONG
                ).show()
                return 0.0F
            } else {
                return sqrt(firstNum)
            }
        }
        return 0.0F
    }
}



