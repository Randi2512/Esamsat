package com.example.esamsat.info.faq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import com.example.esamsat.R;

public class faq extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) ,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) ,
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("E-Samsat itu apa?");
        listDataHeader.add("Bagaimana cara mengurus pelepasan blokir pada STNK ?");
        listDataHeader.add("Apa saja Dokumen yang harus dilengkapi untuk melakukan BBN Sepeda Motor ?");
        listDataHeader.add("Bisakah membayar pajak motor tanpa KTP pemilik ?");
        listDataHeader.add("Berapa biaya mutasi motor antar kota, dalam 1 propinsi yaitu, dari kota padang ke kota Solok? Dan berapa biaya balik nama untuk motor");
        listDataHeader.add("Bagaimana cara memblokir STNK kendaraan yang telah di jual  ?");
        listDataHeader.add("Bagaimana cara cabut berkas dan syaratnya apa saja");
        listDataHeader.add("Bagaimana cara mutasi dari Jateng ke Padang (Mutasi Antar Provinsi) ?");
        listDataHeader.add("saya mau blokir pajak mobil saya yang sudah terjual. Bagaimana prosedurnya Bapak/ Ibu admin. Apakah cara blokirnya bisa secara online. Mohon penjelasannya Bapak/ Ibu admin. Terima Kasih");

        // Adding child data
        List<String> faq1 = new ArrayList<String>();
        faq1.add("E-Samsat Adalah layanan pengesahan STNK tahunan dan pembayaran Pajak Kendaraan Bermotor serta SWDKLLJ ( Jasa Raharja ) melalui e-Channel Bank yaitu : ATM, Teller, PPOB, Mobil Banking dan Internet Banking");

        List<String> faq2 = new ArrayList<String>();
        faq2.add("Kalau status terblokir, Silahkan datangi kantor samsat sesuai domisili , pergi ke bagian Penagihan dan jangan lupa bawa KTP asli atas nama di STNK untuk melakukan pelepasan blokirnya");


        List<String> faq3 = new ArrayList<String>();
        faq3.add("Berikut adalah syarat  mengenai cara balik nama sepeda motor, \n" +
                "1.STNK asli dan fotokopi \n" +
                "2.KTP pemilik baru asli dan fotokopi \n" +
                "3.BPKB asli dan fotokopi \n" +
                "4.Kwitansi pembelian dengan materai Rp 10.000 \n" +
                "5.Faktur asli dan fotokopi");

        List<String> faq4 = new ArrayList<String>();
        faq4.add("Dengan demikian, proses bayar pajak motor bisa tanpa KTP asli. Pembayaran hanya butuh data NIK dan alamat KTP saja.");

        List<String> faq5 = new ArrayList<String>();
        faq5.add("Langkah Balik nama antar kota kabupaten \n " +
                "1. Cabut file terlebih dahulu - jika kendaraan asalnya kota padang datangi ditlantas sumbar - jika kendaraan asalnya selain kota padang langsung saja ke samsat sesuai kota kabupaten tsb Untuk biaya cabut file kami tidak mengetahui karena ranahnya kepolisian \n" +
                "2. Setelah cabut file, datangi kantor samsat sesuai domisili di stnk lama untuk cetak fiskal keluar dan bayar pajak jika sudah masuk masa pembayarannya. \n" +
                "Untuk info besaran pajak bisa di cek di https://dpkd.sumbarprov.go.id/info-pkb.html atau download aplikasi android kami di https://play.google.com/store/apps/details?id=id.go.sumbarprov.bkeuda.esamsatsumbar \n" +
                "3. Setelah fiskal terbit, datangi kantor ditlantas untuk beli bpkb baru \n" +
                "4. Setelah bpkb baru terbit kunjungi kantor samsat sesuai domisili barunya untuk membeli stnk dan plat Biaya plat stnk Roda Dua 160.000 Roda Empat 300.000 \n" +
                "5. Setelah terbit stnk proses selesai Terima kasih");

        List<String> faq6 = new ArrayList<String>();
        faq6.add("Caranya dengan melapor ke skskskskskns  njsjdjdj ke skskskskskns  njsjdjdj  ke skskskskskns  njsjdjdj");

        List<String> faq7 = new ArrayList<String>();
        faq7.add("Caranya dengan melapor ke skskskskskns  njsjdjdj ke skskskskskns  njsjdjdj  ke skskskskskns  njsjdjdj");

        List<String> faq8 = new ArrayList<String>();
        faq8.add("langkah awalnya silahkan ibuk cabut berkas/file kendaraan tersebut di samsat asal dalam hal ini provinsi jawa tengah, \n " +
                "setelah selesai pengurusan pada prov jawa tengah kemudian baru ibu bisa mendaftarkan kendaraan tersebut pada samsat tujuan dalam hal ini (kota Padang)..untuk persyaratannya ibuk dapat menanyakan langsung pada kantor samsat..terimakasih");

        List<String> faq9 = new ArrayList<String>();
        faq9.add(" cara untuk melaporkan kendaraan yang sudah terjual, silahkan bapak mengunjungi kantor samsat, dimana kendaraan tersebut terdaftar, \n " +
                "kemudian bapak akan mengisi form yang telah disediakan pada kantor samsat..mohon maaf bapak saat ini kami belum menyediakan form online untuk pemblokiran tersebut..terimakasih");




        listDataChild.put(listDataHeader.get(0), faq1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), faq2);
        listDataChild.put(listDataHeader.get(2), faq3);
        listDataChild.put(listDataHeader.get(3), faq4);
        listDataChild.put(listDataHeader.get(4), faq5);
        listDataChild.put(listDataHeader.get(5), faq6);
        listDataChild.put(listDataHeader.get(6), faq7);
        listDataChild.put(listDataHeader.get(7), faq8);
        listDataChild.put(listDataHeader.get(8), faq9);






    }
}