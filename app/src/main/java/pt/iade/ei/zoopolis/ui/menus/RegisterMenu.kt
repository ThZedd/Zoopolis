package pt.iade.ei.zoopolis.ui.menus

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.zoopolis.R
import pt.iade.ei.zoopolis.ui.components.DatePickerFieldToModal
import pt.iade.ei.zoopolis.ui.components.IHaveAnAccountButton
import pt.iade.ei.zoopolis.ui.components.RegisterButton
import pt.iade.ei.zoopolis.ui.components.TextField

@Composable
fun RegisterMenu() {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("Male") }
    val genders = listOf("Male", "Female", "Other")
    val focusManager = LocalFocusManager.current
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.startingmenubackground),
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
                        .fillMaxSize()
                        .padding(top = 50.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.logozoo),
                        contentDescription = "Logo",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(300.dp),
                        alignment = Alignment.TopStart
                    )
                }
                Card(
                    modifier = Modifier
                        .padding(top = 300.dp)
                        .fillMaxSize(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF58A458)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(
                            text = "Username",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(top = 8.dp, start = 3.dp),
                            textAlign = TextAlign.Start,
                            color = Color.White
                        )
                        TextField(
                            value = username,
                            onValueChange = { username = it },
                            labelText = "Username",
                            leadingIcon = Icons.Default.Person,
                            onNext = { focusManager.moveFocus(androidx.compose.ui.focus.FocusDirection.Next) }
                        )

                        Text(
                            text = "Email",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(top = 8.dp, start = 3.dp),
                            textAlign = TextAlign.Start,
                            color = Color.White
                        )
                        TextField(
                            value = email,
                            onValueChange = { email = it },
                            labelText = "Email",
                            leadingIcon = Icons.Default.Person,
                            onNext = { focusManager.moveFocus(androidx.compose.ui.focus.FocusDirection.Next) }

                        )

                        Text(
                            text = "Password",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(top = 8.dp, start = 3.dp),
                            textAlign = TextAlign.Start,
                            color = Color.White
                        )
                        TextField(
                            value = password,
                            onValueChange = { password = it },
                            labelText = "Password",
                            leadingIcon = Icons.Default.Lock,
                            keyboardType = KeyboardType.Password,
                            visualTransformation = PasswordVisualTransformation(), // Exibe asteriscos
                            onNext = { focusManager.clearFocus() }
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Gender selection
                        Text(
                            text = "Gender",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                        Row {
                            genders.forEach { gender ->
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .selectable(
                                            selected = (selectedGender == gender),
                                            onClick = { selectedGender = gender }
                                        )
                                        .padding(8.dp)
                                ) {
                                    RadioButton(
                                        selected = (selectedGender == gender),
                                        onClick = { selectedGender = gender },
                                        colors = RadioButtonDefaults.colors(
                                            selectedColor = Color.White,
                                            unselectedColor = Color.hsl(124f, 0.68f, 0.16f)
                                        )
                                    )
                                    Text(
                                        text = gender,
                                        color = Color.White,
                                        modifier = Modifier.padding(start = 8.dp)
                                    )
                                }
                            }
                        }
                        // Birth date selection
                        DatePickerFieldToModal()

                        Spacer(modifier = Modifier.height(16.dp))

                        Row {
                            Spacer(modifier = Modifier.padding(start = 10.dp))
                            IHaveAnAccountButton("I Have An Account")
                            Spacer(modifier = Modifier.width(10.dp))
                            RegisterButton("Register")
                            Spacer(modifier = Modifier.padding(end = 20.dp))
                        }

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterMenuPreview() {
    RegisterMenu()
}
