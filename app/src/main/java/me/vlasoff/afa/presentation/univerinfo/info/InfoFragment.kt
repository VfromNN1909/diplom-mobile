package me.vlasoff.afa.presentation.univerinfo.info

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import me.vlasoff.afa.BaseFragment
import me.vlasoff.afa.R
import me.vlasoff.afa.databinding.FragmentInfoBinding
import me.vlasoff.afa.presentation.univerinfo.UniverInfoViewModel

@AndroidEntryPoint
class InfoFragment : BaseFragment<FragmentInfoBinding>() {

    private val viewModel: UniverInfoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString("title")
        title?.let {
            val univer = viewModel.getDataByTitle(title)
            binding.imageViewLogo.load(univer?.logoUrl)
            binding.textViewTitle.text = univer?.title
            binding.textViewDescription.text = univer?.info?.description
            binding.checkDormitory.isChecked = univer?.info?.hasDormitory ?: false
            binding.checkIsGovernmental.isChecked = univer?.info?.isGovernmental ?: false
            binding.checkHasMilitaryDepartment.isChecked = univer?.info?.hasMilitaryDepartment ?: false
            binding.checkHasLicence.isChecked = univer?.info?.hasLicence ?: false
            binding.checkHasFreePlaces.isChecked = univer?.info?.hasFreePlaces ?: false
            binding.phone.text = univer?.info?.phoneNumber
            binding.email.text = univer?.info?.email
            binding.address.text = univer?.info?.address
            binding.cite.text = univer?.info?.cite
        }
    }

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentInfoBinding {
        return FragmentInfoBinding.inflate(inflater, container, false)
    }

}