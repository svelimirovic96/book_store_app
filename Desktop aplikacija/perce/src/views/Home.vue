<template>
  <div class="home">
      <div class="centerModal">
        <table>
          <tr>
            <td><p>Korisničko ime:</p></td>
            <td><input type='text' name='kor_ime' v-model="username" size="50" placeholder="Unesite Vaše korisničko ime"></td>
          </tr>
          <tr>
            <td><p>Lozinka:</p></td>
            <td><input type='password' name='lozinka' v-model="password" size="50" placeholder="Unesite Vašu lozinku"></td>
          </tr>
          <tr>
            <td colspan='2'><button class='btn1' @click='prijava()'>Prijavite se</button>
           </td>
          </tr>
        </table>
      </div>
  </div>
</template>

<style>
body{
   background: radial-gradient(#FFBE17, #FF0707);
}
.centerModal {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 300px;
  }
.centerModal p{
  font-size: 20px;
  font-weight: bold;
  float: left;
  color: black;
  font-style: italic;
}
.centerModal .btn1{
  justify-content: center;
  padding: 10px -10px;
  width: 200px;
  height: 40px;
  font-size: 20px;
  font-weight: bold;
  font-style: italic;
  color: black;
  background-color: #FF732D;
  border: 3px solid #000000;
  border-radius: 7px;
}

</style>
  
<script>
// @ is an alias to /src
import korisnici from '../data/korisnici.js'
export default {
  name: 'Home',
  data(){
    return { 
      username: '',
      password: '',
      users: []
    }

  },
  mounted(){
    localStorage.removeItem('korisnik');
  },
  methods: {
    prijava(){
      if (this.username=='' && this.password=='') alert("Unesite korisničko ime i lozinku!");
      else {
        if (this.username=='') alert("Unesite korisničko ime!");
         else 
            {
              if (this.password=='') alert("Unesite lozinku!");
              else {
                if (localStorage.getItem('korisnici')!=null){
                      this.users=JSON.parse(localStorage.getItem('korisnici'));
                           }
                      else this.users=korisnici;
                let korisnik=this.users.find(kor=>kor.kor_ime==this.username && kor.lozinka==this.password);
                if (korisnik==null) { alert("Vaš nalog nije registrovan!"); }
                else {
                localStorage.setItem('korisnici', JSON.stringify(this.users));
                localStorage.setItem('korisnik', JSON.stringify(korisnik));
                if (korisnik.tip==1){
                   this.$router.push('prodavac');
                 }
                 else if (korisnik.tip==0){
                   this.$router.push('kupac');
                 }
                }
              }
            }
        }
    }
  }
  
}
</script>
