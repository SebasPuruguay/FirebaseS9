package com.example.firebases9.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebases9.Model.ProductApiModel
import com.example.firebases9.repository.ProductApiRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductoApiViewModel : ViewModel() {
    private val repository = ProductApiRepository()

    private val _isProductAdded = MutableLiveData<Boolean>()
    val isProductAdded:MutableLiveData<Boolean> get() = _isProductAdded

    fun createProduct(producto: ProductApiModel) {
        repository.createProduct(producto).enqueue(object : Callback<ProductApiModel> {
            override fun onResponse(
                call: Call<ProductApiModel>,
                response: Response<ProductApiModel>
            ) {
                if (response.isSuccessful) {
                    _isProductAdded.value = true
                    //TODO: notificiar carga de productos
                }
            }

            override fun onFailure(call: Call<ProductApiModel>, t: Throwable) {
                _isProductAdded.value = false
            }
        })
    }

}