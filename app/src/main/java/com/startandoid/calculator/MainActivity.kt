package com.startandoid.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        Plus.setOnClickListener { add("+", false) }
        Minus.setOnClickListener { add("-", false) }
        Mult.setOnClickListener { add("*", false) }
        Divide.setOnClickListener { add("/", false) }
        Open.setOnClickListener { add("(", false) }
        Close.setOnClickListener { add(")", false) }
        Pow.setOnClickListener {
            add("^", false)
        }
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
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        when(item.title){
            "Clear" ->{
                Task.text = ""
                Result.text = ""
                Toast.makeText(this,"All clean", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
