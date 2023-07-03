package com.pl.agh.bator.ishihara_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.pl.agh.bator.ishihara_test.databinding.FragmentResultsTestBinding


/**
 * Fragment where the test results are displayed (for the test mode)
 */
class ResultsTestFragment : Fragment() {

    private var _binding : FragmentResultsTestBinding? = null
    private val binding get() = _binding!! // get-only property
    private val viewModel : IshiharaViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {} // empty for now

        // if the back button is pressed, go back to main menu
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.action_resultsTestFragment_to_chooseModeFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResultsTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        val colorBlindnessResults = translateResults()
        binding.leaderboardDescription.text = colorBlindnessResults

        // return to main menu:
        binding.returnToMenu.setOnClickListener {
            findNavController().navigate(R.id.action_resultsTestFragment_to_chooseModeFragment)
        }
    }

    //TODO: change translation for something that user could figure out
    fun translateResults() : String{
        var resultString = ""
        val redGreenScore = viewModel.colorBlindnessScores.value!![1]
        val protanopiaScore = viewModel.colorBlindnessScores.value!![2]
        val deuteranopiaScore = viewModel.colorBlindnessScores.value!![3]
        val otherScore = viewModel.colorBlindnessScores.value!![4]

        resultString += ("Red green: $redGreenScore ")
        resultString += ("Protanopia: $protanopiaScore ")
        resultString += ("Deuteranopia: $deuteranopiaScore ")
        resultString += ("Other: $otherScore")

        return resultString
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}