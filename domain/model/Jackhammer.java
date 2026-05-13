package domain.model;

import domain.enums.Disparo;

public class Jackhammer extends Escopeta{

    public Jackhammer(String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva,
            int porcentajePrecision, int cadenciaDisparo, Disparo modoDisparo, int numeroDisparos) {
        super(29, "Pancor Jackhammer", 0,
                12, 24,
                50, 7,
                modoDisparo, numeroDisparos
            );
    }
    
}
