package domain.model;

import domain.enums.Disparo;

public class GaussRifle extends Francotirador {

    public GaussRifle(String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva,
            int porcentajePrecision, int cadenciaDisparo, Disparo modoDisparo) {
        super("M72 Gauss Rifle", 0,
                6, 12,
                95, 12,
                modoDisparo);
    }
    
}
