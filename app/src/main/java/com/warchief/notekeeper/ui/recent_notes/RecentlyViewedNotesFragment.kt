package com.warchief.notekeeper.ui.recent_notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.warchief.notekeeper.DataManager
import com.warchief.notekeeper.NoteRecyclerAdapter
import com.warchief.notekeeper.R
import com.warchief.notekeeper.RecentNotesRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_notes.*
import kotlinx.android.synthetic.main.fragment_recently_viewed_notes.*

class RecentlyViewedNotesFragment : Fragment() {

    private val noteLayoutManager by lazy { LinearLayoutManager(activity) }

    private val noteRecyclerAdapter by lazy {
        RecentNotesRecyclerAdapter(activity!!, DataManager.recentNotes)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recently_viewed_notes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recentNotes.layoutManager = noteLayoutManager
        recentNotes.adapter = noteRecyclerAdapter
    }

    override fun onResume() {
        super.onResume()
        recentNotes.adapter?.notifyDataSetChanged()
    }

}