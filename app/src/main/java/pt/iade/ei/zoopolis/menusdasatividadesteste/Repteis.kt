package pt.iade.ei.zoopolis.menusdasatividadesteste

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import pt.iade.ei.zoopolis.ui.components.ActivitiesDescriptionBox
import pt.iade.ei.zoopolis.ui.components.ActivitiesImageBox
import pt.iade.ei.zoopolis.ui.components.ActivitiesTimeBox


@Composable

fun Repteis() {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.repteis_design_background),
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
                        ActivitiesImageBox("Reptilário", R.drawable.repteis_design_banner_titulo_com_cobra,Color.hsl(196f, 0.93f, 0.63f))
                        ActivitiesTimeBox("Horário:", R.drawable.repteis_design_banner_horario, "Verão: 10h - 20h\n\n" +
                                "Inverno: 10h - 18h\n")
                        ActivitiesDescriptionBox("Descrição:", R.drawable.repteis_design_banner_info, "Aqui poderá conhecer as mais fascinantes espécies de répteis de todo o Mundo: o mítico Dragão-de-komodo, a Pitão-reticulado, o Hidrossauro-das-filipinas, a Iguana-rinoceronte, o gigante Aligátor-americano e a pequena Tartaruga-do-egipto, assim como algumas espécies de anfíbios e invertebrados.  ")


                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable

fun RepteisPreview(){
    Repteis()

}

