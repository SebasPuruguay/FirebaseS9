package com.example.firebases9.service

import com.example.firebases9.Model.ProductApiModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ProductApiService {

    @GET("products")
    fun getProducts(): Call<List<ProductApiModel>>

    @GET("products/{id}")
    fun getProductById(@Path("id") id: Int): Call<ProductApiModel>

    //Create POST product
    @POST("products")
    fun createProduct(product: ProductApiModel): Call<ProductApiModel>

    //Create PUT product
    @PUT("products/{id}")
    fun updateProduct(@Path("id") id: Int, product: ProductApiModel): Call<ProductApiModel>

    //Create DELETE product
    @DELETE("products/{id}")
    fun deleteProduct(@Path("id") id: Int): Call<Void>


}