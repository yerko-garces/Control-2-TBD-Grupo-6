package com.Grupo6.Control2.Services;

import com.Grupo6.Control2.models.Tarea;
import com.Grupo6.Control2.repositories.TareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
public class TareaServices {

    private final TareaRepository tareaRepository;

    TareaServices(TareaRepository TareaRepository){this.tareaRepository = TareaRepository;}

    @PostMapping("/CrearTarea")
    @ResponseBody
    public Tarea crearTarea(@RequestBody Tarea tarea){
        Tarea resultado = tareaRepository.crearTarea(tarea);
        return resultado;
    }

    @DeleteMapping("BorrarTarea/{id_tarea}")
    public void borrarTarea(@PathVariable("id_tarea") Long id_tarea){
        tareaRepository.borrarTarea(id_tarea);
    }

    @PutMapping("ActualizarTarea/{id_tarea}")
    @ResponseBody
    public void actualizarTarea(@RequestBody Tarea tarea, @PathVariable("id_tarea") Long id_tarea){
        tareaRepository.actualizarTarea(tarea, id_tarea);
    }

    @GetMapping("MostrarTarea")
    public ArrayList<Tarea> obtenerTareas(){return (ArrayList<Tarea>) tareaRepository.todasLasTareas();}
}