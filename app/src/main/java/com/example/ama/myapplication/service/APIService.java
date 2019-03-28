package com.example.ama.myapplication.service;

import com.example.ama.myapplication.Message;
import com.example.ama.myapplication.Myoder.Value;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface APIService {
    @GET("api/booking/read_booking_list.php")
    Call<com.example.ama.myapplication.Booking.Value> viewListBooking(@QueryMap HashMap<String, String> params);

    @GET("api/booking/read_booking_list.php")
    Call<com.example.ama.myapplication.Booking.Message> viewListBookingMessage(@QueryMap HashMap<String, String> params);

    @FormUrlEncoded
    @POST("api/booking/create.php")
    Call<com.example.ama.myapplication.Booking.Message> createBooking (@Field("id_booking") String id_booking,
                                                                      @Field("id_mitra") String id_mitra,
                                                                      @Field("id_lapangan") String id_lapangan,
                                                                      @Field("id_user") String id_user,
                                                                      @Field("harga_lapangan") String harga_lapangan,
                                                                      @Field("jumlah_jam") String jumlah_jam,
                                                                      @Field("tgl_booking") String tgl_booking,
                                                                      @Field("jam_booking") String jam_booking,
                                                                      @Field("status_booking") String status_booking);

    @GET("api/booking/read_booking_history.php")
    Call<Value> viewBookingHistory(@QueryMap HashMap<String, String> params);

    @GET("api/booking/read_booking_history.php")
    Call<Message> viewMyorderHistoryMessage(@QueryMap HashMap<String, String> params);

}
