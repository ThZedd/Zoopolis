package pt.iade.ei.zoopolis.ui.menus


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

fun ActivitiesTimeMenu() {
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
                        ActivitiesImageBox("Baia dos Golfinhos", R.drawable.baia_dos_golfinhos_design_penguin_dentro_do_retangulo,Color.hsl(196f, 0.93f, 0.63f))
                        ActivitiesTimeBox("Horário:", R.drawable.baia_dos_golfinhos_design_horario, "21 de setembro a 20 março: 11h (não se realiza à terça-feira) / 14h30\n" +
                                "21 de março a 20 de setembro: 11h / 14h30 / 16h30\n")
                        ActivitiesDescriptionBox("Descrição:", R.drawable.activitiesdescriptionbox, "A valorização dos oceanos e a conservação da biodiversidade marinha, é a mensagem das apresentações diárias da Baía dos Golfinhos. \n" +
                                "\n" +
                                "Numa envolvência única, de comportamentos subaquáticos, os visitantes têm a oportunidade de conhecer as capacidades físicas e mentais dos embaixadores dos oceanos - os golfinhos. Com esta apresentação pretende-se ainda, sensibilizar os visitantes para a maior ameaça dos oceanos – o lixo marinho – e, deste modo, promover a mudança de atitudes e comportamentos.\n" +
                                "\n" +
                                "Conhecer para cuidar e agir pela preservação dos oceanos!")


                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable

fun ActivitiesTimeMenuPreview(){
    ActivitiesTimeMenu()

}

