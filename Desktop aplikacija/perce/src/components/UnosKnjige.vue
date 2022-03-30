<template>
    <div id="dodaj">
        <h1>Dodavanje knjige</h1>
        <div id="central_forma">
            <table>
                <tr>
                <td>
                    <p>Naziv</p>
                </td>
                <td>
                    <input type="text" v-model="naziv" size="50" name="naziv_knjige" placeholder="Unesite naziv knjige">
                </td>
                </tr>
                <tr>
                <td>
                    <p>Autor</p>
                </td>
                <td>
                    <input type="text" v-model="autor" size="50" name="autor_knjige" placeholder="Unesite autora knjige">
                </td>
                </tr>
                <tr>
                <td>
                    <p>Opis</p>
                </td>
                <td style="padding: 15px">
                    <textarea v-model="opis" style="width: 100%; height: 120px" name="opis_knjige" placeholder="Unesite opis knjige"/>
                </td>
                </tr>
                <tr>
                <td>
                    <p>Godina izdanja</p>
                </td>
                <td>
                    <input type="text" v-model="godina_izdanja" size="50" name="godina_izdanja" placeholder="Unesite godinu izdanja knjige">
                </td>
                </tr>
                <tr>
                <td>
                    <p>Broj strana</p>
                </td>
                <td>
                    <input type="text" v-model="broj_strana" size="50" name="broj_strana" placeholder="Unesite broj strana knjige">
                </td>
                </tr>
                <tr>
                <td>
                    <p>Slika</p>
                </td>
                <td>
                    <button id="dodajSliku" @click="pokaziModal()"><i class="fa fa-plus"></i></button><h4 v-if="putanja==''">Dodajte sliku</h4><h4 v-if="putanja!=''">Dodata slika <b>{{nameExt}}</b></h4>
                    <modal name='slikaModal'>
                        <div class='closingModal'><button @click="$modal.hide('slikaModal')"><i class="fa fa-close"></i></button></div>
                        <div class='centralModal'>
                            <div class="row justify-content-center" style="max-width: 85em">
                            <div class="col-sm-4" v-for="slika in slike" :key="slika.id">
                                   <div class='card' @click="izabrana(slika.slika, slika.nameExt, slika.id)" v-bind:class="{'back-card':slika.id==oznacena}">
                                        <div class='card-body'> 
                                            <img class='card-img-top' :src="''+slika.slika+''"/>
                                        </div>
                                   </div>
                            </div>
                            </div>
                        </div>
                    </modal>
                </td>
                </tr>
    </table>
        </div>
        <div id="dugme">
    <button class="btnDodaj" @click="dodajKnjigu()">Izmenite podatke</button>
    </div>
    </div>
</template>
<style>
    .back-card{
        background: #107fb4;
    }

    .closingModal {
        width: 100%;
        background-color: #FF732D;
        text-align: right;
    }
    #central_forma h4 {
        font-size: 15px;
        font-style: italic;
    }
    #dodajSliku {
        justify-content: center;
        padding: 5px 10px;
        color: white;
        background-color: #FF732D;
        border-radius: 7px;
    }
    .centralModal {
        justify-content: center;
        display: inline-block;
        align-items: center;
        height: 270px;
        overflow-y: auto;
        overflow-x: hidden;
    }
    #dodaj h1 {
        font-family: 'Pattaya';
        padding-bottom: 20px;
    }
    #dugme {
        padding-top: 20px;
    }
    .btnDodaj {
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
    #dodaj{
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
    #central_forma table input{
        font-style: italic;
    }
    #central_forma table textarea{
        font-style: italic;
    }
</style>

<script>
import knjige from '../data/knjige.js'
import slike from '../data/slike.js'
export default {
    name: 'UnosKnjige',
    data() {
        return {
            naziv: '',
            autor: '',
            opis: '',
            godina_izdanja: '',
            broj_strana: '',
            putanja: '',
            nameExt:'',
            knjige: [],
            slike: [],
            oznacena: 0
        }
    },
    methods: {
        pokaziModal(){
            this.$modal.show('slikaModal');
        },
        izabrana(slika, nameExt, id){
            this.putanja=slika;
            this.nameExt=nameExt;
            this.oznacena=id;
        },
        dodajKnjigu() {
            if (this.naziv=='' || this.autor=='' || this.opis=='' || this.broj_strana=='' || this.godina_izdanja==''  || this.putanja=='') alert("Sva polja za dodavanje knjige se moraju popuniti!");
            else {
                const regex=/^[A-ZŠĐŽČĆ][a-zšđžčć]+(\s{1}[A-ZŠĐŽČĆa-zšđžčć]+)*(\s{1}[0-9]+)?$/;
                if (regex.exec(this.naziv)==null){ alert('Neispravan format za polje naziv knjige!'); return;}
                const regex1a=/^[A-ZŠĐŽČĆ](([a-zšđžčć]+(\s{1}[A-ZŠĐŽČĆ][a-zšđžčć]+)*)|([a-zšđžčć]*\.{1}\s{1}[A-ZŠĐŽČĆ][a-zšđžčć]*)+)$/;
                if (regex1a.exec(this.autor)==null) { alert('Neispravan format za polje autor knjige!'); return;}
                 const regex2=/^(19[7-9][0-9])|(20(([0-1][0-9])|2[0-2]))$/;
                if (regex2.test(this.godina_izdanja)==false) {alert('Neispravan format za polje godina izdanja knjige!'); return;}
                
                const regex1=/^[1-9][0-9]*$/; 
                if (regex1.test(this.broj_strana)==false) {alert('Neispravan format za polje broj strana knjige!'); return;}
               

                let id=this.knjige.length+1;
                this.knjige.push({
                id: id,
                naziv: String(this.naziv),
                autor: String(this.autor),
                godina_izdanja: Number(this.godina_izdanja),
                broj_strana: Number(this.broj_strana),
                opis: String(this.opis),
                slika: this.putanja,
                promocija: false
            });
            localStorage.setItem('knjige', JSON.stringify(this.knjige));
            alert("Dodavanje knjige uspešno!");
            }
        }
    },
    mounted(){
        if (localStorage.getItem('knjige')!=null){
            this.knjige=JSON.parse(localStorage.getItem('knjige'));
        }
        else this.knjige=knjige;
        this.slike=slike;
        this.oznacena=0;
    }
}
</script>