package repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import domain.model.Arma;
import exceptions.ArchivoArmaException;

public class CvsArmaRepository implements ArmaRepository  {
    private final String ruta;

    public CvsArmaRepository(String ruta){
        this.ruta = ruta;
    }


    @Override // Reparar ruta de ArchivoPersonajeException
    public List<Arma> getListaArma() throws ArchivoPersonajeException {
        
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
            throw new ArchivoArmaException("No se pudieron cargar las armas desde CSV", e);
        }
        return armas;

        
    }

    

}