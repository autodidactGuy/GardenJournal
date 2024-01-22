package edu.miu.cs473.gardenjournal.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.miu.cs473.gardenjournal.db.Plant
import edu.miu.cs473.gardenjournal.db.PlantRepository
import kotlinx.coroutines.launch

class GardenLogViewModel(application: Application): AndroidViewModel(application){
    private val repository: PlantRepository

    val allPlants: LiveData<List<Plant>>

    init{
        repository = PlantRepository(application)
        allPlants = repository.allPlants
    }

    fun insert(plant: Plant) = viewModelScope.launch {
        repository.insert(plant)
    }

    fun getPlantById(plantId: Int): LiveData<Plant> {
        return repository.getPlantById(plantId)
    }
}