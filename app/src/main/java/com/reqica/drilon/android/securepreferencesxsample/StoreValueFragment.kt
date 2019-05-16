package com.reqica.drilon.android.securepreferencesxsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.reqica.drilon.android.securepreferences.R
import com.reqica.drilon.android.securepreferencesx.SecurePreferences
import kotlinx.android.synthetic.main.fragment_store_value.*

class StoreValueFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store_value, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        store_value_button.setOnClickListener {
            if (input_value_edit_text.text.isNullOrEmpty() || input_key_edit_text.text.isNullOrEmpty()) {
                Toast.makeText(context, getString(R.string.error_message_fields_cannot_be_empty), Toast.LENGTH_SHORT)
                    .show()
            } else {
                val inputKey = input_key_edit_text.text.toString()
                val inputValue = input_value_edit_text.text.toString()
                SecurePreferences.storeValue(context!!, inputKey, inputValue)
                Toast.makeText(
                    context,
                    getString(R.string.success_message_successfully_stored_value, inputValue),
                    Toast.LENGTH_SHORT
                ).show()
                input_key_edit_text.text.clear()
                input_value_edit_text.text.clear()
            }
        }
    }

}
