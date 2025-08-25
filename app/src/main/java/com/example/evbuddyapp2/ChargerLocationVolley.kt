package com.example.evbuddyapp2

import android.content.Context
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.Column
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import com.android.volley.Response
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject


class ChargerLocationVolley {

    @OptIn(UnstableApi::class)
    fun fetchEVChargers(context: Context,latitude: Long, longitude: Long,distance: Int) {
        //val url = "https://api.openchargemap.io/v3/poi/?output=json&countrycode=US&maxresults=100&key=YOUR_API_KEY"



        val apiKey = "0a2ebda2-5e4c-4210-b2a4-0d5f5d376358"
        val url = "https://api.openchargemap.io/v3/poi/?" +
                "output=json&latitude=$latitude&longitude=$longitude" +
                "&distance=$distance&maxresults=100&key=$apiKey"
        val requestQueue = Volley.newRequestQueue(context)

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                try {
                    val jsonArray = JSONArray(response)
                    for (i in 0 until jsonArray.length()) {
                        val charger = jsonArray.getJSONObject(i)
                        val addressInfo = charger.getJSONObject("AddressInfo")
                        val latitude = addressInfo.getDouble("Latitude")
                        val longitude = addressInfo.getDouble("Longitude")
                        val title = addressInfo.getString("Title")

                        // You can now use these values to drop markers on a map
                        Log.d("EV Charger", "Name: $title, Lat: $latitude, Lng: $longitude")
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            },
            { error ->
                Log.e("Volley Error", error.toString())
            }
        )

        requestQueue.add(stringRequest)
    }


}