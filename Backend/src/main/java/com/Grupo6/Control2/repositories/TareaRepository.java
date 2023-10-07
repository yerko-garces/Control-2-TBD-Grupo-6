package com.Grupo6.Control2.repositories;

import com.Grupo6.Control2.models.Tarea;

import java.util.List;

public interface TareaRepository {
    public Tarea crearTarea(Tarea tarea);

    public String actualizarTarea(Tarea tarea, Long id);

    public List<Tarea> todasLasTareas();

    public void borrarTarea(Long id);
}
