package com.example.fragmentwork

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class OneFragment : Fragment(R.layout.fragment_one) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firstName = requireActivity().findViewById<EditText>(R.id.etFirstName)
        val lastName = requireActivity().findViewById<EditText>(R.id.etLastName)
        val email = requireActivity().findViewById<EditText>(R.id.etEmail)
        val savedButton = requireActivity().findViewById<Button>(R.id.btnFragment2)

        savedButton.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("firstName", firstName.getText().toString())
            bundle.putString("lastName", lastName.getText().toString())
            bundle.putString("email", email.getText().toString())
            val secondFragment = TwoFragment()
            secondFragment.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(android.R.id.content, secondFragment).commit()

        }
    }
}