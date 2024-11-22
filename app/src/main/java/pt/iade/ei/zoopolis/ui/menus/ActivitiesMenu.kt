package pt.iade.ei.zoopolis.ui.menus

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import pt.iade.ei.zoopolis.ActivitiesTimeActivity
import pt.iade.ei.zoopolis.MainActivity
import pt.iade.ei.zoopolis.R
import pt.iade.ei.zoopolis.ui.components.PriceButton

@Composable

fun ActivitiesMenu() {

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
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top
                        ) {

                           item{
                            PriceButton("Dolphins", R.drawable.baiadosgolfinhos, ActivitiesTimeActivity::class.java)
                            PriceButton("Zoo's Train", R.drawable.comboiozoo, MainActivity::class.java)
                            PriceButton("Cable Car", R.drawable.teleferico, MainActivity::class.java)
                            PriceButton("Enchanted Forest", R.drawable.bosqueencantado, MainActivity::class.java)
                            PriceButton("Pelicans", R.drawable.pelicanos, MainActivity::class.java)
                            PriceButton("Children's Farm", R.drawable.quintinhadolidl, MainActivity::class.java)
                            }
                        }
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable

fun ActivitiesMenuPreview(){
    ActivitiesMenu()

}

