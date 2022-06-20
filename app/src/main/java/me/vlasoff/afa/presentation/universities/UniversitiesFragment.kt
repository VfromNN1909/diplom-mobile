package me.vlasoff.afa.presentation.universities

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.vlasoff.afa.BaseFragment
import me.vlasoff.afa.databinding.FragmentUniversitiesBinding

@AndroidEntryPoint
class UniversitiesFragment : BaseFragment<FragmentUniversitiesBinding>(), IFragment {

    private val viewModel: UniversitiesViewModel by viewModels()

    private val universAdapter: UniversitiesAdapter by lazy {
        UniversitiesAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.writeData()
        binding.recyclerViewUnivers.apply {
            adapter = universAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getData().collect {
                Log.d("universities", it.toString())
                universAdapter.list = it
            }
        }
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUniversitiesBinding {
        return FragmentUniversitiesBinding.inflate(inflater, container, false)
    }
}