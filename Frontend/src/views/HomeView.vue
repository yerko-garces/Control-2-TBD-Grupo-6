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
          hide-details="auto"
          label="Direccion de correo electronico"
          placeholder="Introduzca su correo"
          type="email"
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
          type="input"
          placeholder="Introduzca su contraseña"
        ></v-text-field>
      </v-responsive>

      <v-btn
        block
        class="mb-8"
        color="green"
        size="large"
        variant="tonal"
      >
        <RouterLink to="/about">INICIAR SESION</RouterLink>
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
