package kg.bakai.sportbook.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.bakai.sportbook.R
import kg.bakai.sportbook.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            mainViewModel.userData.observe(viewLifecycleOwner) { user ->
                tvUserName.text = "Привет, ${user.name}"
                tvUserHeight.text = "${user.currentHeight.toString()} см"
                tvUserWeight.text = "${user.currentWeight.toString()} кг"
                tvGoalWeight.text = "Цель: ${user.goalWeight} кг"
                val weightDifference = user.goalWeight!! - user.currentWeight!!
                tvGoalWeightText.text = "Тебе надо набрать ещё $weightDifference кг"

                val progress = (user.currentWeight!! / user.goalWeight!!) * 100

                progressBarWeight.progress = progress.toInt()
            }
        }
    }

}