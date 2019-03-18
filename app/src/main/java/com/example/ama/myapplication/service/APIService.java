package com.example.ama.myapplication.service;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface APIService {
    @GET("api/booking/read_booking_list.php")
    Call<com.example.ama.myapplication.Booking.Value> viewListBooking(@QueryMap HashMap<String, String> params);
}
