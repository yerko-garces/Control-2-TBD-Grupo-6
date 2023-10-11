<template>
  <v-form v-model="valid">
    <v-container>
      <div class="form-title">
        <h2>Formulario registro</h2>
      </div>

      <v-row class="d-flex justify-center">
        <v-col cols="12" md="4">
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
        <v-col cols="12" md="4">
          <v-text-field
            v-model="contrasena"
            :rules="requisitosMax"
            :counter="10"
            label="Contraseña"
            placeholder="Introduzca su contraseña"
            hide-details
            required
            style="margin-bottom: 30px;"
          ></v-text-field>
        </v-col>
      </v-row>

      <v-row class="d-flex justify-center">
        <v-col cols="12" md="4">
          <v-btn
            block
            color="green"
            size="large"
            variant="tonal"
            @click="registrar"

          >
            Registrar
          </v-btn>
        </v-col>
      </v-row>

    </v-container>
  </v-form>
</template>

  
  <script>

import axios from 'axios';
export default {
  name: 'registerView',
  data() {
    return {
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
      if(this.nombre && this.contrasena){
        try {
          const res = await axios({
            method: 'POST',
            url: 'http://localhost:8090/Usuario/CrearUsuario2',
            data: {
              nombre_usuario: this.nombre,
              contrasena: this.contrasena,
            },

          });
          if (res.status === 200) {
            this.$swal({ 
              icon: 'success',
              title: 'Éxito',
              text: 'Se ha registrado el usuario.',
            }).then(() => {
              this.$router.push('/'); 
            });
          }
        } catch (err) {
          this.error = err.response.data;
          alert(this.error);
        }
      }else{
        this.$swal({ 
          icon: 'error',
          title: 'Error',
          text: 'Por favor, complete todos los campos.',
        });
      }

      },
  },
};
  </script>
  
  <style>
  .form-title {
    text-align: center;
    margin-bottom: 20px;
    font-size: 24px;
    color: #333; 
  }
  </style>