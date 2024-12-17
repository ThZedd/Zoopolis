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

fun ComboioZooMenu() {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.baia_golfinhos_background),
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
                        ActivitiesImageBox("Comboio do Zoo", R.drawable.baia_dos_golfinhos_design_penguin_dentro_do_retangulo,Color.hsl(196f, 0.93f, 0.63f))
                        ActivitiesTimeBox("Horário:", R.drawable.baia_dos_golfinhos_design_horario,"Verão: 11:00 às 12:40 e" + " 14:00 às 19:00\n\n" + "Inverno: 11:00 às 12:40 e" + " 14:00 às 17:30\n")
                        ActivitiesDescriptionBox("Descrição:", R.drawable.activitiesdescriptionbox,"Suba no Comboio do Zoo e usufrua de uma visita diferente pelo Jardim Zoológico.\n" +
                                "\n" +
                                "Esta atração proporciona outra perspetiva ao passar pelas instalações de algumas das espécies mais emblemáticas do Parque, sem que para isso tenha de sair do seu lugar.")


                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable

fun ComboioZooPreview(){
    ComboioZooMenu()

}

