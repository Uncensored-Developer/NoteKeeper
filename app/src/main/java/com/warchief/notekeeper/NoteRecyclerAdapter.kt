package com.warchief.notekeeper

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_course_list.view.*
import kotlinx.android.synthetic.main.item_course_list.view.textCourse
import kotlinx.android.synthetic.main.item_note_list.view.*

class NoteRecyclerAdapter(
    private val context: Context,
    private val notes: List<NoteInfo>
):
    RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textCourse: TextView = itemView.textCourse
        val textTitle: TextView = itemView.textTitle
        var notePosition = 0

        init {
            itemView.setOnClickListener {
                val intent = Intent(context, NoteActivity::class.java)
                DataManager.addToRecentNotes(notes[notePosition])
                intent.putExtra(NOTE_POSITION, notePosition)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_note_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]

        holder.textCourse.text = note.course?.title
        holder.textTitle.text = note.title
        holder.notePosition = position
    }

}