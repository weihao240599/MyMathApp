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
import com.example.mymathapp.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {
    private lateinit var vModel: MyViewModel

    lateinit var binding: FragmentQuestionBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false)

        vModel = ViewModelProvider(this).get(MyViewModel::class.java)

        binding.tvQuestion.text = vModel.getQuestion()

        binding.btnEnd.setOnClickListener(){
            Navigation.findNavController(it).navigate(R.id.action_questionFragment_to_resultFragment)
        }

        binding.btnSkip.setOnClickListener(){
           binding.tvQuestion.text = vModel.generateQuestion()
        }

        binding.btnSubmit.setOnClickListener(){
            val userInput : Int = binding.tfAnswer.text.toString().toInt()
            if(vModel.getAnswer() == userInput){
                vModel.score +=1
            }
        }

        return  binding.root
    }




}