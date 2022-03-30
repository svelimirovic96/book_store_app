<template>
<div>
    <div id='pretraga'>
          <table>
            <tr>
            <td><input type='text' name='naziv_knjige' size="50" v-model="naziv" placeholder="Unesite naziv knjige za pretragu" style="border-radius: 15px"></td>
            <td><input type='text' name='autor_knjige' size="50" v-model="autor" placeholder="Unesite autora knjige za pretragu" style="border-radius: 15px"></td>
            <td><button class='btn1' @click='pretrazi()' style="border-radius: 15px"><i class="fa fa-search"></i></button></td>
          </tr>
          </table>
    </div>
    <div id='pocetna_admin'>
      
     <div id='listaKnjiga'>
        <div class="row justify-content-center" style="max-width: 85em">
            <div class="col" v-for="knjiga in knjige" :key="knjiga.id">
                <Knjiga1 :k="knjiga" ></Knjiga1>
            </div>
        </div>
     </div>
     <br/><br/>
    </div>
</div>
</template>
<style>
    #listaKnjiga {
        padding-top: 20px; 
        
    }
  
    #pocetna_admin {
        background: white;
        margin-top: 18px;
        margin-bottom: 50px;
        min-height:400px;
    }
    #listaKnjiga .row{
        display: inline-flex;
    }
</style>
<script>
import Knjiga1 from '../components/Knjiga1.vue'
import knjige from '../data/knjige.js'
export default {
    name: 'ListaKnjigaPretraga',
    components: {
        Knjiga1
    },
    data(){
        return{
            knjige:[],
            naziv: "",
            autor: "",
            listaKnjiga: []
        }
    },
    methods: {
            pretrazi(){
                if (this.naziv=="" && this.autor=="") this.knjige=null;
                else if (this.autor=="") this.knjige=this.listaKnjiga.filter(k=>k.naziv.includes(this.naziv));
                else if (this.naziv=="") this.knjige=this.listaKnjiga.filter(k=>k.autor.includes(this.autor));
                else this.knjige=this.listaKnjiga.filter(k=>k.naziv.includes(this.naziv) && k.autor.includes(this.autor));
            }
    },
    mounted(){
        this.knjige=null;
        if (localStorage.getItem('knjige')!=null) this.listaKnjiga=JSON.parse(localStorage.getItem('knjige'));
        else this.listaKnjiga=knjige;
    }
}
</script>