package com.warchief.notekeeper

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NextThroughNotesTest {

    @Rule
    @JvmField
    val noteListActivity = ActivityTestRule(NoteListActivity::class.java)

    @Test
    fun nextThroughNotes() {

        onData(allOf(instanceOf(NoteInfo::class.java), equalTo(DataManager.notes[0]))).perform(click())

        for (index in 0..DataManager.notes.lastIndex) {
            val note = DataManager.notes[index]

            onView(withId(R.id.spinnerCourses)).check(
                matches(withSpinnerText(note.course?.title))
            )
            onView(withId(R.id.textNoteTitle)).check(
                matches(withText(note.title))
            )
            onView(withId(R.id.textNoteText)).check(
                matches(withText(note.text))
            )

//            check if not currently on last note
//            then click the next action button if it is enabled
            if (index != DataManager.notes.lastIndex)
                onView(allOf(withId(R.id.action_next), isEnabled())).perform(click())
        }

//        check if the next action button is disabled for the last note
        onView(withId(R.id.action_next)).check(matches(not(isEnabled())))
        onView(withId(R.id.action_next)).check(matches(not(isEnabled())))

    }

}