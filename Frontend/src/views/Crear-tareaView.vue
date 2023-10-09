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
        <p class="titulo">Formulario para crear tarea</p>
        <br>
        <ul>
          <li>
          <p class="descripcion">Rellene los campos para guardar la tarea.</p>
          </li>
        </ul>
        <br>
      <div class="input-container">
        <input v-model="id_tarea" placeholder="ID" class="custom-input">
        <input v-model="titulo" placeholder="Título" class="custom-input">
        <input v-model="descripcion" placeholder="Descripción" class="custom-input">
        <input v-model="vencimiento" placeholder="Vencimiento" class="custom-input">
        <input v-model="id_usuario" placeholder="ID Usuario" class="custom-input">
      </div>
      <div class="input-container">
        <!-- Tus inputs aquí -->
      </div>
      <button @click="crearTarea" class="crear-tarea-btn">Crear Tareas</button>
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
      id_tarea: "",
      titulo: "",
      descripcion: "",
      vencimiento: "",
      id_usuario: "",
      message: "",
    };
  },
  methods: {
    async crearTarea() {  
      // Verificar si todos los campos están llenos antes de crear la tarea
      if (this.id_tarea && this.titulo && this.descripcion && this.vencimiento && this.id_usuario) {
        try {
          const res = await axios({
          method: 'POST',
          url: 'http://localhost:8090/CrearTarea',
          data: {
            id_tarea: this.id_tarea,
            titulo: this.titulo,
            descripcion: this.descripcion,
            vencimiento: this.vencimiento,
            id_usuario: this.id_usuario,
          },

        });
        if (res.status === 202) {
          this.$router.push('/ver-tareas');
        }
        } catch (error) {
          console.error("Error al crear tarea:", error);
          // Puedes manejar el error de la manera que desees
        }
      } else {
        alert("Por favor, complete todos los campos antes de crear la tarea.");
      }
    },
  },
};
</script>



<style scoped>

  
.centered-layout {
  display: flex;
  flex-direction: column;
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
.descripcion {
  font-size: 18px;
  color:  #030303;
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