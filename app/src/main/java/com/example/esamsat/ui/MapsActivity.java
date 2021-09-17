package com.example.esamsat.ui;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.esamsat.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final String TAG = MapsActivity.class.getSimpleName();
    public static final int REQUEST_LOCATION_PERMISSION = 1;
    public static final float INITIAL_ZOOM = 12f;
    private ArrayList<LatLng> latlngs = new ArrayList<>();
    private MarkerOptions marker = new MarkerOptions();
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        BottomNavigationView bottomNavigationView  = findViewById(R.id.nav_view);

        bottomNavigationView.setSelectedItemId(R.id.lokasi);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem){
                switch (menuitem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.info:
                        startActivity(new Intent(getApplicationContext()
                                , InfoActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.lokasi:

                        return true;

                }


                return false;
            }
        });
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        enableMapStyles(mMap);
        enableDynamicMarker();

        // Add a marker in Sydney and move the camera
        LatLng Bkeuda = new LatLng(-0.9187268952887465, 100.36038047211105);//kantor Bapenda
        mMap.addMarker(new MarkerOptions().position(Bkeuda).title("Kantor Badan Pendapatan Daerah Provinsi Sumatera Barat"));
        LatLng sPadang = new LatLng(-0.9283258207670059, 100.35525858773914);//Uptd padang
        mMap.addMarker(new MarkerOptions().position(sPadang).title("UPTD SAMSAT PADANG"));
        LatLng BKT = new LatLng( -0.2629934617831177, 100.35635848711412);//Uptd bukitinggi
        mMap.addMarker(new MarkerOptions().position(BKT).title("UPTD SAMSAT BUKITINGGI"));
        LatLng BTS = new LatLng( -0.47540341785783813, 100.62474411534293);//Uptd batusangkar
        mMap.addMarker(new MarkerOptions().position(BTS).title("UPTD SAMSAT BATUSANGKAR"));
        LatLng PP =  new LatLng(-0.9168428162495131, 101.53742011031264);//uptd Pp
        mMap.addMarker(new MarkerOptions().position(PP).title("UPTD SAMSAT PULAU PUNJUNG"));
        LatLng sarilamak =  new LatLng(-0.14639779214302642, 100.67246839731236);//sarilamak
        mMap.addMarker(new MarkerOptions().position(sarilamak).title("UPTD SAMSAT SARILAMAK"));
        LatLng arosuka =  new LatLng(-0.9508342864504051, 100.60860556465741);//uptd arosuka
        mMap.addMarker(new MarkerOptions().position(arosuka).title("UPTD SAMSAT AROSUKA"));
        LatLng pariaman =  new LatLng(-0.6263515890828582, 100.16263680346734);//uptd pariaman
        mMap.addMarker(new MarkerOptions().position(pariaman).title("UPTD SAMSAT PARIAMAN"));
        LatLng ktpariaman =  new LatLng(-0.6132678578346342, 100.11583437450265);//uptd pariaman
        mMap.addMarker(new MarkerOptions().position(ktpariaman).title("UPTD SAMSAT KOTA PARIAMAN"));
        LatLng solok = new LatLng(-0.756125971544064, 100.65887797026075);
        mMap.addMarker(new MarkerOptions().position(solok).title("UPTD SAMSAT SOLOK"));
        LatLng lubas = new LatLng(-0.31246305492284837, 100.02291115306751);
        mMap.addMarker(new MarkerOptions().position(lubas).title("UPTD SAMSAT LUBUK BASUNG"));
        LatLng lusika = new LatLng(0.138499147185089, 100.16599125491763);
        mMap.addMarker(new MarkerOptions().position(lusika).title("UPTD SAMSAT LUBUK SIKAPING"));
        LatLng pdgpjg = new LatLng(-0.45458677271068504, 100.4003378377245);
        mMap.addMarker(new MarkerOptions().position(pdgpjg).title("UPTD SAMSAT PADANG PANJANG"));
        LatLng painan = new LatLng(-1.3057465787034315, 100.54902008300934);
        mMap.addMarker(new MarkerOptions().position(painan).title("UPTD SAMSAT PAINAN"));
        LatLng simp4 = new LatLng(0.10825586642069097, 99.83065776608227);
        mMap.addMarker(new MarkerOptions().position(simp4).title("UPTD SAMSAT SIMPANG EMPAT"));
        LatLng pyk = new LatLng(-0.2209987547659318, 100.65910802608185);
        mMap.addMarker(new MarkerOptions().position(pyk).title("UPTD SAMSAT PAYAKUMBUH"));
        LatLng silunto = new LatLng(-0.6573001244079514, 100.75472402793211);
        mMap.addMarker(new MarkerOptions().position(silunto).title("UPTD SAMSAT SAWAHLUNTO"));
        LatLng sjj = new LatLng(-0.6576691179656575, 100.93286992793224);
        mMap.addMarker(new MarkerOptions().position(sjj).title("UPTD SAMSAT SIJUNJUNG"));
        LatLng aro = new LatLng(-0.9583843594189387, 100.60902915519368);
        mMap.addMarker(new MarkerOptions().position(aro).title("UPTD SAMSAT PADANG ARO"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Bkeuda, INITIAL_ZOOM));



        for (LatLng point : latlngs){
            marker.title("Point of View");
            marker.snippet("UPTD SAMSAT Se SUMBAR ");
            marker.position(point);
            googleMap.addMarker(marker);
        }
        enableMyLocation();
        enableLongClick(mMap);
        enableDropPin(mMap);
        enableMapStyles(mMap);
        enableDynamicMarker();
        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.map_style));

            if (!success) {
                Log.e(TAG, "Style parsing gagal.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Tidak dapat menemukan style. Error: ", e);
        }


    }



    private void enableMapStyles(GoogleMap googleMap) {
        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.map_style));
            if (!success) {
                Log.e(TAG, "Style parsing gagal.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Tidak dapat menemukan style. Error: ", e);
        }
    }


    private void enableMyLocation() {
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED){
            mMap.setMyLocationEnabled(true);
        }else{
            ActivityCompat.requestPermissions(this,new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        }
    }
    private void enableDynamicMarker() {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("JSONResult" , response.toString());
                        JSONObject jObj = null;
                        try{
                            jObj =new JSONObject(response);
                            JSONArray result = jObj.getJSONArray("LOCATION");
                            for(int i=0;i<result.length();i++){
                                JSONObject jsonObject1=result.getJSONObject(i);
                                String lat_i = jsonObject1.getString("1");
                                String long_i = jsonObject1.getString("2");
                                String locationName = jsonObject1.getString("3");
                                mMap.addMarker(new MarkerOptions()
                                        .position(new LatLng(Double.parseDouble(lat_i) , Double.parseDouble(long_i)))
                                        .title(Double.valueOf(lat_i).toString() + "," + Double.valueOf(long_i).toString())
                                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                                        .snippet(locationName));
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-0.9187268952887465, 100.36038047211105), 11.0f));
                            }
                        }catch (NullPointerException e){
                            e.printStackTrace();
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        } }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(MapsActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }});
        int socketTimeout = 10000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }

    private void enableLongClick(final GoogleMap mMap) {
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                String snippet = String.format(Locale.getDefault(),
                        getString(R.string.lat_long_snippet),
                        latLng.latitude,
                        latLng.longitude);
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title(getString(R.string.dropped_pin))
                        .snippet(snippet)
                        .icon(BitmapDescriptorFactory.defaultMarker
                                (BitmapDescriptorFactory.HUE_BLUE)));
            }
        });
    }
    private void enableDropPin(final GoogleMap mMap) {
        mMap.setOnPoiClickListener(new GoogleMap.OnPoiClickListener() {
                                       @Override
                                       public void onPoiClick(PointOfInterest poi) {
                                           Marker poiMarker = mMap.addMarker(new MarkerOptions()
                                                   .position(poi.latLng)
                                                   .title(poi.name));
                                           poiMarker.showInfoWindow();
                                       }
                                   }
        );
    }





}
