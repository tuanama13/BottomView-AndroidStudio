package com.example.ama.myapplication;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
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

                _intput_tgl.setText("");
                c = Calendar.getInstance();
//                int hari = c.get(Calendar.DAY_OF_WEEK);
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);


                date_pic = new DatePickerDialog(Order_1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                      String hari = null;
//                         hari = c.get(Calendar.DAY_OF_WEEK);
                         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
                         hari = simpleDateFormat.format(c.get(Calendar.DAY_OF_WEEK));
//
                        _intput_tgl.setText(hari+", " +mDay + "/" +(mMonth + 1) + "/"+ mYear);

//                        _intput_tgl.setText();
                    }
                }, day, month, year);
//                date_pic.updateDate(day, month, year);
//                date_pic.getDatePicker().setMinDate(System.currentTimeMillis());

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

    public static String harinya(String hari){
            String _harinya = null;

            if (hari.equals("Sunday")){
//            _harinya = new String("Minggu");
                _harinya =  "Minggu";
//                System.out.println(_harinya);
            }
            if(hari.equals("Monday")){
                _harinya =  "Senin";
//                System.out.println(_harinya);
//            _harinya = new String("Senin");
            }
            if(hari.equals("Tuesday")){
//            _harinya = new String("Selasa");
                _harinya =  "Selasa";
//                System.out.println(_harinya);
            }
            if(hari.equals("Wednesday")){
//            _harinya = new String("Rabu");
                _harinya =  "Rabu";
//                System.out.println(_harinya);
            }
            if(hari.equals("Thursday")){
//            _harinya = new String("Kamis");
                _harinya =  "Kamis";
//                System.out.println(_harinya);
            }
            if(hari.equals("Friday")){
//            _harinya = new String("Jumat");
                _harinya =  "Jumat";
//                System.out.println(_harinya);
            }
            if(hari.equals("Saturday")) {
//            _harinya = new String("Sabtu");
                _harinya = "Sabtu";
//                System.out.println(_harinya);
            }

           return new String(_harinya);
    }
}
