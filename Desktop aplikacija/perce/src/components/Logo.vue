<template>
    <div id="nav" v-on='prikazi()'>
        <nav class="navbar">
        <a class="navbar-menu" :href="link1">
            <img id="logo" src="../assets/perce log.png">
        </a>
        <a class="navbar-menu" :href="link1">
            <h1 id="naslov">PERCE</h1>
        </a>
        <!--{{$route.name}} testiranje-->
        <div class="navbar-menu links" v-if="!kupac">
                <router-link to="/preporuke"><h2>Pregled preporuka</h2></router-link>
                <router-link to="/promena_podataka_1"><h2>Promena podataka</h2></router-link>
                <router-link to="/"><h2>Odjava</h2></router-link>
        </div>
        <div class="navbar-menu links" v-if="!prodavac">
                <router-link to="/dodavanje_knjige"><h2>Dodavanje knjige</h2></router-link>
                <router-link to="/promena_podataka_2"><h2>Promena podataka</h2></router-link>
                <router-link to="/"><h2>Odjava</h2></router-link>
        </div>
        </nav>
    </div>
</template>

<style>
    .links {
        position: absolute;
        width: 274px;
        height: 74px;
        right: 100px;
        top: 45px;

        display: flex;
        align-items: center;
        text-align: center;
        
    }
    .links h2{
        font-family: 'Pattaya';
        font-weight: bold;
        color: #ff9901;
        font-size: 25px;
        line-height: 30px;
        padding-right: 50px;
        -webkit-text-stroke: 1pt black;
    }
    
    #naslov {
        position: absolute;
        width: 274px;
        height: 74px;
        left: 150px;
        top: 45px;

        font-family: 'Pattaya';
        font-weight: normal;
        color: #ff9901 ;
        font-size: 64px;
        line-height: 89px;
        display: flex;
        align-items: center;
        text-align: center;
        -webkit-text-stroke: 1pt black;
    }
    #nav {
        background-image: url(../assets/books-banner.jpg);
        background-repeat: no-repeat;
        background-size: 100%;
        width: auto;
        min-height: 155pt;
        margin: -8px;
    }
    #logo {
        width: 145px;
        height: 149px;
        mix-blend-mode: color-burn;
        display: flex;
        justify-content: left;
        position: absolute;
        top: 0px;
        left: 0px;
    }
</style>

<script>
export default {
    name: 'Logo',
    data(){
        return {
            kupac: false,
            prodavac: false,
            link1: ""
        }
    },
    methods: {
        prikazi(){

        if (this.$route.name=='Home') {this.kupac=true; this.prodavac=true; this.link1="";}
            //kupac linkovi
        else if (this.$route.name=='Kupac')  {this.kupac=false; this.link1="";}
        else if (this.$route.name=='DetaljiKnjige') {this.kupac=false; this.link1="../../kupac"}
        else if (this.$route.name=='PromenaPodataka') {this.kupac=false; this.link1="../kupac"}
        else if (this.$route.name=='Preporuke') {this.kupac=false; this.link1="../kupac"}
        else this.kupac=true; 
        //prodavac
        if (this.$route.name=='Admin') {this.prodavac=false; this.link1=""}
        else if (this.$route.name=='PromenaPodatakaAdmin') {this.prodavac=false; this.link1="../prodavac"}
        else if (this.$route.name=='DodavanjeKnjige') {this.prodavac=false; this.link1="../prodavac"}
        else this.prodavac=true;
        }
    }
}
</script>