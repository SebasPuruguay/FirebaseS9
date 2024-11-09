package com.example.firebases9.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.example.firebases9.Model.ProductApiModel
import com.example.firebases9.R


class AddProductFragment : Fragment() {

    private val productApiViewModel: ProductoApiViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_add_product, container, false)

        val etDescripcion: EditText = view.findViewById(R.id.etDescripcion)
        val etImageURL: EditText = view.findViewById(R.id.etImageURL)
        val etStock: EditText = view.findViewById(R.id.etStock)
        val etPrecio: EditText = view.findViewById(R.id.etPrecio)
        val etDescuento: EditText = view.findViewById(R.id.etDescuento)
        val btnAddProduct: Button = view.findViewById(R.id.btnAddProduct)

        btnAddProduct.setOnClickListener {
            val descripcion = etDescripcion.text.toString()
            val imageURL = etImageURL.text.toString()
            val stock = etStock.text.toString().toInt()
            val precio = etPrecio.text.toString().toDouble()
            val descuento = etDescuento.text.toString().toDouble()


            //Create ProductApiModel object
            val product = ProductApiModel(
                description = descripcion,
                imageUrl = imageURL,
                stock = stock,
                price = precio,
                discount = descuento,
                categoryId = 1
            )

            //Add product to view model
            productApiViewModel.createProduct(product)

        }
        return view


    }


}