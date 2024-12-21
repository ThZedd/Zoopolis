package pt.iade.ei.zoopolis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pt.iade.ei.zoopolis.retrofit.PersonRepositoryImplementation
import pt.iade.ei.zoopolis.retrofit.RetrofitInstance
import pt.iade.ei.zoopolis.ui.menus.RegisterMenu
import pt.iade.ei.zoopolis.ui.theme.ZoopolisTheme
import pt.iade.ei.zoopolis.viewmodel.PersonViewModel

class RegisterMenuActivity : ComponentActivity() {
    private val viewModel by viewModels<PersonViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return PersonViewModel(PersonRepositoryImplementation(RetrofitInstance.api))
                        as T
            }
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZoopolisTheme {
                RegisterMenu(viewModel = viewModel)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun  RegisterMenuActivityPreview() {
    ZoopolisTheme {
        RegisterMenu(viewModel = PersonViewModel(PersonRepositoryImplementation(RetrofitInstance.api)))
    }
}