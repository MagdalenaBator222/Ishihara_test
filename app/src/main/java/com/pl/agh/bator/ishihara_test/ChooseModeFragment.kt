package com.pl.agh.bator.ishihara_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pl.agh.bator.ishihara_test.databinding.FragmentChooseModeBinding


/**
 * Fragment for choosing the game mode
 */
class ChooseModeFragment : Fragment() {

    private var _binding : FragmentChooseModeBinding? = null
    private val binding get() = _binding!! // get-only property

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {} // empty, might add something later
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
        binding.testOption.setOnClickListener {
            changeDescription(false)
        }
        binding.versusOption.setOnClickListener {
            changeDescription(true)
        }
        binding.startGame.setOnClickListener {
            if(binding.selectMode.checkedButtonId == R.id.test_option) {
                findNavController().navigate(R.id.action_chooseModeFragment_to_loopTestFragment)
            } else {
                findNavController().navigate(R.id.action_chooseModeFragment_to_loopVersusFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //TODO change to enums or smth or even ViewModel
    //for now true = versus
    fun changeDescription(state: Boolean) {
        if(state)
        {
            _binding!!.descriptionImage.setImageResource(R.drawable.podium)
            binding!!.descriptionText.setText(R.string.versus_description)
        }
        else
        {
            _binding!!.descriptionImage.setImageResource(R.drawable.eye)
            _binding!!.descriptionText.setText(R.string.test_description)
        }
    }
}