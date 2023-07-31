package capps.quiz.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import capps.quiz.app.databinding.FragmentResultBinding
import capps.quiz.app.viewmodel.ResultFragmentVM
import capps.quiz.app.viewmodelfactory.ResultFragmentVMFactory

class ResultFragment : Fragment() {
    private lateinit var binding : FragmentResultBinding
    private lateinit var resultFragmentVM: ResultFragmentVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_result, container, false)

        val topic = requireArguments().getString("topic")
        val score = requireArguments().getInt("score")
        val questionCount = requireArguments().getInt("questionCount")

        val factory = ResultFragmentVMFactory(score, questionCount)
        resultFragmentVM = ViewModelProvider(this, factory)[ResultFragmentVM::class.java]
        binding.resultViewModel = resultFragmentVM
        binding.lifecycleOwner = viewLifecycleOwner

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                findNavController().popBackStack(R.id.homeFragment,false)
            }
        })

        binding.cancel.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment,false)
        }

        binding.newQuiz.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("topic", topic)

            findNavController().navigate(R.id.action_resultFragment_to_quizFragment, bundle)
        }


        return binding.root
    }


}