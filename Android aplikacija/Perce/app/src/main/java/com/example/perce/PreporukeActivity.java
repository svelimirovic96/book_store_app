package com.example.perce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PreporukeActivity extends AppCompatActivity {

    public Korisnik korisnik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preporuke);
        Intent intent=getIntent();
        korisnik= (Korisnik) intent.getSerializableExtra("korisnik");
        ImageView logo = (ImageView) findViewById(R.id.logo);
        TextView tvPerce=(TextView) findViewById(R.id.textFront);
        LinearLayout ll=(LinearLayout) findViewById(R.id.logoPart);
        ll.bringToFront();
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PreporukeActivity.this, KupacPocetnaActivity.class);
                intent.putExtra("korisnik", korisnik);
                startActivity(intent);
            }
        });
        tvPerce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PreporukeActivity.this, KupacPocetnaActivity.class);
                intent.putExtra("korisnik", korisnik);
                startActivity(intent);
            }
        });
       ArrayList<Preporuka> listaKnjiga=new ArrayList<>();
        for (int i=0; i<MainActivity.preporuke.size();i++){
            if (MainActivity.preporuke.get(i).getPrimalac().equals(korisnik.getKor_ime())) listaKnjiga.add(MainActivity.preporuke.get(i));
        }
        PreporukeListAdapter adapter=new PreporukeListAdapter( PreporukeActivity.this, listaKnjiga);

        ListView listView=(ListView) findViewById(R.id.listView3);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Preporuka p=listaKnjiga.get(i);
                Knjiga knjiga=null;
                for (int j=0; j<MainActivity.knjige.size(); j++)
                    if (MainActivity.knjige.get(j).getId()==p.getKnjiga_id()) knjiga=MainActivity.knjige.get(j);
                Intent intent=new Intent(PreporukeActivity.this, DetaljiActivity.class);
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