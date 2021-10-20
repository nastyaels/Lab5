package ru.nastya.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment
import ru.nastya.myapplication.databinding.ActivityMainBinding
import ru.nastya.myapplication.ui.events.Events
import ru.nastya.myapplication.ui.holidays.Holidays
import ru.nastya.myapplication.ui.profile.Profile
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.nastya.myapplication.ui.events.AddNewEventFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val fab by lazy { findViewById<FloatingActionButton>(R.id.fab) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavBar()
        fabClick()
        fab.hide()
    }

    fun fabClick(){
        fab.setOnClickListener{
            setFragment(AddNewEventFragment())
        }
    }
    private fun setupBottomNavBar() {
        binding.bottomNavigationView.setOnItemSelectedListener { it ->
            when (it.itemId) {
                R.id.event -> {setFragment(Events())
                    true}
                R.id.profile -> { setFragment(Profile())
                    true
                }
                R.id.holiday -> {setFragment(Holidays())
                    true
                }
                else ->
                    true
            }
        }
    }
    fun getFloatingActionButton(): FloatingActionButton? {
        return fab
    }

    fun showFloatingActionButton() {
        fab.show()
    }

    fun hideFloatingActionButton() {
        fab.hide()
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.profile, fragment)
            .addToBackStack(null)
            .commit()
    }
}