# Garden Journal App
A Gardening Journal App using Android Kotlin that incorporates ViewModel, LiveData, Navigation component, NavHostFragment, Room database, and coroutine concepts.

## Instructions

<ul>
 <li> `Clone the Repo` </li> 
 <li> `Open this project in Latest Android Studio` </li> 
 <li>`Run app on Emulator / Connected Android Device` </li>  
</ul>

## Navigation Structure:

Create a gardening app with at least three main screens: Home, Garden Log, and Plant Details.
Use the Navigation component to implement navigation between these screens.
Utilize a NavHostFragment for hosting the navigation graph.
 

## ViewModel and LiveData:

Implement a ViewModel for each screen to manage the UI-related data.
Use LiveData to observe and update the UI based on the underlying data changes.
Ensure that the ViewModel survives configuration changes.
 

## Room Database:

Create an entity class representing a plant with attributes like name, type, watering frequency, and planting date.
Implement a Room database to store and retrieve plant data.
Use a DAO (Data Access Object) to perform database operations.
 

## Coroutines:

Use coroutines to perform asynchronous operations, such as database queries.
Ensure that database operations run on a background thread to avoid blocking the main thread.
 

## Garden Log Screen:

Display a list of plants from the Room database in a RecyclerView on the Garden Log screen.
Allow users to add new plants to the database by entering the plant details.
Implement a coroutine to insert plant data into the database asynchronously.

## Plant Details Screen:

Create a Plant Details screen that displays detailed information about a selected plant.
Use navigation arguments to pass the selected plant's ID to the Plant Details screen.
Retrieve the plant details from the Room database using the ID.

# Home
![alt_text](https://github.com/autodidactGuy/GardenJournal/blob/master/screenshots/Screenshot_20240121_212705.png?raw=true)

# Garden Log
![alt_text](https://github.com/autodidactGuy/GardenJournal/blob/master/screenshots/Screenshot_20240121_224425.png?raw=true)

# Plant Details
![alt_text](https://github.com/autodidactGuy/GardenJournal/blob/master/screenshots/Screenshot_20240121_212723.png?raw=true)

# Add New Plant
![alt_text](https://github.com/autodidactGuy/GardenJournal/blob/master/screenshots/Screenshot_20240121_212731.png?raw=true)



