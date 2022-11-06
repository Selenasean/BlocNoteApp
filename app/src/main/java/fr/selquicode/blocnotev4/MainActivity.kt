package fr.selquicode.blocnotev4

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    // var to save all the text we want to displayed
    var fullText = ""
    val SETTINGS_FILE_NAME = "fr.selquicode.blocNoteV4"
    val FULLTEXT_SETTINGS_KEY = "Notes"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferencesReader = getSharedPreferences(SETTINGS_FILE_NAME, Context.MODE_PRIVATE)
        fullText = sharedPreferencesReader.getString(FULLTEXT_SETTINGS_KEY, "")!!
        fullTextView.text = fullText
    }

    fun addButtonTouched(button:View){
        val userInput = userField.text
        fullText = "$fullText\n$userInput"
        saveTextDB()
        fullTextView.text = fullText
        userField.text = null
    }

    fun saveTextDB(){
        val sharedPreferencesEditor = getSharedPreferences(SETTINGS_FILE_NAME, Context.MODE_PRIVATE).edit()
        sharedPreferencesEditor.putString(FULLTEXT_SETTINGS_KEY, fullText)
        sharedPreferencesEditor.apply()
    }
}