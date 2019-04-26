package com.cohen.challenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private val itemsListFragment: ItemsListFragment  by lazy {
        if (supportFragmentManager.findFragmentByTag("ItemsListFragment") != null) {
            supportFragmentManager.findFragmentByTag("ItemsListFragment") as ItemsListFragment
        } else {
            ItemsListFragment.newInstance(100)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListMode()
    }


    private fun setListMode() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, itemsListFragment, "itemsListFragment")
        transaction.commit()
    }

}
