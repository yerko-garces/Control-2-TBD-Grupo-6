<template>
    <v-layout class="rounded rounded-md centered-layout">
        <Header />
        <div class="centered-message">
            <h1>
                <img alt="Vue logo" class="logo" src="@/assets/logo_sai_usach_4.png" width="300" height="150" />
            </h1>
            <div class="tarea-container">
                <p class="titulo">Detalles de la Tarea</p>
                <div class="tarea-details">
                    <v-responsive class="mx-auto" max-width="400">
                        <v-text-field label="Titulo" :value="tarea.titulo" type="input"
                            v-model="tarea.titulo"></v-text-field>
                    </v-responsive>

                    <v-responsive class="mx-auto" max-width="400">
                        <v-text-field label="Descripción" :value="tarea.descripcion" type="input"
                            v-model="tarea.descripcion"></v-text-field>
                    </v-responsive>

                    <v-responsive class="mx-auto" max-width="400">
                        <v-text-field label="Fecha" :value="tarea.vencimiento" type="date"
                            v-model="this.tarea.vencimiento"></v-text-field>
                    </v-responsive>

                    <v-btn block class="mb-8" color="blue" size="large" variant="tonal" @click="Actualizar">
                        Actualizar
                    </v-btn>
                </div>
            </div>
        </div>
    </v-layout>
</template>
  
<script>
import Header from '../components/Header.vue';
import axios from 'axios';
import moment from 'moment';

export default {
    components: {
        Header,
    },
    data() {
        return {
            tarea: {},
            tarea2:{id_tarea:'',titulo:'',descripcion:'',vencimiento:'',id_usuario:''},
            
        };
    },
    mounted() {
        this.cargarTarea();
    },
    methods: {
        cargarTarea() {
            const tarea = localStorage.getItem('tarea');

            if (tarea) {
                this.tarea = JSON.parse(tarea);
                this.tarea2.id_tarea = this.tarea.id_tarea;
                this.tarea2.id_usuario = this.tarea.id_usuario;
            }

        },
        async Actualizar() {
            console.log(this.tarea2);
            this.tarea2.titulo = this.tarea.titulo;
            this.tarea2.descripcion = this.tarea.descripcion;
            this.tarea2.vencimiento = new Date(this.tarea.vencimiento);
            console.log(this.tarea2);
            if (this.tarea2.titulo && this.tarea2.descripcion && this.tarea2.vencimiento) {
                try {
                    const res = await axios.post( `http://localhost:8090/Tarea/ActualizarTarea`, this.tarea2);
                    if (res.status === 202) {
                        this.$router.push('/Ver-Tarea');
                    }
                } catch (error) {
                    console.error("Error al crear tarea:", error);
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
    justify-content: center;
    height: 100vh;
}

.centered-message {
    text-align: center;
    padding: 20px;
}

.titulo {
    font-size: 24px;
    font-weight: bold;
    padding: 15px;
    border: 2px solid #020202;
    border-radius: 10px;
    background-color: #EA7600;
}

.tarea-container {
    margin-top: 20px;
}

.tarea-details {
    border: 2px solid #020202;
    border-radius: 10px;
    padding: 15px;
    text-align: left;
}

.logo {
    border-radius: 10px;
}
</style>