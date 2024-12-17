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

fun Teleferico() {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.telefericos_design_background),
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
                        ActivitiesImageBox("Teleférico", R.drawable.telefericos_design_banner_titulo,Color.hsl(196f, 0.93f, 0.63f))
                        ActivitiesTimeBox("Horário:", R.drawable.telefericos_design_banner_horario, "Verão: 11h30 - 19h30 (última viagem) \n\n" +
                                "Inverno: 11h - 17h30 (última viagem)\n")
                        ActivitiesDescriptionBox("Descrição:", R.drawable.telefericos_design_banner_info, "OBSERVE O ZOO DE OUTRA PERSPETIVA, UMA VIAGEM SURPREENDENTE DE 20 MINUTOS. \n" +
                                "\n" +
                                "Tenha em atenção\n" +
                                "Não se realiza sob chuva e/ou ventos fortes.\n" +
                                "Crianças menores de 12 anos terão de ser acompanhadas por um adulto maior de 18 anos.")


                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable

fun TelefericoPreview(){
    Teleferico()

}

