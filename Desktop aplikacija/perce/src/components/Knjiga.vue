<template>
    <div id='knjiga'>
        <div class='card'>
        <div class='card-body'>
            <img class='card-img-top' :src="''+k.slika+''">
            <br/><br/>
            <i id="star" class="fa fa-star fa-2x fa-spin " v-if="k.promocija==true"></i>
            <br/>
            <br/>
            <h4>{{k.naziv}}</h4>
            <h4>{{k.autor}}</h4>
        </div>
        </div>
    </div>
</template>

<style>
    #star{
         color: yellow;
    }
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
export default {
    name: 'Knjiga',
    props: ['k']
}
</script>