package pt.iade.ei.zoopolis.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.zoopolis.R
import pt.iade.ei.zoopolis.models.Animal
import pt.iade.ei.zoopolis.models.AnimalClass


@Composable
fun AnimalNameBox(animal: Animal, containerColor: Color) {
    val borderStrokeWidthSize = 1.45f
    OutlinedCard(
        modifier = Modifier
            .padding(top = 15.dp, end = 8.dp, start = 8.dp)
            .size(width = 330.dp, height = 80.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor),
        border = BorderStroke(borderStrokeWidthSize.dp, Color.hsl(0f, 0f, 0f)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 7.dp,

            )
    ){


        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){

                // Texto principal
                Text(
                    text = animal.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    minLines = 2,
                    color = Color.White,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(4f, 4f), // Ajuste o deslocamento da sombra
                            blurRadius = 6f // Aumente o valor para uma sombra mais suave
                        )
                    )
                )
            }
        }
    }



@Preview(showBackground = true)
@Composable
fun AnimalNameBoxPreview(){
    AnimalNameBox(animal = Animal(
        id = 0,
        name = "Tiger \n Panthera Tigris",
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
    ), containerColor = Color.hsl(330f, 0.11f, 0.11f))

}


