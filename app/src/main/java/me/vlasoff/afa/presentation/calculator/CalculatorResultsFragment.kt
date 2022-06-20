package me.vlasoff.afa.presentation.calculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import me.vlasoff.afa.BaseFragment
import me.vlasoff.afa.R
import me.vlasoff.afa.databinding.FragmentCalculatorResultsBinding
import me.vlasoff.afa.presentation.univerinfo.spec.SpecialitiesRecyclerAdapter

@AndroidEntryPoint
class CalculatorResultsFragment : BaseFragment<FragmentCalculatorResultsBinding>() {

    private val viewModel: CalculatorViewModel by viewModels()
    private val args: CalculatorResultsFragmentArgs by navArgs()
    private val specAdapter: SpecialitiesRecyclerAdapter by lazy { SpecialitiesRecyclerAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewFoundSpecs.apply {
            adapter = specAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        val calculatorOptions = args.option
        Log.d("ege_calc", "$calculatorOptions")
        val specs = viewModel.findSpecialities(calculatorOptions)
        Log.d("ege_calc", "Specs: $specs\nsize: ${specs.size}")
        specAdapter.list = specs
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCalculatorResultsBinding {
        return FragmentCalculatorResultsBinding.inflate(inflater, container, false)
    }
}