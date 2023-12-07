package com.uthjcbl.ds41_bin_hex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {


    private var binarios : List<ListaBinHex> = emptyList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        initData()
        val recyclerView =
            view.findViewById<RecyclerView>(
                R.id.countriesRecycler
            )
        val adapter = BinHexAdapter(binarios)
        //Lista anchura completa
        val layoutManager = LinearLayoutManager(container?.context)
        //Cuadricula 2X2
        //val gridLayoutManager = GridLayoutManager(container?.context, 2)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        return view
    }

    private fun initData() {

        binarios = listOf(
            ListaBinHex(1,  "Binarios"  , "tabla   de conversion de decimal a binario" , "https://i.ytimg.com/vi/grRcrHO3kIg/maxresdefault.jpg" ),
            ListaBinHex(2, "Binarios 2", "tabla decimal a binario", "https://es-static.z-dn.net/files/d85/135859fe5fe365df9e61a21554f6f2bc.png"),
            ListaBinHex(3,"Hexadecimal","tabla   de conversion de decimal a hexadecimal","https://th.bing.com/th/id/OIP.WsdVanqqProMs2hO81U9NwHaEK?w=768&h=432&rs=1&pid=ImgDetMain"),
            ListaBinHex(4, "Hexadecimal 2", "tabla   decimal a binario", "https://dkgoelsolutions.com/wp-content/uploads/2021/11/image-255.png", ),
            ListaBinHex(5, "Binario y Hexadecimal", "tabla   de conversion binario/hexadecimal", "https://2.bp.blogspot.com/_dyjfSI62w6U/SrxC73rw_bI/AAAAAAAAAAk/MWsXSZJXXl8/s320/hexa.jpg",)
        )
    }
}