<template>
    <v-form v-model="valid">
      <v-container>
        <div class="form-title">
          <h2>Formulario registro</h2>
        </div>
  


        <v-row class="d-flex justify-center">
          <v-col
            cols="12"
            md="4"
          >
            <v-text-field
              v-model="id_usuario"
              :rules="requisitosMax"
              :counter="10"
              label="ID"
              placeholder="Por qué tenemos que colocar el id?"
              hide-details
              required
            ></v-text-field>
          </v-col>
        </v-row>

        <v-row class="d-flex justify-center">
          <v-col
            cols="12"
            md="4"
          >
            <v-text-field
              v-model="nombre"
              :rules="requisitosMax"
              :counter="10"
              label="Nombre de usuario"
              placeholder="Introduzca su nombre de usuario"
              required
              hide-details
            ></v-text-field>
          </v-col>
        </v-row>
  
        
        <v-row class="d-flex justify-center">
          <v-col
            cols="12"
            md="4"
          >
            <v-text-field
              v-model="contrasena"
              :rules="requisitosMax"
              :counter="10"
              label="Contraseña"
              placeholder="Introduzca su contraseña"
              hide-details
              required
            ></v-text-field>
          </v-col>
        </v-row>

        <v-btn
        block
        class="mb-8"
        color="green"
        size="large"
        variant="tonal"
        to="/registrar-usuario"
        @click="registrar"
      >
        Registrar
        </v-btn>

      </v-container>
    </v-form>
  </template>
  
  <script>

import axios from 'axios';
export default {
  name: 'registerView',
  data() {
    return {
      id_usuario: '',
      nombre: '',
      contrasena: '',
      error: '',
      requisitosMax: [
        value => {
          if (value) return true
  
          return 'Se requiere nombre.'
            },
        ],
    };
  },
  methods: {
    async registrar() {
      try {
        const res = await axios({
          method: 'POST',
          url: 'http://localhost:8090/Usuario/CrearUsuario',
          data: {
            id_usuario: this.id_usuario,
            nombre_usuario: this.nombre,
            contrasena: this.contrasena,
          },

        });
        console.log(res);
        if (res.status === 202) {
          console.log(res);
          this.$router.push('/about');
        }
      } catch (err) {
        this.error = err.response.data;
        alert(this.error);
      }
    },
  },
};
  </script>
  
  <style>
  /* Estilo personalizado para el título */
  .form-title {
    text-align: center;
    margin-bottom: 20px;
    font-size: 24px;
    color: #333; /* Cambia el color según tus preferencias */
  }
  </style>