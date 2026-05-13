package domain.model;

import domain.enums.Disparo;
import domain.util.interfaces.ModoAutomatico;

public abstract class Escopeta extends Arma implements ModoAutomatico{

    /*
        Un arma debe implementar ModoAutomatico y usar Disparo.AUTOMATICO
        si puede disparar en RAFAGA
    */
    
    private int numeroDisparos;

    public Escopeta(int dano, String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva,
            int porcentajePrecision, int cadenciaDisparo){
            super(dano, nombreArma, cargadorActual, dimensionCargador, municionReserva, porcentajePrecision, cadenciaDisparo, Disparo.SOLO);
            this.numeroDisparos = 1;
    }

    @Override
    public void disparar(){
        int n_Cartuchos = calcularDisparosPosibles();
        if(puedeDisparar()){
            setCargadorActual(getCargadorActual() - n_Cartuchos);
            System.out.print(getNombreArma() + " dispara perdigones en " + n_Cartuchos + " cartuchos en " + obtenerModoDisparo() + "\n");
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

        if(esModoEsperado(Disparo.SOLO)){
            return "DISPARO UNICO";
        }

        if(esModoEsperado(Disparo.AUTOMATICO)){
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

    private boolean esModoEsperado(Disparo esperado){
        return getModoDisparo() == esperado;
    }

}
