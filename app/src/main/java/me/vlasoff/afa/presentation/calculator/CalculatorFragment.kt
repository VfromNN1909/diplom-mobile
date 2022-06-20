package me.vlasoff.afa.presentation.calculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import me.vlasoff.afa.BaseFragment
import me.vlasoff.afa.R
import me.vlasoff.afa.databinding.FragmentCalculatorBinding

@AndroidEntryPoint
class CalculatorFragment : BaseFragment<FragmentCalculatorBinding>() {

    private val viewModel: CalculatorViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSpinners()
        binding.buttonFindUniversity.setOnClickListener {
            val calculatorOptions = viewModel.buildCalculatorOptions(
                binding.spinnerRusLang.selectedItem.toString(),
                binding.spinnerMaths.selectedItem.toString(),
                Pair(
                    binding.examFirstOther.selectedItem.toString(),
                    binding.spinnerFirstOther.selectedItem.toString()
                ),
                Pair(
                    binding.examSecondOther.selectedItem.toString(),
                    binding.spinnerSecondOther.selectedItem.toString()
                ),
            )
            findNavController().navigate(
                CalculatorFragmentDirections.actionCalculatorFragmentToCalculatorResultsFragment(
                    calculatorOptions
                )
            )
        }
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCalculatorBinding {
        return FragmentCalculatorBinding.inflate(inflater, container, false)
    }

    private fun setupSpinners() {
        val marks = (0..100).reversed().map { it.toString() }.toList().toTypedArray()
        val adapter =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, marks)
        binding.spinnerRusLang.adapter = adapter
        binding.spinnerMaths.adapter = adapter
        binding.spinnerFirstOther.adapter = adapter
        binding.spinnerSecondOther.adapter = adapter
    }
}