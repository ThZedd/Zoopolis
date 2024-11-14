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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




@Composable
fun AnimalDescriptionBox(name: String, containerColor: Color) {
    val borderStrokeWidthSize = 1.45f
    val context = LocalContext.current
    OutlinedCard(
        modifier = Modifier
            .padding(top = 15.dp, end = 8.dp, start = 8.dp)
            .size(width = 330.dp, height = 600.dp),
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
            verticalAlignment = Alignment.Top
        ){


                // Texto principal
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 10.dp),
                    textAlign = TextAlign.Center,
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
fun AnimalDescriptionPreview(){
    AnimalDescriptionBox("É a subespécie mais pequena de tigre no Mundo. A pelagem ocre-alaranjada, apresenta riscas negras longitudinais largas e muitas vezes duplas, pelo que a sua pelagem é mais escura do que noutras subespécies.\n" +
            "\n" +
            "Hábitos\n" +
            "Espécie territorial e solitária embora pares de macho e fêmea se possam associar para além da reprodução. Esta espécie gosta muito de água e é uma excelente nadadora. Durante os dias mais quentes da época seca, passa longos períodos dentro de água. Caça por emboscada.Reprodução\n" +
            "O acasalamento pode ocorrer em qualquer altura do ano, no entanto, em cada época de acasalamento, um macho e uma fêmea acasalam apenas um com o outro. A cópula é muito breve, e repetida durante 5 a 6 dias. As crias são amamentadas durante 3 a 6 meses.Conservação\n" +
            "Ameaçada pela perda do habitat sobretudo para produção de óleo de palma, pela caça para o comércio ilegal e pela perseguição direta pelo Homem. Estima-se que existam apenas 400 destes animais na Natureza.)", containerColor = Color.hsl(330f, 0.11f, 0.11f))

}


