package com.example.esamsat.info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import com.example.esamsat.R;

public class CekPajakActivity extends AppCompatActivity {
    final String URL_SIGNIN = "https://192.168.13.64/cekpajak.php";
    Button btnproses;
    Context context;
    EditText nopol;
    int cek;
    String idkendaraan;
    RequestQueue requestQueue;
    ArrayList<HashMap<String, String>> list_data;
    private StringRequest stringRequest;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_pajak);
        nopol = (EditText) findViewById(R.id.edtNopol);
        context = CekPajakActivity.this;
        addProsesAction();

    }

    private void addProsesAction() {
        btnproses = (Button) findViewById(R.id.btnproses);
        requestQueue = Volley.newRequestQueue(CekPajakActivity.this);

        list_data = new ArrayList<HashMap<String, String>>();

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no = nopol.getText().toString();



                for (int i = 0; i < list_data.size(); i++) {
                    String kendaraan = list_data.get(i).get("NoKendaraan");
                    if (no.equals(kendaraan)) {
                        cek = i;
                        break;
                    }
                }
                idkendaraan = list_data.get(cek).get("NoKendaraan");
                if (no.equals(idkendaraan)){
                    Intent intent = new Intent(CekPajakActivity.this, DataCekPajak.class);
                    intent.putExtra("NoKendaraan",list_data.get(cek).get("NoKendaraan"));
                    intent.putExtra("MerkKendaraan",list_data.get(cek).get("MerkKendaraan"));
                    intent.putExtra("TipeKendaraan",list_data.get(cek).get("TipeKendaraan"));
                    intent.putExtra("WarnaKendaraan",list_data.get(cek).get("WarnaKendaraan"));
                    intent.putExtra("MerkKendaraan",list_data.get(cek).get("MerkKendaraan"));
                    intent.putExtra("TglPajak",list_data.get(cek).get("TglPajak"));
                    intent.putExtra("Status",list_data.get(cek).get("Status"));
                    intent.putExtra("BiayaPKB",list_data.get(cek).get("BiayaPKB"));
                    intent.putExtra("SanksiPKB",list_data.get(cek).get("SanksiPKB"));
                    intent.putExtra("BiayaSwdkljj",list_data.get(cek).get("BiayaSwdkljj"));
                    intent.putExtra("SanksiSwdkljj",list_data.get(cek).get("SanksiSwdkljj"));
                    intent.putExtra("ADMTnkb",list_data.get(cek).get("ADMTnkb"));
                    intent.putExtra("ADMStnk",list_data.get(cek).get("ADMStnk"));

                    Toast.makeText(CekPajakActivity.this,"Proses Sukses",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                    ClearText();

                }else{
                    Toast.makeText(CekPajakActivity.this,"Proses Gagal\n Please Try Again!!",Toast.LENGTH_LONG).show();
                }

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