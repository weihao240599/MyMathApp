package com.example.mymathapp.data

import androidx.lifecycle.ViewModel

class MyViewModel :ViewModel(){
    var name: String = ""
    var no1 : Int = 0
    var no2 : Int = 0
    var score: Int = 0

    init{
        generateQuestion()
    }

    fun generateQuestion():String{
        var no1 = (Math.random()*100).toInt()
        var no2 = (Math.random()*100).toInt()

        return "${no1} + ${no2} = ?"
    }

    fun getQuestion():String{
        return "${no1} + ${no2} = ?"
    }

    fun getAnswer():Int{
        return no1 + no2
    }
}
