<template>
<div id="promena">
    <div id="central_forma">
    <table>
        <tr>
            <td>
                <p>Ime</p>
            </td>
            <td>
                <input type="text" v-model="korisnik.ime" size="50" name="ime">
            </td>
        </tr>
        <tr>
            <td>
                <p>Prezime</p>
            </td>
            <td>
                <input type="text" v-model="korisnik.prezime" size="50" name="prezime">
            </td>
        </tr>
        <tr>
            <td>
                <p>Kontakt telefona</p>
            </td>
            <td>
                <input type="text" v-model="korisnik.telefon" size="50" name="telefon">
            </td>
        </tr>
        <tr>
            <td>
                <p>Adresa</p>
            </td>
            <td>
                <input type="text" v-model="korisnik.adresa" size="50" name="adresa">
            </td>
        </tr>
        <tr>
            <td>
                <p>Korisničko ime</p>
            </td>
            <td>
                <input type="text" v-model="korisnik.kor_ime" size="50" name="kor_ime">
            </td>
        </tr>
        <tr>
            <td>
                <p>Lozinka</p>
            </td>
            <td>
                <input type="password" v-model="korisnik.lozinka" size="50" name="lozinka">
            </td>
        </tr>
    </table>
    </div>
    <div id="dugme">
    <button class="btnPrijava" @click="izmena()">Izmenite podatke</button>
    </div>
</div>
</template>

<style>
    #dugme {
        padding-top: 20px;
    }
    .btnPrijava {
        justify-content: center;
        padding: 10px -10px;
        width: 200px;
        height: 40px;
        font-size: 20px;
        font-style: italic;
        color: white;
        background-color: #FF732D;
        border-radius: 7px;
    }
    #promena {
        background: white;
        margin-top: 50px;
        margin-bottom: 50px;
        padding-top: 40px;
        padding-bottom: 40px;
    }
    
    #central_forma {
        display: flex;
        justify-content: center;
        align-items: center;
    }
    #central_forma table td{
        width: 400px;
        border: 1px solid black;
    }
    #central_forma table p {
        text-align: left;
        padding-top: 15px; 
        padding-left: 10px;
        font-family: 'Pattaya';
        font-size: 20px;
    }
    #central_forma table input {
        font-style: italic;
    }
</style>

