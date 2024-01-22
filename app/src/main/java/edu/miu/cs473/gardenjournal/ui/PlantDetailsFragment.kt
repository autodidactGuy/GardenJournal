package edu.miu.cs473.gardenjournal.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.miu.cs473.gardenjournal.R
import edu.miu.cs473.gardenjournal.db.Plant


class PlantDetailsFragment : Fragment() {

    private lateinit var viewModel: GardenLogViewModel
    private var plantId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plant_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the plantId from the arguments
        plantId = arguments?.getInt("plantId") ?: 0

        val viewModel: GardenLogViewModel by viewModels()

        // Observe the plant details and update UI
        viewModel.getPlantById(plantId).observe(viewLifecycleOwner, Observer { plant ->
            plant?.let { displayPlantDetails(it) }
        })
    }

    private fun displayPlantDetails(plant: Plant) {
        // Update UI with plant details
        view?.findViewById<TextView>(R.id.plantName)?.text = plant.name
        view?.findViewById<TextView>(R.id.plantType)?.text = "Type: ${plant.type}"
        view?.findViewById<TextView>(R.id.wateringFrequency)?.text = "Watering Frequency: ${plant.wateringFrequency} days"
        view?.findViewById<TextView>(R.id.plantingDate)?.text = "Planting Date: ${plant.plantingDate}"
    }
}
