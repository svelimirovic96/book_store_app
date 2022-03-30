<template>
    <div id='knjiga'>
        <div class='card'>
        <div class='card-body'>
            <img class='card-img-top img-fluid' :src="''+k.slika+''">
            <br/><br/>
            <h4>{{k.naziv}}</h4>
            <h4>{{k.autor}}</h4>
            <input type="checkbox" v-model="k.promocija" name="promocija" :checked=k.promocija @change="promocija()"><h4>na promociji</h4>
        </div>
        </div>
    </div>
</template>

<style>
    h4 {
        font-size: 12px;
        font-style: italic;
        font-weight: bold;
    }
    #knjiga img{
        width: 100%;
        height: 15vw;
        object-fit: scale-down;
    }
</style>

<script>
import knjige from '../data/knjige.js'
import preporuke from '../data/preporuke.js'
export default {
    name: 'Knjiga1',
    props: ['k'],
    data(){
        return{
            knjige:[],
            preporuke:[],
            korisnici:[],
            vrednost:''
        }
    },
    methods: {
        promocija(){
            this.knjige=JSON.parse(localStorage.getItem('knjige'));
            let knjiga=this.knjige.find(kk=>kk.id==this.vrednost);
            let id=knjiga.id;
            let naziv=knjiga.naziv;
            let autor=knjiga.autor;
            let godina_izdanja=knjiga.godina_izdanja;
            let broj_strana=knjiga.broj_strana;
            let opis=knjiga.opis; 
            let slika=knjiga.slika;
            let promocija=knjiga.promocija;
            if (promocija==true) promocija=false;
            else promocija=true;
           // this.knjige.splice(id-1, id-1, id, naziv, autor, godina_izdanja, broj_strana, opis, slika, promocija);
            this.knjige.splice(this.knjige.indexOf(knjiga), 1);
            this.knjige.push({
                'id': id,
                'naziv': naziv,
                'autor': autor,
                'godina_izdanja': godina_izdanja,
                'broj_strana': broj_strana,
                'opis': opis,
                'slika': slika,
                'promocija': promocija
            });
            localStorage.setItem('knjige', JSON.stringify(this.knjige));

            if (localStorage.getItem('preporucene')!=null){
                    this.preporucene=JSON.parse(localStorage.getItem('preporucene'));
            } 
            else {
                 this.preporucene=preporuke;
             }
             if (localStorage.getItem('korisnici')!=null){
                    this.korisnici=JSON.parse(localStorage.getItem('korisnici'));
            } 
            else {
                 this.korisnici=korisnici;
             }
            let nizP=this.preporucene.filter(p=>p.knjiga[0].id==id);
            for (let i=0; i<nizP.length; i++){
            let knjigaP=nizP[i];
            this.preporucene.splice(this.preporucene.indexOf(knjigaP), 1);
            this.preporucene.push({
                            id: knjigaP.id,
                            primalac: this.korisnici.filter(k=>k.kor_ime==knjigaP.primalac[0].kor_ime),
                            knjiga: this.knjige.filter(k=>k.id==id),
                            posiljalac: this.korisnici.filter(k=>k.kor_ime==knjigaP.posiljalac[0].kor_ime)
                        });
                    }
            localStorage.setItem('preporucene', JSON.stringify(this.preporucene));
        }
    },
    mounted(){   //dodavanje knjiga u listu pri inicijalizaciji
       if (localStorage.getItem('knjige')!=null){
           this.knjige=JSON.parse(localStorage.getItem('knjige'));
       }
       else this.knjige=knjige;
       this.vrednost=this.k.id;
    }
}
</script>