package kg.bakai.sportbook.presentation.login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kg.bakai.sportbook.R
import kg.bakai.sportbook.databinding.ActivityLoginBinding
import kg.bakai.sportbook.presentation.login.onboarding.OnboardingFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private val TAG = "LoginActivity"

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel by viewModel<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = findNavController(R.id.nav_host_fragment_login)
        loginViewModel.isFirstLaunch.observe(this) { isFirstTime ->
            Log.i(TAG, isFirstTime.toString())
            if (!isFirstTime) {
                navController.navigate(OnboardingFragmentDirections.actionOnboardingFragmentToLoginFragment())
            }
        }
    }
}