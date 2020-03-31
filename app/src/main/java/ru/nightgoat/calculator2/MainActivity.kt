package ru.nightgoat.calculator2

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var firstNumber: Long = 0
    var secondNumber: Long = 0
    var action: Action = Action.NONE
    var isSecondNumberChosen = false

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button0.setOnClickListener {
            appendNumber(0)
        }

        button1.setOnClickListener {
            appendNumber(1)
        }

        button2.setOnClickListener {
            appendNumber(2)

        }

        button3.setOnClickListener {
            appendNumber(3)

        }

        button4.setOnClickListener {
            appendNumber(4)

        }

        button5.setOnClickListener {
            appendNumber(5)

        }

        button6.setOnClickListener {
            appendNumber(6)
        }

        button7.setOnClickListener {
            appendNumber(7)
        }

        button8.setOnClickListener {
            appendNumber(8)
        }

        button9.setOnClickListener {
            appendNumber(9)
        }

        buttonPlus.setOnClickListener {
            choseFirstNumber()
            action = Action.PLUS
        }

        buttonMin.setOnClickListener {
            choseFirstNumber()
            action = Action.MINUS
        }

        buttonMul.setOnClickListener {
            choseFirstNumber()
            action = Action.MULT
        }

        buttonDiv.setOnClickListener {
            choseFirstNumber()
            action = Action.DIV
        }

        button_eq.setOnClickListener {
            text_result.text = count()
        }

        buttonDel.setOnClickListener {
            text_result.text = text_result.text.dropLast(1)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun appendNumber(number: Int) {
        if (text_result.text == "0") text_result.text = number.toString()
        else text_result.text = "${text_result.text}$number"
    }

    private fun choseFirstNumber() {
        firstNumber = text_result.text.toString().toLong()
        isSecondNumberChosen = false
        text_result.text = "0"
    }

    private fun count(): String {
        if (!isSecondNumberChosen) {
            secondNumber = text_result.text.toString().toLong()
            isSecondNumberChosen = true
        } else {
            firstNumber = text_result.text.toString().toLong()
        }
        return when (action) {
            Action.PLUS -> (firstNumber + secondNumber).toString()
            Action.MINUS -> (firstNumber - secondNumber).toString()
            Action.MULT -> (firstNumber * secondNumber).toString()
            Action.DIV -> {
                if (secondNumber != 0L) (firstNumber / secondNumber).toString()
                else {
                    Toast.makeText(this, "Не дели на ноль!", Toast.LENGTH_SHORT).show()
                    "0"
                }
            }
            else -> "0"
        }
    }
}
