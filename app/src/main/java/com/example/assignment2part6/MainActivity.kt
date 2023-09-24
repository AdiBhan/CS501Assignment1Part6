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
    lateinit var twoButton: Button
    lateinit var threeButton: Button
    lateinit var fourButton: Button
    lateinit var fiveButton: Button
    lateinit var sixButton: Button
    lateinit var sevenButton: Button
    lateinit var eightButton: Button
    lateinit var nineButton: Button
    lateinit var equalButton: Button
    lateinit var decimalButton: Button
    lateinit var zeroPointZero: TextView
    lateinit var sqrtButton: Button
    lateinit var clearButton: Button
    lateinit var addButton: Button
    lateinit var subtractButton: Button
    lateinit var multiplyButton: Button
    lateinit var divideButton: Button


    // STATE VARIABLES FOR OPERATION
    var currentAnswer: String = "0"
    var clickedOperation: Boolean = false
    var selectedOperation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        oneButton = findViewById(R.id.one_id)
        twoButton = findViewById(R.id.two_id);
        threeButton = findViewById(R.id.three_id);
        fourButton = findViewById(R.id.four_id);
        fiveButton = findViewById(R.id.five_id);
        sixButton = findViewById(R.id.six_id);
        sevenButton = findViewById(R.id.seven_id);
        eightButton = findViewById(R.id.eight_id);
        nineButton = findViewById(R.id.nine_id);
        clearButton = findViewById(R.id.clear);
        addButton = findViewById(R.id.add);
        subtractButton = findViewById(R.id.subtract);
        multiplyButton = findViewById(R.id.multiply);
        divideButton = findViewById(R.id.divide);
        equalButton = findViewById(R.id.equal_id);
        decimalButton = findViewById(R.id.decimal_id);
        zeroPointZero = findViewById(R.id.zero_point_zero_id);
        sqrtButton = findViewById(R.id.sqrt_id);



        oneButton.setOnClickListener { view: View ->

            currentAnswer = handleClickNumberButtons(
                clickedOperation,
                selectedOperation,
                currentAnswer,
                "1",
                view
            )


        }


    }

        private fun handleClickNumberButtons(clickedOperation:Boolean, selectedOperation:String, currentAnswer:String, newNumber:String,view: View): String {
            var result = currentAnswer
            // If previous button clicked was an operation
            if (clickedOperation) {
                // Here, convert currentAnswer to float and then do your operations
                val currentFloat = currentAnswer.toFloat()
                result = currentOperation(selectedOperation, currentFloat, 1F,view).toString()
                zeroPointZero.text = result
            } else {
                if (currentAnswer == newNumber) {
                    result = newNumber
                } else {
                    result += newNumber
                }
                ZeroPointZero.text = result
            }
            return result
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



