<template>
    <div id='detalji'>
        <div class="row">
                <div class="col-2">
                <img class='card-img-top' :src="''+link_slike+''">
                </div>
                <div class="col-2" style="text-align: left; border: 1px solid black; border-radius: 5px; width: 80.5%">
                <p>Autor: {{izabrana.autor}}</p>
                <p>Godina izdanja: {{izabrana.godina_izdanja}}</p>
                <p>Broj strana: {{izabrana.broj_strana}}</p>
                <p>Opis: {{izabrana.opis}}</p>
                </div>
        </div>
        <div class="row id2"> 
                <div class="col-3" style="font-family:'Pattaya'; width:15%;">
                <h3>{{izabrana.naziv}}</h3>
                <button class='btn1' @click="preporuci()">Preporučite</button>
                </div>
                <div class="col-3" style="text-align: left; border: 1px solid black; border-radius: 5px; margin-left: 13px; width: 41%">
                <h3 style="font-family:'Pattaya';">Ocenite i komentarišite knjigu</h3>
                <table>
                    <tr><td colspan='2'><textarea style="width: 170%; height: 200px" v-model="novi_komentar" placeholder="Unesite Vaš komentar o knjizi"/></td></tr>
                    <tr><td><i class="fa fa-star fa-2x" v-bind:class="{'yellow':clicked1, 'normal': !clicked1}" v-on:click="podesi1()"/>
                    <i class="fa fa-star fa-2x" v-bind:class="{'yellow':clicked2, 'normal': !clicked2}" v-on:click="podesi2()" />
                    <i class="fa fa-star fa-2x" v-bind:class="{'yellow':clicked3, 'normal': !clicked3}" v-on:click="podesi3()"/>
                    <i class="fa fa-star fa-2x" v-bind:class="{'yellow':clicked4, 'normal': !clicked4}" v-on:click="podesi4()"/>
                    <i class="fa fa-star fa-2x" v-bind:class="{'yellow':clicked5, 'normal': !clicked5}" v-on:click="podesi5()"/>
                    </td>
                    <td colspan='2' style="padding-left: 70%;"><button class='btn1' style="font-family:'Pattaya';" @click="posalji()">Pošaljite</button></td></tr>
                </table>
                </div>
                <div class="col-3" style="font-family:'Pattaya'; text-align: left; border: 1px solid black; border-radius: 5px;  width: 41%;">
                <h3>Ocene i komentari</h3>
                <table v-for="kom_ocena in kom" :key="kom_ocena.id">
                    <tr><td colspan='2'><textarea style="min-width: 130%; height: 200px" disabled="true" :value="kom_ocena.komentar"/></td></tr>
                    <tr><td><i id="star-active" class="fa fa-star fa-2x"/><i id="star-active" class="fa fa-star fa-2x" v-if="kom_ocena.ocena>=2"/><i id="star-active" class="fa fa-star fa-2x" v-if="kom_ocena.ocena>=3"/><i id="star-active" class="fa fa-star fa-2x" v-if="kom_ocena.ocena>=4"/><i id="star-active" class="fa fa-star fa-2x" v-if="kom_ocena.ocena==5"/></td><td colspan='2' style="padding-left: 30%" v-for="korisnik in korisnici.filter(k=>k.kor_ime==kom_ocena.ocenio)" :key="korisnik.kor_ime">{{korisnik.ime}}&nbsp;{{korisnik.prezime}}</td></tr>
                    <tr><td>
                    <ul class="pagination">
                        <li class="page-item">
                        <button class="page-link" v-if="page!=1" @click="page--"> <i class="fa fa-arrow-left"></i> </button>
                        </li>
                        <li class="page-item">
                        <button class="page-link" v-for="pageNumber in pages.slice(page-1, page+5)" :key="pageNumber" @click="page=pageNumber"> {{pageNumber}} </button>
                        </li>
                        <li class="page-item"> 
                        <button class="page-link" v-if="page<pages.length" @click="page++"> <i class="fa fa-arrow-right"></i> </button>
                        </li>
                    </ul></td></tr>
                </table>
                </div>
        </div>
        <modal name='preporuciModal'>
            <div class='closeModal'>
                <button @click="$modal.hide('preporuciModal')"><i class="fa fa-close" /></button>
            </div>
            <div class='centralModal1'>
                <br/>
                <h5>Izaberite nekog od sledećih korisnika za preporuku knjige:</h5>
                <br/>
                <select v-model="izabrani_kor" @change="izaberi(izabrani_kor)">
                    <option v-for="user in korisnici.filter(k=>k.kor_ime!=korisnik.kor_ime && k.tip==0)" :value="user.kor_ime" :key="user.kor_ime">
                        {{user.ime}}&nbsp;{{user.prezime}}
                    </option>
                </select>
                <br/><br/>
                <button @click="preporuciKorisniku()">Preporuči</button>
            </div>
             
        </modal>
        <modal name='uspehModal'>
            <div class='closeModal'>
                <button @click="$modal.hide('uspehModal')"><i class="fa fa-close" /></button>
            </div>
            <div class='centralModal'>
                <br/>
                <h2>Uspešno slanje komentara i ocene za knjigu! <br/> Možete izaći. :D</h2>
                <br/>
               <i class="fa fa-thumbs-up fa-5x" />
            </div>
             
        </modal>
        <modal name='uspesnaPreporuka'>
            <div class='closeModal'>
                <button @click="$modal.hide('uspesnaPreporuka')"><i class="fa fa-close" /></button>
            </div>
            <div class='centralModal'>
                <br/>
                <h2>Uspešno ste preporučili knjigu! <br/> Možete izaći. :D</h2>
                <br/>
               <i class="fa fa-thumbs-up fa-5x" />
            </div>
             
        </modal>
        
    </div>
