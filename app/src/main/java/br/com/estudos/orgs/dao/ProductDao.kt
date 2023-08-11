package br.com.estudos.orgs.dao

import br.com.estudos.orgs.model.Product

class ProductDao {

    companion object {
        private val products = mutableListOf<Product>()
    }

    fun addItem(product: Product) {
        products.add(product)
    }

    fun showItems() : List<Product> {
        return products.toList()
    }
}