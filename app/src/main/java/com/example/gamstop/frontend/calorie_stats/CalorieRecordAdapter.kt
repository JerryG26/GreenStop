package com.example.gamstop.frontend.calorie_stats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamstop.databinding.ItemCalorieRecordBinding

class CalorieRecordAdapter(private var records: List<CalorieEntity>) :
    RecyclerView.Adapter<CalorieRecordAdapter.RecordViewHolder>() {

    class RecordViewHolder(val binding: ItemCalorieRecordBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        val binding = ItemCalorieRecordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        val record = records[position]
        holder.binding.timeText.text = record.time
        holder.binding.foodNameText.text = record.foodName
        holder.binding.caloriesText.text = "Cals taken: ${record.calories}"
    }

    override fun getItemCount(): Int = records.size

    fun updateData(newRecords: List<CalorieEntity>) {
        records = newRecords
        notifyDataSetChanged()
    }
}