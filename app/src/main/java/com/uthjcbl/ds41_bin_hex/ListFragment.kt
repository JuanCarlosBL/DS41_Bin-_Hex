package com.uthjcbl.ds41_bin_hex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {


    private var binarios : MutableList<ListaBinHex> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)
        initData()
        val fab = view.findViewById<FloatingActionButton>(R.id.fab_new)
        val adapter = BinHexAdapter(binarios)


        val recyclerView =
            view.findViewById<RecyclerView>(
                R.id.countriesRecycler
            )

        //Variables para el elemento nuevo
        var _id : Int = 0
        var _name : String
        var _descripcion : String
        var _image : String

        fab.setOnClickListener {


            // Show Bottom Sheet Dialog and add a new item
            val bottomSheetFragment =BottomSheetDialog(view.context)
            val parentView : View = layoutInflater.inflate(R.layout.bsd_new_binhex, null)
            bottomSheetFragment.setContentView(parentView)
            bottomSheetFragment.show()

            //elementos del formulario bsd
            val newId = parentView.findViewById<EditText>(R.id.bsd_id)
            val newName = parentView.findViewById<EditText>(R.id.bsd_name)
            val newDescripcion = parentView.findViewById<EditText>(R.id.bsd_descripcion)

            val newImage = parentView.findViewById<EditText>(R.id.bsd_image)


            val button = parentView.findViewById<Button>(R.id.bsd_submit)

            //boton guardar del bsd, asignación de valores y creación del nuevo elemento
            button.setOnClickListener{
                _id = newId.text.toString().toInt()
                _name = newName.text.toString()
                _descripcion = newDescripcion.text.toString()
                _image = newImage.text.toString()


                val newProductAdd = ListaBinHex(
                    _id,
                    _name,
                    _descripcion,
                    _image
                )

                binarios.add(newProductAdd)

                recyclerView.adapter?.notifyDataSetChanged()

                bottomSheetFragment.dismiss()
            }
        }


        //Lista anchura completa
        val layoutManager = LinearLayoutManager(container?.context)
        //Cuadricula 2X2
        //val gridLayoutManager = GridLayoutManager(container?.context, 2)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        return view
    }

    private fun initData() {

        binarios = mutableListOf(
            ListaBinHex(1,  "Binarios"  , "tabla   de conversion de decimal a binario" , "https://i.ytimg.com/vi/grRcrHO3kIg/maxresdefault.jpg" ),
            ListaBinHex(2, "Binarios 2", "tabla decimal a binario", "https://es-static.z-dn.net/files/d85/135859fe5fe365df9e61a21554f6f2bc.png"),
            ListaBinHex(3,"Hexadecimal","tabla   de conversion de decimal a hexadecimal","https://th.bing.com/th/id/OIP.WsdVanqqProMs2hO81U9NwHaEK?w=768&h=432&rs=1&pid=ImgDetMain"),
            ListaBinHex(4, "Hexadecimal 2", "tabla   decimal a binario", "https://dkgoelsolutions.com/wp-content/uploads/2021/11/image-255.png", ),
            ListaBinHex(5, "Binario y Hexadecimal", "tabla   de conversion binario/hexadecimal", "https://2.bp.blogspot.com/_dyjfSI62w6U/SrxC73rw_bI/AAAAAAAAAAk/MWsXSZJXXl8/s320/hexa.jpg",),
            ListaBinHex(6, "decimales y enteros", "tabla   de conversion binario/hexadecimal", "https://3.bp.blogspot.com/-9EXKEv0X9r8/WIujHScaXnI/AAAAAAAABUc/I3gqIz6uHTwad7y-kl4FyLKSzp1m3EXhQCLcB/s1600/Tabla%2Bvalores%2BDECIMALES1.png",),
            ListaBinHex(7, "enteros", "tabla de numeros enteros", "https://th.bing.com/th/id/OIP.jtwO5Y5byvyt1JqwmWFobgHaFX?rs=1&pid=ImgDetMain",),
            ListaBinHex(8, "decimales 2", "tabla de numeros decimales", "https://lh3.googleusercontent.com/proxy/NegPoIaCPm1an4UrkKahPpzwbN_vMuJdx2JtO93WQbQIKjvqgFuCJz70UmWCedFxOetY3wZOky-CFgITpdolI6tEIx0gbAf29P_LVdH6PaV6LZ8bQ9gpXMk68hNhKIBX5WVmRr-YdmdEsT1_=w1200-h630-p-k-no-nu",),
            ListaBinHex(9, "hexadecimales 3", "tabla de numeros hexadecimales", "https://th.bing.com/th/id/OIP.moO3K5HtyEAF8MLTsoHlGQHaFO?rs=1&pid=ImgDetMain",),
            ListaBinHex(10, "pan", "un simple pan comun y para nada raro ", "https://th.bing.com/th/id/OIP.zoFEKsURlrl94Z2d_Tx5MwHaE5?rs=1&pid=ImgDetMain",),
                )

    }
}