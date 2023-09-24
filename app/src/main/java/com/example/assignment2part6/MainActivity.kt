package com.example.assignment2part6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {


    // VIEWS
    lateinit var zeroButton: Button
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
    var firstNumber: Float = 0F
    var clickedOperation: Boolean = false
    var selectedOperation: String = ""
    val MAX_LENGTH = 10

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
        zeroButton = findViewById(R.id.zero_id);



        oneButton.setOnClickListener { view: View ->

            currentAnswer = handleClickNumberButtons(
                clickedOperation,
                selectedOperation,
                currentAnswer,
                "1",
                view
            )
            Log.d("SETTING 1",currentAnswer + selectedOperation + clickedOperation)


        }
        twoButton.setOnClickListener { view: View ->

            currentAnswer = handleClickNumberButtons(
                clickedOperation,
                selectedOperation,
                currentAnswer,
                "2",
                view
            )
            Log.d("SETTING 2",currentAnswer + selectedOperation + clickedOperation)


        }
        threeButton.setOnClickListener { view: View ->

            currentAnswer = handleClickNumberButtons(
                clickedOperation,
                selectedOperation,
                currentAnswer,
                "3",
                view
            )


        }
        fourButton.setOnClickListener { view: View ->

            currentAnswer = handleClickNumberButtons(
                clickedOperation,
                selectedOperation,
                currentAnswer,
                "4",
                view
            )


        }
        fiveButton.setOnClickListener { view: View ->

            currentAnswer = handleClickNumberButtons(
                clickedOperation,
                selectedOperation,
                currentAnswer,
                "5",
                view
            )


        }
        sixButton.setOnClickListener { view: View ->

            currentAnswer = handleClickNumberButtons(
                clickedOperation,
                selectedOperation,
                currentAnswer,
                "6",
                view
            )


        }
        sevenButton.setOnClickListener { view: View ->

            currentAnswer = handleClickNumberButtons(
                clickedOperation,
                selectedOperation,
                currentAnswer,
                "7",
                view
            )


        }
        eightButton.setOnClickListener { view: View ->

            currentAnswer = handleClickNumberButtons(
                clickedOperation,
                selectedOperation,
                currentAnswer,
                "8",
                view
            )


        }
        nineButton.setOnClickListener { view: View ->

            currentAnswer = handleClickNumberButtons(
                clickedOperation,
                selectedOperation,
                currentAnswer,
                "9",
                view
            )


        }
        zeroButton.setOnClickListener { view: View ->

            currentAnswer = handleClickNumberButtons(
                clickedOperation,
                selectedOperation,
                currentAnswer,
                "0",
                view
            )


        }


        decimalButton.setOnClickListener { view: View ->

            currentAnswer = handleClickNumberButtons(
                clickedOperation,
                selectedOperation,
                currentAnswer,
                ".",
                view
            )


        }

        clearButton.setOnClickListener { view: View ->
            zeroPointZero.text = "0.0"
            clickedOperation = false
            selectedOperation = ""
            currentAnswer = "0"
        }


        addButton.setOnClickListener { view: View ->
            clickedOperation = true
            selectedOperation = "add"
            firstNumber = currentAnswer.toFloat()
            currentAnswer = "0"
            Log.d("ADDING",currentAnswer + selectedOperation + clickedOperation)

        }

        subtractButton.setOnClickListener { view: View ->
            clickedOperation = true
            selectedOperation = "subtract"
            firstNumber = currentAnswer.toFloat()
            currentAnswer = "0"
            Log.d("SUBTRACTING",currentAnswer + selectedOperation + clickedOperation)
        }

        multiplyButton.setOnClickListener { view: View ->
            clickedOperation = true
            selectedOperation = "multiply"
            firstNumber = currentAnswer.toFloat()
            currentAnswer = "0"
            Log.d("MULTIPLYING",currentAnswer + selectedOperation + clickedOperation)
        }

        divideButton.setOnClickListener { view: View ->
            clickedOperation = true
            selectedOperation = "divide"
            currentAnswer = "0"
            Log.d("DIVIDING",currentAnswer + selectedOperation + clickedOperation)
        }

        sqrtButton.setOnClickListener { view: View ->
            val currentFloat = currentAnswer.toFloat()
            val result = currentOperation("SQRT", currentFloat, 0F, view)
            zeroPointZero.text = result.toString()
            clickedOperation = false
        }
        equalButton.setOnClickListener { view: View ->
            if (clickedOperation) {
                val secondNum = currentAnswer.toFloat()
                Log.d(selectedOperation,zeroPointZero.text.toString() + secondNum +  selectedOperation + clickedOperation)


                val result = currentOperation(selectedOperation, firstNumber, secondNum, view) // Use firstNumber here

                zeroPointZero.text = result.toString()
                clickedOperation = false
                selectedOperation = ""
                firstNumber = 0F
            }
        }



    }

    private fun handleClickNumberButtons(clickedOperation: Boolean, selectedOperation: String, currentAnswer: String, newNumber: String, view: View): String {
        var result = currentAnswer

        // If the previous button clicked was an operation, reset the currentAnswer
        if (clickedOperation) {
            zeroPointZero.text = newNumber
            return newNumber  // Return early since operation is complete
        }

        // Checking if user typed too many numbers
        if (result.length >= MAX_LENGTH) {
            Snackbar.make(view, "Error: Maximum input length reached.", Snackbar.LENGTH_LONG).show()
            return currentAnswer
        }

        // Can't input multiple decimals
        if (newNumber == "." && currentAnswer.contains(".")) {
            Snackbar.make(view, "Error: You cannot enter more than one decimal point", Snackbar.LENGTH_LONG).show()
            return currentAnswer
        }

        // If the previous button clicked was not an operation, append the new number
        if (currentAnswer != "0" || newNumber == ".") {  // Prevent leading zeros
            result += newNumber
        } else {
            result = newNumber
        }

        zeroPointZero.text = result
        return result
    }









    private fun currentOperation(operation: String, firstNum: Float, secondNum: Float,view: View): Float {

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
                    "Error, you cannot SQRT a number less than zero. Please restart and try again with a positive number!",
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



