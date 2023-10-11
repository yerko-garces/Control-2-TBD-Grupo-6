package com.Grupo6.Control2.repositories;

import com.Grupo6.Control2.models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TareaRepositoryImp implements  TareaRepository{

    private final Sql2o sql2o;

    @Autowired
    public TareaRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Tarea crearTarea(Tarea tarea) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Tarea (id_tarea, titulo, descripcion, vencimiento, id_usuario)" +
                    "VALUES (:id_tarea, :titulo, :descripcion, :vencimiento, :id_usuario)";
            conn.createQuery(sql, true)
                    .addParameter("id_tarea", tarea.getId_tarea())
                    .addParameter("titulo", tarea.getTitulo())
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("vencimiento", tarea.getVencimiento())
                    .addParameter("id_usuario", tarea.getId_usuario())
                    .executeUpdate();
            return tarea;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String actualizarTarea(Tarea tarea) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Tarea SET titulo=:titulo, descripcion=:descripcion, vencimiento=:vencimiento, id_usuario=:id_usuario WHERE id_tarea=:id_tarea" ;
            conn.createQuery(sql)
                    .addParameter("id_tarea", tarea.getId_tarea())
                    .addParameter("titulo", tarea.getTitulo())
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("vencimiento", tarea.getVencimiento())
                    .addParameter("id_usuario", tarea.getId_usuario())
                    .executeUpdate();
            return "Se actualizo la tarea";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Tarea> todasLasTareas() {
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * FROM Tarea";
            return (ArrayList<Tarea>) conn.createQuery(sql).executeAndFetch(Tarea.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrarTarea(Long id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM Tarea WHERE id_tarea=:id_tarea")
                    .addParameter("id_tarea", id)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Tarea obtenerTareaPorId(Long id_tarea) {
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * FROM Tarea WHERE id_tarea=:id_tarea";
            return conn.createQuery(sql)
                    .addParameter("id_tarea", id_tarea)
                    .executeAndFetchFirst(Tarea.class);
    }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea> obtenerTareasPorUsuario(Long id_usuario) {
        try (Connection con = sql2o.open()) {
            String query = "SELECT * FROM Tarea WHERE id_usuario = :id_usuario";

            // Ejecuta la consulta y obtén una lista de objetos Tarea
            List<Tarea> tareas = con.createQuery(query)
                    .addParameter("id_usuario", id_usuario)
                    .executeAndFetch(Tarea.class);

            // Itera sobre la lista de tareas y realiza las operaciones necesarias
            for (Tarea tarea : tareas) {
                System.out.println(tarea.toString());
            }
            return tareas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea crearTareaSinID(Tarea tarea) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Tarea (titulo, descripcion, vencimiento, id_usuario, status)" +
                    "VALUES (:titulo, :descripcion, :vencimiento, :id_usuario, :status)";
            conn.createQuery(sql, true)
                    .addParameter("titulo", tarea.getTitulo())
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("vencimiento", tarea.getVencimiento())
                    .addParameter("id_usuario", tarea.getId_usuario())
                    .addParameter("status", tarea.isStatus())
                    .executeUpdate();
            return tarea;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public void actualizarEstatus(Long id_tarea, boolean status){
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Tarea SET status=:status WHERE id_tarea=:id_tarea" ;
            conn.createQuery(sql)
                    .addParameter("id_tarea", id_tarea)
                    .addParameter("status", status )
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}



















