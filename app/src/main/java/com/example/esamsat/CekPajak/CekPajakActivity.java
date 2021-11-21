  package com.example.esamsat.CekPajak;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.esamsat.R;
import com.example.esamsat.api.Api;
import com.example.esamsat.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;

public class CekPajakActivity extends AppCompatActivity {
    final String URL_SIGNIN = "https://192.168.13.241/getDataPKB.php";
    Button btnproses;
    Context context;
    EditText nopol;
    int cek;
    ProgressDialog progressDialog;

    String idkendaraan;
    RequestQueue requestQueue;
    ArrayList<HashMap<String, String>> list_data;
    private StringRequest stringRequest;
    private Api api;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_pajak);
        nopol = (EditText) findViewById(R.id.edtNopol);
        context = CekPajakActivity.this;
        progressDialog = new ProgressDialog(CekPajakActivity.this);
        addProsesAction();

    }

    private void addProsesAction() {
        btnproses = (Button) findViewById(R.id.btnproses);


        list_data = new ArrayList<HashMap<String, String>>();

        btnproses.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                progressDialog.setMessage("Silakan tunggu, cek data ke server sedang berlangsung");
                progressDialog.show();


                String no = nopol.getText().toString();

                api = ApiService.endpoint();


                Call<GetPkbResponse> call = api.getDataPkb(no);
                call.enqueue(new Callback<GetPkbResponse>() {

                    @Override
                    public void onResponse(Call<GetPkbResponse> call, retrofit2.Response<GetPkbResponse> response) {
                        Log.d("Response::", response.body().result.toString());

                        Intent intent = new Intent(getApplicationContext(), DataCekPajak.class);
                        intent.putExtra("NoKendaraan",response.body().result.get(0).noKendaraan );
                        intent.putExtra("TahunKendaraan",response.body().result.get(0).tahunKendaraan);
                        intent.putExtra("MerkKendaraan",response.body().result.get(0).merkKendaraan);
                        intent.putExtra("WarnaKendaraan",response.body().result.get(0).warnaKendaraan );
                        intent.putExtra("TglPajak",response.body().result.get(0).tglPajak);
                        intent.putExtra("TglStnk",response.body().result.get(0).tglStnk );
                        intent.putExtra("Status",response.body().result.get(0).status );
                        intent.putExtra("BiayaPKB",response.body().result.get(0).biayaPKB );
                        intent.putExtra("SanksiPKB",response.body().result.get(0).sanksiPKB );
                        intent.putExtra("BiayaSwdkllj",response.body().result.get(0).biayaSwdkllj );
                        intent.putExtra("SanksiSwdkllj",response.body().result.get(0).sanksiSwdkllj );
                        intent.putExtra("ADMTnkb",response.body().result.get(0).aDMTnkb );
                        intent.putExtra("ADMStnk",response.body().result.get(0).aDMStnk);
                        intent.putExtra("Total",response.body().result.get(0).tOtal);
                        startActivity(intent);




                    }

                    @Override
                    public void onFailure(Call<GetPkbResponse> call, Throwable t) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                        builder1.setTitle("Error")
                                .setMessage("Data tidak ditemukan")
                                .setNegativeButton("tutup", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }
                });

            }
        });

    }

    private void ClearText() {
        nopol.setText("");

    }

    private void login() {
        stringRequest = new StringRequest(Request.Method.GET, URL_SIGNIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("tbl_kendaraan");
                    for (int a = 0; a < jsonArray.length(); a++) {
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("NoKendaraan", json.getString("NoKendaraan"));
                        map.put("MerkKendaraan", json.getString("MerkKendaraan"));
                        map.put("TipeKendaraan", json.getString("TipeKendaraan"));
                        map.put("WarnaKendaraan", json.getString("WarnaKendaraan"));
                        map.put("TglPajak", json.getString("TglPajak"));
                        map.put("TglStnk", json.getString("TglStnk"));
                        map.put("Status", json.getString("Status"));
                        map.put("BiayaPKB", json.getString("BiayaPKB"));
                        map.put("SanksiPKB", json.getString("SanksiPKB"));
                        map.put("BiayaSwdkllj", json.getString("BiayaSwdkllj"));
                        map.put("SanksiSwdkllj", json.getString("SanksiSwdkllj"));
                        map.put("ADMTnkb", json.getString("ADMTnkb"));
                        map.put("ADMStnk", json.getString("ADMStnk"));
                        map.put("Total", json.getString("Total"));
                        list_data.add(map);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CekPajakActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(stringRequest);
    }
}