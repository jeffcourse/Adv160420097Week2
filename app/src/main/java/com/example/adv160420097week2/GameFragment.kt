package com.example.adv160420097week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null){
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            val txtTurn = view.findViewById<TextView>(R.id.txtTurn)
            txtTurn.text = "$playerName's Turn"
        }
        var score = 0
        var trueAns = 0
        val first = (1..1000).random()
        val second = (1..1000).random()
        val txtNumbers = view.findViewById<TextView>(R.id.txtNumbers)
        txtNumbers.text = "$first + $second"
        trueAns = first + second
        val btnSubmit = view.findViewById<Button>(R.id.btnSubmit)
        btnSubmit.setOnClickListener{
            val txtAnswer = view.findViewById<TextView>(R.id.txtAnswer)
            val answer = txtAnswer.text.toString().toInt()
            if(trueAns == answer){
                score++
                Toast.makeText(activity, "Congratulations! you get 1 point",Toast.LENGTH_SHORT).show()
                val first = (1..1000).random()
                val second = (1..1000).random()
                val txtNumbers = view.findViewById<TextView>(R.id.txtNumbers)
                txtNumbers.text = "$first + $second"
                trueAns = first + second
            }
            else{
                val action = GameFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GameFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GameFragment().apply {

            }
    }
}