package pt.iade.ei.zoopolis.teste


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import pt.iade.ei.zoopolis.R
import pt.iade.ei.zoopolis.models.AnimalDTO
import pt.iade.ei.zoopolis.ui.components.GetDirectionsButton
import pt.iade.ei.zoopolis.viewmodel.AnimalDTOViewModel

@Composable

fun AnimalDescriptionMenuTeste(animal: AnimalDTO) {
    val borderStrokeWidthSize = 1.45f
    val animalDTOViewModel: AnimalDTOViewModel = viewModel()

    // Coleta os animais da ViewModel


    // Ação de erro de rede
    val showErrorToast by animalDTOViewModel.showErrorToastChannel.collectAsState(initial = false)
    if (showErrorToast) {
        Toast.makeText(LocalContext.current, "Error loading animals", Toast.LENGTH_SHORT).show()
    }
    val imageState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(animal.imageUrl).size(Size.ORIGINAL).build()
    ).state

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
                        OutlinedCard(
                            modifier = Modifier
                                .padding(vertical = 0.dp, horizontal = 8.dp)
                                .size(width = 330.dp, height = 200.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surface
                            ),
                            border = BorderStroke(
                                borderStrokeWidthSize.dp,
                                Color.hsl(0f, 0f, 0f)
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 7.dp
                            )
                        ) {

                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
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
                                }
                            }
                        }
                        GetDirectionsButton(
                            name = "Get Directions",
                            containerColor = Color(0xFF0D4311)
                        )
                        AnimalNameBoxTeste(animal = AnimalDTO(
                            id = animal.id,
                            name = animal.name,
                            ciName = animal.ciName,
                            description = animal.description,
                            imageUrl = animal.imageUrl)
                        )


                        AnimalDescriptionBoxTeste(
                            animal = AnimalDTO(
                                id = animal.id,
                                name = animal.name,
                                ciName = animal.ciName,
                                description = animal.description,
                                imageUrl = animal.imageUrl)
                        )

                    }
                }
            }
        }
    }
}


