package kg.bakai.sportbook.presentation.login.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import kg.bakai.sportbook.databinding.FragmentLoginBinding
import kg.bakai.sportbook.presentation.MainActivity
import kg.bakai.sportbook.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel by sharedViewModel<LoginViewModel>()
    private val loginFieldsAdapter = LoginFieldsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loginViewPager.adapter = loginFieldsAdapter
            loginViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if (position == loginFieldsAdapter.itemCount - 1) {
                        btnLoginNext.text = "Finish"
                    } else {
                        btnLoginNext.text = "Next"
                    }
                }
            })
            btnLoginNext.setOnClickListener {
                if (loginViewPager.currentItem + 1 < loginFieldsAdapter.itemCount) {
                    loginViewPager.currentItem = loginViewPager.currentItem + 1
                } else {
                    finishLogin()
                }
            }
        }
        loginViewModel.slidesLogin.observe(viewLifecycleOwner) {
            loginFieldsAdapter.submitItems(it)
        }
    }

    private fun finishLogin() {
        activity?.apply {
            startActivity(Intent(context, MainActivity::class.java))
            finish()
        }
        loginViewModel.saveProfileData()
    }

}