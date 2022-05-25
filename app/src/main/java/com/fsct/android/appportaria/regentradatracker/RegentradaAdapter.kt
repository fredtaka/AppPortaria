
package com.fsct.android.appportaria.regentradatracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fsct.android.appportaria.database.Registro
import com.fsct.android.appportaria.databinding.ListItemRegistroBinding

class RegentradaAdapter : ListAdapter<Registro, RegentradaAdapter.ViewHolder>(RegistroDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ListItemRegistroBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Registro) {
            binding.entradasaida = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemRegistroBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}


class RegistroDiffCallback : DiffUtil.ItemCallback<Registro>() {

    override fun areItemsTheSame(oldItem: Registro, newItem: Registro): Boolean {
        return oldItem.registroId == newItem.registroId
    }


    override fun areContentsTheSame(oldItem: Registro, newItem: Registro): Boolean {
        return oldItem == newItem
    }


}
