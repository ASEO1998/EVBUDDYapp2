# EV Buddy – Charge On Demand

This is a prototype Android app built for Klick Capital LLC's mobile development assignment.

## Features

- Home screen with header and two action buttons
- Google Maps integration showing EV charger locations
- Bottom navigation bar with Home, My Requests, and Profile tabs
- Bonus: Mock list of mobile power drivers with name, distance, ETA, and rating

## Tech Stack

- Kotlin
- Android SDK
- Google Maps API
- Volley (for network requests)
- ConstraintLayout & RecyclerView

## Notes

- Location-based charger data fetched from [Open Charge Map API](https://openchargemap.org/site/develop/api)
- Mock driver list appears when "Find Mobile Power Driver" is tapped
- Designed for responsiveness across device sizes

## How to Run

1. Clone the repo or unzip the project
2. Open in Android Studio
3. Add your Google Maps API key in `AndroidManifest.xml`
4. Run on emulator or device

## Author

Aaron Seo – Mobile Developer & Creative Technologist
