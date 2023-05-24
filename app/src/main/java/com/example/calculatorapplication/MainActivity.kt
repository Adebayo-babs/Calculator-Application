package com.example.calculatorapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    lateinit var button1: android.widget.Button
    lateinit var button2: android.widget.Button
    lateinit var button3: android.widget.Button
    lateinit var button4: android.widget.Button
    lateinit var button5: android.widget.Button
    lateinit var button6: android.widget.Button
    lateinit var button7: android.widget.Button
    lateinit var button8: android.widget.Button
    lateinit var button9: android.widget.Button
    lateinit var button0: android.widget.Button
    lateinit var buttonReturn: android.widget.Button
    lateinit var buttonmodulo: android.widget.Button
    lateinit var buttonClear: android.widget.Button
    lateinit var buttonDot: android.widget.Button
    lateinit var buttonEqual: android.widget.Button
    lateinit var buttonAdd: android.widget.Button
    lateinit var buttonSubtract: android.widget.Button
    lateinit var buttonMultiply: android.widget.Button
    lateinit var buttonDivide: android.widget.Button
    lateinit var buttonToPower: android.widget.Button
    lateinit var buttonBackspace: android.widget.Button
    lateinit var buttonRecall: android.widget.Button
    lateinit var buttonSave: android.widget.Button
    lateinit var buttonMClear: android.widget.Button
    lateinit var inputText: EditText
    lateinit var resultText: EditText
    var check = 0





    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        button0=findViewById(R.id.button0)
        buttonReturn=findViewById(R.id.buttonReturn)
        button1=findViewById(R.id.button1)
        button2=findViewById(R.id.button2)
        button3=findViewById(R.id.button3)
        button4=findViewById(R.id.button4)
        button5=findViewById(R.id.button5)
        button6=findViewById(R.id.button6)
        button7=findViewById(R.id.button7)
        button8=findViewById(R.id.button8)
        button9=findViewById(R.id.button9)
        buttonDot=findViewById(R.id.buttonDot)
        buttonEqual=findViewById(R.id.buttonEqual)
        buttonAdd=findViewById(R.id.buttonPlus)
        buttonSubtract=findViewById(R.id.buttonMinus)
        buttonMultiply=findViewById(R.id.buttonMultiply)
        buttonDivide=findViewById(R.id.buttonDivide)
        buttonmodulo=findViewById(R.id.buttonModulo)
        buttonBackspace=findViewById(R.id.buttonBackspace)
        buttonClear=findViewById(R.id.buttonClear)
        buttonRecall=findViewById(R.id.memoryRecall)
        buttonSave=findViewById(R.id.memoryAdd)
        buttonMClear=findViewById(R.id.memoryClears)
        resultText=findViewById(R.id.result)
        inputText = findViewById(R.id.inputNumber)
        inputText.movementMethod = ScrollingMovementMethod()
        inputText.setActivated(true)
        inputText.setPressed(true)

        var text: String

        button0.setOnClickListener{
            text=inputText.text.toString()+"0"
            inputText.setText(text)
            result(text)
        }

        button1.setOnClickListener{
            text=inputText.text.toString()+"1"
            inputText.setText(text)
            result(text)
        }
        button2.setOnClickListener{
            text=inputText.text.toString()+"2"
            inputText.setText(text)
            result(text)
        }
        button3.setOnClickListener{
            text=inputText.text.toString()+"3"
            inputText.setText(text)
            result(text)
        }
        button4.setOnClickListener{
            text=inputText.text.toString()+"4"
            inputText.setText(text)
            result(text)
        }
        button5.setOnClickListener{
            text=inputText.text.toString()+"5"
            inputText.setText(text)
            result(text)
        }
        button6.setOnClickListener{
            text=inputText.text.toString()+"6"
            inputText.setText(text)
            result(text)
        }
        button7.setOnClickListener{
            text=inputText.text.toString()+"7"
            inputText.setText(text)
            result(text)
        }
        button8.setOnClickListener{
            text=inputText.text.toString()+"8"
            inputText.setText(text)
            result(text)
        }
        button9.setOnClickListener{
            text=inputText.text.toString()+"9"
            inputText.setText(text)
            result(text)
        }
        buttonDot.setOnClickListener{
            text=inputText.text.toString()+"."
            inputText.setText(text)
            result(text)
        }

        buttonAdd.setOnClickListener{
            text = inputText.text.toString()+"+"
            inputText.setText(text)
            check += 1
        }
        buttonSubtract.setOnClickListener{
            text = inputText.text.toString()+"-"
            inputText.setText(text)
            check += 1
        }
        buttonMultiply.setOnClickListener{
            text = inputText.text.toString()+"*"
            inputText.setText(text)
            check += 1
        }
        buttonDivide.setOnClickListener{
            text = inputText.text.toString()+"/"
            inputText.setText(text)
            check += 1
        }
        buttonmodulo.setOnClickListener{
            text = inputText.text.toString()+"%"
            inputText.setText(text)
            check += 1
        }


        buttonEqual.setOnClickListener{
            text=resultText.text.toString()
            inputText.setText(text)
            resultText.setText(null)
        }
        buttonClear.setOnClickListener{
            inputText.setText(null)
            resultText.setText(null)
        }

        var memory: Double = 0.0

        buttonRecall.isEnabled = false

        buttonSave.setOnClickListener{
            text = inputText.text.toString()
            if (text.isNotEmpty()) {
                val resultValue = text.toDouble()
                memory += resultValue
                buttonRecall.isEnabled = true
                Toast.makeText(this, "Result added to memory", Toast.LENGTH_SHORT ).show()
            }
        }



        buttonRecall.setOnClickListener{
            if (memory != null) {
                text=inputText.text.toString()+memory
                inputText.setText(text)
                result(text)
            }else {
                Toast.makeText(this, "The memory is empty", Toast.LENGTH_SHORT ).show()
            }

        }

        buttonMClear.setOnClickListener{
            memory= 0.0
            buttonRecall.isEnabled=false
        }

        buttonReturn.setOnClickListener{
            text = inputText.text.toString()

            // Find the index of the last operator
            val lastOperatorIndex = text.lastIndexOfAny(charArrayOf('+', '-', '*', '/', '%'))

            if (lastOperatorIndex >= 0) {
                // Remove all characters after the last operator
                val newText = text.substring(0, lastOperatorIndex + 1)
                inputText.setText(newText)
                result(newText)
            }
        }



        buttonBackspace.setOnClickListener{
            var BackSpace: String?=null
            if (inputText.text.length>0) {
                val stringBuilder: StringBuilder=StringBuilder(inputText.text)
                val find = inputText.text.toString()
                val find2 = find.last()

                if (find2.equals('+')||find2.equals('-')||find2.equals('*')||find2.equals('/')||find2.equals('%'))
                {
                    check=check-1
                }

                stringBuilder.deleteCharAt(inputText.text.length-1)
                BackSpace=stringBuilder.toString()
                inputText.setText(BackSpace)
                result(BackSpace)
            }
        }

    }



    private fun result(text: String) {

        val engine: ScriptEngine=ScriptEngineManager().getEngineByName("rhino")
        try {
            val result: Any=engine.eval(text)
            var mainResult=result.toString()
            if (check==0) {
                resultText.setText(null)
            }else {
                resultText.setText(mainResult)
            }
        }
        catch (e: ScriptException){
            Log.d("TAG", "ERROR")
        }
    }
}