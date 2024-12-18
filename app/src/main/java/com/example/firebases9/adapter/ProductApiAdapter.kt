package com.example.firebases9.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firebases9.Model.ProductApiModel
import com.example.firebases9.R

class ProductApiAdapter(private var productList: List<ProductApiModel>) :
 RecyclerView.Adapter<ProductApiAdapter.ViewHolder>()  {

     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val ivProductApi = itemView.findViewById<ImageView>(R.id.ivProductApi)
         val tvDescriptionProductoApi = itemView.findViewById<TextView>(R.id.tvDescriptionProductoApi)
         val tvPriceProductApi = itemView.findViewById<TextView>(R.id.tvPriceProductApi)

     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_product_api, parent, false))
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemProducto = productList[position]
        holder.tvDescriptionProductoApi.text = itemProducto.description
        holder.tvPriceProductApi.text = itemProducto.price.toString()

        Glide.with(holder.itemView.context)
            .load(itemProducto.imageUrl)
            .into(holder.ivProductApi)
    }
    fun updateProductList(newProductList: List<ProductApiModel>) {
        productList = newProductList
        notifyDataSetChanged()
    }
}