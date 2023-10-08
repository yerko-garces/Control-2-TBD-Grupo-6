<script>
import axios from 'axios';
export default {
  name: 'HomeView',
  data() {
    return {
      usuario: '',
      password: '',
      error: '',
    };
  },
  methods: {
    async login() {
      try {
        const res = await axios({
          method: 'POST',
          url: 'http://localhost:8090/Usuario/Login',
          data: {
            nombre_usuario: this.usuario,
            contrasena: this.password,
          },

        });
        console.log(res.data.status);
        if (res.data.status === 'success') {
          console.log(res);
          alert('Logged in successfully!');
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
<template>
  <div>
    <v-card
      class="mx-auto pa-12 pb-8"
      elevation="8"
      max-width="500"
      rounded="lg"
    >
      <div class="text-subtitle-1 text-medium-emphasis">Cuenta</div>

      <v-responsive class="mx-auto" max-width="400">
        <v-text-field
          label="Nombre de usuario"
          placeholder="Introduzca su nombre de usuario"
          type="input"
          v-model="usuario"
        ></v-text-field>
      </v-responsive>

      <div class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between">
        Contraseña
        <a
          class="text-caption text-decoration-none text-blue"
          href="#"
          rel="noopener noreferrer"
          target="_blank"
        >
          ¿Olvidó su contraseña?</a>
      </div>

      <v-responsive class="mx-auto" max-width="400">
        <v-text-field
            label="Contraseña"
            placeholder="Introduzca su contraseña"
            type="input"
            v-model="password"
        ></v-text-field>
      </v-responsive>

      <v-btn
        block
        class="mb-8"
        color="green"
        size="large"
        variant="tonal"
        @click="login"
      >
        INICIAR SESIÓN
      </v-btn>





      <v-card-text class="text-center">
        <a
          class="text-blue text-decoration-none"
          href="#"
          rel="noopener noreferrer"
          target="_blank"
        >
          <v-btn
            block
            class="mb-8"
            size="large"
            color="surface-variant"
            variant="tonal"
          >INVITADO
          </v-btn>
        </a>
      </v-card-text>
    </v-card>
  </div>
</template>

<style scoped>
body {
  background-color: #424953;
  display: flex;
  justify-content: center;
  align-items: center;
}

.log-in {
  color: #00a499;
}

body {
  height: 100vh;
}

#flexbox {
  display: flex;
}

#divImagen {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
