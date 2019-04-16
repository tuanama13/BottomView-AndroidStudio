package com.example.ama.myapplication.Tips;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("id_tips")
    @Expose
    private String idTips;
    @SerializedName("img_tips")
    @Expose
    private String imgTips;
    @SerializedName("tgl_post_tips")
    @Expose
    private String tglPostTips;
    @SerializedName("judul_tips")
    @Expose
    private String judulTips;
    @SerializedName("isi_tips")
    @Expose
    private String isiTips;

    public String getIdTips() {
        return idTips;
    }

    public void setIdTips(String idTips) {
        this.idTips = idTips;
    }

    public String getImgTips() {
        return imgTips;
    }

    public void setImgTips(String imgTips) {
        this.imgTips = imgTips;
    }

    public String getTglPostTips() {
        return tglPostTips;
    }

    public void setTglPostTips(String tglPostTips) {
        this.tglPostTips = tglPostTips;
    }

    public String getJudulTips() {
        return judulTips;
    }

    public void setJudulTips(String judulTips) {
        this.judulTips = judulTips;
    }

    public String getIsiTips() {
        return isiTips;
    }

    public void setIsiTips(String isiTips) {
        this.isiTips = isiTips;
    }
}
