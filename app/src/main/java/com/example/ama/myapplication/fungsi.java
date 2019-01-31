package com.example.ama.myapplication;

public class fungsi {
    private String _harinya = "";
    public String harinya (String hari){

        if (hari == "Sunday"){
//            _harinya = new String("Minggu");
            _harinya =  "Minggu";
        } else
        if(hari == "Monday"){
            _harinya =  "Senin";
//            _harinya = new String("Senin");
        }else
        if(hari == "Tuesday"){
//            _harinya = new String("Selasa");
            _harinya =  "Selasa";
        }else
        if(hari == "Wednesday"){
//            _harinya = new String("Rabu");
            _harinya =  "Rabu";
        }else
        if(hari == "Thursday"){
//            _harinya = new String("Kamis");
            _harinya =  "Kamis";
        }else
        if(hari == "Friday"){
//            _harinya = new String("Jumat");
            _harinya =  "Jumat";
        }else
        if(hari == "Saturday") {
//            _harinya = new String("Sabtu");
            _harinya = "Sabtu";
        }
//        System.out.print(_harinya);

        return this._harinya;
//        return hari;
    }

}
