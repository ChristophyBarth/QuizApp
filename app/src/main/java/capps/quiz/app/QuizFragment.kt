package capps.quiz.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import capps.quiz.app.adapter.IndicatorAdapter
import capps.quiz.app.adapter.IndicatorViewHolder
import capps.quiz.app.databinding.FragmentQuizBinding
import capps.quiz.app.others.Quizzes
import capps.quiz.app.viewmodel.QuizFragmentVM
import capps.quiz.app.viewmodelfactory.QuizFragmentVMFactory
import cn.pedant.SweetAlert.SweetAlertDialog


class QuizFragment : Fragment() {
    private lateinit var binding: FragmentQuizBinding
    private lateinit var quizFragmentVM: QuizFragmentVM

    private lateinit var indicatorAdapter: IndicatorAdapter

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

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        indicatorAdapter = IndicatorAdapter(requireContext(), quizFragmentVM.questions.value)
        binding.recyclerViewIndicator.layoutManager = layoutManager
        binding.recyclerViewIndicator.adapter = indicatorAdapter

        quizFragmentVM.buttonTextChanger.observe(viewLifecycleOwner){}

        quizFragmentVM.buttonClicked.observe(viewLifecycleOwner){
            if (quizFragmentVM.currentQuestion.value!!.plus(1) == questions.size && quizFragmentVM.userSelection.value != ""){
                val bundle = Bundle()
                bundle.putString("topic", topic)
                bundle.putInt("score", quizFragmentVM.score.value!!)
                bundle.putInt("questionCount", questions.size)
                findNavController().navigate(R.id.action_quizFragment_to_resultFragment, bundle)
            }

            updateIndicator(quizFragmentVM.currentQuestion.value!!)
        }

        binding.quitQuiz.setOnClickListener {
            areYouSureDialog()
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                areYouSureDialog()
            }

        })

        return binding.root
    }

    private fun areYouSureDialog() {
        val sweetAlertDialog = SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
        sweetAlertDialog.titleText = "Quit Quiz?"
        sweetAlertDialog.contentText = "Are you sure you want to quit the quiz?"
        sweetAlertDialog.setCancelable(true)
        sweetAlertDialog.confirmText = "Yes"
        sweetAlertDialog.cancelText = "No"

        sweetAlertDialog.setConfirmClickListener { dialog ->
            dialog.dismissWithAnimation()
            findNavController().popBackStack()
        }

        sweetAlertDialog.setCancelClickListener { dialog ->
            dialog.dismissWithAnimation()
        }

        sweetAlertDialog.show()
    }

    private fun updateIndicator(position: Int) {
        // Update the indicatorView in the ViewHolder at the given position
        val viewHolder = binding.recyclerViewIndicator.findViewHolderForAdapterPosition(position) as IndicatorViewHolder
        viewHolder.binding.indicator.background = ContextCompat.getDrawable(requireContext(), R.drawable.indicator_bg)
    }
}