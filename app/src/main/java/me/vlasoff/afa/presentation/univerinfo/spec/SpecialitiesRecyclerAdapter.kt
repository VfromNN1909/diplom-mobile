package me.vlasoff.afa.presentation.univerinfo.spec

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.vlasoff.afa.databinding.SpecialityRecyclerItemBinding
import me.vlasoff.afa.domain.models.Speciality

class SpecialitiesRecyclerAdapter : RecyclerView.Adapter<SpecialitiesRecyclerAdapter.ViewHolder>() {

    var list = emptyList<Speciality>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(private val binding: SpecialityRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
            SpecialityRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

        fun bind(item: Speciality) {
            binding.tvTitle.text = item.title
            binding.tvStudyingForms.text = item.studyingForms.toList().joinToString(",").trim()
            val examsString = "ЕГЭ: ${item.exams.toList().joinToString(",")}"
            binding.tvExams.text = examsString
            val freePlacesText =
                "Мест: ${if (item.freePlaces == null) "-" else "${item.freePlaces}"}"
            binding.textViewFreePlaces.text = freePlacesText
            val freePlacesExamResultsText =
                "Сумма баллов: ${if (item.examResultsForFreePlaces == null) "-" else "${item.examResultsForFreePlaces}"}"
            binding.textViewFreePlacesExamResults.text = freePlacesExamResultsText
            val paidPlacesText =
                "Мест: ${if (item.paidPlaces == null) "-" else "${item.paidPlaces}"}"
            binding.textViewPaidPlaces.text = paidPlacesText
            val paidPlacesExamResultsText =
                "Сумма баллов: ${if (item.examResultsForPaidPlaces == null) "-" else "${item.examResultsForPaidPlaces}"}"
            binding.textViewPaidPlacesExamResults.text = paidPlacesExamResultsText
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}