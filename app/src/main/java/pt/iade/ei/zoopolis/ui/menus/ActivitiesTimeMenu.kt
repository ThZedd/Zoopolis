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
                        ActivitiesTimeBox("Horário:", R.drawable.baia_dos_golfinhos_design_horario)
                        ActivitiesDescriptionBox("Descrição:", R.drawable.activitiesdescriptionbox)


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

