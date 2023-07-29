package capps.quiz.app

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import capps.quiz.app.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    lateinit var binding: FragmentSplashBinding

    private lateinit var handler: Handler
    private lateinit var navigateToFragment: Runnable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_splash, container, false)

        handler = Handler(Looper.getMainLooper())
        navigateToFragment = Runnable {
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }

        handler.postDelayed(navigateToFragment, 3000)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        handler.removeCallbacks(navigateToFragment)
    }

}