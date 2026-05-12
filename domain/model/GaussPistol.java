package domain.model;

import domain.enums.Disparo;

public class GaussPistol extends Pistola{

    public GaussPistol(String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva,
            int porcentajePrecision, int cadenciaDisparo, Disparo modoDisparo) {
        super("PPK12 Gauss Pistol", 0,
                12, 24, 
                90, 4,
                Disparo.SOLO);
    }
    
}
