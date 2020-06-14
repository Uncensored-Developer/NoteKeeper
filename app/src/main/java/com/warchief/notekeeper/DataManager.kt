package com.warchief.notekeeper

object DataManager {

    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

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
    }

    private fun initializeNotes() {
        for ((k,v) in courses) {
            val note = NoteInfo(v, k, v.title)
            notes.add(note)
        }
    }

}