package com.example.ama.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailBookingActivity extends AppCompatActivity {
    @BindView(R.id.harga_lap_detail)
    TextView txtharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_booking);
        ButterKnife.bind(this);

        Bundle bundle=getIntent().getExtras();
        txtharga.setText(bundle.getString("harga"));

    }
}
