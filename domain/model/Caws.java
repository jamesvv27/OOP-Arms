package domain.model;

import domain.enums.Disparo;

public class Caws extends Escopeta {

    public Caws(String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva,
            int porcentajePrecision, int cadenciaDisparo, Disparo modoDisparo, int numeroDisparos) {
        super("H&K CAWS", 0,
                10, 20,
                40, 9, 
                modoDisparo, numeroDisparos
            );
    }
    
}
