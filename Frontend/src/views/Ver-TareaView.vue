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
          <p class="titulo">Historial de Tareas</p>
          <br>
          <ul>
            <li>
            <p class="descripcion">Tareas hechas y pendientes.</p>
            </li>
            <li v-for="Tarea in historial" :key="Tarea.id_tarea">
              {{ Tarea.titulo }} - {{ Tarea.descripcion }}
            </li>
          </ul>
          <br>
        <div class="input-container">
        </div>
        <div class="input-container">
        </div>
      </div>  
    </v-layout>
  </template>
  
  
  
  
  <script>
  import axios from 'axios';
  import Header from "../components/Header.vue";
  export default {
    components: {
      Header,
    },
    data() {
      return {
        historial: [], // Aquí se almacenarán las tareas

      };
    },
    mounted() {
      // Llama a la función para cargar tareas asociadas al ID
      this.cargarHistorial();
    },
    methods: {
      cargarHistorial() {
        const id_usuario = localStorage.getItem('nombre_usuario');
        const url = `http://localhost:8090/MostrarPorUsuario/${id_usuario}`;

      // Supongamos que estás utilizando axios
      axios.get(url)
        .then(response => {
          this.historial = response.data;
        })
        .catch(error => {
          console.error('Error al cargar tareas:', error);
        });
    },
    },

  };
  </script>
  
  
  
  <style scoped>
  
    
  .centered-layout {
    display: flex;
    flex-direction:column;
    align-items: center;
    justify-content: normal;
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
    font-size: 34px;
    font-weight: black;
    padding: 15px;
    border: 2px solid #020202;
    border-radius: 10px;
    background-color: #EA7600;
  }
  .crear-tarea-btn {
  font-size: 20px;
  padding: 10px 30px;
  margin-top: 100px; /* Agrega un margen superior para separar el botón de los campos de entrada */
  background-color: #4CAF50;
  color: white;
  border: 1px solid #020202;
  border-radius: 10px;
  cursor: pointer;
}
  </style>