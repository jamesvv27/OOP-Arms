package armas;

import java.util.ArrayList;
import java.util.List;
import domain.model.Arma;
import exceptions.ArchivoArmaException;
import repository.ArmaRepository;
import repository.CvsArmaRepository;

public class Juego {
    
    public static void main(String[] args) {

        final ArmaRepository repositoryCsv = new CvsArmaRepository("./armas/data/armas.csv");
        List<Arma> armas = new ArrayList<>();
        
        try{
            armas = repositoryCsv.getListaArma();
        }catch (ArchivoArmaException e){
            e.printStackTrace();
        }
    
        //for each. Recorrer toda la lista de armas e imprimir su informacion
        for(final Arma arma : armas){
            System.out.println(arma.toString());
        }

    }
}
