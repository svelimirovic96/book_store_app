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
        komOcene.add(new KomentarOcena(1, "zoran", 10, "Pro??itao sam. Ni??ta posebno.", 2));
        komOcene.add(new KomentarOcena(2, "milena", 6, "Sve preporuke, odli??no smi??ljena radnja od kralja horora!", 5));
        komOcene.add(new KomentarOcena(3, "nikola", 6, "Sjajna je pri??a, interesantna, sve preporuke, mada vi??e mi se svi??a filmska adaptacija. Zadovoljan sam. ;)", 4));
        komOcene.add(new KomentarOcena(4, "zoran", 6, "Nisam ba?? puno ??itao Kinga, jer su mi se njegove knjige u??inile beskrajno dosadne Suprotno od uobi??ajenog, tv adaptacije su mnogo bolje, gledljive i zabavnije od knji??evnog originala. Najvi??e su mi smetali ti beskrajno dugi i dosadni opisi svega i sva??ega, ??esto i ne ba?? ne??to naro??ito va??no za radnju...", 2));
    }

    private void napraviKorisnike() {
        korisnici = new ArrayList<>();
        korisnici.add(new Korisnik("Sandra", "Velimirovi??", "064 197 2344", "Janka Veselinovi??a 56", "sandra", "sandra123"));
        korisnici.add(new Korisnik("Marko", "Kasi??", "064 152 9752", "Sokolska 1", "marko", "marko123"));
        korisnici.add(new Korisnik("Srdjan", "Gadji??", "064 122 9352", "Palilulska 10", "srdjan", "srdjan123"));
        korisnici.add(new Korisnik("Zoran", "Radosavljevi??", "061 218 1238", "Ivanova 1a", "zoran", "zoran123"));
        korisnici.add(new Korisnik("Milena", "??iri??", "069 102 2931", "Cara Du??ana 15", "milena", "milena123"));
        korisnici.add(new Korisnik("Nikola", "Risti??", "069 121 2837", "Bulevar despota Stefana 23", "nikola", "nikola123"));
    }

    private void napraviKnjige() {
        knjige = new ArrayList<>();
        knjige.add(new Knjiga(1, 265, "Hari Poter i kamen mudrosti", "D??. K. Rouling", "2014", "Ostavljen kao beba na pragu ku??e u ??im??irovoj ulici broj 4, Hari Poter odrasta u ostavi ispod stepeni??ta, kao meta stalnih maltretiranja tetke, te??e i njihovog Dadlija. Ali kada sove po??nu da opsedaju njihov dom, nose??i na njega adresirana pisma, ??ivot mu se iz korena menja. Od polud??ina Hagrida saznaje za svoje ??arobnja??ko nasle??e i magijski svet skriven iza kulisa svakida??njice, poput perona devet i tri ??etvrtine, po??etne stanice ??arobnog voza koji Harija vodi do Hogvortsa, ??kole za ve??ti??arenje i ??arobnja??tvo, srca sveta magije!", R.drawable.hp1cover, false));
        knjige.add(new Knjiga(2, 270, "Hari Poter i Dvorana tajni", "D??. K. Rouling", "2014", "Darsijevi su bili toliko zli i odvratni da je Hari Poter jedino ??elio da se vrati u Hogvorts, ??kolu za vje??tice i ??arobnjake. Ali tek ??to je po??eo sa pakovanjem, Hari dobija upozorenje od stvorenja po imenu Dobi koji ga opominje da, ako se vrati u ??kolu, ??e nastati niz katastrofa. I napadi su se desili. Dok je Hari na drugoj godini u Hogvortsu, sna??ne oluje i horori se pove??avaju, uklju??uju??i drskog novog profesora Gilderoja Lokharta, duha zvanog Jecaju??a Mirta koji proganja u ??enskim toaletima, i nepo??eljnu pa??nju D??ini, mla??e sestre Rona Vizlija. Ali sve su to sitne muke, jer pravi problemi tek nastaju, i neko ili ne??to po??inje u??enike Hogvortsa da gura ka stijeni. Da li je to Drako Melfroj, najotrovniji rival? Da li je to mo??da Hagrid ??ija je pro??lost otkrivena? Ili je to neko u koga svi u Hogvortsu sumnjaju ??? sam Hari Poter?", R.drawable.hp2cover, false));
        knjige.add(new Knjiga(3, 879, "Hari Poter i red feniksa", "D??. K. Rouling", "2014", "Nakon napada dementora na Harija i njegovog ro??aka Dadlija, profesori i ??arobnjaci prinu??eni su da ponovo aktiviraju pokret otpora pod nazivom Red Feniksa. Na Dambldorovo insistiranje, Hari poku??ava da zatvori svoj um od kontrole Lorda Voldemora u??e??i Oklumenciju sa zlokobnim profesorom Snejpom, a pri tom poku??ava i da svoje prijatelje obu??i odbrambenim ??inima da bi bili spremni za predstoje??e bitke. Ho??e li novoosnovana Dambldorova armija biti u stanju da se odupre Voldemoru i spre??i ga u njegovim mra??nim namerama?", R.drawable.hp5cover, false));
        knjige.add(new Knjiga(4, 432, "Hari Poter i Polukrvni princ", "D??. K. Rouling", "2016", "Sredina je ljeta, ali neobi??na, neo??ekivana magla pritiska prozore. Hari Poter nervozno i????ekuje u svojoj sobi u ku??i Darsijevih posjetu profesora Dambldora li??no. Poslednji put je upravnika Hogvortsa vidio tokom ??estokog okr??aja sa mra??nim gospodarom Voldemorom i Hari ne mo??e da vjeruje da ??e profesor Dambldor pojaviti upravo kod Darslijevih. Za??to profesor dolazi da ga posjeti? ??ta je to ??to ne mo??e da sa??eka nekoliko sedmica dok se Hari ne vrati natrag u Hogvorts? Dok Dambldor priprema Harija za njegov sudbinski okr??aj sa Voldemorom, otkri??e mu i zapanjuju??e detalje o pro??losti mra??nog gospodara ??? ko su bili njegovi roditelji, ??ta se dogodilo po??to je napustio Hogvorts i mnogo toga drugog. ", R.drawable.hp6cover, false));
        knjige.add(new Knjiga(5, 635, "Doma??in", "Stefani Majer", "2009", "Novi roman autorke ???Sumraka???! U ovoj me??avini nau??nofantasti??nog i ljubavnog romana, Stefani Majer otkriva ??ta se de??ava s intimnim vezama kada dva bi??a nastanjuju isto telo. Zemlju je okupirala vanzemaljska rasa Du??a, koja zaposeda ljudska tela i bri??e njihove li??nosti. Melani Strajder, jedna od malobrojnih slobodnih ljudi, biva uhvae??ena i njeno telo nastani Du??a po imenu Lutalica, ??iva legenda me??u pripadnicima svoje vrste zbog mnogih doma??ina u kojima je boravila i mno??tva planeta na kojima je ??ivela. Njen zadatak je da otkrije lokaciju poreostalih pripadnika pokreta otpora. Me??utim, bitisanje u ljudskom telu i ljudskom umu nije ni nalik bilo ??emu ??to je Lutalica do tada iskusila. Ubrzo otkriva da Melani nema nameru da se preda bez borbe - umesto da joj pru??i ??eljne informacije, ona Lutali??in um ispunjava se??anjima na voljenog mu??karca, D??areda, koji je jo?? uvek u bekstvu. Nemo??na da se odupre ??eljama svog doma??ina, Lutalica po??inje da ??udi za tim istim ??ovekom, koga po zadatku mora da prona??e. Kada okolnosti nateraju lutalicu i Melani da se i protiv svoje volje udru??e, one ??e krenuti u opasnu i neizvesnu potragu za mu??karcem koga obe vole.", R.drawable.domacin, false));
        knjige.add(new Knjiga(6, 392, "Isijavanje", "Stiven King", "2014", "???Isijavanje??? predstavlja oli??enje savremenog horor romana i pru??a pronicljiv uvid u jednu rasturenu porodicu, mra??ne hodnike du??e i ljudsku slabost. Talenat Stivena Kinga ni u jednoj knjizi nije bio blistaviji. D??ek Torens, njegova ??ena Vendi i sin Deni useljavaju se u hotel ???Vidikovac??? , gde je D??ek dobio posao ku??epazitelja za vreme zime. Mesecima odse??eni od civilizacije, D??ek poku??ava da se izbori sa alkoholizmom i napadima besa dok pi??e nov pozori??ni komad. Me??utim, sile tame koje borave u hotelu ???Vidikovac??? ??? koji ima dugu istoriju nasilja ??? ??ele da se do??epaju Denija zbog njegovih sna??nih prekognitivnih sposobnosti i slu??e se D??ekovim slabostima kako bi ugrabile de??aka...", R.drawable.theshining, true));
        knjige.add(new Knjiga(7, 952, "Jadnici", "Viktor Hugo", "2013", "Epski roman o iskupljenju, po??rtvovanosti, ljubavi i patnji... Jadnici pripovedaju pri??u o ??anu Val??anu, koji je proveo devetnaest jezivih godina u zatvoru jer je ukrao veknu hleba. Po??to je izbavljen zahvaljuju??i dobro??instvu, pru??a mu se prilika da spozna sre??u, ukoliko bude uspeo da pomogne k??erki mlade Fantine. Me??utim, istrajni policijski inspektor ??aver ne dozvoljava ??anu da pobegne od pro??losti. Na listi bestselera otkako je objavljen, roman Jadnici ve??to prepli??e li??ne sudbine sa turbulentnom istorijskom epohom u jedinsvenu, rasko??nu i ma??tovitu dramati??nu pri??u o ??ivotnim neda??ama. ", R.drawable.lesmiserables, true));
        knjige.add(new Knjiga(8, 792, "Ana Karenjina", "Lav Tolstoj", "2014", " ??ini se da Ana Karenjina ima sve ??to se po??eleti mo??e ??? lepa je, bogata, omiljena u dru??tvu, a njen sin je jednostavno obo??ava. Me??utim, Ana ipak ose??a da je ??ivot suvi??e prazan, sve dok ne sretne nao??itog i ??armantnog oficira, grofa Vronskog. Njihova veza posta??e pravi skandal u visokom dru??tvu i izazva??e ogor??enost i zavist ljudi koji okru??uju ovo dvoje ljubavnika. Strastvenoj ljubavi i Aninom putu ka samouni??tenju suprotstavljena je pri??a Konstantina Ljevina, mladog ??oveka koji te??i tome da prona??e spokoj i smisao ??ivota ??? briljantan autoportret samog autora ove izuzetne, bezvremene knjige. Ponovo pro??ivite jedan od najvoljenijih knji??evnih klasika, sada i u novom, luksuznom izdanju...", R.drawable.anna_karenina, false));
        knjige.add(new Knjiga(9, 432, "Autsajder", "Stiven King", "2019", "Sad ga vidi??, sad ga ne vidi??. Nakon ubistva de??aka u gradskom parku, pouzdani o??evici jednodu??no su ukazali na omiljenog trenera Lige petli??a Terija Mejtlanda kao krivca. DNK dokazi i otisci prstiju samo su potvrdili da je ovaj ugledni porodi??ni ??ovek po??inio stra??an zlo??in. U??asnut brutalnim ubistvom i potresen ??injenicom da je Mejtland trenirao i njegovog sina, detektiv Ralf Anderson nare??uje da hap??enje osumnji??enog bude javni spektakl. Ali Mejtland ima alibi i drugi svedoci potvr??uju da tog dana nije ni bio u gradu. Anderson i okru??ni tu??ilac pretresaju dokaze, a istraga se ??iri od Ohaja do Teksasa. Pojavljuju se u??asavaju??i odgovori, koji dodatno komplikuju i ubrzavaju Kingovu ionako nepodno??ljivo uzbudljivu pri??u.Teri Mejtland je po op??tem mi??ljenju dobar momak, ali postoji ??injenica neporeciva poput gravitacije: ??ovek ne mo??e istovremeno da bude na dva mesta. Ili mo??da mo??e?", R.drawable.autsajder, true));
        knjige.add(new Knjiga(10, 418, "Sumrak", "Stefani Majer", "2010", "U sredi??tu pri??e je mlada Bela Svon, dobrovoljno a bezvoljno pristigla u ki??oviti Forks, gde zapo??inje da ??ivi sa svojim ocem. Ve?? prvog dana u novoj sredini i u novoj ??koli, za oko joj zapadaju Kalenovi, ??udnovata i prili??no izolovana porodica. Posebno joj je privla??an Edvard, najlep??i i najgraciozniji me??u njima. Nevolja, me??utim, nastaje kada i on opazi nju... Tajna Kalenovih je iskonska, no oni su prevazi??li ograni??enja svoga roda, jer svoju ??e?? zadovoljavaju razli??itim ??ivotinjskim vrstama. Postoje, me??utim, i oni drugi, koji po??tuju tradicionalni na??in Ishrane...", R.drawable.twilight1, false));
        knjige.add(new Knjiga(11, 460, "Mlad mesec", "Stefani Majer", "2010", "Kako to ina??e u ??ivotu biva, jedno zlo ili dobro, kako ga ko do??ivljava, ne mo??e s??mo da pro??e ??? neophodna je ravnote??a. Nakon neizmernog ljubavnog bola koji do??ivljava, Bela otkriva tu drugu, paralelnu stranu medalje u??u??kanog Forksa. Prijateljstvo sa D??ejkobom Blekom, drugarom iz detinjstva, koji pripada drevnom indijanskom plemenu Kvilita, otkriva joj jo?? jednu bri??ljivo ??uvanu tajnu. Ni Kviliti nisu tek jedno pleme ukra??eno ??ivopisnim no??njama i dramati??nim totemima. Naprotiv, njihova tajna je, poput one vampirske, prikrivena svetlo????u no??i u seni Mladog meseca.", R.drawable.twilight3, false));
        knjige.add(new Knjiga(12, 384, "Hemi??ar", "Stefani Majer", "2016", "Ona zna previse??? Oni ??ele njenu smrt. Tako po??inje bitka njenog ??ivota. Radila je za ameri??ku vladu, ali je vrlo malo ljudi znalo za to. Bila je jedna od najbolje ??uvanih tajni agencije toliko tajnovite da ??ak nema ni ime. A kada su njeni poslodavci shvatili da bi mogla da bude problem, re??ili su da je uklone, i to ??to pre. Zato je sada u bekstvu ??? retko se zadr??ava na jednom mestu i stalno menja identitet. Ubili su jedinu osobu kojoj je verovala. Ona je slede??a. A onda dobija priliku da prihvati jo?? jedan posao za njih, kao jedini na??in da ostane u ??ivotu. Dok se priprema za najte??u misiju do sada, neo??ekivana strast samo ??e umanjiti njene ??anse da pre??ivi i dovesti u pitanje sva njena ube??enja. Puna napetosti i uzbudljivih preokreta, ova pri??a sa nesvakida??njom i mo??nom heroinom jo?? jednom dokazuje za??to su knjige Stefeni Majer ve?? godinama me??u najprodavanijima na svetu.", R.drawable.hemicar, false));
        knjige.add(new Knjiga(13, 140, "Lav, ve??tica i orman", "C. S. Luis", "2005", "Narnija??? Zemlja iza vrata ormana, tajno mesto okovano ve??nom zimom??? ??arobna zemlja koja ??eka da bude oslobo??ena. U profesorovoj tajanstvenoj ku??i Lusi je otkrila neobi??an orman. U prvi mah joj njena bra??a i sestra ne veruju kada im pri??a o svom izletu u Narniju. Ali Edmund, Piter i Suzan ubrzo i sami prolaze kroz orman. U Narniji ??e prona??i zemlju zarobljenu zlom kletvom Bele Ve??tice. Kada upoznaju velikog lava Aslana, shvataju da su upravo oni odabrani da u??estvuju u velikoj pustolovini i hrabro se priklju??uju borbi za osloba??anje Narnije od opake ve??ti??je ??ini.", R.drawable.narnia, false));
        knjige.add(new Knjiga(14, 448, "Kum", "Mario Puzo", "2003", "Pri??a o don Vitu Korleoneu, glavi njujor??ke mafija??ke porodice, inspirisala je tri mo??da najbolja filma svih vremena i postavila temelje sasvim novom literarnom ??anru. Roman obiluje nezaboravnim likovima koji uprkos neuobi??ajenom na??inu ??ivota koji vode unutar poznate kriminalne porodice do??ivljavaju sve uspone i padove koji su neizbe??ni za svakoga od nas. Moderni klasik koji ni danas nije izgubio ni trunku svoje sve??ine i aktuelnosti, i koji jo?? jednom dokazuje da ni najbolji film ne mo??e da nadma??i knjigu na kojoj je zasnovan.", R.drawable.kum, true));
        knjige.add(new Knjiga(15, 228, "Sumnji??avi umovi", "Gvenda Bond", "2020", "Prvi oficijelni Stranger Things roman, koji otkriva istinu o majci Jedanaestice. Ako ??ele da ovaj eksperiment pomeri granice ljudskog uma, trebaju im posebni kandidati. Poput devoj??ice koju je poveo sa sobom: ima samo pet godina i toliko neobja??njive mo??i da je neophodan strog bezbednosni protokol. Indijana, Sjedinjene Ameri??ke Dr??ave, 1969. godina. Teri Ajvs je radoznala devojka nemirnog duha. Zavidi svojim vr??njacima koji u gradovima kao ??to su San Francisko ili Va??ington protestima menjaju svet. Kada sazna da univerzitet tra??i dobrovoljce za psihijatrijski eksperiment, ose??a da se iza toga krije ne??to va??no i odlu??uje da se prijavi. Ne ??ele??i da propusti priliku ??ivota, re??ena je da najzad odigra svoju ulogu u istoriji. Ali ne zna da se iza ovog projekta krije opasna zavera, i ne??e joj biti dovoljna samo hrabrost da joj se suprotstavi. Bi??e joj potrebne natprirodne mo??i. I tako, dok svet tinja, u malom ameri??kom gradu dobro i zlo sukobljavaju se u tajnom ratu u kojem je ljudski um bojno polje. ", R.drawable.sumnjicaviumovi, true));
        knjige.add(new Knjiga(16, 368, "Ve??ti??ina zima", "Katerin Arden", "2019", "Nakon ??to je spasla Moskvu od po??ara koji je sama izazvala oslobodiv??i ??ar-pticu, Vasja be??i od razularene rulje koja ??eli da je spali i napu??ta ledom okovanu kne??evu prestonicu tra??e??i uto??i??te u ??udnovatoj zemlji Pono??i, u kojoj se godi??nja doba smenjuju u tren oka, a vol??ebne opasnosti vrebaju sa svih strana: zli blatnici, pe??urke koje govore, prepredeni bagjanici i krvolo??ni vodenjaci... Tra??e??i odmor i predah, Vasja ??e tamo prona??i ne samo neo??ekivane saveznike ve?? i novu mo?? i snagu. A snaga ??e joj biti potrebna jer ??e srednjovekovnoj Rusiji u sukobu sa krvolo??nim Tatarima biti neophodna i pomo?? nevidljivih sila koje jedino Vasja mo??e da pomiri s narodom koji ih je zaboravio i oterao odjecima crkvenih zvona. Me??aju??i stvarne junake iz ruske istorije sa ma??tovitim likovima iz sveta ??arolija i ??ini, Ketrin Arden zavr??ava pri??u ??uvenom bitkom na Kulikovom polju, na kojem su udru??ene ruske snage slavno porazile tatarsku Zlatnu hordu iznedriv??i legendu o Dimitriju Donskom i njegovim hrabrim ratnicima, koji su odva??no ustali u odbranu zemlje protiv trostruko brojnijeg neprijatelja. DOK SE BO??ANSTVA NOVA I BO??ANSTVA STARA BORE ZA DU??U SREDNJOVEKOVNE RUSIJE, SUDBINA SVIH NJIH LE??I NA NEJAKIM PLE??IMA DEVOJKE KOJA SE USUDILA DA POVERUJE U ??AROLIJE! ", R.drawable.vestica_zime, true));
        knjige.add(new Knjiga(17, 368, "Nezavisna ??ena", "Klajd Stivenson", "2019", "Stavljanje opisa u toku...", R.drawable.nezavisnazena, true));
        knjige.add(new Knjiga(18, 368, "Planina vukodlaka", "C. V. Voters", "2019", "Stavljanje opisa u toku...", R.drawable.planinavukodlaka, true));
        knjige.add(new Knjiga(19, 368, "Mra??an svet", "D??. F. Grato", "2019", "Stavljanje opisa u toku...", R.drawable.darkworld, true));
        knjige.add(new Knjiga(20, 412, "Gospodar prstenova 3", "D??. R. R. Tolkin", "2018", "Gandalf, Aragorn, Gimli i Legolas imaju svoj zadatak u spasavanju Srednjeg sveta. Poku??avaju da na??u saveznike u tome, i da otmu od tmine one koje su dograbile duge mra??ne ruke Mordora, poput Teodena, kralja Rohana. Uspostavljen savez Gondora i Rohana o??ajni??ki se bori protiv Sauronovih sila zla, u poku??aju da pa??nju Oka zadr??i na bojnom polju i odvrati je od Froda, koji se sa Semom i Golumom, nadaju se, pribli??ava Mordoru. Teret Prstena za Froda postaje sve te??i, a Sauron sprema vojsku za kona??an obra??un protiv svih koji se bore za njegovo uni??tenje. Ho??e li Frodo uspeti da stigne do Planine Usuda i uni??ti Prsten? Kakvu ??e va??nu ulogu, koju je Gandalf naslutio, u tome odigrati Golum? Kakav ??e biti ishod odsudnog Rata za Prsten, i za spas Srednjeg sveta? I u ??emu je Frodo uspeo, a u ??emu je na kraju ipak bio pora??en? I ??ta o??ekuje svet nakon ??to ono najbolje i najsvetlije u njemu polako ode u Sive luke... i nastupi novo doba.", R.drawable.lordoftherings3, true));

    }

    public void prijavaKorisnika(View view) {
        EditText korisnicko_ime = findViewById(R.id.korisnicko_ime);
        EditText lozinka = findViewById(R.id.lozinka);
        if (korisnicko_ime.getText().toString().isEmpty()) {
            Toast.makeText(this, "Unesite korisni??ko ime!", Toast.LENGTH_SHORT).show();
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
        Toast.makeText(this, "Va?? nalog nije registrovan!", Toast.LENGTH_SHORT).show();
    }
}