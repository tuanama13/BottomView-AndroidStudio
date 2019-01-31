package com.example.ama.myapplication;

class fungsi_hari {
    void fungsi_h(String hari) {
        String _harinya = "";
        if (hari == "Sunday"){
            _harinya =  "Minggu";
        } else if(hari == "Monday"){
            _harinya =  "Senin";
        }else if(hari == "Tuesday"){
            _harinya =  "Selasa";
        }else if(hari == "Wednesday"){
            _harinya =  "Rabu";
        }else if(hari == "Thursday"){
            _harinya =  "Kamis";
        }else if(hari == "Friday"){
            _harinya =  "Jumat";
        }else if(hari == "Saturday") {
            _harinya = "Sabtu";
        }
    }
}
