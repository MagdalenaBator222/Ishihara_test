package com.pl.agh.bator.ishihara_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.pl.agh.bator.ishihara_test.databinding.FragmentLoopTestBinding


/**
 * [LoopTestFragment] is where the proper colour blindness test takes place
 */

class LoopTestFragment : Fragment() {

    private var _binding : FragmentLoopTestBinding? = null
    private val binding get() = _binding!! // get-only property

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {} // empty for now
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoopTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // navigate to the next screen after clicking on one of the buttons
        // the code below is not working:
        view.findViewById<Button>(R.id.answer_1).setOnClickListener {
            findNavController().navigate(R.id.action_loopTestFragment_to_resultsTestFragment) }
        view.findViewById<Button>(R.id.answer_2).setOnClickListener {
            findNavController().navigate(R.id.action_loopTestFragment_to_resultsTestFragment) }
        view.findViewById<Button>(R.id.answer_3).setOnClickListener {
            findNavController().navigate(R.id.action_loopTestFragment_to_resultsTestFragment) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}