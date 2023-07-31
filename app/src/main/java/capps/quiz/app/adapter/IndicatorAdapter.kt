package capps.quiz.app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import capps.quiz.app.R
import capps.quiz.app.databinding.IndicatorBinding
import capps.quiz.app.model.Quiz

class IndicatorAdapter(private val context: Context, private val questions: MutableList<Quiz>?) :
    RecyclerView.Adapter<IndicatorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndicatorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<IndicatorBinding>(
            layoutInflater,
            R.layout.indicator,
            parent,
            false
        )

        return IndicatorViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return questions!!.size
    }

    override fun onBindViewHolder(holder: IndicatorViewHolder, position: Int) {
        holder.bind(questions!![position].selected!!, context)

        val proposedItemWidth = calculateItemWidth(context, questions.size)

        val layoutParams = holder.itemView.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width = proposedItemWidth
        holder.itemView.layoutParams = layoutParams
    }
    private fun calculateItemWidth(context: Context, itemCount: Int): Int {
        val displayMetrics = context.resources.displayMetrics
        val screenWidth = displayMetrics.widthPixels

        // Calculate the new item width based on the screen width and margins
        //Removed 15dp for recyclerview marginHorizontal
        val newScreenWidth = screenWidth - dpToPx(context, 30)
        val itemViewMargin = dpToPx(context, 5)

        return newScreenWidth / itemCount - itemViewMargin
    }
    private fun dpToPx(context: Context, dp: Int): Int {
        val density = context.resources.displayMetrics.density
        return (dp * density).toInt()
    }
}

class IndicatorViewHolder(val binding: IndicatorBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(selected: Boolean, context: Context) {
        if (selected) {
            binding.indicator.background =
                ContextCompat.getDrawable(context, R.drawable.indicator_bg)
        } else {
            binding.indicator.background =
                ContextCompat.getDrawable(context, R.drawable.indicator2_bg)
        }
    }
}
