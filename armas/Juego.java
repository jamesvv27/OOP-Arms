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

        List<Arma> rifles = new ArrayList<>();

        try{
            rifles = repositoryCsv.getListaArma("RifleAsalto");
        }catch (ArchivoArmaException e){
            e.printStackTrace();
        }
        
        List<Arma> ametralladoras = new ArrayList<>();
        
        try{
            ametralladoras = repositoryCsv.getListaArma("AmetralladoraLigera");
        }catch (ArchivoArmaException e){
            e.printStackTrace();
        }
    
        //for each. Recorrer toda la lista de armas e imprimir su informacion
        for(final Arma arma : rifles){
            System.out.println(arma.toString());
        }

        for(final Arma arma : ametralladoras){
            System.out.println(arma.toString());
        }

    }
}
