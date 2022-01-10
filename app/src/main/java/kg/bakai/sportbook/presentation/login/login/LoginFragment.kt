package kg.bakai.sportbook.presentation.login.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.viewpager2.widget.ViewPager2
import kg.bakai.sportbook.databinding.FragmentLoginBinding
import kg.bakai.sportbook.presentation.MainActivity
import kg.bakai.sportbook.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel by sharedViewModel<LoginViewModel>()

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
            etLoginFieldName.doOnTextChanged { text, _, _, _ ->
                loginViewModel.name.postValue(text.toString())
            }
            etLoginFieldAge.doOnTextChanged { text, _, _, _ ->
                loginViewModel.age.postValue(text.toString().toIntOrNull())
            }
            etLoginFieldHeight.doOnTextChanged { text, _, _, _ ->
                loginViewModel.height.postValue(text.toString().toIntOrNull())
            }
            etLoginFieldWeight.doOnTextChanged { text, _, _, _ ->
                loginViewModel.weight.postValue(text.toString().toIntOrNull())
            }
            etLoginFieldGoalWeight.doOnTextChanged { text, _, _, _ ->
                loginViewModel.goalWeight.postValue(text.toString().toIntOrNull())
            }
            loginViewModel.isValid.observe(viewLifecycleOwner) { valid ->
                btnStart.isEnabled = valid
            }
            btnStart.setOnClickListener {
                finishLogin()
            }
        }
    }

    private fun finishLogin() {
        loginViewModel.saveProfileData()
        activity?.apply {
            startActivity(Intent(context, MainActivity::class.java))
            finish()
        }
    }

}