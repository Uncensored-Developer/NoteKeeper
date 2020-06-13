package com.warchief.notekeeper

class DataManager {

    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    private fun initializeCourses() {
        var course = CourseInfo("android_intents", "Android programming with intents")
    }

}