package ca.gbc.comp3074.brown.lab02

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ca.gbc.comp3074.brown.lab02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var counter = 0
    private var step = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.stepButton.text = getString(R.string.step_format, step)

        fun updateOutput() { binding.outputLabel.text = counter.toString() }

        binding.addButton.setOnClickListener { counter += step; updateOutput() }
        binding.subtractButton.setOnClickListener { counter -= step; updateOutput() }

        binding.resetButton.setOnClickListener {
            counter = 0
            step = 1
            binding.stepButton.text = getString(R.string.step_format, step)
            updateOutput()
        }

        binding.stepButton.setOnClickListener {
            step = if (step == 1) 2 else 1
            binding.stepButton.text = getString(R.string.step_format, step)
        }
    }
}
