package com.example.ama.myapplication.Myoder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("id_booking")
    @Expose
    private String idBooking;
    @SerializedName("id_mitra")
    @Expose
    private String idMitra;
    @SerializedName("nama_mitra")
    @Expose
    private String namaMitra;
    @SerializedName("id_lapangan")
    @Expose
    private String idLapangan;
    @SerializedName("nama_lapangan")
    @Expose
    private String namaLapangan;
    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("harga_lapagan")
    @Expose
    private String hargaLapagan;
    @SerializedName("jumlah_jam")
    @Expose
    private String jumlahJam;
    @SerializedName("tgl_booking")
    @Expose
    private String tglBooking;
    @SerializedName("jam_booking")
    @Expose
    private String jamBooking;
    @SerializedName("status_booking")
    @Expose
    private String statusBooking;

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getIdMitra() {
        return idMitra;
    }

    public void setIdMitra(String idMitra) {
        this.idMitra = idMitra;
    }

    public String getNamaMitra() {
        return namaMitra;
    }

    public void setNamaMitra(String namaMitra) {
        this.namaMitra = namaMitra;
    }

    public String getIdLapangan() {
        return idLapangan;
    }

    public void setIdLapangan(String idLapangan) {
        this.idLapangan = idLapangan;
    }

    public String getNamaLapangan() {
        return namaLapangan;
    }

    public void setNamaLapangan(String namaLapangan) {
        this.namaLapangan = namaLapangan;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getHargaLapagan() {
        return hargaLapagan;
    }

    public void setHargaLapagan(String hargaLapagan) {
        this.hargaLapagan = hargaLapagan;
    }

    public String getJumlahJam() {
        return jumlahJam;
    }

    public void setJumlahJam(String jumlahJam) {
        this.jumlahJam = jumlahJam;
    }

    public String getTglBooking() {
        return tglBooking;
    }

    public void setTglBooking(String tglBooking) {
        this.tglBooking = tglBooking;
    }

    public String getJamBooking() {
        return jamBooking;
    }

    public void setJamBooking(String jamBooking) {
        this.jamBooking = jamBooking;
    }

    public String getStatusBooking() {
        return statusBooking;
    }

    public void setStatusBooking(String statusBooking) {
        this.statusBooking = statusBooking;
    }

}
