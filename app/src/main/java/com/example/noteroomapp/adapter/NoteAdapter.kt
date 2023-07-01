package com.example.noteroomapp.adapter

import android.annotation.SuppressLint
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteroomapp.R
import com.example.noteroomapp.model.NoteModel
import kotlinx.android.synthetic.main.item_layout.view.*

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private  var listNote =  emptyList<NoteModel>()


    class NoteViewHolder(view : View ) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.itemView.itemTitle.text = listNote[position].tittle // android-extension
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list : List<NoteModel>){
        this.listNote = list
        notifyDataSetChanged()
    }
}