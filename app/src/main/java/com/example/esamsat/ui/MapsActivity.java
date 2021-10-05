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
    public static final float INITIAL_ZOOM = 8f;
    private ArrayList<LatLng> latlngs = new ArrayList<>();
    private MarkerOptions marker = new MarkerOptions();
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        BottomNavigationView bottomNavigationView  = findViewById(R.id.nav_view);

      //  bottomNavigationView.setSelectedItemId(R.id.lokasi);

     //   bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
          //  @Override
      //      public boolean onNavigationItemSelected(@NonNull MenuItem menuitem){
          //      switch (menuitem.getItemId()){
             //       case R.id.home:
                 //       startActivity(new Intent(getApplicationContext()
                          //      , HomeActivity.class));
                   //     overridePendingTransition(0,0);
                 //       return true;
                    //      case R.id.info:
               //         startActivity(new Intent(getApplicationContext()
        //                      , InfoActivity.class));
        //              overridePendingTransition(0,0);
          //              return true;
            //        case R.id.lokasi:

              //          return true;

                //}


                //return false;
        //    }
      // });
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
        LatLng Sumbar = new LatLng(-0.739940,  100.800005);//Sumatera barat
        LatLng Bkeuda = new LatLng(-0.9186963444057559, 100.36032602188646);//kantor Bapenda
        mMap.addMarker(new MarkerOptions().position(Bkeuda).title("Kantor Badan Pendapatan Daerah Provinsi Sumatera Barat"));
        LatLng sPadang = new LatLng(-0.9281877383438614, 100.35522214047812);//Uptd padang
        mMap.addMarker(new MarkerOptions().position(sPadang).title("UPTD SAMSAT PADANG"));
        LatLng GeraiPdg = new LatLng(-0.9500411426452962, 100.35586989880683);
        mMap.addMarker(new MarkerOptions().position(GeraiPdg).title("Gerai SAMSAT Plaza Andalas"));
        LatLng BKT = new LatLng( -0.26425733920205746, 100.35652703319022);//Uptd bukitinggi
        mMap.addMarker(new MarkerOptions().position(BKT).title("UPTD SAMSAT BUKITINGGI"));
        LatLng GeraiBKT = new LatLng(-0.3051302842497203, 100.36860861044674);
        mMap.addMarker(new MarkerOptions().position(GeraiBKT).title("Gerai SAMSAT Bukittinggi"));
        LatLng BTS = new LatLng( -0.47476115516911566, 100.62472946431001);//Uptd batusangkar
        mMap.addMarker(new MarkerOptions().position(BTS).title("UPTD SAMSAT BATUSANGKAR"));
        LatLng PP =  new LatLng(-0.9768699081145312, 101.54169642125427);//uptd Pp
        mMap.addMarker(new MarkerOptions().position(PP).title("UPTD SAMSAT PULAU PUNJUNG"));
        LatLng sarilamak =  new LatLng(-0.14609738560942204, 100.6721250698873);//sarilamak
        mMap.addMarker(new MarkerOptions().position(sarilamak).title("UPTD SAMSAT SARILAMAK"));
        LatLng arosuka =  new LatLng(-0.9508342864504051, 100.60860556465741);//uptd arosuka
        mMap.addMarker(new MarkerOptions().position(arosuka).title("UPTD SAMSAT AROSUKA"));
        LatLng pariaman =  new LatLng(-0.6263703364357758, 100.1625216490702);//uptd pariaman
        mMap.addMarker(new MarkerOptions().position(pariaman).title("UPTD SAMSAT PARIAMAN"));
        LatLng ktpariaman =  new LatLng(-0.6137090559112602, 100.11618037916416);//uptd pariaman
        mMap.addMarker(new MarkerOptions().position(ktpariaman).title("UPTD SAMSAT KOTA PARIAMAN"));
        LatLng solok = new LatLng(-0.756125971544064, 100.65887797026075);
        mMap.addMarker(new MarkerOptions().position(solok).title("UPTD SAMSAT SOLOK"));
        LatLng lubas = new LatLng(-0.3124201462143175, 100.0229544191956);
        mMap.addMarker(new MarkerOptions().position(lubas).title("UPTD SAMSAT LUBUK BASUNG"));
        LatLng lusika = new LatLng(0.13853133360648184, 100.16599125462385);
        mMap.addMarker(new MarkerOptions().position(lusika).title("UPTD SAMSAT LUBUK SIKAPING"));
        LatLng pdgpjg = new LatLng(-0.45458677271068504, 100.4003378377245);
        mMap.addMarker(new MarkerOptions().position(pdgpjg).title("UPTD SAMSAT PADANG PANJANG"));
        LatLng painan = new LatLng(-1.3057465787034315, 100.54902008300934);
        mMap.addMarker(new MarkerOptions().position(painan).title("UPTD SAMSAT PAINAN"));
        LatLng simp4 = new LatLng(0.10724046961034482, 99.8279528720057);
        mMap.addMarker(new MarkerOptions().position(simp4).title("UPTD SAMSAT SIMPANG EMPAT"));
        LatLng pyk = new LatLng(-0.2209987547659318, 100.65910802608185);
        mMap.addMarker(new MarkerOptions().position(pyk).title("UPTD SAMSAT PAYAKUMBUH"));
        LatLng silunto = new LatLng(-0.6572679400132208, 100.75464892579109);
        mMap.addMarker(new MarkerOptions().position(silunto).title("UPTD SAMSAT SAWAHLUNTO"));
        LatLng sjj = new LatLng(-0.6587935598620186, 100.93278543805978);
        mMap.addMarker(new MarkerOptions().position(sjj).title("UPTD SAMSAT SIJUNJUNG"));
        LatLng aro = new LatLng(-0.9583843594189387, 100.60902915519368);
        mMap.addMarker(new MarkerOptions().position(aro).title("UPTD SAMSAT PADANG ARO"));
        LatLng samnagPessel = new LatLng(-1.8843733745873583, 100.87590694012212);
        mMap.addMarker(new MarkerOptions().position(samnagPessel).title("Kantor SAMSAT Nagari Linggo Sari Baganti"));
        LatLng samnagSialang = new LatLng(-1.0701901677867884, 101.67986249880731);
        mMap.addMarker(new MarkerOptions().position(samnagSialang).title("Samsat Nagari Sialang Gaung "));
        LatLng samnagpasirTalang = new LatLng(-1.4692766409198053, 101.03357799695907);
        mMap.addMarker(new MarkerOptions().position(samnagpasirTalang).title("Samsat Nagari Pasir Talang Barat "));
        LatLng samnagKotobaru = new LatLng(-1.070061444211708, 101.67979812579289);
        mMap.addMarker(new MarkerOptions().position(samnagKotobaru).title("Samsat Nagari Koto Baru"));
        LatLng samsatgeraichip = new LatLng(-0.8018896257938044, 100.31637613963905);
        mMap.addMarker(new MarkerOptions().position(samsatgeraichip).title("Gerai Samsat CHIP"));
        LatLng samnagPdGelugur = new LatLng(0.4406849696913971, 100.0485849257871);
        mMap.addMarker(new MarkerOptions().position(samnagPdGelugur).title("Samsat Nagari Bahagia Padang Gelugur"));
        LatLng DriveBkt = new LatLng(-0.2995554112356345, 100.36619706811817);
        mMap.addMarker(new MarkerOptions().position(DriveBkt).title("Drive Thru Bukittinggi"));
        LatLng limbanang = new LatLng(-0.03935039663998713, 100.50922063319462);
        mMap.addMarker(new MarkerOptions().position(limbanang).title("Samsat Nagari Limbanang"));
        LatLng Drivepyk = new LatLng(-0.24235235903808333, 100.61027203487693);
        mMap.addMarker(new MarkerOptions().position(Drivepyk).title("DRIVE THRU PAYAKUMBUH"));
        LatLng samnagAir = new LatLng(0.2816328494731909, 99.34491460727789);
        mMap.addMarker(new MarkerOptions().position(samnagAir).title("Samsat Nagari Air Bangis"));







        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pdgpjg, INITIAL_ZOOM));



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
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-0.914518, 100.459526), 9.0f));
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
