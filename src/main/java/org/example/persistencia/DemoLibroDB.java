package org.example.persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.SocketHandler;

public class DemoLibroDB {
    public DemoLibroDB() {
    }

    public void insertarStatement(){
        String elTitulo = "Arrancame la vida";
        String elAutor = "Angeles Matreta";
        try{
            Statement stm = ConexionSingleton.getInstance("librosDB.db").getConnection().createStatement();

            String sqlInsert = "INSERT INTO libros(titulo,values) VALUES('"+elTitulo+"','"+elAutor+"')";
            int rowCount = stm.executeUpdate(sqlInsert);
            System.out.println("Se insertaron " + rowCount + " registros ");

        }catch (SQLException sqle){
            System.out.println("Error al conectar " + sqle.getMessage());
        }



    }
    public void insertarPreparedStatement(){
        String elTitulo = "El principito";
        String elAutor = "No me acuerdo";
        String sqlInsert = "INSERT INTO libros (titulo,autor) VALUES (?,?)";
        try{
            PreparedStatement pstm = ConexionSingleton.getInstance("librosDB.db").getConnection().prepareStatement(sqlInsert);
            pstm.setString(1,elTitulo);
            pstm.setString(2,elAutor);
            int rowCount = pstm.executeUpdate();
            System.out.println("Se insertaron " + rowCount + " registros ");

        }catch(SQLException sqle){
            System.out.println("Error Prepared statement " + sqle.getMessage());
        }


    }
}
