package com.matheussilas.motivation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.matheussilas.motivation.R
import com.matheussilas.motivation.infra.MotivationConstants
import com.matheussilas.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var securityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        securityPreferences = SecurityPreferences(this)

        supportActionBar!!.hide()

        bttSave.setOnClickListener(this)

        verifyName()

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.bttSave) {
            handleSave()
        }
    }

    private fun verifyName() {
        val name = securityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        if (name != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun handleSave() {
        val name = editName.text.toString()

        if (name != "") {
            securityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "Informe seu nome", Toast.LENGTH_SHORT).show()
        }
    }
}
