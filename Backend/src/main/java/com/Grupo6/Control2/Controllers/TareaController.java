package com.Grupo6.Control2.Controllers;

import com.Grupo6.Control2.Services.TareaService;
import com.Grupo6.Control2.models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Tarea")
public class TareaController {

    private TareaService tareaService;

    @Autowired
    TareaController(TareaService tareaService){this.tareaService = tareaService;}

    @PostMapping("/CrearTarea")
    @ResponseBody
    public Tarea crearTarea(@RequestBody Tarea tarea){
        Tarea resultado = tareaService.crearTarea(tarea);
        return resultado;
    }

    @PostMapping("/CrearTarea2")
    @ResponseBody
    public ResponseEntity<String> crearTarea2(@RequestBody Tarea tarea){
        tarea.setStatus(true);
        tareaService.crearTareaSinID(tarea);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body("Tarea exitosa");
    }

    @DeleteMapping("BorrarTarea/{id_tarea}")
    public void borrarTarea(@PathVariable("id_tarea") Long id_tarea){
        tareaService.borrarTarea(id_tarea);
    }

    @PostMapping("ActualizarTarea")
    @ResponseBody
    public void actualizarTarea(@RequestBody Tarea tarea){
        System.out.println("Esta es la tarea: "+tarea.getVencimiento());
        tareaService.actualizarTarea(tarea);
    }

    @GetMapping("/MostrarTareas")
    public ArrayList<Tarea> obtenerTareas(){

        System.out.println("Recibida solicitud para obtener tareas");
        ArrayList<Tarea> tareas = tareaService.obtenerTareas();
        System.out.println("Tareas obtenidas: " + tareas);

        return tareas;}

    @GetMapping("/MostrarPorUsuario/{nombre_usuario}")
    public ArrayList<Tarea> obtenerTareasPorUsuario(@PathVariable("nombre_usuario") String nombre_usuario){
        System.out.println(nombre_usuario);
        return tareaService.obtenerTareasPorUsuario(nombre_usuario);
    }

    @PutMapping("/CambiarStatus/{id_tarea}")
    public void cambiarStatus(@PathVariable("id_tarea") Long id_tarea){
        System.out.println("entro a cambiar status");
        tareaService.cambiarStatus(id_tarea);
    }

    @GetMapping("/ObtenerAtrasadas/{nombre_usuario}")
    public ArrayList<Tarea> obtenerTareasAtrasadas(@PathVariable("nombre_usuario") String nombre_usuario){
        System.out.println(nombre_usuario);
        return tareaService.obtenerTareasAtrasadas(nombre_usuario);
    }
}