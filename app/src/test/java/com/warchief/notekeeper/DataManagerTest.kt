package com.warchief.notekeeper

import org.junit.Test

import org.junit.Assert.*

class DataManagerTest {

    @Test
    fun addNote() {
        val course = DataManager.courses["android_async"]!!
        val title = "This is a test title"
        val text = "This is a test text"

        val index = DataManager.addNote(course, title, text)
        val note = DataManager.notes[index]

        assertEquals(course, note.course)
        assertEquals(title, note.title)
        assertEquals(text, note.text)
    }
}