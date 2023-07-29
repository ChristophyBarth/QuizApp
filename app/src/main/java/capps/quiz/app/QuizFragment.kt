package capps.quiz.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import capps.quiz.app.databinding.FragmentQuizBinding
import capps.quiz.app.others.Quizzes
import capps.quiz.app.viewmodel.QuizFragmentVM
import capps.quiz.app.viewmodelfactory.QuizFragmentVMFactory

class QuizFragment : Fragment() {
    private lateinit var binding: FragmentQuizBinding
    private lateinit var quizFragmentVM: QuizFragmentVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.blue_black)

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_quiz, container, false)

        val topic = requireArguments().getString("topic")!!
        val questions = Quizzes(requireContext(),topic).getQuestions()

        val factory = QuizFragmentVMFactory(topic,questions)
        quizFragmentVM = ViewModelProvider(this, factory)[QuizFragmentVM::class.java]
        binding.quizViewModel = quizFragmentVM
        binding.lifecycleOwner = viewLifecycleOwner

        quizFragmentVM.buttonTextChanger.observe(viewLifecycleOwner){}

        quizFragmentVM.buttonClicked.observe(viewLifecycleOwner){
            if (quizFragmentVM.currentQuestion.value!!.plus(1) == 3 && quizFragmentVM.userSelection.value != ""){
                val bundle = Bundle()
                bundle.putString("topic", topic)
                bundle.putInt("score", quizFragmentVM.score.value!!)
                bundle.putInt("questionCount", questions.size)
                findNavController().navigate(R.id.action_quizFragment_to_resultFragment, bundle)
            }
        }

        binding.quitQuiz.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

}