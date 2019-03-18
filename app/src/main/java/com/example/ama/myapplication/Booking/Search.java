package com.example.ama.myapplication.Booking;

import android.app.Application;

import com.example.ama.myapplication.BookingListActivity;

public class Search extends Application{
    private String tgl_;
    private String jam_;

    public String getTgl_() {
        return tgl_;
    }

    public void setTgl_(String tgl_) {
        this.tgl_ = tgl_;
    }

    public String getJam_() {
        return jam_;
    }

    public void setJam_(String jam_) {
        this.jam_ = jam_;
    }
}
