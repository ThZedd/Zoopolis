package pt.iade.ei.zoopolis.ui.menus

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.zoopolis.ActivitiesMenuActivity
import pt.iade.ei.zoopolis.AnimalMenuActivity
import pt.iade.ei.zoopolis.MapMenuActivity
import pt.iade.ei.zoopolis.PricesMenuActivity
import pt.iade.ei.zoopolis.R
import pt.iade.ei.zoopolis.ui.components.EnterTheCodeButton
import pt.iade.ei.zoopolis.ui.components.MenuButton

@Composable

fun MainMenu() {

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

                    Row{
                        MenuButton("Animais", R.drawable.animais, AnimalMenuActivity::class.java)
                        MenuButton("Atividades", R.drawable.atividades, ActivitiesMenuActivity::class.java)
                    }

                    Row{
                        MenuButton("Mapa", R.drawable.mapazoo, MapMenuActivity::class.java)
                        MenuButton("Preços", R.drawable.precos, PricesMenuActivity::class.java)
                    }

                    EnterTheCodeButton("Enter The Code", R.drawable.enterthecode)

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable

fun MainMenuPreview(){
    MainMenu()

}