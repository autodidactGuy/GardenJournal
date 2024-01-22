package edu.miu.cs473.gardenjournal.db

import android.content.Context
import androidx.lifecycle.LiveData

class PlantRepository(context: Context) {
    private val plantDao: PlantDao
    val allPlants: LiveData<List<Plant>>

    init {
        val database = PlantDatabase.getDatabase(context)
        plantDao = database.plantDao()
        allPlants = plantDao.getAllPlants()
    }

    suspend fun insert(plant: Plant) {
        plantDao.insert(plant)
    }

    suspend fun update(plant: Plant) {
        plantDao.update(plant)
    }

    suspend fun delete(plant: Plant) {
        plantDao.delete(plant.id)
    }

    fun getPlantById(plantId: Int): LiveData<Plant> {
        return plantDao.getPlantById(plantId)
    }
}
