package com.startandoid.calculator

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.Back
import kotlinx.android.synthetic.main.activity_main.Close
import kotlinx.android.synthetic.main.activity_main.Divide
import kotlinx.android.synthetic.main.activity_main.Dot
import kotlinx.android.synthetic.main.activity_main.Eight
import kotlinx.android.synthetic.main.activity_main.Equals
import kotlinx.android.synthetic.main.activity_main.Five
import kotlinx.android.synthetic.main.activity_main.Four
import kotlinx.android.synthetic.main.activity_main.Minus
import kotlinx.android.synthetic.main.activity_main.Mult
import kotlinx.android.synthetic.main.activity_main.Nine
import kotlinx.android.synthetic.main.activity_main.One
import kotlinx.android.synthetic.main.activity_main.Open
import kotlinx.android.synthetic.main.activity_main.Plus
import kotlinx.android.synthetic.main.activity_main.Pow
import kotlinx.android.synthetic.main.activity_main.Result
import kotlinx.android.synthetic.main.activity_main.Seven
import kotlinx.android.synthetic.main.activity_main.Six
import kotlinx.android.synthetic.main.activity_main.Task
import kotlinx.android.synthetic.main.activity_main.Three
import kotlinx.android.synthetic.main.activity_main.Two
import kotlinx.android.synthetic.main.activity_main.Zero
import kotlinx.android.synthetic.main.extent_activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.Result

class ExtendActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.extent_activity_main)

        //цифры
        One.setOnClickListener { add("1", true) }
        Two.setOnClickListener { add("2", true) }
        Three.setOnClickListener { add("3", true) }
        Four.setOnClickListener { add("4", true) }
        Five.setOnClickListener { add("5", true) }
        Six.setOnClickListener { add("6", true) }
        Seven.setOnClickListener {add("7", true) }
        Eight.setOnClickListener { add("8", true) }
        Nine.setOnClickListener { add("9", true) }
        Zero.setOnClickListener { add("0", true) }
        Dot.setOnClickListener { add(".", true) }

        //операторы
        Sin.setOnClickListener { add("sin(", false) }
        Cos.setOnClickListener { add("cos(", false) }
        Tan.setOnClickListener { add("tan(", false) }
        Sqrt.setOnClickListener { add("sqrt(", false) }
        Log.setOnClickListener{add("log(", false)}
        Plus.setOnClickListener { add("+", false) }
        Minus.setOnClickListener { add("-", false) }
        Mult.setOnClickListener { add("*", false) }
        Divide.setOnClickListener { add("/", false) }
        Open.setOnClickListener { add("(", false) }
        Close.setOnClickListener { add(")", false) }
        Pow.setOnClickListener {add("^", false) }
        Equals.setOnClickListener {
            try{
                val Task = ExpressionBuilder(Task.text.toString()).build()
                val result = Task.evaluate()
                Result.text = result.toString()
            }
            catch (exc:Exception){
                Result.text = exc.message
            }
        }
        Back.setOnClickListener{
            Task.text = Task.text.dropLast(1)
        }
    }

    fun add(number: String, clear: Boolean){
        if(Result.text.isNotEmpty()){
            Task.text = ""
        }
        if (clear){
            Result.text = ""
            Task.append(number)
        }
        else {
            Task.append(Result.text)
            Task.append(number)
            Result.text = ""
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean{
        menu.add("Clear")
        menu.add("Standard")
        menu.add("Extend")
        menu.add("About")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        when(item.title){
            "Clear" ->{
                Task.text = ""
                Result.text = ""
                Toast.makeText(this,"All clean", Toast.LENGTH_SHORT).show()
            }
            "Standard"->{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            "Extend" ->{
                val intent = Intent(this, ExtendActivity::class.java)
                startActivity(intent)
            }
            "About" ->{
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}