package com.example.perce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BlendMode;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Korisnik> korisnici;
    public static ArrayList<Knjiga> knjige ;
    public static ArrayList<KomentarOcena> komOcene;
    public static ArrayList<Preporuka> preporuke;
    public static int prvi_put=1;

    @Override
    protected void onStart() {
        super.onStart();
        if (prvi_put==1){
        napraviKorisnike();
        napraviKnjige();
        napraviKomentareOcene();
        napraviPreporuke();
        prvi_put=2;
            //Log.i("poruka", "on start method");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Log.i("poruka", "on create method");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.background_image);
        imageView.setImageResource(R.drawable.books_banner);
        ImageView logo = (ImageView) findViewById(R.id.logo);
        TextView tvPerce=(TextView) findViewById(R.id.textFront);
        LinearLayout ll=(LinearLayout) findViewById(R.id.logoPart);
        ll.bringToFront();
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        tvPerce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void napraviPreporuke() {
        preporuke = new ArrayList<>();
        preporuke.add(new Preporuka(1, "sandra", 1, "marko"));
        preporuke.add(new Preporuka(2, "sandra", 10, "nikola"));
        preporuke.add(new Preporuka(3, "sandra", 14, "milena"));
        preporuke.add(new Preporuka(4, "sandra", 12, "zoran"));
    }

    private void napraviKomentareOcene() {
        komOcene = new ArrayList<>();
        komOcene.add(new KomentarOcena(1, "zoran", 10, "Pročitao sam. Ništa posebno.", 2));
        komOcene.add(new KomentarOcena(2, "milena", 6, "Sve preporuke, odlično smišljena radnja od kralja horora!", 5));
        komOcene.add(new KomentarOcena(3, "nikola", 6, "Sjajna je priča, interesantna, sve preporuke, mada više mi se sviđa filmska adaptacija. Zadovoljan sam. ;)", 4));
        komOcene.add(new KomentarOcena(4, "zoran", 6, "Nisam baš puno čitao Kinga, jer su mi se njegove knjige učinile beskrajno dosadne Suprotno od uobičajenog, tv adaptacije su mnogo bolje, gledljive i zabavnije od književnog originala. Najviše su mi smetali ti beskrajno dugi i dosadni opisi svega i svačega, često i ne baš nešto naročito važno za radnju...", 2));
    }

    private void napraviKorisnike() {
        korisnici = new ArrayList<>();
        korisnici.add(new Korisnik("Sandra", "Velimirović", "064 197 2344", "Janka Veselinovića 56", "sandra", "sandra123"));
        korisnici.add(new Korisnik("Marko", "Kasić", "064 152 9752", "Sokolska 1", "marko", "marko123"));
        korisnici.add(new Korisnik("Srdjan", "Gadjić", "064 122 9352", "Palilulska 10", "srdjan", "srdjan123"));
        korisnici.add(new Korisnik("Zoran", "Radosavljević", "061 218 1238", "Ivanova 1a", "zoran", "zoran123"));
        korisnici.add(new Korisnik("Milena", "Ćirić", "069 102 2931", "Cara Dušana 15", "milena", "milena123"));
        korisnici.add(new Korisnik("Nikola", "Ristić", "069 121 2837", "Bulevar despota Stefana 23", "nikola", "nikola123"));
    }

    private void napraviKnjige() {
        knjige = new ArrayList<>();
        knjige.add(new Knjiga(1, 265, "Hari Poter i kamen mudrosti", "Dž. K. Rouling", "2014", "Ostavljen kao beba na pragu kuće u Šimširovoj ulici broj 4, Hari Poter odrasta u ostavi ispod stepeništa, kao meta stalnih maltretiranja tetke, teče i njihovog Dadlija. Ali kada sove počnu da opsedaju njihov dom, noseći na njega adresirana pisma, život mu se iz korena menja. Od poludžina Hagrida saznaje za svoje čarobnjačko nasleđe i magijski svet skriven iza kulisa svakidašnjice, poput perona devet i tri četvrtine, početne stanice čarobnog voza koji Harija vodi do Hogvortsa, škole za veštičarenje i čarobnjaštvo, srca sveta magije!", R.drawable.hp1cover, false));
        knjige.add(new Knjiga(2, 270, "Hari Poter i Dvorana tajni", "Dž. K. Rouling", "2014", "Darsijevi su bili toliko zli i odvratni da je Hari Poter jedino želio da se vrati u Hogvorts, školu za vještice i čarobnjake. Ali tek što je počeo sa pakovanjem, Hari dobija upozorenje od stvorenja po imenu Dobi koji ga opominje da, ako se vrati u školu, će nastati niz katastrofa. I napadi su se desili. Dok je Hari na drugoj godini u Hogvortsu, snažne oluje i horori se povećavaju, uključujući drskog novog profesora Gilderoja Lokharta, duha zvanog Jecajuća Mirta koji proganja u ženskim toaletima, i nepoželjnu pažnju Džini, mlađe sestre Rona Vizlija. Ali sve su to sitne muke, jer pravi problemi tek nastaju, i neko ili nešto počinje učenike Hogvortsa da gura ka stijeni. Da li je to Drako Melfroj, najotrovniji rival? Da li je to možda Hagrid čija je prošlost otkrivena? Ili je to neko u koga svi u Hogvortsu sumnjaju – sam Hari Poter?", R.drawable.hp2cover, false));
        knjige.add(new Knjiga(3, 879, "Hari Poter i red feniksa", "Dž. K. Rouling", "2014", "Nakon napada dementora na Harija i njegovog rođaka Dadlija, profesori i čarobnjaci prinuđeni su da ponovo aktiviraju pokret otpora pod nazivom Red Feniksa. Na Dambldorovo insistiranje, Hari pokušava da zatvori svoj um od kontrole Lorda Voldemora učeći Oklumenciju sa zlokobnim profesorom Snejpom, a pri tom pokušava i da svoje prijatelje obuči odbrambenim činima da bi bili spremni za predstojeće bitke. Hoće li novoosnovana Dambldorova armija biti u stanju da se odupre Voldemoru i spreči ga u njegovim mračnim namerama?", R.drawable.hp5cover, false));
        knjige.add(new Knjiga(4, 432, "Hari Poter i Polukrvni princ", "Dž. K. Rouling", "2016", "Sredina je ljeta, ali neobična, neočekivana magla pritiska prozore. Hari Poter nervozno iščekuje u svojoj sobi u kući Darsijevih posjetu profesora Dambldora lično. Poslednji put je upravnika Hogvortsa vidio tokom žestokog okršaja sa mračnim gospodarom Voldemorom i Hari ne može da vjeruje da će profesor Dambldor pojaviti upravo kod Darslijevih. Zašto profesor dolazi da ga posjeti? Šta je to što ne može da sačeka nekoliko sedmica dok se Hari ne vrati natrag u Hogvorts? Dok Dambldor priprema Harija za njegov sudbinski okršaj sa Voldemorom, otkriće mu i zapanjujuće detalje o prošlosti mračnog gospodara – ko su bili njegovi roditelji, šta se dogodilo pošto je napustio Hogvorts i mnogo toga drugog. ", R.drawable.hp6cover, false));
        knjige.add(new Knjiga(5, 635, "Domaćin", "Stefani Majer", "2009", "Novi roman autorke „Sumraka”! U ovoj mešavini naučnofantastičnog i ljubavnog romana, Stefani Majer otkriva šta se dešava s intimnim vezama kada dva bića nastanjuju isto telo. Zemlju je okupirala vanzemaljska rasa Duša, koja zaposeda ljudska tela i briše njihove ličnosti. Melani Strajder, jedna od malobrojnih slobodnih ljudi, biva uhvaećena i njeno telo nastani Duša po imenu Lutalica, živa legenda među pripadnicima svoje vrste zbog mnogih domaćina u kojima je boravila i mnoštva planeta na kojima je živela. Njen zadatak je da otkrije lokaciju poreostalih pripadnika pokreta otpora. Međutim, bitisanje u ljudskom telu i ljudskom umu nije ni nalik bilo čemu što je Lutalica do tada iskusila. Ubrzo otkriva da Melani nema nameru da se preda bez borbe - umesto da joj pruži željne informacije, ona Lutaličin um ispunjava sećanjima na voljenog muškarca, Džareda, koji je još uvek u bekstvu. Nemoćna da se odupre željama svog domaćina, Lutalica počinje da žudi za tim istim čovekom, koga po zadatku mora da pronađe. Kada okolnosti nateraju lutalicu i Melani da se i protiv svoje volje udruže, one će krenuti u opasnu i neizvesnu potragu za muškarcem koga obe vole.", R.drawable.domacin, false));
        knjige.add(new Knjiga(6, 392, "Isijavanje", "Stiven King", "2014", "„Isijavanje” predstavlja oličenje savremenog horor romana i pruža pronicljiv uvid u jednu rasturenu porodicu, mračne hodnike duše i ljudsku slabost. Talenat Stivena Kinga ni u jednoj knjizi nije bio blistaviji. Džek Torens, njegova žena Vendi i sin Deni useljavaju se u hotel „Vidikovac“ , gde je Džek dobio posao kućepazitelja za vreme zime. Mesecima odsečeni od civilizacije, Džek pokušava da se izbori sa alkoholizmom i napadima besa dok piše nov pozorišni komad. Međutim, sile tame koje borave u hotelu „Vidikovac“ – koji ima dugu istoriju nasilja – žele da se dočepaju Denija zbog njegovih snažnih prekognitivnih sposobnosti i služe se Džekovim slabostima kako bi ugrabile dečaka...", R.drawable.theshining, true));
        knjige.add(new Knjiga(7, 952, "Jadnici", "Viktor Hugo", "2013", "Epski roman o iskupljenju, požrtvovanosti, ljubavi i patnji... Jadnici pripovedaju priču o Žanu Valžanu, koji je proveo devetnaest jezivih godina u zatvoru jer je ukrao veknu hleba. Pošto je izbavljen zahvaljujući dobročinstvu, pruža mu se prilika da spozna sreću, ukoliko bude uspeo da pomogne kćerki mlade Fantine. Međutim, istrajni policijski inspektor Žaver ne dozvoljava Žanu da pobegne od prošlosti. Na listi bestselera otkako je objavljen, roman Jadnici vešto prepliće lične sudbine sa turbulentnom istorijskom epohom u jedinsvenu, raskošnu i maštovitu dramatičnu priču o životnim nedaćama. ", R.drawable.lesmiserables, true));
        knjige.add(new Knjiga(8, 792, "Ana Karenjina", "Lav Tolstoj", "2014", " Čini se da Ana Karenjina ima sve što se poželeti može – lepa je, bogata, omiljena u društvu, a njen sin je jednostavno obožava. Međutim, Ana ipak oseća da je život suviše prazan, sve dok ne sretne naočitog i šarmantnog oficira, grofa Vronskog. Njihova veza postaće pravi skandal u visokom društvu i izazvaće ogorčenost i zavist ljudi koji okružuju ovo dvoje ljubavnika. Strastvenoj ljubavi i Aninom putu ka samouništenju suprotstavljena je priča Konstantina Ljevina, mladog čoveka koji teži tome da pronađe spokoj i smisao života – briljantan autoportret samog autora ove izuzetne, bezvremene knjige. Ponovo proživite jedan od najvoljenijih književnih klasika, sada i u novom, luksuznom izdanju...", R.drawable.anna_karenina, false));
        knjige.add(new Knjiga(9, 432, "Autsajder", "Stiven King", "2019", "Sad ga vidiš, sad ga ne vidiš. Nakon ubistva dečaka u gradskom parku, pouzdani očevici jednodušno su ukazali na omiljenog trenera Lige petlića Terija Mejtlanda kao krivca. DNK dokazi i otisci prstiju samo su potvrdili da je ovaj ugledni porodični čovek počinio strašan zločin. Užasnut brutalnim ubistvom i potresen činjenicom da je Mejtland trenirao i njegovog sina, detektiv Ralf Anderson naređuje da hapšenje osumnjičenog bude javni spektakl. Ali Mejtland ima alibi i drugi svedoci potvrđuju da tog dana nije ni bio u gradu. Anderson i okružni tužilac pretresaju dokaze, a istraga se širi od Ohaja do Teksasa. Pojavljuju se užasavajući odgovori, koji dodatno komplikuju i ubrzavaju Kingovu ionako nepodnošljivo uzbudljivu priču.Teri Mejtland je po opštem mišljenju dobar momak, ali postoji činjenica neporeciva poput gravitacije: čovek ne može istovremeno da bude na dva mesta. Ili možda može?", R.drawable.autsajder, true));
        knjige.add(new Knjiga(10, 418, "Sumrak", "Stefani Majer", "2010", "U središtu priče je mlada Bela Svon, dobrovoljno a bezvoljno pristigla u kišoviti Forks, gde započinje da živi sa svojim ocem. Već prvog dana u novoj sredini i u novoj školi, za oko joj zapadaju Kalenovi, čudnovata i prilično izolovana porodica. Posebno joj je privlačan Edvard, najlepši i najgraciozniji među njima. Nevolja, međutim, nastaje kada i on opazi nju... Tajna Kalenovih je iskonska, no oni su prevazišli ograničenja svoga roda, jer svoju žeđ zadovoljavaju različitim životinjskim vrstama. Postoje, međutim, i oni drugi, koji poštuju tradicionalni način Ishrane...", R.drawable.twilight1, false));
        knjige.add(new Knjiga(11, 460, "Mlad mesec", "Stefani Majer", "2010", "Kako to inače u životu biva, jedno zlo ili dobro, kako ga ko doživljava, ne može sámo da prođe – neophodna je ravnoteža. Nakon neizmernog ljubavnog bola koji doživljava, Bela otkriva tu drugu, paralelnu stranu medalje ušuškanog Forksa. Prijateljstvo sa Džejkobom Blekom, drugarom iz detinjstva, koji pripada drevnom indijanskom plemenu Kvilita, otkriva joj još jednu brižljivo čuvanu tajnu. Ni Kviliti nisu tek jedno pleme ukrašeno živopisnim nošnjama i dramatičnim totemima. Naprotiv, njihova tajna je, poput one vampirske, prikrivena svetlošću noći u seni Mladog meseca.", R.drawable.twilight3, false));
        knjige.add(new Knjiga(12, 384, "Hemičar", "Stefani Majer", "2016", "Ona zna previse… Oni žele njenu smrt. Tako počinje bitka njenog života. Radila je za američku vladu, ali je vrlo malo ljudi znalo za to. Bila je jedna od najbolje čuvanih tajni agencije toliko tajnovite da čak nema ni ime. A kada su njeni poslodavci shvatili da bi mogla da bude problem, rešili su da je uklone, i to što pre. Zato je sada u bekstvu – retko se zadržava na jednom mestu i stalno menja identitet. Ubili su jedinu osobu kojoj je verovala. Ona je sledeća. A onda dobija priliku da prihvati još jedan posao za njih, kao jedini način da ostane u životu. Dok se priprema za najtežu misiju do sada, neočekivana strast samo će umanjiti njene šanse da preživi i dovesti u pitanje sva njena ubeđenja. Puna napetosti i uzbudljivih preokreta, ova priča sa nesvakidašnjom i moćnom heroinom još jednom dokazuje zašto su knjige Stefeni Majer već godinama među najprodavanijima na svetu.", R.drawable.hemicar, false));
        knjige.add(new Knjiga(13, 140, "Lav, veštica i orman", "C. S. Luis", "2005", "Narnija… Zemlja iza vrata ormana, tajno mesto okovano večnom zimom… Čarobna zemlja koja čeka da bude oslobođena. U profesorovoj tajanstvenoj kući Lusi je otkrila neobičan orman. U prvi mah joj njena braća i sestra ne veruju kada im priča o svom izletu u Narniju. Ali Edmund, Piter i Suzan ubrzo i sami prolaze kroz orman. U Narniji će pronaći zemlju zarobljenu zlom kletvom Bele Veštice. Kada upoznaju velikog lava Aslana, shvataju da su upravo oni odabrani da učestvuju u velikoj pustolovini i hrabro se priključuju borbi za oslobađanje Narnije od opake veštičje čini.", R.drawable.narnia, false));
        knjige.add(new Knjiga(14, 448, "Kum", "Mario Puzo", "2003", "Priča o don Vitu Korleoneu, glavi njujorške mafijaške porodice, inspirisala je tri možda najbolja filma svih vremena i postavila temelje sasvim novom literarnom žanru. Roman obiluje nezaboravnim likovima koji uprkos neuobičajenom načinu života koji vode unutar poznate kriminalne porodice doživljavaju sve uspone i padove koji su neizbežni za svakoga od nas. Moderni klasik koji ni danas nije izgubio ni trunku svoje svežine i aktuelnosti, i koji još jednom dokazuje da ni najbolji film ne može da nadmaši knjigu na kojoj je zasnovan.", R.drawable.kum, true));
        knjige.add(new Knjiga(15, 228, "Sumnjičavi umovi", "Gvenda Bond", "2020", "Prvi oficijelni Stranger Things roman, koji otkriva istinu o majci Jedanaestice. Ako žele da ovaj eksperiment pomeri granice ljudskog uma, trebaju im posebni kandidati. Poput devojčice koju je poveo sa sobom: ima samo pet godina i toliko neobjašnjive moći da je neophodan strog bezbednosni protokol. Indijana, Sjedinjene Američke Države, 1969. godina. Teri Ajvs je radoznala devojka nemirnog duha. Zavidi svojim vršnjacima koji u gradovima kao što su San Francisko ili Vašington protestima menjaju svet. Kada sazna da univerzitet traži dobrovoljce za psihijatrijski eksperiment, oseća da se iza toga krije nešto važno i odlučuje da se prijavi. Ne želeći da propusti priliku života, rešena je da najzad odigra svoju ulogu u istoriji. Ali ne zna da se iza ovog projekta krije opasna zavera, i neće joj biti dovoljna samo hrabrost da joj se suprotstavi. Biće joj potrebne natprirodne moći. I tako, dok svet tinja, u malom američkom gradu dobro i zlo sukobljavaju se u tajnom ratu u kojem je ljudski um bojno polje. ", R.drawable.sumnjicaviumovi, true));
        knjige.add(new Knjiga(16, 368, "Veštičina zima", "Katerin Arden", "2019", "Nakon što je spasla Moskvu od požara koji je sama izazvala oslobodivši Žar-pticu, Vasja beži od razularene rulje koja želi da je spali i napušta ledom okovanu kneževu prestonicu tražeći utočište u čudnovatoj zemlji Ponoći, u kojoj se godišnja doba smenjuju u tren oka, a volšebne opasnosti vrebaju sa svih strana: zli blatnici, pečurke koje govore, prepredeni bagjanici i krvoločni vodenjaci... Tražeći odmor i predah, Vasja će tamo pronaći ne samo neočekivane saveznike već i novu moć i snagu. A snaga će joj biti potrebna jer će srednjovekovnoj Rusiji u sukobu sa krvoločnim Tatarima biti neophodna i pomoć nevidljivih sila koje jedino Vasja može da pomiri s narodom koji ih je zaboravio i oterao odjecima crkvenih zvona. Mešajući stvarne junake iz ruske istorije sa maštovitim likovima iz sveta čarolija i čini, Ketrin Arden završava priču čuvenom bitkom na Kulikovom polju, na kojem su udružene ruske snage slavno porazile tatarsku Zlatnu hordu iznedrivši legendu o Dimitriju Donskom i njegovim hrabrim ratnicima, koji su odvažno ustali u odbranu zemlje protiv trostruko brojnijeg neprijatelja. DOK SE BOŽANSTVA NOVA I BOŽANSTVA STARA BORE ZA DUŠU SREDNJOVEKOVNE RUSIJE, SUDBINA SVIH NJIH LEŽI NA NEJAKIM PLEĆIMA DEVOJKE KOJA SE USUDILA DA POVERUJE U ČAROLIJE! ", R.drawable.vestica_zime, true));
        knjige.add(new Knjiga(17, 368, "Nezavisna žena", "Klajd Stivenson", "2019", "Stavljanje opisa u toku...", R.drawable.nezavisnazena, true));
        knjige.add(new Knjiga(18, 368, "Planina vukodlaka", "C. V. Voters", "2019", "Stavljanje opisa u toku...", R.drawable.planinavukodlaka, true));
        knjige.add(new Knjiga(19, 368, "Mračan svet", "Dž. F. Grato", "2019", "Stavljanje opisa u toku...", R.drawable.darkworld, true));
        knjige.add(new Knjiga(20, 412, "Gospodar prstenova 3", "Dž. R. R. Tolkin", "2018", "Gandalf, Aragorn, Gimli i Legolas imaju svoj zadatak u spasavanju Srednjeg sveta. Pokušavaju da nađu saveznike u tome, i da otmu od tmine one koje su dograbile duge mračne ruke Mordora, poput Teodena, kralja Rohana. Uspostavljen savez Gondora i Rohana očajnički se bori protiv Sauronovih sila zla, u pokušaju da pažnju Oka zadrži na bojnom polju i odvrati je od Froda, koji se sa Semom i Golumom, nadaju se, približava Mordoru. Teret Prstena za Froda postaje sve teži, a Sauron sprema vojsku za konačan obračun protiv svih koji se bore za njegovo uništenje. Hoće li Frodo uspeti da stigne do Planine Usuda i uništi Prsten? Kakvu će važnu ulogu, koju je Gandalf naslutio, u tome odigrati Golum? Kakav će biti ishod odsudnog Rata za Prsten, i za spas Srednjeg sveta? I u čemu je Frodo uspeo, a u čemu je na kraju ipak bio poražen? I šta očekuje svet nakon što ono najbolje i najsvetlije u njemu polako ode u Sive luke... i nastupi novo doba.", R.drawable.lordoftherings3, true));

    }

    public void prijavaKorisnika(View view) {
        EditText korisnicko_ime = findViewById(R.id.korisnicko_ime);
        EditText lozinka = findViewById(R.id.lozinka);
        if (korisnicko_ime.getText().toString().isEmpty()) {
            Toast.makeText(this, "Unesite korisničko ime!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (lozinka.getText().toString().isEmpty()) {
            Toast.makeText(this, "Unesite lozinku!", Toast.LENGTH_SHORT).show();
            return;
        }
        for (int i = 0; i < korisnici.size(); i++) {
            Korisnik k = korisnici.get(i);
            if (k.getKor_ime().equals(korisnicko_ime.getText().toString())) {
                if (k.getLozinka().equals(lozinka.getText().toString())) {
                    Intent intent = new Intent(this, KupacPocetnaActivity.class);
                    intent.putExtra("korisnik", k);
                    startActivity(intent);
                    return;
                }
            }
        }
        Toast.makeText(this, "Vaš nalog nije registrovan!", Toast.LENGTH_SHORT).show();
    }
}