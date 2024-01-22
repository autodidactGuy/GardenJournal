package edu.miu.cs473.gardenjournal.ui

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.miu.cs473.gardenjournal.R
import edu.miu.cs473.gardenjournal.db.Plant
import kotlinx.coroutines.launch

class AddPlantFragment : BaseFragment() {
    private var plant: Plant? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_plant, container, false)
        val buttonSave = view.findViewById<FloatingActionButton>(R.id.button_save)
        val viewModel = GardenLogViewModel(requireContext())
        buttonSave.setOnClickListener {
            val plantName = view.findViewById<EditText>(R.id.plantName)
            val plantType = view.findViewById<EditText>(R.id.plantType)
            val wateringFrequency = view.findViewById<EditText>(R.id.wateringFrequency)
            val plantingDate = view.findViewById<EditText>(R.id.plantingDate)

            if(plantName.text.toString().isEmpty() || plantType.text.toString().isEmpty() || wateringFrequency.text.toString().isEmpty() || plantingDate.text.toString().isEmpty()){
                Toast.makeText(context, "Please enter valid plant details!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            launch {
                plant = Plant(name = plantName.text.toString(), type = plantType.text.toString(), wateringFrequency = wateringFrequency.text.toString().toInt(), plantingDate = plantingDate.text.toString())
                context?.let {
                    viewModel.insert(plant!!)
                    Toast.makeText(it, "New Plant added!", Toast.LENGTH_SHORT).show()
                    val action = AddPlantFragmentDirections.actionAddPlantFragmentToGardenLogFragment()
                    Navigation.findNavController(view).navigate(action)
                }
            }
        }
        return view
    }
}