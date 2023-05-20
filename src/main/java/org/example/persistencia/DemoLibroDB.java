package org.example.persistencia;

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

    }
}
