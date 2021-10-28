package com.example.example_viewmodel_with_databinding

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    lateinit var modifiedEntryString : String

    var bindingString = "This string is from the viewModel"

    fun modifyEntry(testEditText: String): String {
        var modifiedEntryString = "Marked up entry: $testEditText"
        return modifiedEntryString
    }

}