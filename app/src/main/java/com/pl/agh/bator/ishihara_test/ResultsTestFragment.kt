package com.pl.agh.bator.ishihara_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.pl.agh.bator.ishihara_test.databinding.FragmentChooseModeBinding


/**
 * Fragment where the test results are displayed (for the test mode)
 */
class ResultsTestFragment : Fragment() {

    private var _binding : FragmentChooseModeBinding? = null
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
        _binding = FragmentChooseModeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.return_to_menu).setOnClickListener {
            findNavController().navigate(R.id.action_resultsTestFragment_to_chooseModeFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}