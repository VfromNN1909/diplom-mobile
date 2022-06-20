package me.vlasoff.afa.presentation.univerinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import me.vlasoff.afa.BaseFragment
import me.vlasoff.afa.databinding.FragmentUniverInfoBinding

@AndroidEntryPoint
class UniverInfoFragment : BaseFragment<FragmentUniverInfoBinding>() {

    private val viewModel: UniverInfoViewModel by viewModels()
    private val args: UniverInfoFragmentArgs by navArgs()

    override var bottomNavigationViewVisibility: Int = View.GONE

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = args.title
        viewModel.currentUniverTitle.postValue(title)
        setupTabs(title)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUniverInfoBinding {
        return FragmentUniverInfoBinding.inflate(inflater, container, false)
    }

    private fun setupTabs(title: String) {
        val pagerAdapter = ViewpagerAdapter(childFragmentManager, title)
        binding.tabs.addTab(binding.tabs.newTab().setText("Информация"))
        binding.tabs.addTab(binding.tabs.newTab().setText("Специальности"))
        binding.tabs.addTab(binding.tabs.newTab().setText("Программы"))
        binding.tabs.tabGravity = TabLayout.GRAVITY_FILL
        binding.viewpager.adapter = pagerAdapter
        binding.viewpager.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(binding.tabs)
        )
        binding.tabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewpager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }
}