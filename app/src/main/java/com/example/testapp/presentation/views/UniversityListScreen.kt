package com.example.testapp.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.presentation.viewModel.UniversitiesViewModel
import com.example.testapp.ui.theme.TestAppTheme

@Composable
fun UniversityListScreen(viewModel: UniversitiesViewModel) {
    val universities by viewModel.universityList.collectAsState()

    LazyColumn {
        items(universities) { university ->

            Card(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                Column(Modifier.padding(10.dp)) {
                    Text(text = university.name)
                    Text(text = university.country)

                }

            }
        }
    }
}




