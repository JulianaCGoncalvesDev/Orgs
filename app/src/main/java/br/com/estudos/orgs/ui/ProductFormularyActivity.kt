package br.com.estudos.orgs.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.estudos.orgs.R
import br.com.estudos.orgs.dao.ProductDao
import br.com.estudos.orgs.databinding.ActivityProductFormularyBinding
import br.com.estudos.orgs.databinding.ActivityProductListBinding
import br.com.estudos.orgs.model.Product

class ProductFormularyActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProductFormularyBinding
    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductFormularyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val product = Product(
                name = binding.edtName.text.toString(),
                description = binding.edtDescription.text.toString(),
                value = binding.edtValue.text.toString()
            )
            dao.addItem(product)
            finish()
        }
    }
}