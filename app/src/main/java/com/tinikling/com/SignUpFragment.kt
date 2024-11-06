package com.tinikling.com

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.tinikling.com.databinding.FragmentSignInBinding
import com.tinikling.com.databinding.FragmentSignUpBinding
import com.tinikling.com.table.User
import com.tinikling.com.util.ProgressDialogUtils
import com.tinikling.com.util.SignUpModelFactory
import kotlinx.coroutines.launch


class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    private val viewModel: ViewModelSignUp by viewModels { SignUpModelFactory(requireContext()) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCreate.setOnClickListener {
            ProgressDialogUtils.showProgressDialog(requireContext(), "Loading...")
            Handler(Looper.getMainLooper()).postDelayed({
                validateData()
                ProgressDialogUtils.dismissProgressDialog()
            }, 1000)
        }


    }

    private var fullName = ""
    private var email = ""
    private var age = ""
    private var password = ""
    private fun validateData() {
        fullName = binding.etFullName.text.toString().trim()
        email = binding.emailEditText.text.toString().trim()
        age = binding.etAge.text.toString().trim()
        password = binding.passwordEditText.text.toString().trim()
        if (fullName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && age.isNotEmpty()) {
            uploadInDb()
        }
    }

    private fun uploadInDb() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.insertUser(
                User(
                    1,
                    fullName,
                    age.toInt(),
                    email,
                    password,
                    0
                )
            )
            Toast.makeText(requireContext(), "Account Created", Toast.LENGTH_SHORT).show();
            findNavController().navigate(R.id.signInFragment)
        }
    }
}