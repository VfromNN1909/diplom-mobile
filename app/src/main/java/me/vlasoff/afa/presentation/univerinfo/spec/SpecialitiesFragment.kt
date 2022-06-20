package me.vlasoff.afa.presentation.univerinfo.spec

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import me.vlasoff.afa.BaseFragment
import me.vlasoff.afa.R
import me.vlasoff.afa.databinding.FragmentInfoBinding
import me.vlasoff.afa.databinding.FragmentSpecialitiesBinding
import me.vlasoff.afa.presentation.univerinfo.UniverInfoViewModel

@AndroidEntryPoint
class SpecialitiesFragment : BaseFragment<FragmentSpecialitiesBinding>() {

    private val viewModel: UniverInfoViewModel by viewModels()

    private val specialitiesAdapter: SpecialitiesRecyclerAdapter by lazy {
        SpecialitiesRecyclerAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewSpecialities.apply {
            adapter = specialitiesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        val title = arguments?.getString("title")
        title?.let {
            val univer = viewModel.getDataByTitle(title)
            if (univer != null)
                specialitiesAdapter.list = univer.specialities.toList()
        }
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSpecialitiesBinding {
        return FragmentSpecialitiesBinding.inflate(inflater, container, false)
    }

}