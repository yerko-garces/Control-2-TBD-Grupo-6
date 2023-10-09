package com.Grupo6.Control2.models;

import java.time.LocalDate;
import java.util.Date;

public class Tarea {
    private Long id_tarea;
    private String titulo;
    private String descripcion;
    private Date vencimiento;
    private Long id_usuario;

    public Tarea(Long id_tarea, String titulo, String descripcion, Date vencimiento, Long id_usuario) {
        this.id_tarea = id_tarea;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.vencimiento = vencimiento;
        this.id_usuario = id_usuario;
    }
    public Tarea() {
    }
    public Long getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }


}
