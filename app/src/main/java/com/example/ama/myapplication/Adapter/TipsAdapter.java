package com.example.ama.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.ama.myapplication.HomeFragment;
import com.example.ama.myapplication.MyOrderDetailActivity;
import com.example.ama.myapplication.R;
import com.example.ama.myapplication.Tips.Data;
import com.example.ama.myapplication.TipsDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.ViewHolder> {
    private Context context;
    List<Data> data;
    public static final String URL = "http://airless-shout.000webhostapp.com/";

    public TipsAdapter(Context context, List<Data> data){
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public TipsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_tips,parent,false);
        TipsAdapter.ViewHolder holder = new TipsAdapter.ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TipsAdapter.ViewHolder holder, int position) {
        final Data datas = data.get(position);
        holder.id_tips = datas.getIdTips();
        holder.img_tips = datas.getImgTips();
        holder.tgl_post_tips = datas.getTglPostTips();
        holder.txtJudulTips.setText(datas.getJudulTips());
        holder.isi_tips =  datas.getIsiTips();

        Glide.with(this.context)
                .load(URL+datas.getImgTips())
                .placeholder(new ColorDrawable(Color.GRAY))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.imgTips);

        holder.cardTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TipsDetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        String id_tips;
        String tgl_post_tips;
        String img_tips;
        String isi_tips;

        @BindView(R.id.img_tips)
        ImageView imgTips;
        @BindView(R.id.judul_tips)
        TextView txtJudulTips;
        @BindView(R.id.card_tips)
        CardView cardTips;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
