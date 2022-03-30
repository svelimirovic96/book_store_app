<template>
    <div id='pocetna_kupac'>
     <div id='listaDostupnihKnjiga'>
         <h1>Dostupne knjige</h1>
         <br/><br/>
        <div class="row justify-content-center" style="max-width: 85em">
            <div class="col" v-for="knjiga in prikazaneKnjige1.filter(k=>k.promocija==false)" :key="knjiga.id">
                <router-link :to='/detaljiknjige/+knjiga.id'>
                <Knjiga :k="knjiga" ></Knjiga>
                </router-link>
            </div>
        </div>
        <nav id="central_nav">
           <ul class="pagination">
               <li class="page-item">
                   <button class="page-link" v-if="page1!=1" @click="page1--"> <i class="fa fa-arrow-left"></i> </button>
               </li>
               <li class="page-item">
                   <button class="page-link" v-for="pageNumber in pages1.slice(page1-1, page1+5)" :key="pageNumber" @click="page1=pageNumber"> {{pageNumber}} </button>
               </li>
               <li class="page-item"> 
                   <button class="page-link" v-if="page1<pages1.length" @click="page1++"> <i class="fa fa-arrow-right"></i> </button>
               </li>
           </ul>
       </nav>
     </div>
     <br/><br/>
     <div id='listaKnjigaNaPromociji'>
         <h1>Na promociji</h1>
         <br/><br/>
        <div class="row justify-content-center" style="max-width: 85em">
            <div class="col" v-for="knjiga in prikazaneKnjige.filter(k=>k.promocija==true)" :key="knjiga.id">
                <router-link :to='/detaljiknjige/+knjiga.id'>
                <Knjiga :k="knjiga" ></Knjiga>
                </router-link>
            </div>
        </div>
       <nav id="central_nav">
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
           </ul>
       </nav>
     </div>
    </div>
</template>
<style>
   
    #listaDostupnihKnjiga {
        padding-top: 20px; 
    }
     #listaDostupnihKnjiga .row{
        display: inline-flex;
    }
    #listaKnjigaNaPromociji {
        padding-bottom: 20px; 
    }
    #listaKnjigaNaPromociji .row{
         display: inline-flex;
    }
    #pocetna_kupac {
        background: white;
        margin-top: 50px;
        margin-bottom: 50px;
    }
    #listaDostupnihKnjiga h1 {
        font-family: 'Pattaya';
        text-decoration-line: underline;
        color: #FF605E;
    }
    #listaKnjigaNaPromociji h1 {
        font-family: 'Pattaya';
        text-decoration-line: underline;
        color: #FF605E;
    }
    #central_nav {
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .page-link {
        display: inline-block;
        font-size: 20px;
        color: #29b3ed;
        font-weight: 500;
    }
   
</style>

<script>
import Knjiga from './Knjiga.vue'
import knjige from '../data/knjige.js'
export default {
    name: 'ListaKnjiga',
    components :{
        Knjiga
    },
    data(){
        return {
            knjige :[],
            page: 1,
            page1: 1,
            pages: [],
            pages1: [],
            perPage: 5,
            promocije: [],
            dostupne: []
        }
    },
    mounted(){   //dodavanje knjiga u listu pri inicijalizaciji
       if (localStorage.getItem('knjige')!=null){
           this.knjige=JSON.parse(localStorage.getItem('knjige'));
       }
       else this.knjige=knjige;
       this.promocije=this.knjige.filter(k=>k.promocija==true);
       this.dostupne=this.knjige.filter(k=>k.promocija==false);
       let brojStranica=Math.ceil(this.promocije.length/this.perPage);
       for (let i=1; i<=brojStranica; i++){
           this.pages.push(i);
       }
       brojStranica=Math.ceil(this.dostupne.length/this.perPage);
       for (let i=1; i<=brojStranica; i++){
           this.pages1.push(i);
       }
       
    },
    computed: {
        prikazaneKnjige() {
            let page=this.page;
            let perPage=this.perPage;
            let from=(page*perPage)-perPage;
            let to=(page*perPage);
            return this.promocije.slice(from, to);
        },
        prikazaneKnjige1(){
            let page=this.page1;
            let perPage=this.perPage;
            let from=(page*perPage)-perPage;
            let to=(page*perPage);
            return this.dostupne.slice(from, to);
        }
    }
  
       
}
</script>