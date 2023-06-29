package com.pl.agh.bator.ishihara_test

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.pl.agh.bator.ishihara_test.databinding.FragmentLeaderboardBinding

/**
 * Fragment for displaying the leaderboard.
 */
class LeaderboardFragment : Fragment() {

    private var _binding: FragmentLeaderboardBinding? = null
    private val binding get() = _binding!! // get-only property

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {} // empty for now

        // if the back button is pressed, go back to main menu
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.action_leaderboardFragment_to_chooseModeFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLeaderboardBinding.inflate(inflater, container, false)

        //TODO: Get real
        // temporary displaying made up leaderboard
        val mockupData = MockupData().loadMockup()
        val recyclerView = _binding!!.recyclerView
        recyclerView.adapter = LeaderboardAdapter(mockupData)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // return to main menu
        binding.returnToMenu.setOnClickListener {
            findNavController().navigate(R.id.action_leaderboardFragment_to_chooseModeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}