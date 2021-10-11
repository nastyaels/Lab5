package ru.nastya.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.nastya.myapplication.databinding.ActivityMainBinding
import ru.nastya.myapplication.events.Events
import ru.nastya.myapplication.holidays.Holidays
import ru.nastya.myapplication.profile.Profile


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavBar()

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
                true}
                else -> true
            }
        }
    }
        private fun setFragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.profile, fragment)
                .addToBackStack(null)
                .commit()
        }
}