package com.bonni.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bonni.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
//    private val viewModel by viewModel<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        calculate()
    }

    private fun isValidFields(): Boolean {
        return (binding.editDistance.text.toString() != ""
            && binding.editPrice.text.toString() != ""
            && binding.editAutonomy.text.toString() != ""
            && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    private fun calculate() {
        if (isValidFields()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            binding.textTotal.text = "R$ ${"%.2f".format(totalValue)}"
        }else{
            Toast.makeText(this,R.string.validation_fill_all_fields,Toast.LENGTH_SHORT).show()
        }
    }

}