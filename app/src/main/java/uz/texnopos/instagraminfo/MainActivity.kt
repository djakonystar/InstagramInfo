package uz.texnopos.instagraminfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.texnopos.instagraminfo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContinue.setOnClickListener {
            if (!binding.etUsername.text.isNullOrBlank() or !binding.etUsername.text.isNullOrEmpty()) {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("username", binding.etUsername.text.toString())
                startActivity(intent)
            }
        }
    }
}