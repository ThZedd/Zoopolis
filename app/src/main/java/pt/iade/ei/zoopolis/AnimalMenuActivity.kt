package pt.iade.ei.zoopolis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.zoopolis.ui.menus.AnimalMenu
import pt.iade.ei.zoopolis.ui.theme.ZoopolisTheme

class AnimalMenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZoopolisTheme {
                AnimalMenu()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimalMenuActivityPreview() {
    ZoopolisTheme {
       AnimalMenu()
    }
}