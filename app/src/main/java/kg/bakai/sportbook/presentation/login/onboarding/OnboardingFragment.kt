package kg.bakai.sportbook.presentation.login.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import kg.bakai.sportbook.R
import kg.bakai.sportbook.databinding.FragmentOnboardingBinding
import kg.bakai.sportbook.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnboardingFragment : Fragment() {
    private lateinit var binding: FragmentOnboardingBinding
    private val onboardingViewModel by viewModel<OnboardingViewModel>()
    private val loginViewModel by sharedViewModel<LoginViewModel>()

    private val adapter = OnboardingAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            onboardingViewPager.adapter = adapter
            onboardingViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if (position == adapter.itemCount - 1) {
                        btnOnboarding.text = "Start"
                    } else {
                        btnOnboarding.text = "Next"
                    }
                }
            })
            btnOnboarding.setOnClickListener {
                if (onboardingViewPager.currentItem + 1 < adapter.itemCount) {
                    onboardingViewPager.currentItem = onboardingViewPager.currentItem + 1
                } else {
                    finishOnboarding()
                }
            }
        }
        onboardingViewModel.slides.observe(viewLifecycleOwner) { slides ->
            adapter.submitItems(slides)
        }
    }

    private fun finishOnboarding() {
        findNavController().navigate(OnboardingFragmentDirections.actionOnboardingFragmentToLoginFragment())
        onboardingViewModel.finishOnboarding()
    }
}