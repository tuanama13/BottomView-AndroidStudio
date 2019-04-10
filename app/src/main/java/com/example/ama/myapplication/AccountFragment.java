package com.example.ama.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AccountFragment extends Fragment {
    @BindView(R.id.btn_bantuan)
    Button btnBantuan;
    @BindView(R.id.btn_tentang) Button btnTentang;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = getLayoutInflater().inflate(R.layout.fragment_account, container, false);
        ButterKnife.bind(this, rootView);

        btnBantuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), BantuanActivity.class);
////                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                getActivity().startActivity(intent);
//                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                Intent i = new Intent(getActivity(), login.class);
                getActivity().startActivity(i);
            }
        });

        btnTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TentangActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                getActivity().startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });



        return rootView;
    }
}
