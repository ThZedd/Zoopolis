package pt.iade.ei.zoopolis.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.zoopolis.R
import pt.iade.ei.zoopolis.models.Animal
import pt.iade.ei.zoopolis.models.AnimalClass


@Composable

fun AnimalMenu() {
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