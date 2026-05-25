package repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import domain.model.Arma;

public class CvsArmaRepository implements ArmaRepository{
    private final String ruta;

    public CvsArmaRepository(String ruta){
        this.ruta = ruta;
    }


    @Override
    public List<Arma> getListaArma() {
        
        final List<Arma> armas = new ArrayList<>();

        try {
            final BufferedReader reader = new BufferedReader(new FileReader(ruta));
            String linea;
            reader.readLine();//opcional dependiendo el caso

            while ((linea = reader.readLine()) != null) {
                final String[] columnas = linea.split(",");
                final ArmaData data = new ArmaData(linea, 0, 0, null, null, null, null, null, null, 0, 0);
                final Arma arma = ArmaFactory.crearDesdeData(data);
                armas.add(arma);
            }
            reader.close();
        } catch(Exception e) {
            System.out.println("Error leyendo el archiv CSV");
            System.out.println(e.getMessage());
        }
        return armas;

        
    }

    

}