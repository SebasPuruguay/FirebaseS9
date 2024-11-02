package com.example.firebases9.repository

import com.example.firebases9.Model.ProductApiModel
import com.example.firebases9.service.ProductApiService
import com.example.firebases9.service.RetrofitInstance

class ProductApiRepository {
    private val apiService: ProductApiService = RetrofitInstance.api

    fun getProducts() = apiService.getProducts()
    fun getProductById(id: Int) = apiService.getProductById(id)
    fun createProduct(product: ProductApiModel) = apiService.createProduct(product)
    fun updateProduct(id: Int, product: ProductApiModel) = apiService.updateProduct(id, product)
    fun deleteProduct(id: Int) = apiService.deleteProduct(id)

}