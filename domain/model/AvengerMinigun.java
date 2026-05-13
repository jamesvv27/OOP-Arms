package domain.model;

import domain.enums.Disparo;

public class AvengerMinigun extends AmetralladoraLigera{

    public AvengerMinigun(String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva,
            int porcentajePrecision, int cadenciaDisparo, Disparo modoDisparo, int numeroDisparos) {
        super("Avenger Minigun", 0, 
                120, 240,
                70, 1,
                modoDisparo, numeroDisparos);
    }
    
}
