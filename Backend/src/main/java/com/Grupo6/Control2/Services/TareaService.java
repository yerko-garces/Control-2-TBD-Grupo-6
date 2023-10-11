package com.Grupo6.Control2.Services;

import com.Grupo6.Control2.models.Tarea;
import com.Grupo6.Control2.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

    public void cambiarStatus(Long id){
        tareaRepository.actualizarEstatus(id,false);
    }

    public ArrayList<Tarea> obtenerTareasPorVencer(String nombre_usuario) {
        ArrayList<Tarea> todasLasTareas = obtenerTareasPorUsuario(nombre_usuario);
        ArrayList<Tarea> tareasPorVencer = new ArrayList<>();

        if (todasLasTareas == null) {
            return null;
        }

        Date hoy = new Date();
        Calendar limite = Calendar.getInstance();
        limite.add(Calendar.DAY_OF_MONTH, 2);
        for (Tarea tarea : todasLasTareas) {
            Date fechaVencimiento = tarea.getVencimiento();
            if (fechaVencimiento.after(hoy) && fechaVencimiento.before(limite.getTime()) && tarea.isStatus()) {
                tareasPorVencer.add(tarea);
            }
        }
        return tareasPorVencer;
    }


}
