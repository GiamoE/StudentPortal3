package com.example.studentportal3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_portal.*

const val EXTRA_PORTAL = "EXTRA_PORTAL"

class AddPortalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // allow a back button and give a name to the activity.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.title_activity_add_portal)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_portal)
        initViews()
    }

    private fun initViews() {
        btnAddPortal.setOnClickListener {
            onConfirmClick()
        }
    }

    private fun onConfirmClick() {
        val name = etTitle.text.toString()
        val url = etUrl.text.toString()

        if (name.isNotBlank() && url.isNotBlank()) {
            val portal = Portal(name, url)
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_PORTAL, portal)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this, getString(R.string.empty_fields)
                , Toast.LENGTH_SHORT)
                .show()
        }
    }
}
