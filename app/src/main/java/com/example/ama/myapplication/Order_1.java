package com.example.ama.myapplication;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.ganfra.materialspinner.MaterialSpinner;

public class Order_1 extends Activity {
    @BindView(R.id.input_tgl) TextView _intput_tgl;
    @BindView(R.id.input_jam) Spinner _intput_jam;
    @BindView(R.id.input_loc) TextView _intput_loc;
    @BindView(R.id.simpan_button) Button _btntgl;
    @BindView(R.id.order_back) ImageView _back;

    Calendar c;
    DatePickerDialog date_pic;

    String jam="";
    String tgl="";

    String[] SPINNERLIST = {
            "07:00","08:00","09:00","10:00","11:00","12:00","13:00",
            "14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","07:00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_1);
        ButterKnife.bind(this);

        _intput_jam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                jam = _intput_jam.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });









        _intput_tgl.setFocusable(false);
        _intput_loc.setFocusable(false);

        Date date = new Date();
//        SimpleDateFormat df_hari = new SimpleDateFormat("EEEE");
        String format_hari = "EE";
        SimpleDateFormat sdf = new SimpleDateFormat(format_hari);

//        Format Untuk Intent
        String format_input = "yyyy-MM-dd";
        SimpleDateFormat simpleDF_input = new SimpleDateFormat(format_input);
        tgl = simpleDF_input.format(date);

//        String hari_ = harinya(sdf.format(c.getTime()));
        SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");

        _intput_tgl.setText(harinya(sdf.format(date))+", "+df.format(date));

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

                        String format_input = "yyyy-MM-dd";
                        SimpleDateFormat simpleDF_input = new SimpleDateFormat(format_input);

                        String format = "dd MMM yyy";
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

                        String format_hari = "EE";
                        SimpleDateFormat sdf = new SimpleDateFormat(format_hari);

                        String hari_ = harinya(sdf.format(c.getTime()));

                        Log.d("Tes-TGL", simpleDF_input.format(c.getTime()));
                        tgl = simpleDF_input.format(c.getTime());

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

        _btntgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Order_1.this,BookingListActivity.class);
                i.putExtra("tgl", tgl);
                i.putExtra("jam", jam);
                startActivity(i);
                Log.d("TES", _intput_jam.getSelectedItem().toString());
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
