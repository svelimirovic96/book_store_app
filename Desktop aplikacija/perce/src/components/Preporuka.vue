<template>
    <div id='preporuka'>
        <div class='card'>
        <div class='card-body'>
            <img class='card-img-top' :src="''+p.knjiga[0].slika+''">
            <br/><br/>
            <h4>{{p.knjiga[0].naziv}}</h4>
            <br/><br/>
            <h4>Preporučio/la:<br/>{{p.posiljalac[0].ime}}&nbsp;{{p.posiljalac[0].prezime}}</h4>
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
    img{
        max-width: 75%;
    }
</style>

<script>
import preporucene from '../data/preporuke.js'
export default {
    name: 'Preporuka',
    props: ['p'],
    data() {
        return {
            preporucene: []
        }
    },
    mounted() {
        if (localStorage.getItem('preporucene')!=null){
            this.preporucene=JSON.parse(localStorage.getItem('preporucene'));
        } 
        else {
            this.preporucene=preporucene;
        }
        
    }
}
</script>