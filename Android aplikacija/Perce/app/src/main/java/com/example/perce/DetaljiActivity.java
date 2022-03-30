package com.example.perce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DetaljiActivity extends AppCompatActivity {
    Korisnik korisnik;
    Knjiga knjiga;
    Korisnik izabrani[]={null};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalji);
        Intent intent=getIntent();
        korisnik= (Korisnik) intent.getSerializableExtra("korisnik");
        knjiga= (Knjiga) intent.getSerializableExtra("knjiga");
        ImageView logo = (ImageView) findViewById(R.id.logo);
        TextView tvPerce=(TextView) findViewById(R.id.textFront);
        LinearLayout ll=(LinearLayout) findViewById(R.id.logoPart);
        ll.bringToFront();
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DetaljiActivity.this, KupacPocetnaActivity.class);
                intent.putExtra("korisnik", korisnik);
                startActivity(intent);
            }
        });
        tvPerce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DetaljiActivity.this, KupacPocetnaActivity.class);
                intent.putExtra("korisnik", korisnik);
                startActivity(intent);
            }
        });
        TextView tNaziv=findViewById(R.id.text1);
        TextView tAutor=findViewById(R.id.autorKnjige);
        TextView tGodina=findViewById(R.id.godinaIzdanja);
        TextView tBrojStrana=findViewById(R.id.brojstrana);
        TextView tOpis=findViewById(R.id.opisKnjige);
        tNaziv.setText(knjiga.getNaziv());
        tAutor.setText("Autor: "+knjiga.getAutor());
        tGodina.setText("Godina izdanja: "+knjiga.getGodina_izdanja());
        tBrojStrana.setText("Broj strana: "+knjiga.getBroj_strana());
        tOpis.setText("Opis: "+knjiga.getOpis());
        tOpis.setMovementMethod(new ScrollingMovementMethod());
        ImageView ivSlika=findViewById(R.id.slika1);
        ivSlika.setImageResource(knjiga.getIdSlika());
        ivSlika.setMaxWidth(250);
        ivSlika.setMaxHeight(250);
        ArrayList<KomentarOcena> listaKomentara=new ArrayList<>();
        for (int i=0; i<MainActivity.komOcene.size();i++){
            if (MainActivity.komOcene.get(i).getOcenjena()==knjiga.getId()) listaKomentara.add(MainActivity.komOcene.get(i));
        }
        KomentariOceneListAdapter adapter=new KomentariOceneListAdapter( DetaljiActivity.this, listaKomentara);

        ListView listView=(ListView) findViewById(R.id.listViewOc);
        listView.setAdapter(adapter);
    }

    public void preporuciti(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        LayoutInflater inflater=this.getLayoutInflater();
        View dialogView=inflater.inflate(R.layout.dialog_preporuke, null);
        ArrayList<Korisnik> listaKor=new ArrayList<>();
        for (int i=0; i<MainActivity.korisnici.size();i++){
            if (!MainActivity.korisnici.get(i).getKor_ime().equals(korisnik.getKor_ime())) listaKor.add(MainActivity.korisnici.get(i));
        }
        izabrani[0]=listaKor.get(0);
        KorisniciListAdapter adapter=new KorisniciListAdapter(DetaljiActivity.this, listaKor);
        ListView listView=(ListView) dialogView.findViewById(R.id.listView4);
        listView.setAdapter(adapter);
        builder.setView(dialogView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.oznaciKorisnika(i);
                izabrani[0] =adapter.izabrani;
            }
        });
        builder.setPositiveButton("Preporučite", ((dialogInterface, i) -> {
            if (izabrani[0]!=null){
                boolean istiPreporuka=false;
                for (int j=0; j<MainActivity.preporuke.size(); j++){
                    if (MainActivity.preporuke.get(j).getKnjiga_id()==knjiga.getId() &&
                            MainActivity.preporuke.get(j).getPosiljalac().equals(korisnik.getKor_ime()) &&
                            MainActivity.preporuke.get(j).getPrimalac().equals(izabrani[0].getKor_ime())){
                        dialogInterface.dismiss();
                        AlertDialog.Builder builder1=new AlertDialog.Builder(this);
                        LayoutInflater inflater1=this.getLayoutInflater();
                        View dialogView1=inflater.inflate(R.layout.dialog_neuspesna_preporuka, null);
                        TextView tvBez=dialogView1.findViewById(R.id.bezuspesno);
                        tvBez.setText("Već ste preporučili knjigu '"+knjiga.getNaziv()+"' korisniku "+izabrani[0].getIme()+" "+izabrani[0].getPrezime()+".");
                        builder1.setView(dialogView1).setNegativeButton("Izađite", (dialogInterface1, i1) -> {});
                        builder1.create();
                        builder1.show();
                        return;
                    }

                }

                MainActivity.preporuke.add(new Preporuka(MainActivity.preporuke.size()+1, izabrani[0].getKor_ime(), knjiga.getId(), korisnik.getKor_ime()));

                dialogInterface.dismiss();
                AlertDialog.Builder builder1=new AlertDialog.Builder(this);
                LayoutInflater inflater1=this.getLayoutInflater();
                View dialogView1=inflater1.inflate(R.layout.dialog_uspesna_preporuka, null);
                builder1.setView(dialogView1).setNegativeButton("Izađite", (dialogInterface1, i1) -> {});
                builder1.create();
                builder1.show();
            }
            else {
                Toast.makeText(this, "Izaberite korisnika!", Toast.LENGTH_SHORT).show();

            }
        }));
        builder.setNegativeButton("Odustani", ((dialogInterface, i) -> {}));

        builder.create();
        builder.show();
    }


    public void posalji(View view) {
        EditText komentar=findViewById(R.id.komentar);
        RatingBar rb=findViewById(R.id.ocenjivanje);
        Float oc=rb.getRating();
        if (komentar.getText().toString().isEmpty()) {
            Toast.makeText(this, "Unesite komentar!", Toast.LENGTH_SHORT).show(); return;}

        if (oc==0) {
        Toast.makeText(this, "Ocena mora biti veća od 1!", Toast.LENGTH_SHORT).show(); return;}
        MainActivity.komOcene.add(new KomentarOcena(MainActivity.komOcene.size()+1, korisnik.getKor_ime(), knjiga.getId(), komentar.getText().toString(), oc.intValue()));

        AlertDialog.Builder builder1=new AlertDialog.Builder(this);
        LayoutInflater inflater1=this.getLayoutInflater();
        View dialogView1=inflater1.inflate(R.layout.dialog_kom_ocena, null);
        builder1.setView(dialogView1).setNegativeButton("Izađite", (dialogInterface1, i1) -> {});
        builder1.create();
        builder1.show();

        ArrayList<KomentarOcena> listaKomentara=new ArrayList<>();
        for (int i=0; i<MainActivity.komOcene.size();i++){
            if (MainActivity.komOcene.get(i).getOcenjena()==knjiga.getId()) listaKomentara.add(MainActivity.komOcene.get(i));
        }
        KomentariOceneListAdapter adapter=new KomentariOceneListAdapter( DetaljiActivity.this, listaKomentara);

        ListView listView=(ListView) findViewById(R.id.listViewOc);
        listView.setAdapter(adapter);
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