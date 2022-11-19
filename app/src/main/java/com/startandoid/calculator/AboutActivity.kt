package com.startandoid.calculator

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.about_activity.*
import kotlinx.android.synthetic.main.activity_main.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_activity)
        Git.setOnClickListener{open_github()}
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean{
        menu.add("Clear")
        menu.add("Standard")
        menu.add("Extend")
        return super.onCreateOptionsMenu(menu)

    }
    fun open_github(){
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/nzVoid/Calculator"))
        startActivity(browserIntent)
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
//                val intent = Intent(this, ExtendActivity::class.java)
//                startActivity(intent)
                setContentView(R.layout.extent_activity_main)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}