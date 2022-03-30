package com.example.perce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class KupacPocetnaActivity extends AppCompatActivity {

    public ArrayList<Knjiga> dostupneKnjige=new ArrayList<>();
    public ArrayList<Knjiga> knjigeNaPromociji=new ArrayList<>();
    public Korisnik korisnik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        korisnik= (Korisnik) intent.getSerializableExtra("korisnik");
        setContentView(R.layout.activity_kupac_pocetna);
        ImageView imageView=(ImageView)findViewById(R.id.background_image);
        imageView.setImageResource(R.drawable.books_banner);
        ImageView logo = (ImageView) findViewById(R.id.logo);
        TextView tvPerce=(TextView) findViewById(R.id.textFront);
        LinearLayout ll=(LinearLayout) findViewById(R.id.logoPart);
        ll.bringToFront();
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(KupacPocetnaActivity.this, KupacPocetnaActivity.class);
                intent.putExtra("korisnik", korisnik);
                startActivity(intent);
            }
        });
        tvPerce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(KupacPocetnaActivity.this, KupacPocetnaActivity.class);
                intent.putExtra("korisnik", korisnik);
                startActivity(intent);
            }
        });
        for (int i=0; i<MainActivity.knjige.size();i++){
            if (MainActivity.knjige.get(i).isPromocija()) knjigeNaPromociji.add(MainActivity.knjige.get(i));
            else dostupneKnjige.add(MainActivity.knjige.get(i));
        }
        KnjigeListAdapter adapter=new KnjigeListAdapter(KupacPocetnaActivity.this, dostupneKnjige);

        ListView listView=(ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Knjiga knjiga=dostupneKnjige.get(i);
                Intent intent=new Intent(KupacPocetnaActivity.this, DetaljiActivity.class);
                intent.putExtra("korisnik", korisnik);
                intent.putExtra("knjiga", knjiga);
                startActivity(intent);
            }
        });
        adapter=new KnjigeListAdapter(KupacPocetnaActivity.this, knjigeNaPromociji);
        ListView listView2=(ListView) findViewById(R.id.listView2);
        listView2.setAdapter(adapter);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Knjiga knjiga=knjigeNaPromociji.get(i);
                Intent intent=new Intent(KupacPocetnaActivity.this, DetaljiActivity.class);
                intent.putExtra("korisnik", korisnik);
                intent.putExtra("knjiga", knjiga);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.preporuke:
                Intent intent=new Intent(this, PreporukeActivity.class);
                intent.putExtra("korisnik", korisnik);
                startActivity(intent);
                return true;
            case R.id.promena:
                intent=new Intent(this, IzmenaPodatakaActivity.class);
                intent.putExtra("korisnik", korisnik);
                startActivity(intent);
                return true;
            case R.id.odjava:
                intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}