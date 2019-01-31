package com.example.ama.myapplication;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Order_1 extends Activity {
    @BindView(R.id.input_tgl) TextView _intput_tgl;
    @BindView(R.id.simpan_button) Button _btntgl;
    @BindView(R.id.order_back) ImageView _back;

    Calendar c;
    DatePickerDialog date_pic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_1);

        ButterKnife.bind(this);
        _intput_tgl.setFocusable(false);

        SimpleDateFormat df_hari = new SimpleDateFormat("EEEE");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        _intput_tgl.setText(df_hari.format(date.getTime()) +", "+df.format(date));

//        _btntgl = (Button)findViewById(R.id.simpan_button);
//        _intput_tgl = (TextView)findViewById(R.id.input_tgl);

        _intput_tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                c = Calendar.getInstance();
//                int hari = c.get(Calendar.DAY_OF_WEEK);
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);


                date_pic = new DatePickerDialog(Order_1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
                         String hari = simpleDateFormat.format(c.getTime());
//                         fungsi dayt = new fungsi();
//                         dayt.harinya(hari);
//                         String _hari = dayt.harinya(hari);
                        _intput_tgl.setText(hari+", " +mDay + "/" +(mMonth + 1) + "/"+ mYear);
//                        _intput_tgl.setText();
                    }
                }, day, month, year);
                date_pic.getDatePicker().setMinDate(System.currentTimeMillis());
                date_pic.show();
            }
        });

        _back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
