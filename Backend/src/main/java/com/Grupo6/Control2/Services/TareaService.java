package com.Grupo6.Control2.Services;

import com.Grupo6.Control2.models.Tarea;
import com.Grupo6.Control2.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TareaService {
    private final TareaRepository tareaRepository;

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    public TareaService(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }

    public Tarea crearTarea(Tarea tarea){
        tareaRepository.crearTarea(tarea);
        return tarea;
    }
    public void borrarTarea(Long id_tarea){
        tareaRepository.borrarTarea(id_tarea);
    }
    public void actualizarTarea(Tarea tarea){
        tareaRepository.actualizarTarea(tarea);
    }
    public ArrayList<Tarea> obtenerTareas(){
        return tareaRepository.todasLasTareas();
    }
    public Tarea obtenerTarea(Long id_tarea){
        return tareaRepository.obtenerTareaPorId(id_tarea);
    }
    public ArrayList<Tarea> obtenerTareasPorUsuario(String nombre_usuario){
        Long id_usuario = usuarioService.obtenerIdUsuarioPorNombre(nombre_usuario);
        System.out.println(id_usuario);
        return (ArrayList<Tarea>) tareaRepository.obtenerTareasPorUsuario(id_usuario);
    }

    public Tarea crearTareaSinID(Tarea tarea){
        tareaRepository.crearTareaSinID(tarea);
        return tarea;
    }
}
