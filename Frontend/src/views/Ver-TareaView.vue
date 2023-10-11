<template>
  <v-layout class="rounded rounded-md centered-layout">
    <Header />
    <div class="centered-message">
      <h1>
        <img alt="Vue logo" class="logo" src="@/assets/logo_sai_usach_4.png" width="300" height="150" />
      </h1>
      <p class="titulo">Historial de Tareas</p>
      <div class="tabla-container">
        <table class="tabla">
          <thead>
            <tr>
              <th>Título</th>
              <th>Descripción</th>
              <th>status</th>
              <th>Acción</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="tarea in historial" :key="tarea.id_tarea">
              <td>{{ tarea.titulo }}</td>
              <td>{{ tarea.descripcion }}</td>
              <td>{{ mostrarStatus(tarea.status) }}</td>
              <td>
                <v-btn v-if="mostrarBoton(tarea)" block class="mb-1" color="green" background-color="#394049" @click="editarTarea(tarea);
                ">
                  <div>Editar Tarea</div>
                </v-btn>
                <v-btn block class="mb-1" color="red" background-color="#394049" @click="borrarTarea(tarea);
                ">
                  <div>Eliminar Tarea</div>
                </v-btn>
                <v-btn v-if="mostrarBoton(tarea)" block class="mb-1" color="blue" background-color="#394049" @click="cancelarTarea(tarea);
                ">
                  <div>Finalizar Tarea</div>
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
      this.$router.push('/editarTarea');
    },
     async borrarTarea(tarea) {
      try {
        const res = await axios.delete(`http://localhost:8090/Tarea/BorrarTarea/${tarea.id_tarea}`).then(response => {
          this.cargarHistorial();
        })
          .catch(error => {
            console.error('Error al borrar tareas:', error);
          });
      }
      catch {
        console.error('Error al borrar tareas:', error);
      }
    },
    async cancelarTarea(tarea){
      try{
        await axios.put(`http://localhost:8090/Tarea/CambiarStatus/${tarea.id_tarea}`).then(response => {
          this.cargarHistorial();
        }).catch(error => {
            console.error('Error al finalizar tarea:', error);
          });
      }catch {
        console.error('Error al finalizar tarea:', error);
      }
    },
    mostrarStatus(status){
      if(status){
        return("Pendiente");
      }else{
        return("Finalizada");
      }
    },
    mostrarBoton(tarea){
      console.log(tarea.status)
      console.log(tarea)
      return tarea.status;
    }
    



  },

};
</script>
  
