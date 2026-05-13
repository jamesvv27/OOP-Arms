package domain.model;

import domain.enums.Disparo;

public class LightSupport extends AmetralladoraLigera{

    public LightSupport(String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva,
            int porcentajePrecision, int cadenciaDisparo, Disparo modoDisparo, int numeroDisparos) {
        super("Light Support Weapon", 0,
                30, 60, 
                85, 2, 
                modoDisparo, numeroDisparos);
    }
    
}
