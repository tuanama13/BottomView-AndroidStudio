package com.example.ama.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ama.myapplication.Adapter.BookingListAdapter;
import com.example.ama.myapplication.Adapter.MyorderAdapter;
import com.example.ama.myapplication.Booking.Value;
import com.example.ama.myapplication.Myoder.Data;
import com.example.ama.myapplication.service.APIService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class OrderFragment extends Fragment {
    private MyorderAdapter myoderAdapter;
    public static final String URL = "http://airless-shout.000webhostapp.com/";
    private List<Data> data = new ArrayList<>();

    @BindView(R.id.recycleView_myorder)
    RecyclerView recyclerView;
    @BindView(R.id.btn_toorder_myorder)
    Button btnToOrder;
    @BindView(R.id.progress_bar_myorder)
    ProgressBar progressBar;
    @BindView(R.id.message_myorder)
    TextView txtMessageMyorder;
    @BindView(R.id.img_myorder)
    ImageView imgMyorder;
//    @BindView(R.id.status_booking_myorder)
//    TextView txtStatusMyorder_;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_order, null);
        View rootView = getLayoutInflater().inflate(R.layout.fragment_order, container, false);
        ButterKnife.bind(this, rootView);

        btnToOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Order_1.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                getActivity().startActivity(intent);
            }
        });



        myoderAdapter = new MyorderAdapter(getActivity().getApplicationContext(), data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(myoderAdapter);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        loadMyorder();

        return rootView;
    }

    private void loadMyorder() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final HashMap<String, String> params = new HashMap<>();
        params.put("id_user", "1");

        final APIService api = retrofit.create(APIService.class);
        Call<com.example.ama.myapplication.Myoder.Value> call = api.viewBookingHistory(params);
        call.enqueue(new Callback<com.example.ama.myapplication.Myoder.Value>() {
            @Override
            public void onResponse(Call<com.example.ama.myapplication.Myoder.Value> call, Response<com.example.ama.myapplication.Myoder.Value> response) {
                if (response.body().getData()== null){
                    Call<Message> callM = api.viewMyorderHistoryMessage(params);
                    callM.enqueue(new Callback<Message>() {
                        @Override
                        public void onResponse(Call<Message> call, Response<Message> response) {
                            progressBar.setVisibility(View.GONE);
                            btnToOrder.setVisibility(View.VISIBLE);
                            imgMyorder.setImageResource(R.drawable.message_img);
                            txtMessageMyorder.setText(response.body().getMessage());
                        }

                        @Override
                        public void onFailure(Call<Message> call, Throwable t) {
                            Log.d("Error", "onFailure: "+t);
                        }
                    });
                }else{
                    progressBar.setVisibility(View.GONE);
//                    txtStatusMyorder_.setBackgroundResource(R.drawable.border_text_alt);
                    data = response.body().getData();
                    String tes = Integer.toString(data.size());
                    myoderAdapter = new MyorderAdapter(getActivity(), data);
                    myoderAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(myoderAdapter);
                    response.isSuccessful();
                }
//
// btnToOrder.setVisibility(View.VISIBLE);

            }

            @Override
            public void onFailure(Call<com.example.ama.myapplication.Myoder.Value> call, Throwable t) {
                Log.d("Error", "onFailure: "+t);
            }
        });
    }
}
