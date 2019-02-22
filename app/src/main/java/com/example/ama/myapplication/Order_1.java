package com.example.ama.myapplication;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Order_1 extends Activity {
    @BindView(R.id.input_tgl) TextView _intput_tgl;
    @BindView(R.id.input_loc) TextView _intput_loc;
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
        _intput_loc.setFocusable(false);

//        SimpleDateFormat df_hari = new SimpleDateFormat("EEEE");
        String format_hari = "EE";
        SimpleDateFormat sdf = new SimpleDateFormat(format_hari);

//        String hari_ = harinya(sdf.format(c.getTime()));
        SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
        Date date = new Date();
        _intput_tgl.setText(harinya(sdf.format(date))+", "+df.format(date));

//        _btntgl = (Button)findViewById(R.id.simpan_button);
//        _intput_tgl = (TextView)findViewById(R.id.input_tgl);

        _intput_tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                _intput_tgl.setText("");
                c = Calendar.getInstance();
                c.getTime();
//                int hari = c.get(Calendar.DAY_OF_WEEK);
//                int day = c.get(Calendar.DAY_OF_MONTH);
//                int month = c.get(Calendar.MONTH);
//                int year = c.get(Calendar.YEAR);
//                int hari = 0;


                date_pic = new DatePickerDialog(Order_1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        int hari = 0;
                        c.set(Calendar.YEAR, mYear);
                        c.set(Calendar.MONTH, mMonth);
                        c.set(Calendar.DAY_OF_MONTH, mDay);
//                        c.set(Calendar.DAY_OF_WEEK, hari);
//                        Date d = new Date();
//                        int day = 0;
                        String format = "dd MMM yyy";
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

                        String format_hari = "EE";
                        SimpleDateFormat sdf = new SimpleDateFormat(format_hari);

                        String hari_ = harinya(sdf.format(c.getTime()));
//                        Log.v("metode",hari_);
//                         hari = simpleDateFormat.format(c.get(Calendar.DAY_OF_WEEK));
//
//                        _intput_tgl.setText(simpleDateFormat.format(c.getTime()));

                        _intput_tgl.setText( new StringBuilder().append(hari_).append(", ").append(simpleDateFormat.format(c.getTime())));
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));

//                date_pic.updateDate(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
                date_pic.show();
                date_pic.getDatePicker().setMinDate(System.currentTimeMillis());


            }
        });

        _back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private String harinya(String hari){
            String _harinya = null;

            switch (hari){
                case "Sun":
                    _harinya = "Min";
                    break;
                case "Mon":
                    _harinya = "Sen";
                    break;
                case "Tue":
                    _harinya = "Sel";
                    break;
                case "Wed":
                    _harinya = "Rab";
                    break;
                case "Thu":
                    _harinya = "Kam";
                    break;
                case "Fri":
                    _harinya = "Jum";
                    break;
                case "Sat":
                    _harinya = "Sab";
                    break;
            }

           return _harinya ;
    }
}
