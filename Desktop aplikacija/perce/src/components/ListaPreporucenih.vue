<template>
    <div id='preporuceno_kupac'>
     <div id='listaPreporucenihKnjiga'>
         <h1>Preporučene knjige</h1>
         <br/><br/>
        <div class="row justify-content-center" style="max-width: 85em">
            <div class="col" v-for="preporuka in prikazanePreporuke" :key="preporuka.id">
                <router-link :to='/detaljiknjige/+preporuka.knjiga[0].id'>
                <Preporuka :p="preporuka" ></Preporuka>
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
    #listaPreporucenihKnjiga {
        padding-top: 20px; 
    }
    #listaPreporucenihKnjiga .row{
        display: inline-flex;
    }

    #preporuceno_kupac {
        background: white;
        margin-top: 50px;
        margin-bottom: 50px;
        min-height: 400px;
    }
    #listaPreporucenihKnjiga h1 {
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
import Preporuka from '../components/Preporuka.vue'
import preporucene from '../data/preporuke.js'
export default {
    name: 'ListaPreporucenih',
    components:{
        Preporuka
    },
    data(){
        return {
            page: 1,
            pages: [],
            perPage: 5,
            preporucene: [],
            korisnik: []
        }
    },
    mounted(){   //dodavanje knjiga u listu pri inicijalizaciji
       if (localStorage.getItem('preporucene')!=null){
           this.preporucene=JSON.parse(localStorage.getItem('preporucene'));
       }
       else this.preporucene=preporucene;
       localStorage.setItem('preporucene', JSON.stringify(this.preporucene));
       this.korisnik=JSON.parse(localStorage.getItem('korisnik'));
       this.preporucene=this.preporucene.filter(p=>p.primalac[0].kor_ime==this.korisnik.kor_ime);
       let brojStranica=Math.ceil(this.preporucene.length/this.perPage);
       for (let i=1; i<=brojStranica; i++){
           this.pages.push(i);
       }
    },
    computed: {
        prikazanePreporuke() {
            let page=this.page;
            let perPage=this.perPage;
            let from=(page*perPage)-perPage;
            let to=(page*perPage);
            return this.preporucene.slice(from, to);
        }
    }
}
</script>