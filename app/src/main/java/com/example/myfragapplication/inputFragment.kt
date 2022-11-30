package com.example.myfragapplication

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import com.example.myfragapplication.databinding.FragmentInputBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "number1"
private const val ARG_PARAM2 = "number2"
private const val ARG_PARAM3 = "number3"

/**
 * A simple [Fragment] subclass.
 * Use the [inputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class inputFragment : Fragment() {
    var binding: FragmentInputBinding? = null
    private var number1: Int = 0
    private var number2: Int = 0
    private var number3: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            number1 = it.getInt("number1", 0)
            number2 = it.getInt("number2", 0)
            number3 = it.getInt("number3", 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInputBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        binding?.edtNumber1?.setText(number1.toString())
        binding?.edtNumber2?.setText(number2.toString())
        binding?.edtNumber3?.setText(number3.toString())

        binding?.edtNumber1?.setOnKeyListener { view, i, keyEvent ->
            setResult()
            false
        }
        binding?.edtNumber2?.setOnKeyListener { view, i, keyEvent ->
            setResult()
            false
        }
        binding?.edtNumber3?.setOnKeyListener { view, i, keyEvent ->
            setResult()
            false
        }
        return binding?.root
    }

    fun setResult() {
        Bundle().let  { bundle ->
            binding?.edtNumber1?.text.toString().toIntOrNull()?.let { number ->
                bundle.putInt("number1", number)
            }
            binding?.edtNumber2?.text.toString().toIntOrNull()?.let { number ->
                bundle.putInt("number2", number)
            }
            binding?.edtNumber3?.text.toString().toIntOrNull()?.let { number ->
                bundle.putInt("number3", number)
            }
            setFragmentResult("input", bundle)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment inputFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(number1: Int?, number2: Int?, number3: Int?) =
            inputFragment().apply {
                arguments = Bundle().apply {
                    number1?.let{
                        putInt("number1", it)
                    }
                    number2?.let{
                        putInt("number2", it)
                    }
                    number3?.let{
                        putInt("number3", it)
                    }
                }
            }
    }
}