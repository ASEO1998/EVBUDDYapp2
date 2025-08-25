package com.example.evbuddyapp2

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONArray

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Looper
import android.util.Log
import android.widget.Button
import androidx.annotation.RequiresPermission
import androidx.constraintlayout.widget.ConstraintLayout

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.location.LocationServices
import androidx.core.view.isVisible


//import com.google.android.gms.location.*


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonMobileDriver: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.driver_list)
        buttonMobileDriver = findViewById(R.id.button2)

//        buttonMobileDriver.setOnClickListener {
//            val mockDrivers = listOf(
//                Driver("Alex Johnson", "1.2 km", "5 min", 4.5f),
//                Driver("Maria Chen", "2.5 km", "8 min", 4.8f),
//                Driver("Samir Patel", "3.1 km", "10 min", 4.2f)
//            )
//
//            recyclerView.layoutManager = LinearLayoutManager(this)
//            recyclerView.adapter = DriverAdapter(mockDrivers)
//            recyclerView.visibility = View.VISIBLE
//        }





    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun findEV(v : View){

        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            111
        )

        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                if (location != null) {
                    val latitude = location.latitude
                    val longitude = location.longitude
                    Log.d("Location", "Lat: $latitude, Lng: $longitude")
                    val ChargerFind = ChargerLocationVolley()
                    ChargerFind.fetchEVChargers(this,latitude, longitude,100)
                } else {
                    Log.d("Location", "Location is null")
                }
            }

    }

    fun placeMarkers(array: JSONArray){


    }

    fun mockDriver(v:View){

        if (recyclerView.isVisible) {
            recyclerView.visibility = View.GONE
            buttonMobileDriver.text = "Find Mobile Power Driver"
        }
        else{
            val mockDrivers = listOf(
                Driver("Alex Johnson", "1.2 km", "5 min", 4.5f),
                Driver("Maria Chen", "2.5 km", "8 min", 4.8f),
                Driver("Samir Patel", "3.1 km", "10 min", 4.2f)
            )

            buttonMobileDriver.text = "Exit Out of Driver List"

            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = DriverAdapter(mockDrivers)
            recyclerView.visibility = View.VISIBLE
        }


    }




}

