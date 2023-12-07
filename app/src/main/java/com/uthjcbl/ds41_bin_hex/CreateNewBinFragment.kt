package com.uthjcbl.ds41_bin_hex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CreateNewBinFragment : BottomSheetDialogFragment() {

    interface OnItemAddedListener {
        fun onItemAddedListener(newItem: ListaBinHex)
    }

    private var itemAddedListener: OnItemAddedListener? = null

    fun setOnItemAddedListener(listener: ListaBinHex) {
        itemAddedListener
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bsd_new_binhex, container, false)

        val button = view.findViewById<Button>(R.id.bsd_submit)

        button.setOnClickListener {
            val country = ListaBinHex(
                9,
                "decimal",
                "lista de decimales ",
                "https://cdn.britannica.com/90/7490-004-BAD4AA72/Flag-China.jpg")
            itemAddedListener?.onItemAddedListener(country)
            dismiss()
        }

        return view
    }
}