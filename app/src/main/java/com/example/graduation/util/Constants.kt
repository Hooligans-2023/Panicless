package com.example.graduation.util

import com.example.graduation.R


typealias ResString = R.string

object Constants {
    //const val OLD_BASE_URL = "https://talab.moltaqadev.com/api/"
    const val BASE_URL = "https://ammar5werdani.pythonanywhere.com/"
    const val PREFERENCES_DB: String = "PreferencesDb"
    const val NETWORK_PAGE_SIZE = 10
    const val DEBOUNCE_SEARCH = 900L
    const val API_MY_FATOORH_KEY = "rLtt6JWvbUHDDhsZnfpAhpYk4dxYDQkbcPTyGaKp2TYqQgG7FGZ5Th_WD53Oq8Ebz6A53njUoo1w3pjU1D4vs_ZMqFiz_j0urb_BH9Oq9VZoKFoJEDAbRZepGcQanImyYrry7Kt6MnMdgfG5jn4HngWoRdKduNNyP4kzcp3mRv7x00ahkm9LAK7ZRieg7k1PDAnBIOG3EyVSJ5kK4WLMvYr7sCwHbHcu4A5WwelxYK0GMJy37bNAarSJDFQsJ2ZvJjvMDmfWwDVFEVe_5tOomfVNt6bOg9mexbGjMrnHBnKnZR1vQbBtQieDlQepzTZMuQrSuKn-t5XZM7V6fCW7oP-uXGX-sMOajeX65JOf6XVpk29DP6ro8WTAflCDANC193yof8-f5_EYY-3hXhJj7RBXmizDpneEQDSaSz5sFk0sV5qPcARJ9zGG73vuGFyenjPPmtDtXtpx35A-BVcOSBYVIWe9kndG3nclfefjKEuZ3m4jL9Gg1h2JBvmXSMYiZtp9MR5I6pvbvylU_PP5xJFSjVTIz7IQSjcVGO41npnwIxRXNRxFOdIUHn0tjQ-7LwvEcTXyPsHXcMD8WtgBh-wxR8aKX7WPSsT1O8d8reb2aR7K3rkV3K82K_0OgawImEpwSvp9MNKynEAJQS6ZHe_J_l77652xwPNxMRTMASk1ZsJL"
    const val VERIFICATION_CODE_TIMER_SECONDS = 60L

   // ================== GET Request Map Key ================
   const val LATITUDE: String = "latitude"
   const val LONGITUDE: String = "longitude"
   const val STORE_RATINGS: String = "ratings"
   const val PRODUCT_CATEGORIES: String = "product_categories"
   const val STORE_INFO: String = "store_infos"
   const val ORDERS_CURRENT: String = "current"
   const val ORDERS_FINISHED: String = "finished"
   const val ORDERS_SCHEDULED: String = "scheduled"
   const val ORDERS_STATUS_NEW: String = "new"
   const val ORDERS_STATUS_PREPARED: String = "prepared"
   const val ORDERS_STATUS_SHIPPED: String = "shipped"
   const val ORDERS_STATUS_RECEIVED: String = "received"
   const val SORT: String = "sort"
   const val ORDERS_STORE_NEARST: String = "nearst"
   const val ORDERS_STORE_HIGHEST_RATED: String = "highest_rated"
   const val ORDERS_STORE_LOWEST_TIME: String = "lowest_time"
   const val ORDERS_STORE_ALPHA: String = "alpha"



   // ================== POST Request Map Key ================
   const val PRODUCT_ID: String = "product_id"
   const val TYPE: String = "type"
   const val PAGE: String = "page"
   const val ADD: String = "add"
   const val REMOVE: String = "remove"
   const val MALE: String = "male"
   const val FEMALE: String = "female"
   const val CASH: Int = 1
   const val ONLINE: Int = 2

    const val ADDRESS_HOME: String = "home"
    const val ADDRESS_WORK: String = "work"
    const val ADDRESS_FRIEND: String = "friend"
    const val ADDRESS_REST: String = "rest"



}