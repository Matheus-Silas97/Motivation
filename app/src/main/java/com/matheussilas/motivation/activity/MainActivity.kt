package com.matheussilas.motivation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.matheussilas.motivation.R
import com.matheussilas.motivation.infra.MotivationConstants
import com.matheussilas.motivation.infra.SecurityPreferences
import com.matheussilas.motivation.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var securityPreferences: SecurityPreferences
    private var mPhraseFilter: Int = MotivationConstants.PHRASEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        securityPreferences = SecurityPreferences(this)
        val name = securityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        textName.text = "Olá, $name"

        imgAll.setColorFilter(resources.getColor(R.color.colorAccent))
        handleNewPhrase()

        bttNewPhrase.setOnClickListener(this)
        imgAll.setOnClickListener(this)
        imgHappy.setOnClickListener(this)
        imgMorning.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        val id = view.id

        val listFilter = listOf(R.id.imgAll, R.id.imgHappy, R.id.imgMorning)

        if (id == R.id.bttNewPhrase) {
            handleNewPhrase()
        } else if (id in listFilter) {
            handleFilter(id)
        }
    }

    private fun handleNewPhrase() {

        val phrase = Mock().getPhrase(mPhraseFilter)
        textPhrase.text = phrase

    }

    private fun handleFilter(id: Int) {

        imgAll.setColorFilter(resources.getColor(R.color.white))
        imgHappy.setColorFilter(resources.getColor(R.color.white))
        imgMorning.setColorFilter(resources.getColor(R.color.white))

        when (id) {
            R.id.imgAll -> {
                imgAll.setColorFilter(resources.getColor(R.color.colorAccent))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.ALL
            }
            R.id.imgHappy -> {
                imgHappy.setColorFilter(resources.getColor(R.color.colorAccent))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
            }
            R.id.imgMorning -> {
                imgMorning.setColorFilter(resources.getColor(R.color.colorAccent))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.MORNING
            }
        }

    }

}