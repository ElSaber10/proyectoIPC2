package com.ipc2.todoweb.data;

import com.ipc2.todoweb.model.Libro;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDB {
    private Connection conexion;

    public LibroDB(Connection conexion) {
        this.conexion = conexion;
    }
    public void insertar(Libro libro) {
        String query = "INSERT INTO LIBROS (nombre, costo, autor, categoria_id) VALUES (?, ?, ?, ?)";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, libro.getNombre());
            preparedStatement.setInt(2, (int) libro.getPrecio());
            preparedStatement.setString(3, libro.getAutor());
            preparedStatement.setInt(4, libro.getCategoria());
            preparedStatement.executeUpdate();
            System.out.println("Libro creado");
        } catch (SQLException e) {
            System.out.println("Error al crear libro: " + e);
        }
    }
    public void actualizar(Libro libro) {
        String query = "UPDATE LIBROS SET nombre = ?, costo = ?, autor = ?, categoria_id = ?, WHERE isbn = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, libro.getNombre());
            preparedStatement.setFloat(2, libro.getPrecio());
            preparedStatement.setString(3, libro.getAutor());
            preparedStatement.setInt(4, libro.getCategoria());
            preparedStatement.executeUpdate();
            System.out.println("libro actualizada");
        } catch (SQLException e) {
            System.out.println("Error al actualizar tarea: " + e);
        }
    }

    public List<Libro> listar() {
        //String sql = "select * from LIBROS order by id desc";
        String query = "SELECT * FROM LIBROS order by isbn asc";
        List<Libro> libros = new ArrayList<>();
        System.out.println("entrando a la consulta");
        try (var preparedStatement = conexion.prepareStatement(query)) {
            //preparedStatement.setInt(1, isbn1);
            try (var resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    var isbn = resultSet.getInt("isbn");
                    var nombre = resultSet.getString("nombre");
                    var costo = resultSet.getFloat("costo");
                    var autor = resultSet.getString("autor");
                    var categoria_id = resultSet.getInt("categoria_id");

                    var libro = new Libro(isbn,nombre,costo,autor,categoria_id);
                    libros.add(libro);
                    System.out.println("mandando la lista " + libros);
                }
            }
        }catch (SQLException e) {
            System.out.println("Error al consultar: " + e);
        }
        return libros;
    }



}
