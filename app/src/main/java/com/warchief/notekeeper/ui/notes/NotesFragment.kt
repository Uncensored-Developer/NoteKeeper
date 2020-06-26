package com.warchief.notekeeper.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.warchief.notekeeper.CourseRecyclerAdapter
import com.warchief.notekeeper.DataManager
import com.warchief.notekeeper.NoteRecyclerAdapter
import com.warchief.notekeeper.R
import kotlinx.android.synthetic.main.fragment_notes.*

class NotesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    private val noteLayoutManager by lazy { LinearLayoutManager(activity) }

    private val noteRecyclerAdapter by lazy { NoteRecyclerAdapter(activity!!, DataManager.notes) }

    private val courseLayoutManager by lazy { GridLayoutManager(activity, 2) }

    private val courseRecyclerAdapter by lazy {
        CourseRecyclerAdapter(activity!!, DataManager.courses.values.toList())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listItems.layoutManager = noteLayoutManager
        listItems.adapter = noteRecyclerAdapter
    }

    override fun onResume() {
        super.onResume()
        listItems.adapter?.notifyDataSetChanged()
    }
}