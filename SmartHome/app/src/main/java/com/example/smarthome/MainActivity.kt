package com.example.smarthome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.smarthome.databinding.ActivityMainBinding;

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)  //it inflates layouts
        super.onCreate(savedInstanceState)
        setContentView(binding.root) //accesses all the tags/attributes in the activity main
        setScreen(favorites())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.fav -> setScreen(favorites())
                R.id.rout -> setScreen(Routines())
                R.id.thing -> setScreen(things())
                R.id.idea -> setScreen(Ideas())
                R.id.set -> setScreen(settings())

            }
            true
        }

    }
    fun setScreen(fragment: Fragment) {
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.f_layOut, fragment)
        transaction.commit()
    }


}


    // to help change screens use;
