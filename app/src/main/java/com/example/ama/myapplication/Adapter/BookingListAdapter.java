package com.example.ama.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ama.myapplication.Booking.Data;
import com.example.ama.myapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookingListAdapter extends RecyclerView.Adapter<BookingListAdapter.ViewHolder> {
    String jam;
//    @BindView(R.id.jam_pilih) TextView txtJamnya;
    private Context context;

    List<com.example.ama.myapplication.Booking.Data> data;
//    String jamnya = txtJamnya.getText().toString();

    public BookingListAdapter(Context context, List<Data> data, String jam){

        this.context = context;
        this.data = data;
        this.jam = jam;

//        Log.d("TES jam", jam);
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
        com.example.ama.myapplication.Booking.Data datas = data.get(position);
        holder.id_lap = datas.getId_lapangan();
        holder.txtNamaLapList.setText(datas.getNama_lapangan());
        holder.txtHargaLapList.setText(datas.getHarga_lapangan());
        holder.txtNamaLapList.setText(datas.getNama_lapangan());
        holder.id_mitra = datas.getId_mitra();
        holder.txtNamaMitraList.setText(datas.getNama_mitra());
        holder.txtJamBookingList.setText(jam);
        Log.d("Tes Jam", "onBindViewHolder: "+jam);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
//        String jam_booking=((Search) this.get()).getSomeVariable();;
        String id_lap;

        @BindView(R.id.nama_lap_list) TextView txtNamaLapList;
        @BindView(R.id.jam_booking_list) TextView txtJamBookingList;
        @BindView(R.id.harga_lap_list) TextView txtHargaLapList;
        String id_mitra;
        @BindView(R.id.nama_mitra_list) TextView txtNamaMitraList;



        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
