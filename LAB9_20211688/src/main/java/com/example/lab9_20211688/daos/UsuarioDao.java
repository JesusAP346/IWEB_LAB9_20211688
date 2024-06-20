package com.example.lab9_20211688.daos;

import com.example.lab9_20211688.beans.LicenciaB;
import com.example.lab9_20211688.beans.PaisB;
import com.example.lab9_20211688.beans.UsuarioB;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.*;

public class UsuarioDao  extends BaseDao{

    public ArrayList<UsuarioB> listarUsuariosOperativos() {

        String sql = "select \n" +
                "usuario.idUsuario,\n" +
                "usuario.nombres,\n" +
                "usuario.apellidos,\n" +
                "licencia.categoria,\n" +
                "licencia.fecha_emision,\n" +
                "licencia.fecha_caducidad,\n" +
                "pais.nombre_pais\n" +
                "from usuario\n" +
                "join licencia on usuario.licencia_idlicencia =  licencia.idlicencia\n" +
                "join pais on licencia.pais_idpais = pais.idpais\n" +
                "where rol_idrol = 1;" ;


        ArrayList<UsuarioB> listaUsuarios = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                UsuarioB usuarioB = new UsuarioB();
                usuarioB.setIdUsuario(rs.getInt(1));
                usuarioB.setNombre(rs.getString(2));
                usuarioB.setApellido(rs.getString(3));
                LicenciaB licencia = new LicenciaB();
                licencia.setCategoria(rs.getString(4));
                licencia.setFecha_emision(rs.getString(5));
                licencia.setFecha_caducidad(rs.getString(6));

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                String fechaActual = "2024-06-19";
                LocalDate fechaActual_Date = LocalDate.parse(fechaActual,formatter);
                LocalDate emision = LocalDate.parse(licencia.getFecha_emision(),formatter);
                LocalDate caducidad = LocalDate.parse(licencia.getFecha_caducidad(),formatter);


                if(fechaActual_Date.isAfter(emision) && fechaActual_Date.isBefore(caducidad)){
                    licencia.setEstado("vigente");
                }
                else{
                    licencia.setEstado("no vigente");
                }

                PaisB pais = new PaisB();
                pais.setNombre(rs.getString(7));
                licencia.setPais(pais);
                usuarioB.setLicenciaB(licencia);

                listaUsuarios.add(usuarioB);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return listaUsuarios;
    }
}
