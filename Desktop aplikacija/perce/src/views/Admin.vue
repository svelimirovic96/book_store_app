<template>
    <ListaKnjigaPretraga></ListaKnjigaPretraga>
</template>

<style>
</style>
<script>
import korisnici from '../data/korisnici.js'
import knjige from '../data/knjige.js'
import ListaKnjigaPretraga from '../components/ListaKnjigaPretraga.vue'
export default {
    name: 'Admin',
    components: {
        ListaKnjigaPretraga
    },
    mounted(){
        if (localStorage.getItem('knjige')==null)
         localStorage.setItem('knjige', JSON.stringify(knjige));
    }
}
</script>