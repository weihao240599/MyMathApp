package com.example.mymathapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.mymathapp.data.MyViewModel
import com.example.mymathapp.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var vModel: MyViewModel
    lateinit var binding : FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_result, container, false)

        vModel = ViewModelProvider(this).get(MyViewModel::class.java)

        binding.tvName.text = vModel.name
        binding.tvScore.text = vModel.score.toString()

        binding.btnOK.setOnClickListener(){
            Navigation.findNavController(it).navigate(R.id.action_registerFragment_to_questionFragment)
        }


        return binding.root
    }


}