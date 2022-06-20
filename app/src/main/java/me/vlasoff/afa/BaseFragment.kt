package me.vlasoff.afa

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint

abstract class BaseFragment<B: ViewBinding> : Fragment() {

    private var _binding: B? = null
    protected val binding get() = checkNotNull(_binding)

    protected open var bottomNavigationViewVisibility = View.VISIBLE

    abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?): B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("🍉", "onCreateView: ")
        _binding = initBinding(inflater, container)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setVisibility()
    }

    private fun setVisibility() {
        if (activity is MainActivity) {
            val mainActivity = activity as MainActivity
            mainActivity.setBottomNavigationVisibility(bottomNavigationViewVisibility)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}