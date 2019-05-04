package com.example.ama.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.example.ama.myapplication.Adapter.MyorderAdapter;
import com.example.ama.myapplication.Adapter.TipsAdapter;
import com.example.ama.myapplication.Myoder.Data;
import com.example.ama.myapplication.Tips.Value;
import com.example.ama.myapplication.service.APIService;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment {

    @BindView(R.id.btn_pesan) CardView _btnOrder;
//    @BindView(R.id.carouselView) CarouselView _carouselImg;
//    @BindView(R.id.button2) Button button2;
    @BindView(R.id.recycleView_tips) RecyclerView recyclerView;

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.img1, R.drawable.img2, R.drawable.img3};

    private TipsAdapter tipsAdapter;
    public static final String URL = "http://airless-shout.000webhostapp.com/";
    private List<com.example.ama.myapplication.Tips.Data> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = getLayoutInflater().inflate(R.layout.fragment_home2, container, false);

        ButterKnife.bind(this, rootView);


        _btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Order_1.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                getActivity().startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

            }
        });


        tipsAdapter = new TipsAdapter(getActivity().getApplicationContext(), data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setAdapter(tipsAdapter);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

//        final SkeletonScreen skeletonScreen = Skeleton.bind(recyclerView)
//                .adapter(tipsAdapter)
//                .load(R.layout.item_skeleton_news)
//                .show();

        loadTips();

        
//        carouselView = (CarouselView) rootView.findViewById(R.id.carouselImg);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);




        return rootView;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };


    private void loadTips() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final APIService api = retrofit.create(APIService.class);
        Call<Value> call = api.viewTips();
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                data = response.body().getData();
                String tes = Integer.toString(data.size());
                tipsAdapter = new TipsAdapter(getActivity(), data);
                tipsAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(tipsAdapter);
                response.isSuccessful();
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                Log.d("Error", "onFailure: "+t);
            }
        });
    }


}
