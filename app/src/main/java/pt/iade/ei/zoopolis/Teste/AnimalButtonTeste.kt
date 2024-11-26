package pt.iade.ei.zoopolis.teste


import android.content.Intent
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import pt.iade.ei.zoopolis.AnimalDescriptionMenuActivity
import pt.iade.ei.zoopolis.models.AnimalDTO

@Composable
fun AnimalButtonTeste(animal: AnimalDTO, activityClass: Class<*>) {
    val borderStrokeWidthSize = 1.45f
    val context = LocalContext.current
    val imageState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(animal.imageUrl).size(Size.ORIGINAL).build()
    ).state

    OutlinedCard(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 8.dp)
            .size(width = 300.dp, height = 90.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(borderStrokeWidthSize.dp, Color.hsl(124f, 0.68f, 0.16f)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 7.dp
        ),
        onClick = {
            val intent = Intent(context, activityClass)
            intent.putExtra("animal_id", animal.id)
            context.startActivity(intent)
        }
    ){


        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                if (imageState is AsyncImagePainter.State.Error){
                    Log.e("AnimalButton", animal.imageUrl)
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                if (imageState is AsyncImagePainter.State.Success){
                    Image(
                        painter = imageState.painter,
                        contentDescription = animal.name,
                        contentScale = ContentScale.Crop
                    )
                }

                Box(
                    modifier = Modifier.padding(top = 65.dp)
                ) {


//color = Color(0xFF0D4311)


                    Text(
                        text = animal.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF0D4311), // Contorno geralmente é preto
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color(0xFF0D4311),
                                offset = Offset(-3f, -3f),
                                blurRadius = 2f
                            )
                        )
                    )
                    // Texto principal
                    Text(
                        text = animal.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color(0xFF0D4311),
                                offset = Offset(3f, 3f), // Ajuste o deslocamento da sombra
                                blurRadius = 0.15f // Aumente o valor para uma sombra mais suave
                            )
                        )
                    )

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AnimalButtonPreview(){
    AnimalButtonTeste(animal = AnimalDTO(
        id = 1,
        name = "Tiger",
        ciName = "Panthera tigris",
        description = "Tiger is a Tiger",
        imageUrl = "ola"
    ),
        AnimalDescriptionMenuActivity::class.java)

}


