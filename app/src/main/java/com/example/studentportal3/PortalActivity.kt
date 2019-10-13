package com.example.studentportal3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_portal.*
import kotlinx.android.synthetic.main.content_portal.*

const val ADD_PORTAL_REQUEST_CODE = 100

class PortalActivity : AppCompatActivity() {
    private val portals = arrayListOf<Portal>()
    private val portalAdapter = PortalAdapter(portals)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portal)
        // setup title & menu
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            startAddActivity()
        }

        initViews()
    }

    private fun initViews(){
        rvPortals.layoutManager = GridLayoutManager(this, 2)
        rvPortals.adapter = portalAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                ADD_PORTAL_REQUEST_CODE -> {
                    val portal = data!!.getParcelableExtra<Portal>(EXTRA_PORTAL)
                    portals.add(portal)
                    portalAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    // create the view for addActivity
    private fun startAddActivity() {
        val intent = Intent(this, AddPortalActivity::class.java)
        startActivityForResult(intent, ADD_PORTAL_REQUEST_CODE)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
