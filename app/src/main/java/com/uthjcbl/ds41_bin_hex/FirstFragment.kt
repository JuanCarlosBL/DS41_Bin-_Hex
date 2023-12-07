package com.uthjcbl.ds41_bin_hex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val second = view.findViewById<Button>(R.id.second_button)
        val list = view.findViewById<Button>(R.id.list_button)
        val buttonBinToHex = view.findViewById<Button>(R.id.button)
        val buttonDecToBin = view.findViewById<Button>(R.id.buttonDecToBin)
        val editTextBinary = view.findViewById<EditText>(R.id.editTextNumberDecimal)
        val editTextDecimal = view.findViewById<EditText>(R.id.editTextNumberDecimal3)
        val textViewResultBinToHex = view.findViewById<TextView>(R.id.textView)
        val textViewResultDecToBin = view.findViewById<TextView>(R.id.textView5)

        second.setOnClickListener {
            val controller: NavController =
                Navigation.findNavController(view)
            controller.navigate(
                R.id.action_firstFragment_to_secondFragment
            )
        }

        list.setOnClickListener {
            val controller: NavController =
                Navigation.findNavController(view)
            controller.navigate(
                R.id.action_firstFragment_to_listFragment
            )
        }

        buttonBinToHex.setOnClickListener {
            // Obtener el valor del EditText para binario
            val binaryValue = editTextBinary.text.toString()

            // Validar y realizar la conversión a hexadecimal
            if (isBinaryNumber(binaryValue)) {
                try {
                    // Convertir el número binario a hexadecimal
                    val decimalValue = Integer.parseInt(binaryValue, 2)
                    val hexadecimalValue = Integer.toHexString(decimalValue).toUpperCase()

                    // Mostrar el resultado en el TextView
                    textViewResultBinToHex.text = "Conversion Hexadecimal: $hexadecimalValue"
                } catch (e: NumberFormatException) {
                    // Manejar la excepción si el valor no es un número binario válido
                    textViewResultBinToHex.text = "Ingrese un número binario válido"
                }
            } else {
                // Manejar el caso en que el EditText está vacío o no es un número binario válido
                textViewResultBinToHex.text = "Ingrese un número binario válido"
            }
        }

        buttonDecToBin.setOnClickListener {
            // Obtener el valor del EditText para decimal
            val decimalValue = editTextDecimal.text.toString()

            // Validar si el valor es un número decimal válido
            if (decimalValue.isNotEmpty() && isDecimalNumber(decimalValue)) {
                try {
                    // Convertir el número decimal a binario
                    val binaryValue = Integer.toBinaryString(Integer.parseInt(decimalValue))

                    // Mostrar el resultado en el TextView
                    textViewResultDecToBin.text = "Conversion binario: $binaryValue"
                } catch (e: NumberFormatException) {
                    // Manejar la excepción si el valor no es un número decimal válido
                    textViewResultDecToBin.text = "Ingrese un número decimal válido"
                }
            } else {
                // Manejar el caso en que el EditText está vacío o no es un número decimal válido
                textViewResultDecToBin.text = "Ingrese un número decimal válido"
            }
        }

        return view
    }

    private fun isBinaryNumber(value: String): Boolean {
        // Verificar si el valor contiene solo 0 y 1
        return value.matches(Regex("[01]+"))
    }

    private fun isDecimalNumber(value: String): Boolean {
        // Verificar si el valor es un número decimal válido
        return value.matches(Regex("\\d+"))
    }
}


