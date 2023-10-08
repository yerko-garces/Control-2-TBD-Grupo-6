package com.Grupo6.Control2.Controllers;

import com.Grupo6.Control2.Services.TareaService;
import com.Grupo6.Control2.models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
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

    @DeleteMapping("BorrarTarea/{id_tarea}")
    public void borrarTarea(@PathVariable("id_tarea") Long id_tarea){
        tareaService.borrarTarea(id_tarea);
    }

    @PutMapping("ActualizarTarea/{id_tarea}")
    @ResponseBody
    public void actualizarTarea(@RequestBody Tarea tarea, @PathVariable("id_tarea") Long id_tarea){
        tareaService.actualizarTarea(tarea, id_tarea);
    }

    @GetMapping("MostrarTareas")
    public ArrayList<Tarea> obtenerTareas(){return tareaService.obtenerTareas();}

    @GetMapping("MostrarPorUsuario/{id_usuario}")
    public ArrayList<Tarea> obtenerTareasPorUsuario(@PathVariable("id_usuario") Long id_usuario){
        return tareaService.obtenerTareasPorUsuario(id_usuario);
    }
}