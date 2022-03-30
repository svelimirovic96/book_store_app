package com.example.perce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IzmenaPodatakaActivity extends AppCompatActivity {
    public Korisnik korisnik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=getIntent();
        korisnik= (Korisnik) intent.getSerializableExtra("korisnik");
        setContentView(R.layout.activity_izmena_podataka);
        ImageView logo = (ImageView) findViewById(R.id.logo);
        TextView tvPerce=(TextView) findViewById(R.id.textFront);
        LinearLayout ll=(LinearLayout) findViewById(R.id.logoPart);
        ll.bringToFront();
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(IzmenaPodatakaActivity.this, KupacPocetnaActivity.class);
                intent.putExtra("korisnik", korisnik);
                startActivity(intent);
            }
        });
        tvPerce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(IzmenaPodatakaActivity.this, KupacPocetnaActivity.class);
                intent.putExtra("korisnik", korisnik);
                startActivity(intent);
            }
        });
        EditText ime=findViewById(R.id.imeK);
        EditText prezime=findViewById(R.id.prezimeK);
        EditText kontakt=findViewById(R.id.kontaktK);
        EditText adresa=findViewById(R.id.adresaK);
        EditText kor_ime=findViewById(R.id.korimeK);
        EditText lozinka=findViewById(R.id.lozinkaK);
        ime.setText(korisnik.getIme());
        prezime.setText(korisnik.getPrezime());
        kontakt.setText(korisnik.getTelefon());
        adresa.setText(korisnik.getAdresa());
        kor_ime.setText(korisnik.getKor_ime());
        lozinka.setText(korisnik.getLozinka());

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

    public void izmena(View view) {
        EditText ime=findViewById(R.id.imeK);
        EditText prezime=findViewById(R.id.prezimeK);
        EditText kontakt=findViewById(R.id.kontaktK);
        EditText adresa=findViewById(R.id.adresaK);
        EditText kor_ime=findViewById(R.id.korimeK);
        EditText lozinka=findViewById(R.id.lozinkaK);
        String imeS=korisnik.getIme();
        String prezimeS=korisnik.getPrezime();
        String kontaktS=korisnik.getTelefon();
        String adresaS=korisnik.getAdresa();
        String kor_imeS=korisnik.getKor_ime();
        String lozinkaS=korisnik.getLozinka();
        if (ime.getText().toString().isEmpty() || prezime.getText().toString().isEmpty() || kontakt.getText().toString().isEmpty()
        || adresa.getText().toString().isEmpty() || kor_ime.getText().toString().isEmpty() || lozinka.getText().toString().isEmpty()){
            Toast.makeText(this, "Polja za izmenu Vaših podataka moraju biti popunjena!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (ime.getText().toString().equals(imeS) && prezime.getText().toString().equals(prezimeS) && kontakt.getText().toString().equals(kontaktS)
                && adresa.getText().toString().equals(adresaS) && kor_ime.getText().toString().equals(kor_imeS) && lozinka.getText().toString().equals(lozinkaS)){
            Toast.makeText(this, "Niste promenili Vaše podatke!", Toast.LENGTH_SHORT).show();
            return;
        }

        Pattern pp=Pattern.compile("[A-ZŠĐŽČĆ][a-zšđžčć]+");
        Matcher m=pp.matcher(ime.getText().toString());
        boolean b=m.matches();
        if (!b) {
            Toast.makeText(this, "Neispravan format za polje ime!", Toast.LENGTH_SHORT).show();
            return;
        }
        m=pp.matcher(prezime.getText().toString());
        b=m.matches();
        if (!b) {
            Toast.makeText(this, "Neispravan format za polje prezime!", Toast.LENGTH_SHORT).show();
            return;
        }

        pp=Pattern.compile("(0|(\\+381))6[0-9]\\p{IsWhite_Space}[0-9]{3}\\p{IsWhite_Space}[0-9]{3,4}");
        m=pp.matcher(kontakt.getText().toString());
        b=m.matches();
        if (!b) {
            Toast.makeText(this, "Neispravan format za polje telefon!", Toast.LENGTH_SHORT).show();
            return;
        }
        pp=Pattern.compile("([A-ZŠĐŽČĆ][a-zšđžčć]+\\p{IsWhite_Space})+[0-9]{1,3}[a-zšđžčć]*");
        m=pp.matcher(adresa.getText().toString());
        b=m.matches();
        if (!b) {
            Toast.makeText(this, "Neispravan format za polje adresa!", Toast.LENGTH_SHORT).show();
            return;
        }
        pp=Pattern.compile("[a-z]([a-z0-9]){3,}");
        m=pp.matcher(kor_ime.getText().toString());
        b=m.matches();
        if (!b) {
            Toast.makeText(this, "Neispravan format za polje korisničko ime!", Toast.LENGTH_SHORT).show();
            return;
        }
        m=pp.matcher(lozinka.getText().toString());
        b=m.matches();
        if (!b) {
            Toast.makeText(this, "Neispravan format za polje lozinka!", Toast.LENGTH_SHORT).show();
            return;
        }

        int i;
        for (i=0; i<MainActivity.korisnici.size(); i++){
            if (MainActivity.korisnici.get(i).getKor_ime().equals(kor_imeS)) break;
        }
        MainActivity.korisnici.get(i).setIme(ime.getText().toString());
        MainActivity.korisnici.get(i).setPrezime(prezime.getText().toString());
        MainActivity.korisnici.get(i).setTelefon(kontakt.getText().toString());
        MainActivity.korisnici.get(i).setAdresa(adresa.getText().toString());
        MainActivity.korisnici.get(i).setKor_ime(kor_ime.getText().toString());
        MainActivity.korisnici.get(i).setLozinka(lozinka.getText().toString());

        for (i=0; i<MainActivity.komOcene.size(); i++){
            if (MainActivity.komOcene.get(i).getOcenio().equals(kor_imeS)) {
                MainActivity.komOcene.get(i).setOcenio(kor_ime.getText().toString());
            }
        }


        for (i=0; i<MainActivity.preporuke.size(); i++){        //podesiti u vue
            if (MainActivity.preporuke.get(i).getPrimalac().equals(kor_imeS)) {
                MainActivity.preporuke.get(i).setPrimalac(kor_ime.getText().toString());
            }
            if (MainActivity.preporuke.get(i).getPosiljalac().equals(kor_imeS)) {
                MainActivity.preporuke.get(i).setPosiljalac(kor_ime.getText().toString());
            }
            }


        korisnik.setIme(ime.getText().toString());
        korisnik.setPrezime(prezime.getText().toString());
        korisnik.setTelefon(kontakt.getText().toString());
        korisnik.setAdresa(adresa.getText().toString());
        korisnik.setKor_ime(kor_ime.getText().toString());
        korisnik.setLozinka(lozinka.getText().toString());
        Toast.makeText(this, "Uspešno izmenjeni Vaši podaci!", Toast.LENGTH_SHORT).show();

    }
}