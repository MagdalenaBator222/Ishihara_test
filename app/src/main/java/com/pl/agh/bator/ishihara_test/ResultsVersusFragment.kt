package com.pl.agh.bator.ishihara_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.pl.agh.bator.ishihara_test.databinding.FragmentResultsVersusBinding

/**
 * Fragment where the test results are displayed (for the versus mode).
 * The user can choose whether to submit the results for display on the leaderboard or return
 * to main menu.
 */

class ResultsVersusFragment : Fragment() {
    private var _binding: FragmentResultsVersusBinding? = null
    private val binding get() = _binding!! // get-only property

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {} // empty for now

        // if the back button is pressed, go back to main menu
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.action_resultsVersusFragment_to_chooseModeFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResultsVersusBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // return to main menu or submit your result to be displayed on the leaderboard
        binding.returnToMenu.setOnClickListener {
            findNavController().navigate(R.id.action_resultsVersusFragment_to_chooseModeFragment)
        }
        binding.submit.setOnClickListener {
            findNavController().navigate(R.id.action_resultsVersusFragment_to_leaderboardFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}