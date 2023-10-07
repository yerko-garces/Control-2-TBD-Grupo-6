<template>
  <v-layout class="rounded rounded-md centered-layout">
    <Header />
    <div class="centered-message">
      <h1>
        <img
            alt="Vue logo"
            class="logo"
            src="@/assets/logo_sai_usach_4.png"
            width="300"
            height="150"/>
      </h1>
        <p class="titulo">BIENVENIDO AL SISTEMA DE GESTIÓN DE TAREAS USACH</p>
        <br>
        <ul>
          <li>
          <p class="descripcion">Este es un servicios que permite gestionar de manera eficiente y efectiva distinto tipo de tareas.</p>
          </li>
          <li>
          <p class="descripcion">Aquí podrá revisar estados y realizar seguimiento.</p>
          </li>
        </ul>
        <br>
      <v-btn class="button" color="black" variant="outlined" to="/Tarea">Tarea</v-btn>
      <v-btn class="button" color="black" variant="outlined" to="/historial">Historial</v-btn>
        
    </div>
  </v-layout>
</template>

<script>
import Header from "../components/Header.vue";
export default {
  components: {
    Header,
  },
};
</script>

<style scoped>
.centered-layout {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
}
.centered-message {
  text-align: center;
  padding: 10 px;
}
.icon {
  margin-right: 10px;
  margin-left: 10px;
}

.titulo {
  font-size: 24px;
  font-weight: black;
  padding: 10px;
  border: 2px solid #020202;
  border-radius: 10px;
  background-color: #EA7600;
}
.descripcion {
  font-size: 18px;
  color:  #030303;
}

.button {
  font-size: 19px;
  margin-top: 20px;
  margin-right: 20px;
}
</style>