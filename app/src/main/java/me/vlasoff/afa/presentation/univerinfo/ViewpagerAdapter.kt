package me.vlasoff.afa.presentation.univerinfo

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import me.vlasoff.afa.presentation.univerinfo.info.InfoFragment
import me.vlasoff.afa.presentation.univerinfo.prog.ProgramsFragment
import me.vlasoff.afa.presentation.univerinfo.spec.SpecialitiesFragment

class ViewpagerAdapter(
    childFragmentManager: FragmentManager,
    private val title: String
) : FragmentPagerAdapter(
    childFragmentManager,
    FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> InfoFragment().apply { arguments = bundleOf("title" to title) }
            1 -> SpecialitiesFragment().apply { arguments = bundleOf("title" to title) }
            2 -> ProgramsFragment().apply { arguments = bundleOf("title" to title) }
            else -> getItem(position)
        }
    }
}