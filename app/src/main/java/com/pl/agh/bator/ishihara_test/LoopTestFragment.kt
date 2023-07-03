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
import com.pl.agh.bator.ishihara_test.databinding.FragmentLoopTestBinding


/**
 * [LoopTestFragment] is where the proper colour blindness test takes place (test mode)
 */

class LoopTestFragment : Fragment() {

    private var _binding : FragmentLoopTestBinding? = null
    private val binding get() = _binding!! // get-only property

    private val sharedViewModel : IshiharaViewModel by activityViewModels()

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
        _binding = FragmentLoopTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.reinitializeData(false)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
        }
        updatePlateOnScreen()
        // navigate to the next screen after clicking on one of the buttons
        binding.answer1.setOnClickListener {
            onAnswerSelected()
        }

        binding.answer2.setOnClickListener {
            onAnswerSelected()
        }

        binding.answer3.setOnClickListener {
            onAnswerSelected()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onAnswerSelected() {
        if(sharedViewModel.currentAnswerCount.value == sharedViewModel.MAX_NO_OF_PLATES) {
            findNavController().navigate(R.id.action_loopTestFragment_to_resultsTestFragment)
        } else {
            sharedViewModel.getNextPlate()
            updatePlateOnScreen()
        }
    }

    private fun updatePlateOnScreen() {
        binding.plateImage.setImageResource(sharedViewModel.currentPlate.value!!.imageResource)
        val answerOrder = listOf<Int>(0, 1, 2).shuffled()

        binding.answer1.text = sharedViewModel.currentPlate.value!!.answers[answerOrder[0]].answer
        binding.answer2.text = sharedViewModel.currentPlate.value!!.answers[answerOrder[1]].answer
        binding.answer3.text = sharedViewModel.currentPlate.value!!.answers[answerOrder[2]].answer
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
                findNavController().navigate(R.id.action_loopTestFragment_to_chooseModeFragment)
            }
            .setNegativeButton(getString(R.string.cancel_btn)) { _, _ ->
                // nothing, as the dialog window should disappear once any of the two
                // buttons is clicked
            }
            .show()
    }
}