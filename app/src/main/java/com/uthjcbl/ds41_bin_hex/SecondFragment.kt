package com.uthjcbl.ds41_bin_hex

import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

       val first = view.findViewById<Button>(R.id.second_button)
       val buttonHexToBin = view.findViewById<Button>(R.id.button)

        val buttonDecToHex = view.findViewById<Button>(R.id.buttonDecToBin)
        val editTextHex = view.findViewById<EditText>(R.id.editTextNumberSigned)
        val editTextDecimal = view.findViewById<EditText>(R.id.editTextNumberDecimal3)
        val textViewResultHexToBin = view.findViewById<TextView>(R.id.textView)
        val textViewResultDecToHex = view.findViewById<TextView>(R.id.textView5)


        first.setOnClickListener {
            val controller: NavController =
                Navigation.findNavController(view)
            controller.navigate(
                R.id.action_secondFragment_to_firstFragment
            )
        }
        // Configurar el tipo de entrada como texto y permitir solo caracteres hexadecimales
        editTextHex.inputType = InputType.TYPE_CLASS_TEXT
        val hexInputFilter = InputFilter { source, _, _, _, _, _ ->
            val inputText = source.toString()
            if (inputText.matches("[0-9A-Fa-f]*".toRegex())) {
                null // Aceptar la entrada
            } else {
                ""  // Rechazar la entrada
            }
        }
        editTextHex.filters = arrayOf(hexInputFilter)

        buttonHexToBin.setOnClickListener {
            // Obtener el valor del EditText para hexadecimal
            val hexValue = editTextHex.text.toString().toUpperCase()

            // Validar y realizar la conversión a binario
            if (isHexadecimalNumber(hexValue)) {
                try {
                    // Convertir el número hexadecimal a binario
                    val decimalValue = Integer.parseInt(hexValue, 16)
                    val binaryValue = Integer.toBinaryString(decimalValue)

                    // Mostrar el resultado en el TextView
                    textViewResultHexToBin.text = "Resultado binario: $binaryValue"
                } catch (e: NumberFormatException) {
                    // Manejar la excepción si el valor no es un número hexadecimal válido
                    textViewResultHexToBin.text = "Ingrese un número hexadecimal válido"
                }
            } else {
                // Manejar el caso en que el EditText está vacío o no es un número hexadecimal válido
                textViewResultHexToBin.text = "Ingrese un número hexadecimal válido"
            }
        }

        buttonDecToHex.setOnClickListener {
            // Obtener el valor del EditText para decimal
            val decimalValue = editTextDecimal.text.toString()

            // Validar si el valor es un número decimal válido
            if (decimalValue.isNotEmpty() && isDecimalNumber(decimalValue)) {
                try {
                    // Convertir el número decimal a hexadecimal
                    val hexadecimalValue = Integer.toHexString(Integer.parseInt(decimalValue)).toUpperCase()

                    // Mostrar el resultado en el TextView
                    textViewResultDecToHex.text = "Resultado hexadecimal: $hexadecimalValue"
                } catch (e: NumberFormatException) {
                    // Manejar la excepción si el valor no es un número decimal válido
                    textViewResultDecToHex.text = "Ingrese un número decimal válido"
                }
            } else {
                // Manejar el caso en que el EditText está vacío o no es un número decimal válido
                textViewResultDecToHex.text = "Ingrese un número decimal válido"
            }
        }

        return view
    }

    private fun isHexadecimalNumber(value: String): Boolean {
        // Verificar si el valor es un número hexadecimal válido
        return value.matches(Regex("[0-9A-Fa-f]+"))
    }

    private fun isDecimalNumber(value: String): Boolean {
        // Verificar si el valor es un número decimal válido
        return value.matches(Regex("\\d+"))
    }
}
