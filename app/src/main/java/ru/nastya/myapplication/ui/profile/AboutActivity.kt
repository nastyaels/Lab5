package ru.nastya.myapplication.ui.profile

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.nastya.myapplication.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    companion object {
        private const val EXTRA_URL = "EXTRA_URL"

        fun newInstance(context: Context, url: String) = Intent(context, AboutActivity::class.java).apply {
            putExtra(EXTRA_URL, url)
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra(EXTRA_URL) ?: ""


        binding.aboutWebView.apply {
            settings.javaScriptEnabled = true
            loadUrl(url)
        }
    }
}