</template>
<style>
    .closeModal {
        width: 100%;
        background-color: #FF732D;
        text-align: right;
    }
    .centralModal1 {
        justify-content: center;
        align-content: center;
        border: 3px solid #FF732D;
        height: 90%;
    }
    .centralModal {
        justify-content: center;
        align-content: center;
        border: 3px solid #FF732D;
        height: 90%;
        font-style: italic;
        color: #FF732D;
    }
    
    .yellow {
        color: yellow;
    }
    .normal {
        color: #2c3e50;
    }
    #central_nav{
        display: flex;
        justify-content: center;
        align-items: center;
    }
    #star-active{
        color: yellow;
    }
    .page-link{
        display: inline-block;
        font-size: 20px;
        color: #29b3ed;
        font-weight: 500;
    }
    #detalji {
        background: white;
        margin-top: 50px;
        margin-bottom: 50px;
    }
    #detalji p {
        font-style: italic;
        font-size: 14px;
    }
    #detalji .row {
        padding: 20px;
    }
    #detalji .id2 {
        margin: 0px;
    }
    #detalji .btn1 {
        font-size: 20px;
        font-weight: 500;
        color: black;
        background-color: #FF732D;
        border: 3px solid #000000;
        border-radius: 7px;
    }
</style>


<script>
import knjige from '../data/knjige.js'
import komentari from '../data/komentari_ocene.js'
import korisnici from '../data/korisnici.js'
import preporuke from '../data/preporuke.js'
export default {
    name: 'DetaljiKnjige',
    data () {
        return {
            sveKnjige:knjige,
            izabrana: {},
            link_slike: "",
            komentari: [],
            korisnici: [],
            page: 1,
            perPage: 1,
            pages: [],
            clicked1: false,
            clicked2: false,
            clicked3: false,
            clicked4: false,
            clicked5: false,
            novi_komentar: "",
            korisnik: [],
            izabrani_kor: "",
            primalac: [],
            knj: [],
            preporuke: [],
            pr_isto:[],
            uradjeno: false
        }
    },
    mounted(){
        if (localStorage.getItem('knjige')==null){
            this.sveKnjige=knjige;
        }
        else this.sveKnjige=JSON.parse(localStorage.getItem('knjige'));
        if (localStorage.getItem('korisnici')==null){
            this.korisnici=korisnici;
        }
        else this.korisnici=JSON.parse(localStorage.getItem('korisnici'));
        let id=Number(this.$route.params.id);
        let knjiga=this.sveKnjige.find(k=>k.id==id);
        this.izabrana=knjiga;
        this.link_slike=knjiga.slika;
        if (localStorage.getItem('komentari')==null){
            localStorage.setItem('komentari', JSON.stringify(komentari));
            this.komentari=komentari.filter(k=>k.ocenjena==id);
        }
        else {this.komentari=JSON.parse(localStorage.getItem('komentari')); this.komentari=this.komentari.filter(k=>k.ocenjena==id);}
        let brojStranica=Math.ceil(this.komentari.length/this.perPage);
        for (let i=1; i<=brojStranica; i++){
            this.pages.push(i);
        }
        if (localStorage.getItem('preporucene')!=null){
           this.preporuke=JSON.parse(localStorage.getItem('preporucene'));
       }
        else this.preporuke=preporuke;
       localStorage.setItem('preporucene', JSON.stringify(this.preporuke));
                   
    },
    computed: {
        kom(){
            let page=this.page;
            let perPage=this.perPage;
            let from=(page*perPage)-perPage;
            let to=page*perPage;
            return this.komentari.slice(from, to);
        }
    },
    methods: {
        podesi1(){
            if (this.clicked1 && (this.clicked2 || this.clicked3 || this.clicked4 || this.clicked5))
             {
                 this.clicked2=this.clicked3=this.clicked4=this.clicked5=false;
             }
             else this.clicked1=!this.clicked1;

        },
        podesi2(){
            if (this.clicked2 && (this.clicked3 || this.clicked4 || this.clicked5))
             {
                 this.clicked3=this.clicked4=this.clicked5=false;
             }
             else {
                 if (this.clicked1==false) this.clicked1=true; 
                 this.clicked2=!this.clicked2;
             }
        },
        podesi3(){
            if (this.clicked3 && (this.clicked4 || this.clicked5))
             {
                 this.clicked4=this.clicked5=false;
             }
             else {
                 if (this.clicked2==false || this.clicked1==false) {this.clicked1=this.clicked2=true;}
                 this.clicked3=!this.clicked3;
                 }
        },
        podesi4(){
            if (this.clicked4 && this.clicked5)
             {
                 this.clicked5=false;
             }
             else {
                 if (this.clicked3==false || this.clicked2==false || this.clicked1==false) {this.clicked1=this.clicked2=this.clicked3=true;}
                 this.clicked4=!this.clicked4;
                 }
        },
        podesi5(){
            if (this.clicked4==false || this.clicked3==false || this.clicked2==false || this.clicked1==false) {this.clicked4=this.clicked1=this.clicked2=this.clicked3=true;}
                 this.clicked5=!this.clicked5;
        },
        posalji(){ //podesiti da se opet ne posalje
            if (this.novi_komentar=="") alert("Polje za komentar mora biti popunjeno!");
            else if (this.clicked1==false && this.clicked2==false && this.clicked3==false && this.clicked4==false && this.clicked5==false) alert("Ocena mora da bude veća od 1 pre slanja komentara i ocene!");
            else {
                let broj_zvezda=1;
                if (this.clicked1 && this.clicked2 && this.clicked3 && this.clicked4 && this.clicked5) broj_zvezda=5;
                else if (this.clicked1 && this.clicked2 && this.clicked3 && this.clicked4) broj_zvezda=4;
                else if (this.clicked1 && this.clicked2 && this.clicked3) broj_zvezda=3;
                else if (this.clicked1 && this.clicked2) broj_zvezda=2;
                this.korisnik=JSON.parse(localStorage.getItem('korisnik'));
                this.komentari=JSON.parse(localStorage.getItem('komentari'));
                let id=this.komentari.length-1;
                this.komentari.push({
                    id: id+1,
                    ocenio: this.korisnik.kor_ime,
                    ocenjena: Number(this.izabrana.id),
                    komentar: this.novi_komentar,
                    ocena: broj_zvezda
                });
                localStorage.setItem('komentari', JSON.stringify(this.komentari));
                this.komentari=this.komentari.filter(k=>k.ocenjena==this.izabrana.id);
                let brojStranica=Math.ceil(this.komentari.length/this.perPage);
                 for (let i=this.pages.length+1;  i<=brojStranica; i++){
                    this.pages.push(i);
                        
                }
                this.$modal.show('uspehModal');
            }
        },
        preporuci(){
            this.korisnik=JSON.parse(localStorage.getItem('korisnik'));
            this.knj=this.sveKnjige.filter(k=>k.id==this.izabrana.id);
            this.$modal.show('preporuciModal');
        },
        izaberi(username){
            this.primalac=this.korisnici.filter(k=>k.kor_ime==username);
            this.uradjeno=true;
        },
        preporuciKorisniku(){
            
            if (this.uradjeno!=true) {alert("Izaberite korisnika!");}
            else {
                    this.pr_isto=this.preporuke.filter(p=>p.knjiga[0].id==this.knj[0].id && p.primalac[0].kor_ime==this.primalac[0].kor_ime && p.posiljalac[0].kor_ime==this.korisnik.kor_ime);
                    if (this.pr_isto.length!=0) {alert("Već ste preporučili knjigu '"+this.knj[0].naziv+"' korisniku "+this.primalac[0].ime+" "+this.primalac[0].prezime+".");}
                    else {
                        /*if (this.pr_isto.id!=0) {alert("Već ste preporučili knjigu '"+this.knj[0].naziv+"' korisniku "+this.primalac[0].ime+" "+this.primalac[0].prezime+".");}
                    else {*/
                        let id=this.preporuke.length;
                        this.preporuke.push({
                        id: Number(id+1),
                        primalac: this.primalac,
                        knjiga: this.knj,
                        posiljalac: this.korisnici.filter(k=>k.kor_ime==this.korisnik.kor_ime)
                    });
                    localStorage.setItem('preporucene', JSON.stringify(this.preporuke));
                    this.$modal.hide('preporuciModal');
                    this.$modal.show('uspesnaPreporuka');
                    }
                       //}
            }
        }
    }
}
</script>