<template>
    <v-app-bar>
      <v-toolbar>
          <img
            alt="Vue logo"
            class="logo"
            src="@/assets/logo_sai_usach_4.png"
            width="100"
            height="40"
          />
  
        <v-btn variant="plain" to="/about">Inicio</v-btn>
        <v-btn variant="plain" to="/tarea">Tarea</v-btn>
        <v-btn variant="plain" to="/historial">Historial</v-btn>
        <v-spacer></v-spacer>
        <v-btn variant="plain" to="/">
          Cerrar Sesión
          <v-icon class="icon"
            ><img
              alt="Cerrar sesión"
              src="@/assets/cerrar-sesion.png"
              width="25"
              height="16"
          /></v-icon>
        </v-btn>
      </v-toolbar>
    </v-app-bar>
  </template>
<script>
  export default {
    name: "Header",
  };
</script>
  