package com.reqica.drilon.android.securepreferencesxsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.reqica.drilon.android.securepreferencesx.SecurePreferences
import kotlinx.android.synthetic.main.fragment_retrieve_value.*

class RetrieveValueFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_retrieve_value, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        retrieve_value_button.setOnClickListener {
            if (input_key_edit_text.text.isNullOrEmpty()) {
                Toast.makeText(context, getString(R.string.error_message_field_cannot_be_empty), Toast.LENGTH_SHORT)
                    .show()
            } else {
                val retrievedValue = SecurePreferences.retrieveValue(context!!, input_key_edit_text.text.toString(), null)
                if (retrievedValue.isNullOrEmpty()) {
                    retrieved_value_text_view.text =
                        getString(R.string.error_message_no_value_for_key, input_key_edit_text.text.toString())
                } else {
                    retrieved_value_text_view.text = getString(R.string.retrieved_value, retrievedValue)
                }
            }
        }
    }
}