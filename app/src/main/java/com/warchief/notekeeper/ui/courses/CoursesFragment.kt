package com.warchief.notekeeper.ui.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.warchief.notekeeper.CourseRecyclerAdapter
import com.warchief.notekeeper.DataManager
import com.warchief.notekeeper.R
import kotlinx.android.synthetic.main.fragment_courses.*
import kotlinx.android.synthetic.main.fragment_notes.*

class CoursesFragment : Fragment() {

    private val courseLayoutManager by lazy { GridLayoutManager(activity, 2) }

    private val courseRecyclerAdapter by lazy {
        CourseRecyclerAdapter(activity!!, DataManager.courses.values.toList())
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_courses, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listCourses.layoutManager = courseLayoutManager
        listCourses.adapter = courseRecyclerAdapter
    }
}