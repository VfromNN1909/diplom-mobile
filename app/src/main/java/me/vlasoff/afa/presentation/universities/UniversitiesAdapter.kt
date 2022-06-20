package me.vlasoff.afa.presentation.universities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import me.vlasoff.afa.R
import me.vlasoff.afa.databinding.FragmentUniverInfoBinding
import me.vlasoff.afa.databinding.UniverRecyclerItemBinding
import me.vlasoff.afa.domain.models.University
import me.vlasoff.afa.presentation.univerinfo.UniverInfoFragmentArgs

class UniversitiesAdapter(
    private val fragment: IFragment
) : RecyclerView.Adapter<UniversitiesAdapter.ViewHolder>() {

    var list = emptyList<University>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UniversitiesAdapter.ViewHolder =
        ViewHolder(parent)

    override fun onBindViewHolder(holder: UniversitiesAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val binding: UniverRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
            UniverRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: University) {
            binding.univerLogo.load(item.logoUrl)
            binding.universityTitle.text = item.title
            binding.univerCity.text = item.city
            binding.root.setOnClickListener {
                (fragment as UniversitiesFragment).findNavController()
                    .navigate(
                        R.id.action_universitiesFragment_to_univerInfoFragment,
                        UniverInfoFragmentArgs.Builder(item.title).build().toBundle()
                    )
            }
        }
    }
}