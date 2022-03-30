import knjige from '../data/knjige.js'
import korisnici from '../data/korisnici.js'

let knjige1=[], korisnici1=[];
if (localStorage.getItem('knjige')!=null){
    knjige1=JSON.parse(localStorage.getItem('knjige'));
} 
else {
    knjige1=knjige;
}
if (localStorage.getItem('korisnici')!=null){
    korisnici1=JSON.parse(localStorage.getItem('korisnici'));
}
else {
    korisnici1=korisnici;
}
let preporuke= [

    {
        id: 1,
        primalac: korisnici1.filter(k=>k.kor_ime=='sandra'),
        knjiga: knjige1.filter(k=>k.id==1),
        posiljalac: korisnici1.filter(k=>k.kor_ime=='marko')
    },
    {
        id: 2,
        primalac: korisnici1.filter(k=>k.kor_ime=='sandra'),
        knjiga: knjige1.filter(k=>k.id==10),
        posiljalac: korisnici1.filter(k=>k.kor_ime=='nikola')
    },
    {
        id: 3,
        primalac: korisnici1.filter(k=>k.kor_ime=='sandra'),
        knjiga: knjige1.filter(k=>k.id==14),
        posiljalac: korisnici1.filter(k=>k.kor_ime=='milena')
    },
    {
        id: 4,
        primalac: korisnici1.filter(k=>k.kor_ime=='sandra'),
        knjiga: knjige1.filter(k=>k.id==12),
        posiljalac: korisnici1.filter(k=>k.kor_ime=='zoran')
    }
]

export default preporuke;