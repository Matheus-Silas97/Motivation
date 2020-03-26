package com.matheussilas.motivation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matheussilas.motivation.R
import com.matheussilas.motivation.infra.MotivationConstants
import com.matheussilas.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var securityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        securityPreferences = SecurityPreferences(this)
        textName.text = securityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
    }
}
