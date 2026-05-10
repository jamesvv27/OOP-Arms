package domain.model;

public class RifleAsalto extends Arma{

    public RifleAsalto(String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva,
            int porcentajePrecision, int cadenciaDisparo) {
        super(nombreArma, cargadorActual, dimensionCargador, municionReserva, porcentajePrecision, cadenciaDisparo);
    }

    @Override
    public void disparar(){
        
    }

}