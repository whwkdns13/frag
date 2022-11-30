package com.example.myfragapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.example.myfragapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private var number1: Int = 0
    private var number2: Int = 0
    private var number3: Int = 0

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().run {
            replace(binding.frmFragment.id, fragment)
            commit()
        }
    }
    fun replaceInputFragment(){
        val inputFragment = inputFragment.newInstance(number1,number2,number3)

        replaceFragment(inputFragment)

        inputFragment.setFragmentResultListener("input") { _, bundle ->
            number1 = bundle.getInt("number1", 0)
            number2 = bundle.getInt("number2", 0)
            number3 = bundle.getInt("number3", 0)
            bundle.getInt("number1", 0)
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceInputFragment()

        binding.btnInput.setOnClickListener {
            replaceInputFragment()
        }

        binding.btnFirst.setOnClickListener {
            replaceFragment(ResultFragment.newInstance(number1))
        }

        binding.btnSecond.setOnClickListener {
            replaceFragment(ResultFragment.newInstance(number2))
        }
    }
}