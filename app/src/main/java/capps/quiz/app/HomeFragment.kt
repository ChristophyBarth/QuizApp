package capps.quiz.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import capps.quiz.app.databinding.FragmentHomeBinding
import capps.quiz.app.viewmodel.HomeFragmentVM
import capps.quiz.app.viewmodelfactory.HomeFragmentVMFactory

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeFragmentVM: HomeFragmentVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark)

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)

        val factory = HomeFragmentVMFactory()
        homeFragmentVM = ViewModelProvider(this, factory)[HomeFragmentVM::class.java]
        binding.homeFragViewModel = homeFragmentVM
        binding.lifecycleOwner = viewLifecycleOwner

        homeFragmentVM.uiText.observe(viewLifecycleOwner){ uiText ->

            val bundle = Bundle()
            bundle.putString("topic", uiText.asString(requireContext()))

            findNavController().navigate(R.id.action_homeFragment_to_quizFragment, bundle)
        }

        return binding.root
    }

}