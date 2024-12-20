package pt.iade.ei.zoopolis.ui.menus

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
import pt.iade.ei.zoopolis.ui.components.AnimalDescriptionBox
import pt.iade.ei.zoopolis.ui.components.AnimalNameBox
import pt.iade.ei.zoopolis.ui.components.GetDirectionsButton

@Composable

fun AnimalDescriptionMenu() {
    val borderStrokeWidthSize = 1.45f
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
            Box(

                contentAlignment = Alignment.TopCenter,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 120.dp)

            ) {

                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        OutlinedCard(
                            modifier = Modifier
                                .padding(vertical = 0.dp, horizontal = 8.dp)
                                .size(width = 330.dp, height = 200.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surface
                            ),
                            border = BorderStroke(
                                borderStrokeWidthSize.dp,
                                Color.hsl(0f, 0f, 0f)
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 7.dp
                            )
                        ) {

                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.precos),
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxSize()

                                    )
                                }
                            }
                        }
                        GetDirectionsButton(
                            name = "Get Directions",
                            containerColor = Color.hsl(4f, 0.45f, 0.14f)
                        )
                        AnimalNameBox(
                            Animal(
                                id = 0,
                                name = "Tiger",
                                imageRes = R.drawable.precos,
                                description = "É a subespécie mais pequena de tigre no Mundo. A pelagem ocre-alaranjada, apresenta riscas negras longitudinais largas e muitas vezes duplas, pelo que a sua pelagem é mais escura do que noutras subespécies.",
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
                            containerColor = Color.hsl(36f, 0.90f, 0.37f)
                        )
                        AnimalDescriptionBox(
                            animal = Animal(
                                id = 0,
                                name = "Tiger",
                                imageRes = R.drawable.precos,
                                description = "É a subespécie mais pequena de tigre no Mundo. A pelagem ocre-alaranjada, apresenta riscas negras longitudinais largas e muitas vezes duplas, pelo que a sua pelagem é mais escura do que noutras subespécies.",
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
                            containerColor = Color.hsl(34f, 0.67f, 0.57f)
                        )

                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable

fun AnimalDescriptionMenuPreview(){
    AnimalDescriptionMenu()

}

