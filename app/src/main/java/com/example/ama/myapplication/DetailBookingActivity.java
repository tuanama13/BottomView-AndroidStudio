package com.example.ama.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ama.myapplication.Booking.Message;
import com.example.ama.myapplication.service.APIService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.midtrans.sdk.corekit.callback.TransactionFinishedCallback;
import com.midtrans.sdk.corekit.core.LocalDataHandler;
import com.midtrans.sdk.corekit.core.MidtransSDK;
import com.midtrans.sdk.corekit.core.PaymentMethod;
import com.midtrans.sdk.corekit.core.TransactionRequest;
import com.midtrans.sdk.corekit.core.themes.CustomColorTheme;
import com.midtrans.sdk.corekit.models.BillInfoModel;
import com.midtrans.sdk.corekit.models.ItemDetails;
import com.midtrans.sdk.corekit.models.UserAddress;
import com.midtrans.sdk.corekit.models.UserDetail;
import com.midtrans.sdk.corekit.models.snap.TransactionResult;
import com.midtrans.sdk.uikit.SdkUIFlowBuilder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.ama.myapplication.BuildConfig.BASE_URL;
import static com.example.ama.myapplication.BuildConfig.CLIENT_KEY;
import static com.example.ama.myapplication.BuildConfig.DEBUG;

public class DetailBookingActivity extends AppCompatActivity implements TransactionFinishedCallback {
    public static final String URL = "http://airless-shout.000webhostapp.com/";
    @BindView(R.id.harga_lap_detail)
    TextView txtharga;
    @BindView(R.id.nama_lap_detail)
    TextView txtNamaLapangan;
    @BindView(R.id.nama_mitra_detail)
    TextView txtNamaMitra;
    @BindView(R.id.jam_detail)
    TextView txtJamBookingDetail;
    @BindView(R.id.tgl_detail)
    TextView txtTglBookingDetail;
    @BindView(R.id.txtnama_detail)
    TextView txtNama_Detail;
    @BindView(R.id.txtemail_detail)
    TextView txtEmail_Detail;
    @BindView(R.id.txtkontak_detail)
    TextView txtKontakDetail;
    @BindView(R.id.btn_pembayaran)
    Button btnPembayaran;
//    @BindView(R.id.btn_pembayaran_indomaret)
//    Button btnPembayaranIndo;
//    public String order_id;

    String order_id;
    String status_booking;
    String id_lap;
    String id_mitra;
    String id_user = "1";
    String jumlah_jam = "1";
    String harga_lapangan;

    String tgl_booking;
    String jam_booking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_booking);
        ButterKnife.bind(this);
        Bundle bundle=getIntent().getExtras();

        order_id = "T-"+System.currentTimeMillis();

        //Property bank_transfer
        String exp_date;
        String url_download;

        //Property C_store
        String indomaret_kode;


        harga_lapangan = bundle.getString("harga");

        tgl_booking = bundle.getString("tgl_booking");
        jam_booking = bundle.getString("jam_booking");

        txtTglBookingDetail.setText(tgl_booking);
        id_lap = bundle.getString("id_lap");
        txtNamaLapangan.setText(bundle.getString("nama_lap"));
        txtharga.setText(bundle.getString("harga"));
        id_mitra = bundle.getString("id_mitra");
        txtNamaMitra.setText(bundle.getString("nama_mitra"));
        txtJamBookingDetail.setText(bundle.getString("jam_booking"));


        SdkUIFlowBuilder.init()
                .setClientKey(CLIENT_KEY) // client_key is mandatory
                .setContext(this) // context is mandatory
                .setTransactionFinishedCallback(new TransactionFinishedCallback() {
                    @Override
                    public void onTransactionFinished(TransactionResult result) {

                        if (result.isTransactionCanceled()){
                            Intent i = new Intent(DetailBookingActivity.this,Order_1.class);
                            startActivity(i);
                            finish();
                        }else {
                            Intent i = new Intent(DetailBookingActivity.this,ResultActivity.class);
                            Log.d("info", "onTransactionFinished: "+result.getResponse().getPaymentType());
                            status_booking = result.getResponse().getTransactionStatus();
                            createBookingnya();

//                        createTransaksinya();

                            i.putExtra("type",result.getResponse().getPaymentType());
                            i.putExtra("url", result.getResponse().getPdfUrl());
//                        i.putExtra("bank", result.getResponse().getBank());
                            startActivity(i);
                            finish();
                        }

                    }
                }) // set transaction finish callback (sdk callback)
                .setMerchantBaseUrl(BASE_URL) //set merchant url (required)
                .enableLog(true) // enable sdk log (optional)
                .setColorTheme(new CustomColorTheme("#FFE51255", "#B61548", "#FFE51255")) // set theme. it will replace theme on snap theme on MAP ( optional)
                .buildSDK();

//        Detail Pengguna
        UserDetail userDetail = LocalDataHandler.readObject("user_details", UserDetail.class);
        if (userDetail == null) {
            userDetail = new UserDetail();
            userDetail.setUserFullName(txtNama_Detail.getText().toString());
            userDetail.setEmail(txtEmail_Detail.getText().toString());
            userDetail.setPhoneNumber(txtKontakDetail.getText().toString());
            userDetail.setUserId("1");

            ArrayList<UserAddress> userAddresses = new ArrayList<>();
            UserAddress userAddress = new UserAddress();
            userAddress.setAddress("Jalan Nawawi Hasan No 83");
            userAddress.setCity("Pontianak");
            userAddress.setAddressType(com.midtrans.sdk.corekit.core.Constants.ADDRESS_TYPE_BOTH);
            userAddress.setZipcode("78113");
            userAddress.setCountry("IDN");
            userAddresses.add(userAddress);
            userDetail.setUserAddresses(userAddresses);
            LocalDataHandler.saveObject("user_details", userDetail);
        }

