package capps.quiz.app.others

import android.util.Log
import android.view.View
import android.widget.ScrollView
import android.widget.TextView
import androidx.annotation.MainThread
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEvent<T> : MutableLiveData<T>() {
    val TAG: String = "SingleLiveEvent"

    private val mPending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {

        if (hasActiveObservers()) {
            Log.w(TAG, "Multiple observers registered but only one will be notified of changes.")
        }

        // Observe the internal MutableLiveData
        super.observe(owner, Observer<T> { t ->
            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        })
    }

    @MainThread
    override fun setValue(@Nullable t: T?) {
        mPending.set(true)
        super.setValue(t)
    }

    /**
     * Used for cases where T is Void, to make calls cleaner.
     */
    @MainThread
    fun call() {
        value = null
    }
}

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("viewBackground")
    fun setViewBackground(view: View, resId: Int?) {
        view.background = ContextCompat.getDrawable(view.context, resId!!)
    }

    @JvmStatic
    @BindingAdapter("correspondingTextViewBG")
    fun setTextColor(textView: TextView, color: Int?) {
        textView.setTextColor(ContextCompat.getColor(textView.context, color!!))
    }

    @JvmStatic
    @BindingAdapter("scroll")
    fun scroll(scrollView: ScrollView, scrollUp: Boolean) {
        if (scrollUp && scrollView.scrollY != 0) {
            scrollView.smoothScrollTo(0,0)
        }
    }
}