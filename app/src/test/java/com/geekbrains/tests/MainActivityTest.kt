package com.geekbrains.tests

import android.content.Context
import android.os.Build
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>
    private lateinit var context: Context

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun activity_AssertNotNull() {
        scenario.onActivity {
            assertNotNull(it)
        }
    }

    @Test
    fun activity_IsResumed() {
        assertEquals(Lifecycle.State.RESUMED, scenario.state)
    }

    @Test
    fun activityEditTextView_NotNull() {
        scenario.onActivity {
            val searchEditTextView = it.findViewById<EditText>(R.id.searchEditText)
            assertNotNull(searchEditTextView)
        }
    }

    @Test
    fun activityEditTextView_HasHint() {
        scenario.onActivity {
            val searchEditTextView = it.findViewById<EditText>(R.id.searchEditText)
            assertEquals("Enter keyword e.g. android", searchEditTextView.hint)
        }
    }

    @Test
    fun activityEditView_IsVisible() {
        scenario.onActivity {
            val searchEditTextView = it.findViewById<EditText>(R.id.searchEditText)
            assertEquals(View.VISIBLE, searchEditTextView.visibility)
        }
    }

    @Test
    fun activityEditView_IsText() {
        scenario.onActivity {
            val searchEditTextView = it.findViewById<EditText>(R.id.searchEditText)
            val expectedString = "text"
            searchEditTextView.setText(expectedString, TextView.BufferType.EDITABLE)
            assertEquals(expectedString, searchEditTextView.text.toString())
        }
    }

    @Test
    fun activityDetailsButton_NotNull() {
        scenario.onActivity {
            val detailsActivityButton = it.findViewById<Button>(R.id.toDetailsActivityButton)
            assertNotNull(detailsActivityButton)
        }
    }

    @Test
    fun activityDetailsButton_HasHint() {
        scenario.onActivity {
            val detailsActivityButton = it.findViewById<Button>(R.id.toDetailsActivityButton)
            assertEquals("to details", detailsActivityButton.text)
        }
    }

    @Test
    fun activityDetailsButton_IsVisible() {
        scenario.onActivity {
            val detailsActivityButton = it.findViewById<Button>(R.id.toDetailsActivityButton)
            assertEquals(View.VISIBLE, detailsActivityButton.visibility)
        }
    }



    @After
    fun close() {
        scenario.close()
    }
}