//        Request Transaksi
        TransactionRequest transactionRequest = new TransactionRequest(order_id, Integer.valueOf(txtharga.getText().toString()));

//        Detail Item nya
        ItemDetails itemDetails1 = new ItemDetails(id_lap, Integer.valueOf(txtharga.getText().toString()), 1, txtNamaLapangan.getText().toString());

//        Membuat Array Dari Item Detail
        ArrayList<ItemDetails> itemDetailsList = new ArrayList<>();
        itemDetailsList.add(itemDetails1);

//        Set Item Detail di Transaksi request
        transactionRequest.setItemDetails(itemDetailsList);

//        Khusus Mandiri Payment
        BillInfoModel billInfoModel = new BillInfoModel("Pembayaran Ofield", harga_lapangan);
        // Set the bill info on transaction details
        transactionRequest.setBillInfoModel(billInfoModel);

        MidtransSDK.getInstance().setTransactionRequest(transactionRequest);
        btnPembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MidtransSDK.getInstance().startPaymentUiFlow(DetailBookingActivity.this);

//                Log.d("token", "onCreate: "+);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });



//
//        btnPembayaranIndo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view ) {
//
//                MidtransSDK.getInstance().getTransaction().getToken();
//                MidtransSDK.getInstance().startPaymentUiFlow(getApplicationContext(), PaymentMethod.INDOMARET,MidtransSDK.getInstance().getTransaction().getToken());
//            }
//        });

//        String pdfUrl = transactionResponse.getPdfUrl()

    }

    private void createTransaksinya() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        APIService api = retrofit.create(APIService.class);
//        Call<com.example.ama.myapplication.Booking.Message> call = api.createBooking(
//                order_id,
//                id_mitra,
//                id_lap,
//                id_user,
//                harga_lapangan,
//                jumlah_jam,
//                tgl_booking,
//                jam_booking,
//                status_booking);
    }

    private void createBookingnya() {
//        Gson gson = new GsonBuilder() .setLenient() .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService api = retrofit.create(APIService.class);
        Call<com.example.ama.myapplication.Booking.Message> call = api.createBooking(
                order_id,
                id_mitra,
                id_lap,
                id_user,
                harga_lapangan,
                jumlah_jam,
                tgl_booking,
                jam_booking,
                status_booking);

        call.enqueue(new Callback<com.example.ama.myapplication.Booking.Message>(){
            @Override
            public void onResponse(Call<com.example.ama.myapplication.Booking.Message> call, Response<com.example.ama.myapplication.Booking.Message> response) {
//                android.widget.Toast.makeText(getApplicationContext(),"Error : "+response.body().getMessage() ,android.widget.Toast.LENGTH_LONG).show();
                Log.d("Info", "onResponse: "+response.body().getMessage());
            }

            @Override
            public void onFailure(Call<com.example.ama.myapplication.Booking.Message> call, Throwable t) {
//                android.widget.Toast.makeText(getApplicationContext(),"Error : "+t ,android.widget.Toast.LENGTH_LONG).show();
                Log.d("error", "onFailure: "+t.getMessage());
//                t.setStackTrace();
            }
        });
    }



    @Override
    public void onTransactionFinished(TransactionResult result) {
//        if (result.getResponse() != null) {
////            switch (result.getStatus()) {
////                case TransactionResult.STATUS_SUCCESS:
////                    Toast.makeText(this, "Transaction Finished. ID: " + result.getResponse().getTransactionId(), Toast.LENGTH_LONG).show();
////                    Log.d("TES", "onTransactionResult: " +result.getResponse());
////                    break;
////                case TransactionResult.STATUS_PENDING:
//////                    Toast.makeText(this, "Transaction Pending. ID: " + result.getResponse().getTransactionId(), Toast.LENGTH_LONG).show();
//////                    Log.d("TES", "onTransactionResult: " +result.getResponse());
////                    Log.d("Pending", "onTransactionFinished: "+result.getSource());
////                    break;
////                case TransactionResult.STATUS_FAILED:
////                    Toast.makeText(this, "Transaction Failed. ID: " + result.getResponse().getTransactionId() + ". Message: " + result.getResponse().getStatusMessage(), Toast.LENGTH_LONG).show();
////                    Log.d("TES", "onTransactionResult: " +result.getResponse());
////                    break;
////            }
//            result.getResponse().getValidationMessages();
//        } else if (result.isTransactionCanceled()) {
//            Toast.makeText(this, "Transaction Canceled", Toast.LENGTH_LONG).show();
//            Log.d("TES", "onTransactionFinished: " +result.getResponse().getTransactionStatus());
//        } else {
////            if (result.getStatus().equalsIgnoreCase(TransactionResult.STATUS_INVALID)) {
////                Toast.makeText(this, "Transaction Invalid", Toast.LENGTH_LONG).show();
////                Log.d("TES", "onTransactionFinished: " +result.getResponse().getTransactionStatus());
////            } else {
////                Toast.makeText(this, "Transaction Finished with failure.", Toast.LENGTH_LONG).show();
////                Log.d("TES", "onTransactionFinished: " +result.getResponse().getTransactionStatus());
////            }
//        }

    }
}
