package pt.iade.ei.zoopolis.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.zoopolis.MainActivity
import pt.iade.ei.zoopolis.R

@Composable

fun PricesMenu() {

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
                    .padding(top = 0.dp)

            ) {

                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Card(modifier = Modifier
                        .padding(top = 120.dp)
                        .fillMaxSize(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.hsl(124f, 0.68f, 0.16f)))
                    {
                        Column(modifier = Modifier.padding(top = 20.dp)) {

                            PriceButton("Buy Tickets", R.drawable.discount, MainActivity::class.java)
                            PriceButton("Entry Costs", R.drawable.entryprice, MainActivity::class.java)
                        }
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable

fun PricesMenuPreview(){
    PricesMenu()

}

