package pt.iade.ei.zoopolis.ui.menus

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.zoopolis.R
import pt.iade.ei.zoopolis.models.SessionManager
import pt.iade.ei.zoopolis.retrofit.Result
import pt.iade.ei.zoopolis.ui.components.LogoutButton
import pt.iade.ei.zoopolis.ui.components.PointsBox
import pt.iade.ei.zoopolis.viewmodel.PersonViewModel

@Composable
fun ProfileMenu(personViewModel: PersonViewModel) {
    val context = LocalContext.current
    val sessionManager = SessionManager(context)
    val personId = sessionManager.getUserId()

    // LiveData para observar a pessoa
    val personResult = personViewModel.getPersonById(personId).observeAsState()

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
                    .padding(top = 0.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .padding(top = 50.dp)
                            .fillMaxSize(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.hsl(124f, 0.68f, 0.16f).copy(alpha = 0.85f)
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.account_circle),
                                contentDescription = "Not favorite animal",
                                modifier = Modifier.size(200.dp),
                                tint = Color.White
                            )

                            // Exibe os dados da pessoa se disponíveis
                            when (val result = personResult.value) {
                                is Result.Sucess -> {
                                    val person = result.data
                                    Text(
                                        text = person?.name ?: "Unknown",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 25.sp,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.fillMaxWidth(),
                                        color = Color.White
                                    )
                                    Text(
                                        text = person?.email ?: "Unknown Email",
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 18.sp,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.fillMaxWidth(),
                                        color = Color.White
                                    )
                                }
                                is Result.Error -> {
                                    Text(
                                        text = "Error loading profile",
                                        color = Color.Red,
                                        modifier = Modifier.padding(16.dp)
                                    )
                                }
                                else -> {
                                    Text(
                                        text = "Loading...",
                                        color = Color.Gray,
                                        modifier = Modifier.padding(16.dp)
                                    )
                                }
                            }

                            LogoutButton("Logout", personViewModel = personViewModel)
                            PointsBox("100 points")
                        }
                    }
                }
            }
        }
    }
}


