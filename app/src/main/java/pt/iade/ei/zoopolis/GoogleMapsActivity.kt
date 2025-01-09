package pt.iade.ei.zoopolis

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import pt.iade.ei.zoopolis.retrofit.AEDTORepositoryImplementation
import pt.iade.ei.zoopolis.retrofit.AnimalsDTORepositoryImplementation
import pt.iade.ei.zoopolis.retrofit.EnclosureDTORepositoryImplementation
import pt.iade.ei.zoopolis.retrofit.RetrofitInstance
import pt.iade.ei.zoopolis.viewmodel.AEDTOViewModel
import pt.iade.ei.zoopolis.viewmodel.AnimalDTOViewModel
import pt.iade.ei.zoopolis.viewmodel.EnclosureDTOViewModel
import pt.iade.ei.zoopolis.retrofit.Result

class GoogleMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private val viewModel by viewModels<AnimalDTOViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return AnimalDTOViewModel(AnimalsDTORepositoryImplementation(RetrofitInstance.api))
                        as T
            }
        }
    })
    private val AEDTOViewModel by viewModels<AEDTOViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return AEDTOViewModel(
                    AEDTORepositoryImplementation(RetrofitInstance.api)
                )
                        as T
            }
        }
    })
    private val EnclosureDTOViewModel by viewModels<EnclosureDTOViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return EnclosureDTOViewModel(
                    EnclosureDTORepositoryImplementation(RetrofitInstance.api)
                )
                        as T
            }
        }
    })
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val animalId = intent.getIntExtra("animal_id", -1) // Obtém o ID do animal
        setContentView(R.layout.google_maps_activity)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this) // Passa 'this' como o callback
    }

    // Implementação obrigatória do método onMapReady
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val animalId = intent.getIntExtra("animal_id", -1) // Obtém o ID do animal
        if (animalId != -1) {
            AEDTOViewModel.getAEByAnimalId(animalId) // Fetch AE data for the given animalId
            AEDTOViewModel.aeByAnimalId.observe(this) { result ->
                when (result) {
                    is Result.Sucess -> {
                        result.data?.let { aeList ->
                            for (ae in aeList) {
                                val enclosureId = ae.enclosure?.id // Acessa o id do Enclosure
                                if (enclosureId != null) {
                                    // Busca o EnclosureDTO usando o EnclosureId
                                    EnclosureDTOViewModel.loadEnclosureById(enclosureId)
                                }
                            }
                        }
                    }

                    is Result.Error -> {
                        Log.e("GoogleMapsActivity", "Erro ao carregar AE: ${result.message}")
                    }
                }
            }

            // Observa o EnclosureDTOViewModel para adicionar marcadores no mapa
            EnclosureDTOViewModel.enclosureById.observe(this) { result ->
                when (result) {
                    is Result.Sucess -> {
                        result.data?.let { enclosure ->
                            val lat = enclosure.latitude
                            val lng = enclosure.longitude
                            if (lat != null && lng != null) {
                                val location = LatLng(lat, lng)
                                mMap.addMarker(
                                    MarkerOptions().position(location).title(enclosure.name)
                                )
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 20.0f))
                            }
                        }
                    }

                    is Result.Error -> {
                        Log.e("GoogleMapsActivity", "Erro ao carregar Enclosure: ${result.message}")
                    }
                }
            }
        }

        try {
            // Carrega o estilo do JSON
            val success = mMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style)
            )
            if (!success) {
                Log.e("GoogleMapsActivity", "Falha ao aplicar o estilo do mapa.")
            }
        } catch (e: Resources.NotFoundException) {
            Log.e("GoogleMapsActivity", "Erro: Estilo não encontrado.", e)
        }


    }
}
