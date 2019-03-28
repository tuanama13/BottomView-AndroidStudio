package com.example.ama.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ama.myapplication.Booking.Data;
import com.example.ama.myapplication.BookingListActivity;
import com.example.ama.myapplication.DetailBookingActivity;
import com.example.ama.myapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookingListAdapter extends RecyclerView.Adapter<BookingListAdapter.ViewHolder> {
    String jam;
    String tgl;
    private Context context;
    List<com.example.ama.myapplication.Booking.Data> data;


    public BookingListAdapter(Context context, List<Data> data, String jam, String tgl){

        this.context = context;
        this.data = data;
        this.jam = jam;
        this.tgl = tgl;
    }


    @NonNull
    @Override
    public BookingListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_booking, parent, false);
        BookingListAdapter.ViewHolder holder = new BookingListAdapter.ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookingListAdapter.ViewHolder holder, int position) {
        final com.example.ama.myapplication.Booking.Data datas = data.get(position);
        holder.id_lap = datas.getId_lapangan();
        holder.txtNamaLapList.setText(datas.getNama_lapangan());
        holder.txtHargaLapList.setText(datas.getHarga_lapangan());
        holder.txtNamaLapList.setText(datas.getNama_lapangan());
        holder.id_mitra = datas.getId_mitra();
        holder.txtNamaMitraList.setText(datas.getNama_mitra());
        holder.txtJamBookingList.setText(jam);
        Log.d("Tes Jam", "onBindViewHolder: "+jam);
        holder.cardList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Clik Element"+datas.getNama_lapangan(), Snackbar.LENGTH_LONG).show();
                Intent intent = new Intent(context, DetailBookingActivity.class);
                intent.putExtra("id_lap", datas.getId_lapangan());
                intent.putExtra("nama_lap", datas.getNama_lapangan());
                intent.putExtra("harga", datas.getHarga_lapangan());
                intent.putExtra("id_mitra", datas.getId_mitra());
                intent.putExtra("nama_mitra", datas.getNama_mitra());
                intent.putExtra("jam_booking", jam);
                intent.putExtra("tgl_booking", tgl);
                context.startActivity(intent);
//                context.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
//                ((Activity)context).finish();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        String id_lap;
        @BindView(R.id.nama_lap_list) TextView txtNamaLapList;
        @BindView(R.id.jam_booking_list) TextView txtJamBookingList;
        @BindView(R.id.harga_lap_list) TextView txtHargaLapList;
        String id_mitra;
        @BindView(R.id.nama_mitra_list) TextView txtNamaMitraList;
        @BindView(R.id.card_list) android.support.v7.widget.CardView cardList;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
