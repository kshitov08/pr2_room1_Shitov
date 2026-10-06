package com.example.pr2_shitov

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pr2_shitov.fragments.AddStatisticFragment
import com.example.pr2_shitov.fragments.StatsListFragment

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTabAdd = findViewById<Button>(R.id.btnTabAdd)
        val btnTabList = findViewById<Button>(R.id.btnTabList)

        if (savedInstanceState == null) {
            replaceFragment(AddStatisticFragment())
        }

        btnTabAdd.setOnClickListener {
            replaceFragment(AddStatisticFragment())
        }

        btnTabList.setOnClickListener {
            replaceFragment(StatsListFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}