<script>
import axios from "axios";
export default {
  name: "HomeView",
  data() {
    return {
      usuario: "",
      password: "",
      error: "",
    };
  },
  methods: {
    async login() {
      try {
        const res = await axios({
          method: "POST",
          url: "http://localhost:8090/Usuario/Login",
          data: {
            nombre_usuario: this.usuario,
            contrasena: this.password,
          },
        });
        if (res.status === 202) {
          const data = res.data;
          console.log(data.id_usuario);
          localStorage.setItem("nombre_usuario", data.nombre_usuario);
          localStorage.setItem("id_usuario", data.id_usuario);

          this.$router.push("/about");
        }
      } catch (err) {
        this.$swal({
          icon: "error",
          title: "Error",
          text: "Credenciales invalidas.",
        });
      }
    },
  },
};
</script>
<template>
  <div>
    <v-card
      class="mx-auto pa-12 pb-8"
      elevation="15"
      max-width="500"
      rounded="lg"
      style="margin-top: 40px"
    >
      <div class="text-subtitle-1 text-medium-emphasis">Cuenta</div>
      <v-responsive class="mx-auto" max-width="400">
        <v-text-field
          label="Usuario"
          placeholder="Introduzca su email de usuario"
          type="input"
          v-model="usuario"
        ></v-text-field>
      </v-responsive>

      <v-responsive class="mx-auto" max-width="400">
        <v-text-field
          label="Contraseña"
          placeholder="Introduzca su contraseña"
          type="password"
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

      <v-btn
        block
        class="mb-8"
        color="blue"
        size="large"
        variant="tonal"
        to="/registrar-usuario"
        @click="crear"
      >
        Registrarse
      </v-btn>

      <v-card-text class="text-center">
        <a
          class="text-blue text-decoration-none"
          href="#"
          rel="noopener noreferrer"
          target="_blank"
        >
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
