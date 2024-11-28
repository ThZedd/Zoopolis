package pt.iade.ei.zoopolis.teste

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import pt.iade.ei.zoopolis.AnimalDescriptionMenuActivity
import pt.iade.ei.zoopolis.R
import pt.iade.ei.zoopolis.viewmodel.AnimalDTOViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalMenuTeste() {
    val animalDTOViewModel: AnimalDTOViewModel = viewModel()

    // Coleta os animais da ViewModel
    val animals by animalDTOViewModel.animals.collectAsState()

    // Ação de erro de rede
    val showErrorToast by animalDTOViewModel.showErrorToastChannel.collectAsState(initial = false)
    if (showErrorToast) {
        Toast.makeText(LocalContext.current, "Error loading animals", Toast.LENGTH_SHORT).show()
    }
    var text by remember{mutableStateOf("") }
    var active by remember{mutableStateOf(false) }
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.mainmenubackground),
            contentDescription = "background_image",
            contentScale = ContentScale.FillBounds
        )
        Scaffold(
            containerColor = Color.Transparent
        ) { innerPadding ->

            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .align(alignment = Alignment.TopCenter)
            ) {
                SearchBar(
                    modifier = Modifier.padding(
                        start = 15.dp,
                        end = 15.dp,
                        top = 80.dp,
                        bottom = 15.dp
                    ),
                    query = text,
                    onQueryChange = {
                        text = it
                    },
                    onSearch = {
                        active = false
                    },
                    active = active,
                    onActiveChange = {
                        active = it
                    },
                    placeholder = {
                        Text(text = "Search")
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon"
                        )
                    },
                    trailingIcon = {
                        if (active) {
                            Icon(
                                modifier = Modifier.clickable {
                                    if (text.isNotEmpty()) {

                                        text = ""
                                    } else {

                                        active = false
                                    }
                                },
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close Icon"
                            )
                        }
                    }
                ) { }
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {

                    items(animals.size) { animal ->
                        AnimalButtonTeste(
                            animal = animals[animal], AnimalDescriptionMenuActivity::class.java )
                    }
                }
            }
            }
        }
    }



@Preview(showBackground = true)
@Composable

fun AnimalMenuPreview(){
    AnimalMenuTeste()
}

