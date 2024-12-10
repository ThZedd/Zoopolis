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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.zoopolis.R
import pt.iade.ei.zoopolis.models.Person
import pt.iade.ei.zoopolis.ui.components.PointsBox
import pt.iade.ei.zoopolis.ui.components.ProfileButton

@Composable
fun ProfileMenu(person: Person) {
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
                    )
                    {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        )
                        {
                            Icon(
                                painter = painterResource(id = R.drawable.account_circle),
                                contentDescription = "Not favorite animal",
                                modifier = Modifier.size(200.dp),
                                tint = Color.White
                            )
                            Text(
                                text = person.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth(),
                                color = Color.White,
                                style = TextStyle(
                                    shadow = Shadow(
                                        color = Color(0xFF000000),
                                        offset = Offset(3f, 3f), // Ajuste o deslocamento da sombra
                                        blurRadius = 0.15f // Aumente o valor para uma sombra mais suave
                                    )
                                )
                            )
                            Text(
                                text = person.email,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth(),
                                color = Color.White,
                                style = TextStyle(
                                    shadow = Shadow(
                                        color = Color(0xFF000000),
                                        offset = Offset(3f, 3f), // Ajuste o deslocamento da sombra
                                        blurRadius = 0.15f // Aumente o valor para uma sombra mais suave
                                    )
                                )
                            )
                            ProfileButton("Edit Profile")
                            PointsBox("100 points")

                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileMenuPreview(){
    ProfileMenu(person = Person(
        id = 1,
        name = "Bernardo Carvalho",
        email = "ber.cai.car@gmail.com",
        gender = "male",
        bdate = "10/07/2004",
        password = "password"
        )
    )

}