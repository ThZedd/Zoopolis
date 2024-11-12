package pt.iade.ei.zoopolis.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.zoopolis.R
import pt.iade.ei.zoopolis.models.Animal
import pt.iade.ei.zoopolis.models.AnimalClass


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun AnimalMenu() {
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
                    modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 80.dp, bottom = 15.dp ),
                    query = text,
                    onQueryChange = {
                        text = it
                    },
                    onSearch = {
                        active = false
                    },
                    active = active ,
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
                        if(active){
                        Icon(
                            modifier = Modifier.clickable {
                                if(text.isNotEmpty()){

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

                // Muito importante! So facam listas assim:
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {

                    items(animalContentListExample()) { animal ->
                        AnimalButton(
                            animal = animal, )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable

fun AnimalMenuPreview(){
    AnimalMenu()
}

fun animalContentListExample(): List<Animal> {
    return listOf(
        Animal(
        id = 0,
        name = "Tiger",
        imageRes = R.drawable.precos,
        description = "Tiger is a Tiger",
        weight = 100.0f,
        height =  1.30f,
        classs = listOf(
            AnimalClass(
                id = 0,
                className = "Mammalia",
                kingdom = "Animalia",
                order = "Carnivora",
                family = "Felidae",
                genus = "Panthera",
                specie = "P. tigris")
            )
        ),
        Animal(
            id = 0,
            name = "Tiger",
            imageRes = R.drawable.precos,
            description = "Tiger is a Tiger",
            weight = 100.0f,
            height =  1.30f,
            classs = listOf(
                AnimalClass(
                    id = 0,
                    className = "Mammalia",
                    kingdom = "Animalia",
                    order = "Carnivora",
                    family = "Felidae",
                    genus = "Panthera",
                    specie = "P. tigris")
            )
        ),
        Animal(
            id = 0,
            name = "Tiger",
            imageRes = R.drawable.precos,
            description = "Tiger is a Tiger",
            weight = 100.0f,
            height =  1.30f,
            classs = listOf(
                AnimalClass(
                    id = 0,
                    className = "Mammalia",
                    kingdom = "Animalia",
                    order = "Carnivora",
                    family = "Felidae",
                    genus = "Panthera",
                    specie = "P. tigris")
            )
        ),
        Animal(
            id = 0,
            name = "Tiger",
            imageRes = R.drawable.precos,
            description = "Tiger is a Tiger",
            weight = 100.0f,
            height =  1.30f,
            classs = listOf(
                AnimalClass(
                    id = 0,
                    className = "Mammalia",
                    kingdom = "Animalia",
                    order = "Carnivora",
                    family = "Felidae",
                    genus = "Panthera",
                    specie = "P. tigris")
            )
        ),
        Animal(
            id = 0,
            name = "Tiger",
            imageRes = R.drawable.precos,
            description = "Tiger is a Tiger",
            weight = 100.0f,
            height =  1.30f,
            classs = listOf(
                AnimalClass(
                    id = 0,
                    className = "Mammalia",
                    kingdom = "Animalia",
                    order = "Carnivora",
                    family = "Felidae",
                    genus = "Panthera",
                    specie = "P. tigris")
            )
        ),
        Animal(
            id = 0,
            name = "Tiger",
            imageRes = R.drawable.precos,
            description = "Tiger is a Tiger",
            weight = 100.0f,
            height =  1.30f,
            classs = listOf(
                AnimalClass(
                    id = 0,
                    className = "Mammalia",
                    kingdom = "Animalia",
                    order = "Carnivora",
                    family = "Felidae",
                    genus = "Panthera",
                    specie = "P. tigris")
            )
        ),
        Animal(
            id = 0,
            name = "Tiger",
            imageRes = R.drawable.precos,
            description = "Tiger is a Tiger",
            weight = 100.0f,
            height =  1.30f,
            classs = listOf(
                AnimalClass(
                    id = 0,
                    className = "Mammalia",
                    kingdom = "Animalia",
                    order = "Carnivora",
                    family = "Felidae",
                    genus = "Panthera",
                    specie = "P. tigris")
            )
        ),
        Animal(
            id = 0,
            name = "Tiger",
            imageRes = R.drawable.precos,
            description = "Tiger is a Tiger",
            weight = 100.0f,
            height =  1.30f,
            classs = listOf(
                AnimalClass(
                    id = 0,
                    className = "Mammalia",
                    kingdom = "Animalia",
                    order = "Carnivora",
                    family = "Felidae",
                    genus = "Panthera",
                    specie = "P. tigris")
            )
        ),
        Animal(
            id = 0,
            name = "Tiger",
            imageRes = R.drawable.precos,
            description = "Tiger is a Tiger",
            weight = 100.0f,
            height =  1.30f,
            classs = listOf(
                AnimalClass(
                    id = 0,
                    className = "Mammalia",
                    kingdom = "Animalia",
                    order = "Carnivora",
                    family = "Felidae",
                    genus = "Panthera",
                    specie = "P. tigris")
            )
        ),
        Animal(
            id = 0,
            name = "Tiger",
            imageRes = R.drawable.precos,
            description = "Tiger is a Tiger",
            weight = 100.0f,
            height =  1.30f,
            classs = listOf(
                AnimalClass(
                    id = 0,
                    className = "Mammalia",
                    kingdom = "Animalia",
                    order = "Carnivora",
                    family = "Felidae",
                    genus = "Panthera",
                    specie = "P. tigris")
            )
        ),
        Animal(
            id = 0,
            name = "Tiger",
            imageRes = R.drawable.precos,
            description = "Tiger is a Tiger",
            weight = 100.0f,
            height =  1.30f,
            classs = listOf(
                AnimalClass(
                    id = 0,
                    className = "Mammalia",
                    kingdom = "Animalia",
                    order = "Carnivora",
                    family = "Felidae",
                    genus = "Panthera",
                    specie = "P. tigris")
            )
        ),
        Animal(
            id = 0,
            name = "Tiger",
            imageRes = R.drawable.precos,
            description = "Tiger is a Tiger",
            weight = 100.0f,
            height =  1.30f,
            classs = listOf(
                AnimalClass(
                    id = 0,
                    className = "Mammalia",
                    kingdom = "Animalia",
                    order = "Carnivora",
                    family = "Felidae",
                    genus = "Panthera",
                    specie = "P. tigris")
            )
        ),
        Animal(
            id = 0,
            name = "Tiger",
            imageRes = R.drawable.precos,
            description = "Tiger is a Tiger",
            weight = 100.0f,
            height =  1.30f,
            classs = listOf(
                AnimalClass(
                    id = 0,
                    className = "Mammalia",
                    kingdom = "Animalia",
                    order = "Carnivora",
                    family = "Felidae",
                    genus = "Panthera",
                    specie = "P. tigris")
            )
        ),
        Animal(
            id = 0,
            name = "Tiger",
            imageRes = R.drawable.precos,
            description = "Tiger is a Tiger",
            weight = 100.0f,
            height =  1.30f,
            classs = listOf(
                AnimalClass(
                    id = 0,
                    className = "Mammalia",
                    kingdom = "Animalia",
                    order = "Carnivora",
                    family = "Felidae",
                    genus = "Panthera",
                    specie = "P. tigris")
            )
        )

    )
}