package pt.iade.ei.zoopolis.ui.components



import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import pt.iade.ei.zoopolis.MainMenuActivity


@Composable
fun ProfileButton(name: String) {
    val borderStrokeWidthSize = 1.45f
    val context = LocalContext.current
    OutlinedCard(
        modifier = Modifier
            .padding(vertical = 15.dp, horizontal = 8.dp)
            .size(width = 165.dp, height = 50.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent),
        border = BorderStroke(borderStrokeWidthSize.dp, Color(0xFF2C2C2C).copy(alpha = 0.7f)),
        shape = RoundedCornerShape(100),
        onClick = {
            val intent = Intent(context, MainMenuActivity::class.java)
            context.startActivity(intent)
        }
    ){

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {


                Box {
                    // Texto principal
                    Text(
                        text = name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black,
                                offset = Offset(4f, 4f), // Ajuste o deslocamento da sombra
                                blurRadius = 2f // Aumente o valor para uma sombra mais suave
                            )
                        )
                    )
                }
            }
        }
    }



@Preview(showBackground = true)
@Composable
fun ProfileButtonPreview(){
    ProfileButton("Edit Profile")

}


