package br.com.estudos.orgs.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.estudos.orgs.R
import br.com.estudos.orgs.dao.ProductDao
import br.com.estudos.orgs.databinding.ActivityProductListBinding
import br.com.estudos.orgs.model.Product
import br.com.estudos.orgs.recyclerview.ProductListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProductListBinding
    private val dao = ProductDao()
    private val adapter = ProductListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvProductList.adapter = adapter
        binding.rvProductList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.fabAddItem.setOnClickListener {
            val intent = Intent(this, ProductFormularyActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.updateList(dao.showItems())
    }
}