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
          height="150"
        />
      </h1>
      <p class="titulo">Historial de Tareas</p>
      <div class="tabla-container">
        <table class="tabla">
          <thead>
            <tr>
              <th>Título</th>
              <th>Descripción</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="tarea in historial" :key="tarea.id_tarea">
              <td>{{ tarea.titulo }}</td>
              <td>{{ tarea.descripcion }}</td>
              <td>
                      <v-btn
                        block
                        class="mb-1"
                        color="#EA7600"
                        background-color="#394049"
                        @click="editarTarea(tarea);
                        console.log(tarea.id_tarea);
                        "
                        ><div>Editar Tarea</div>
                      </v-btn>
                    </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="input-container">
      </div>
    </div>
  </v-layout>
</template>

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
  padding: 20px;
}

.titulo {
  font-size: 34px;
  font-weight: bold;
  padding: 15px;
  border: 2px solid #020202;
  border-radius: 10px;
  background-color: #EA7600;
}

.tabla-container {
  margin-top: 20px;
}

.tabla {
  width: 80%;
  margin: 0 auto;
  border-collapse: collapse;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

.tabla th,
.tabla td {
  padding: 15px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

.tabla th {
  background-color: #EA7600;
  color: white;
}
</style>
  
  
  
  <script>
  import axios from 'axios';
  import Header from "../components/Header.vue";
  export default {
    components: {
      Header,
    },
    data() {
      return {
        historial: [],

      };
    },
    mounted() {
      this.cargarHistorial();
    },
    methods: {
      cargarHistorial() {
        const nombre_usuario = localStorage.getItem('nombre_usuario');
        console.log(nombre_usuario);
        const url = `http://localhost:8090/Tarea/MostrarPorUsuario/${nombre_usuario}`;
      axios.get(url)
        .then(response => {
          this.historial = response.data;
        })
        .catch(error => {
          console.error('Error al cargar tareas:', error);
        });
    },
    editarTarea(tarea) { 
        
        localStorage.setItem("tarea", JSON.stringify(tarea));
        console.log(localStorage.getItem("tarea"));
        this.$router.push('/editarTarea');
    },



    },

  };
  </script>
  
