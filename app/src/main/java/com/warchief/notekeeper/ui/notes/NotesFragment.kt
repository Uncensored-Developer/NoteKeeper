package com.warchief.notekeeper.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.warchief.notekeeper.*
import kotlinx.android.synthetic.main.fragment_notes.*

open class NotesFragment : Fragment() {

    private val noteLayoutManager by lazy { LinearLayoutManager(activity) }

    protected open val noteRecyclerAdapter by lazy {
        NoteRecyclerAdapter(activity!!, DataManager.notes)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes, container, false)
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