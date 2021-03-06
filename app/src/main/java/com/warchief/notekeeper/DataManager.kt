package com.warchief.notekeeper

object DataManager {

    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()
    private const val maxRecentlyViewedNotes = 5
    val recentNotes = ArrayList<NoteInfo>(maxRecentlyViewedNotes)

    init {
        initializeCourses()
        initializeNotes()
    }

    private fun initializeCourses() {
        var course = CourseInfo("android_intents", "Android programming with intents")
        courses[course.courseId] = course

        course = CourseInfo("android_async", "Android Async programming and services")
        courses[course.courseId] = course

        course = CourseInfo("java_lang", "Java Fundamentals: The java language")
        courses[course.courseId] = course

        course = CourseInfo("java_core", "Java Fundamentals: The core platform")
        courses[course.courseId] = course

        course = CourseInfo("java_core0", "Java Fundamentals: The core platform")
        courses[course.courseId] = course

        course = CourseInfo("java_core1", "Java Fundamentals: The core platform")
        courses[course.courseId] = course
    }

    private fun initializeNotes() {
        for ((k,v) in courses) {
            val note = NoteInfo(v, k, v.title)
            notes.add(note)
        }
    }

    fun addNote(course: CourseInfo, noteTitle: String, noteText: String): Int {
        val note = NoteInfo(course, noteTitle, noteText)
        notes.add(note)
        return notes.lastIndex
    }

    fun addToRecentNotes(note: NoteInfo) {
        val existingIndex = recentNotes.indexOf(note)
        if (existingIndex == -1) {
            recentNotes.add(0, note)
            for (index in recentNotes.lastIndex downTo maxRecentlyViewedNotes)
                recentNotes.removeAt(index)
        } else {
            for (index in (existingIndex - 1) downTo 0)
                recentNotes[index + 1] = recentNotes[index]
            recentNotes[0] = note
        }
    }

}