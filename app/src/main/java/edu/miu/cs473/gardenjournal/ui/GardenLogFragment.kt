package edu.miu.cs473.gardenjournal.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.miu.cs473.gardenjournal.R
import edu.miu.cs473.gardenjournal.db.Plant
import kotlinx.coroutines.launch


class GardenLogFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_garden_log, container, false)
        val viewModel: GardenLogViewModel by viewModels()
        val addPlantBtn = view.findViewById<FloatingActionButton>(R.id.button_add)
        val plantListView = view.findViewById<RecyclerView>(R.id.plantList)
        plantListView.setHasFixedSize(true)
        plantListView.layoutManager = LinearLayoutManager(context)

        val samplePlants = mutableListOf<Plant>()
        samplePlants.add(Plant(name = "Rose", type = "Flower", wateringFrequency = 2, plantingDate = "2023-01-01"))
        samplePlants.add(Plant(name = "Tomato", type = "Vegetable", wateringFrequency = 3, plantingDate = "2023-02-15"))
        samplePlants.add(Plant(name = "Basil", type = "Herb", wateringFrequency = 1, plantingDate = "2023-03-10"))


        launch {
            context?.let {
                viewModel.allPlants.observe(viewLifecycleOwner, Observer { plants ->
                    plants?.let {
                        if (plants.isEmpty()) {
                            for (plant in samplePlants) {
                                viewModel.insert(plant)
                            }
                        }
                        val plantAdapter = PlantListAdapter(plants)
                        plantAdapter.onItemClick = { plant ->
                            val action = GardenLogFragmentDirections.actionGardenLogFragmentToPlantDetailsFragment()
                            action.plantId = plant.id
                            Navigation.findNavController(view).navigate(action)
                        }
                        plantListView.adapter = plantAdapter
                    }
                })
            }
        }

        addPlantBtn.setOnClickListener{
            val action = GardenLogFragmentDirections.actionGardenLogFragmentToAddPlantFragment()
            Navigation.findNavController(view).navigate(action)
        }
        return view
    }
}