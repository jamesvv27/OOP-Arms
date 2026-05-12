package domain.model;

import domain.enums.Disparo;
import domain.util.interfaces.ModoAutomatico;

public class Escopeta extends Arma implements ModoAutomatico{

    /*
        Un arma debe implementar ModoAutomatico y usar Disparo.AUTOMATICO
        si puede disparar en RAFAGA
    */
    
    private int numeroDisparos;

    public Escopeta(String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva,
            int porcentajePrecision, int cadenciaDisparo, Disparo modoDisparo,
            int numeroDisparos){
            super(nombreArma, cargadorActual, dimensionCargador, municionReserva, porcentajePrecision, cadenciaDisparo, Disparo.SOLO);
            this.numeroDisparos = 1;
    }

    @Override
    public void disparar(){
        int n_Cartuchos = calcularDisparosPosibles();
        if(puedeDisparar()){
            setCargadorActual(getCargadorActual() - n_Cartuchos);
            System.out.print(getNombreArma() + "dispara perdigones en " + n_Cartuchos + " en " + obtenerModoDisparo());
        }
    }

    @Override
    public int cambiarModoDisparo(){

        if(esModoEsperado(Disparo.SOLO, "Cambiar por AUTOMATICO")){
            cambiarPorAutomatico();
            return 1;
        }

        if(esModoEsperado(Disparo.AUTOMATICO, "Cambiar por SOLO")){
            cambiarPorSolo();
            return 2;
        }

        return 0;
    }

    @Override 
    public String obtenerModoDisparo(){

        if(esModoEsperado(Disparo.SOLO, "Mostrar SOLO")){
            return "DISPARO UNICO";
        }

        if(esModoEsperado(Disparo.AUTOMATICO, "Mostrar AUTOMATICO")){
            return "RAFAGA";
        }

        return "DISPARO " + getModoDisparo(); //Fallback en caso de que ninguno de los anteriores pase

    }

    public int getNumeroDisparos(){
        return numeroDisparos;
    }

    private int calcularDisparosPosibles(){
        return getCargadorActual() < this.numeroDisparos ? getCargadorActual() : this.numeroDisparos;
    }

    private void cambiarPorAutomatico(){
        setModoDisparo(Disparo.AUTOMATICO);
        alternarRafaga();
    }

    private void cambiarPorSolo(){
        setModoDisparo(Disparo.SOLO);
        alternarUnico();
    }

    private void alternarUnico(){
        this.numeroDisparos = 1;
    }

    private void alternarRafaga(){
        this.numeroDisparos = 6;
    }

    private boolean esModoEsperado(Disparo esperado, String accion){
        if(getModoDisparo() != esperado){
            System.out.print("No se puede " + accion + " cuando modoDisparo =" +
            getModoDisparo()
            );
            return false;
        }
        return true;
    }

}
