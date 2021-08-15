package com.example.mymathapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.mymathapp.data.MyViewModel
import com.example.mymathapp.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var vModel: MyViewModel

    lateinit var binding : FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)

        vModel = MyViewModel()

        binding.btnStart.setOnClickListener(){
            val name = binding.tfInputName.text.toString()

            vModel.name = name

            Navigation.findNavController(it).navigate(R.id.action_registerFragment_to_questionFragment)
        }

        return binding.root
    }


}