package com.Grupo6.Control2.repositories;

import com.Grupo6.Control2.models.Tarea;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface TareaRepository {
    public Tarea crearTareaSinID(Tarea tarea);
    public Tarea crearTarea(Tarea tarea);

    public String actualizarTarea(Tarea tarea);

    public ArrayList<Tarea> todasLasTareas();

    public void borrarTarea(Long id);

    public Tarea obtenerTareaPorId(Long id_tarea);
    public List<Tarea> obtenerTareasPorUsuario(Long id_usuario);
}