<script>
import korisnici from '../data/korisnici.js'
import preporucene from '../data/preporuke.js'
import komentari from '../data/komentari_ocene.js'
import knjige from '../data/knjige.js'
export default {
    name: 'Izmena',
    data(){
        return {
            korisnici: [],
            korisnik: [],
            pre_username: "",
            preporucene: [],
            komentari: [],
            knjige : []
        }
    },
    methods: {
            izmena (){
                if (this.korisnik.ime=='' || this.korisnik.prezime=='' || this.korisnik.telefon=='' || this.korisnik.adresa=='' ||
                this.korisnik.kor_ime=='' || this.korisnik.lozinka=='') alert('Polja za izmenu Vaših podataka moraju biti popunjena!');
                else {
                    this.korisnici=JSON.parse(localStorage.getItem('korisnici'));
                    let pre_korisnik=this.korisnici.find(k=>k.kor_ime==this.pre_username);
                    if (pre_korisnik.ime==this.korisnik.ime && pre_korisnik.prezime==this.korisnik.prezime &&
                    pre_korisnik.telefon==this.korisnik.telefon && pre_korisnik.adresa==this.korisnik.adresa &&
                    pre_korisnik.kor_ime==this.korisnik.kor_ime && pre_korisnik.lozinka==this.korisnik.lozinka) alert('Niste promenili Vaše podatke!');
                
                    else {
                        const regex=/^[A-ZŠĐŽČĆ][a-zšđžčć]+$/;
                        if (regex.exec(this.korisnik.ime)==null){ alert('Neispravan format za polje ime!'); return;}
                        if (regex.exec(this.korisnik.prezime)==null) { alert('Neispravan format za polje prezime!'); return;}
                        const regex1=/^(((\+381\s?)|0)6[0-9])\s([0-9]{3})\s([0-9]{3,4})$/; //telefon
                        if (regex1.test(this.korisnik.telefon)==false) {alert('Neispravan format za polje telefon!'); return;}
                        const regex2=/^([A-ZŠĐŽČĆ][a-zšđžčć]+\s)(([A-ZŠĐŽČĆ]|[a-zšđžčć])+\s)*[0-9]{1,3}([a-zšđžčć]*)$/;
                        if (regex2.exec(this.korisnik.adresa)==null) {alert('Neispravan format za polje adresa!'); return;}
                        const regex3=/^[a-z]([a-z0-9]){3,}$/;
                        if (regex3.exec(this.korisnik.kor_ime)==null) {alert('Neispravan format za polje korisničko ime!'); return;}
                        if (regex3.exec(this.korisnik.lozinka)==null) {alert('Neispravan format za polje lozinka!'); return;}
                    

                    this.korisnici.splice(this.korisnici.indexOf(pre_korisnik), 1);
                    this.korisnici.push({
                        ime: this.korisnik.ime,
                        prezime: this.korisnik.prezime,
                        telefon: this.korisnik.telefon,
                        adresa: this.korisnik.adresa,
                        kor_ime: this.korisnik.kor_ime,
                        lozinka: this.korisnik.lozinka,
                        tip: this.korisnik.tip
                    });

                    let kor_novi=this.korisnici.filter(k=>k.kor_ime==this.korisnik.kor_ime);
                    if (localStorage.getItem('knjige')!=null){
                        this.knjige=JSON.parse(localStorage.getItem('knjige'));
                    } 
                    else {
                        this.knjige=knjige;
                        }
                    if (localStorage.getItem('preporucene')!=null){
                        this.preporucene=JSON.parse(localStorage.getItem('preporucene'));
                    } 
                    else {
                        this.preporucene=preporucene;
                        }
                   let nizP=this.preporucene.filter(p=>p.primalac[0].kor_ime==this.pre_username);
                    for (let i=0; i<nizP.length; i++){
                        let preporuka=nizP[i];
                        this.preporucene.splice(this.preporucene.indexOf(preporuka), 1);
                        this.preporucene.push({
                            id: preporuka.id,
                            primalac: kor_novi,
                            knjiga: this.knjige.filter(k=>k.id==preporuka.knjiga[0].id),
                            posiljalac: this.korisnici.filter(k=>k.kor_ime==preporuka.posiljalac[0].kor_ime)
                        });
                    }
                    localStorage.setItem('preporucene', JSON.stringify(this.preporucene));


                    if (localStorage.getItem('preporucene')!=null){
                        this.preporucene=JSON.parse(localStorage.getItem('preporucene'));
                    } 
                    else {
                        this.preporucene=preporucene;
                        }
                    nizP=this.preporucene.filter(p=>p.posiljalac[0].kor_ime==this.pre_username);
                    for (let i=0; i<nizP.length; i++){
                        let preporuka=nizP[i];
                        this.preporucene.splice(this.preporucene.indexOf(preporuka), 1);
                        this.preporucene.push({
                            id: preporuka.id,
                            primalac: this.korisnici.filter(k=>k.kor_ime==preporuka.primalac[0].kor_ime),
                            knjiga: this.knjige.filter(k=>k.id==preporuka.knjiga[0].id),
                            posiljalac: kor_novi
                        });
                    }
                    localStorage.setItem('preporucene', JSON.stringify(this.preporucene));

                    if (this.korisnik.kor_ime!=this.pre_username){
                    if (localStorage.getItem('komentari')!=null){
                        this.komentari=JSON.parse(localStorage.getItem('komentari'));
                    } 
                    else {
                        this.komentari=komentari;
                        }
                    let nizK=this.komentari.filter(k=>k.ocenio==this.pre_username);
                    for (let i=0; i<nizK.length; i++){
                        let komentar=nizK[i];
                        this.komentari.splice(this.komentari.indexOf(komentar), 1);
                        this.komentari.push({
                            id: komentar.id,
                            ocenio: this.korisnik.kor_ime,
                            ocenjena: komentar.ocenjena,
                            komentar: komentar.komentar,
                            ocena: komentar.ocena
                        });
                    }
                    localStorage.setItem('komentari', JSON.stringify(this.komentari));
                    }

                    this.pre_username=this.korisnik.kor_ime;
                    localStorage.setItem('korisnici', JSON.stringify(this.korisnici));
                    localStorage.setItem('korisnik', JSON.stringify(this.korisnik));
                    alert('Uspešno izmenjeni Vaši podaci!');
                }
            }
            }
    },
    mounted(){
        if (localStorage.getItem('korisnici')!=null){
           this.korisnici=JSON.parse(localStorage.getItem('korisnici'));
       }
       else this.korisnici=korisnici;
       this.korisnik=JSON.parse(localStorage.getItem('korisnik'));
       this.pre_username=this.korisnik.kor_ime; 
    }
}
</script>