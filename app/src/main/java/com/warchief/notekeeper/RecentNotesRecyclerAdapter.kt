package com.warchief.notekeeper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.item_course_list.view.*
import kotlinx.android.synthetic.main.item_note_list.view.*
import kotlinx.android.synthetic.main.item_note_list.view.textCourse

class RecentNotesRecyclerAdapter(
    private val context: Context,
    private val recentNotes: List<NoteInfo>
):
    RecyclerView.Adapter<RecentNotesRecyclerAdapter.ViewHolder>(){

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textCourse: TextView = itemView.textCourse
        val textTitle: TextView = itemView.textTitle
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_note_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = recentNotes.size

    override fun onBindViewHolder(holder: RecentNotesRecyclerAdapter.ViewHolder, position: Int) {
        val note = recentNotes[position]

        holder.textCourse.text = note.course?.title
        holder.textTitle.text = note.title
    }
}