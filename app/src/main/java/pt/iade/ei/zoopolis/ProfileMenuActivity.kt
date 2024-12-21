package pt.iade.ei.zoopolis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.zoopolis.models.Person
import pt.iade.ei.zoopolis.ui.menus.ProfileMenu
import pt.iade.ei.zoopolis.ui.theme.ZoopolisTheme

class ProfileMenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZoopolisTheme {
                ProfileMenu(person = Person(
                    id = 1,
                    name = "Bernardo Carvalho",
                    email = "ber.cai.car@gmail.com",
                    gender = 'M',
                    bdate = "10/07/2004",
                    password = "password"
                )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileMenuActivityPreview() {
    ZoopolisTheme {
        ProfileMenu(person = Person(
            id = 1,
            name = "Bernardo Carvalho",
            email = "ber.cai.car@gmail.com",
            gender = 'M',
            bdate = "10/07/2004",
            password = "password"
        )
        )
    }
}


