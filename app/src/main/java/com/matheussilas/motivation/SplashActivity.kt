package com.matheussilas.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar!!.hide()

        bttSave.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.bttSave) {
            handleSave()

        }
    }

    private fun handleSave() {
        val name = editName.text.toString()

        if (name != "") {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Informe seu nome", Toast.LENGTH_SHORT).show()
        }
    }
}
