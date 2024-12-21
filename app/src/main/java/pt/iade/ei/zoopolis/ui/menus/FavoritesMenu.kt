package pt.iade.ei.zoopolis.ui.menus

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import pt.iade.ei.zoopolis.AnimalDescriptionMenuActivity
import pt.iade.ei.zoopolis.R
import pt.iade.ei.zoopolis.teste.AnimalButtonTeste
import pt.iade.ei.zoopolis.viewmodel.FavoriteViewModel


@Composable
fun FavoritesMenu() {
    val favoriteViewModel: FavoriteViewModel = viewModel()

    // Coleta os animais favoritos da ViewModel
    val favoriteAnimals by favoriteViewModel.favoriteAnimals.collectAsState()

    // Ação de erro de rede
    val showErrorToast by favoriteViewModel.showErrorToastChannel.collectAsState(initial = false)
    if (showErrorToast) {
        Toast.makeText(LocalContext.current, "Erro ao carregar os animais favoritos", Toast.LENGTH_SHORT).show()
    }

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

            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .align(alignment = Alignment.TopCenter)
            ) {

                Spacer(modifier = Modifier.padding(top = 100.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {

                    items(favoriteAnimals.size) { animal ->
                        AnimalButtonTeste(
                            animal = favoriteAnimals[animal],
                            AnimalDescriptionMenuActivity::class.java, favoriteViewModel
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesMenuPreview() {
    FavoritesMenu()
}


