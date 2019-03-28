package com.example.ama.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ama.myapplication.DetailBookingActivity;
import com.example.ama.myapplication.MyOrderDetailActivity;
import com.example.ama.myapplication.Myoder.Data;
import com.example.ama.myapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyorderAdapter extends RecyclerView.Adapter<MyorderAdapter.ViewHolder> {
    private Context context;
    List<Data> data;

    public MyorderAdapter(Context context, List<Data> data){

        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public MyorderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_myorder, parent, false);
        MyorderAdapter.ViewHolder holder = new MyorderAdapter.ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyorderAdapter.ViewHolder holder, int position) {
        final Data datas = data.get(position);
        holder.id_booking = datas.getIdBooking();
        holder.id_mitra = datas.getIdMitra();
        holder.nama_mitra = datas.getNamaMitra();
        holder.id_lap = datas.getIdLapangan();
        holder.nama_lapangan = datas.getNamaLapangan();
        holder.id_user = datas.getIdUser();
        holder.harga_lapangan = datas.getHargaLapagan();
        holder.jumlah_jam = datas.getJumlahJam();
        holder.tgl_booking = datas.getTglBooking();
        holder.jam_booking = datas.getJamBooking();
        holder.status_booking = datas.getStatusBooking();
        holder.txtNamaMitraMyorder.setText(datas.getNamaMitra());
        holder.txtJamBookingMyorder.setText(datas.getJamBooking());
        holder.txtNamaLapMyorder.setText(datas.getNamaLapangan());
        holder.txtStatusMyoder.setText(datas.getStatusBooking());

        holder.cardMyorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MyOrderDetailActivity.class);
                context.startActivity(intent);
            }
        });

        Log.d("Bind", "onBindViewHolder: "+datas.getStatusBooking());
        if (datas.getStatusBooking()=="expire"){
            Log.d("expire", "onBindViewHolder: cacat");
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        String id_booking;
        String id_mitra;
        String id_lap;
        String id_user;
        String harga_lapangan;
        String jumlah_jam;
        String tgl_booking;
        String jam_booking;
        String status_booking;
        String nama_mitra;
        String nama_lapangan;

        @BindView(R.id.nama_lap_myorder)
        TextView txtNamaLapMyorder;
        @BindView(R.id.nama_mitra_myorder)
        TextView txtNamaMitraMyorder;
        @BindView(R.id.jam_booking_myorder)
        TextView txtJamBookingMyorder;
        @BindView(R.id.status_booking_myorder)
        TextView txtStatusMyoder;
        @BindView(R.id.card_myoder)
        CardView cardMyorder;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
