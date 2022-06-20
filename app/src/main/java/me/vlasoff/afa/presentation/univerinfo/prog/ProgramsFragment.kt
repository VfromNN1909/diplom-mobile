package me.vlasoff.afa.presentation.univerinfo.prog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import me.vlasoff.afa.BaseFragment
import me.vlasoff.afa.R
import me.vlasoff.afa.databinding.FragmentProgramsBinding
import me.vlasoff.afa.presentation.univerinfo.UniverInfoViewModel

@AndroidEntryPoint
class ProgramsFragment : BaseFragment<FragmentProgramsBinding>() {

    private val viewModel: UniverInfoViewModel by viewModels()

    private val programsAdapter: ProgramsRecyclerAdapter by lazy {
        ProgramsRecyclerAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewPrograms.apply {
            adapter = programsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        val title = arguments?.getString("title")
        title?.let {
            val univer = viewModel.getDataByTitle(title)
            if (univer != null)
                programsAdapter.list = univer.programs.toList()
        }
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProgramsBinding {
        return FragmentProgramsBinding.inflate(inflater, container, false)
    }
}