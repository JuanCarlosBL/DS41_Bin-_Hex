package com.uthjcbl.ds41_bin_hex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class BinHexAdapter(private var binarios: List<ListaBinHex>): RecyclerView.Adapter<BinHexAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val inflador = LayoutInflater.from(parent.context)

        val view = inflador.inflate(R.layout.item_binhex, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val binh = binarios[position]
        holder.render(binh)

        //aquí se aplica la lógica. ej: onClickListener
    }

    override fun getItemCount(): Int {
        return binarios.size
    }

    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val name: TextView = view.findViewById(R.id.binhex_name)
        val descripcion: TextView = view.findViewById(R.id.descripcionn)
        val image: ImageView = view.findViewById(R.id.bin_image)

        fun render(binh: ListaBinHex) {
            name.text = binh.name + ", "
            descripcion.text = binh.descripcion
            Picasso.get().load(binh.image).into(image)
        }
    }
}