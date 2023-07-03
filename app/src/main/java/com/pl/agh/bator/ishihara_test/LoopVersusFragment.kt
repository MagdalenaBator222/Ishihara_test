package com.pl.agh.bator.ishihara_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.pl.agh.bator.ishihara_test.data.Datasource
import com.pl.agh.bator.ishihara_test.databinding.FragmentLoopVersusBinding

/**
 * [LoopVersusFragment] is where the colour blindness test takes place in versus mode
 */
class LoopVersusFragment : Fragment() {
    private var _binding : FragmentLoopVersusBinding? = null
    private val binding get() = _binding!! // get-only property

    private val viewModel : IshiharaViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {} // empty for now

        // show the dialog window if the user presses the "back" button:
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            showReturnDialog()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoopVersusBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.reinitializeData(true)
        updatePlateOnScreen()
        // navigate to the next screen after clicking on one of the buttons
        binding.answer1.setOnClickListener {
            onAnswerSelected(1)
        }

        binding.answer2.setOnClickListener {
            onAnswerSelected(2)
        }

        binding.answer3.setOnClickListener {
            onAnswerSelected(3)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onAnswerSelected(answer: Int) {
        viewModel.checkAnswer(answer)
        if(viewModel.currentAnswerCount.value == viewModel.MAX_NO_OF_PLATES) {
            findNavController().navigate(R.id.action_loopVersusFragment_to_resultsVersusFragment)
        } else {
            viewModel.getNextPlate()
            updatePlateOnScreen()
        }
    }

    private fun updatePlateOnScreen() {
        binding.plateImage.setImageResource(viewModel.currentPlate.value!!.imageResource)
        val answerOrder = listOf<Int>(0, 1, 2).shuffled()
        viewModel.setOrder(answerOrder)
        binding.answer1.text = viewModel.currentPlate.value!!.answers[answerOrder[0]].answer
        binding.answer2.text = viewModel.currentPlate.value!!.answers[answerOrder[1]].answer
        binding.answer3.text = viewModel.currentPlate.value!!.answers[answerOrder[2]].answer
    }

    /*
    * method for displaying a dialog window if the user presses the "back" button during the test
     */
    private fun showReturnDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.return_dialog))
            .setMessage(getString(R.string.return_dialog_detail))
            .setCancelable(false)
            .setPositiveButton(getString(R.string.confirm_btn)) { _, _ ->
                findNavController().navigate(R.id.action_loopVersusFragment_to_chooseModeFragment)
            }
            .setNegativeButton(getString(R.string.cancel_btn)) { _, _ ->
                // nothing, as the dialog window should disappear once any of the two
                // buttons is clicked
            }
            .show()
    }
}