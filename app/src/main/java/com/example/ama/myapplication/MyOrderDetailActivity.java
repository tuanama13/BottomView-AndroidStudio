package com.example.ama.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyOrderDetailActivity extends AppCompatActivity {
    @BindView(R.id.judul_toolbar_detail_myorder)
    TextView judulMyorder;
    @BindView(R.id.order_id_detail_myorder)
    TextView judulOrderid;
    @BindView(R.id.status_booking_detail_myorder)
    TextView statusDetailMyorder;
    @BindView(R.id.nama_lap_detail_myorder)
    TextView namaLapDetailMyorder;
    @BindView(R.id.nama_mitra_detail_myorder)
    TextView namaMitraDetailMyorder;
    @BindView(R.id.tgl_detail_myorder)
    TextView tglDetailMyorder;
    @BindView(R.id.jam_detail_myorder)
    TextView jamDetailMyorder;
    @BindView(R.id.order_back)
    ImageView _back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order_detail);
        ButterKnife.bind(this);
        Bundle bundle=getIntent().getExtras();

        judulMyorder.setText(bundle.getString("nama_lap"));
        judulOrderid.setText(bundle.getString("id_booking"));
        statusDetailMyorder.setText(bundle.getString("status_booking"));
        namaLapDetailMyorder.setText(bundle.getString("nama_lap"));
        namaMitraDetailMyorder.setText(bundle.getString("nama_mitra"));
        tglDetailMyorder.setText(bundle.getString("tgl_booking"));
        jamDetailMyorder.setText(bundle.getString("jam_booking"));


        _back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
