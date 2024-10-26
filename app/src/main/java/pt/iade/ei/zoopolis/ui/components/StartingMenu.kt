package pt.iade.ei.zoopolis.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun StartingMenu(){

    Column(
        modifier = Modifier
            .background(color = Color(0xFF006600)) // Background color

) {
        Text(
            text = "Login",
            fontWeight = FontWeight.Bold,
            fontSize = 9.sp
        )

        Text(
            text = "Register",
            fontWeight = FontWeight.Bold,
            fontSize = 8.sp,
            modifier = Modifier.padding(top = 30.dp)
        )

    }
}


@Preview(showBackground = true)
@Composable

fun StartingMenuPreview(){
    StartingMenu()

}