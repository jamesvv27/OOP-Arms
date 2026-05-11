package domain.model;

import domain.util.interfaces.ModoAutomatico;
import domain.enums.Disparo;

public class RifleAsalto extends Arma implements ModoAutomatico{

    private int numeroDisparos;

    public RifleAsalto(String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva,
            int porcentajePrecision, int cadenciaDisparo, Disparo modoDisparo,
            int numeroDisparos) {
        super(nombreArma, cargadorActual, dimensionCargador, municionReserva, porcentajePrecision, cadenciaDisparo, Disparo.SOLO);
        this.numeroDisparos = 1;
    }

    @Override
    public void disparar(){
        int n_Balas = calcularDisparosPosibles();
        if(puedeDisparar()){
            setCargadorActual(getCargadorActual() - n_Balas);
        }
        System.out.print(getNombreArma() + "dispara " + n_Balas + " balas en " + obtenerModoDisparo());
    }

    @Override
    public int cambiarModoDisparo(){

        if(esModoEsperado(Disparo.SOLO, "Cambiar por APUNTADO")){
            cambiarPorApuntado();
            return 1;
        }
            

        if(esModoEsperado(Disparo.APUNTADO, "Cambiar por AUTOMATICO")){
            cambiarPorAutomatico();
            return 2;
        }
            

        if(esModoEsperado(Disparo.AUTOMATICO, "Cambiar por SOLO")){
            cambiarPorSolo();
            return 3;
        }
        
        return 0;
    }

    @Override
    public String obtenerModoDisparo(){
        if(esModoEsperado(Disparo.AUTOMATICO, "Mostrar disparo AUTOMATICO")){
            return "RAFAGA";
        }
        return "DISPARO UNICO";
    }

    public int getNumeroDisparos(){
        return numeroDisparos;
    }

    private void cambiarPorSolo(){
        setModoDisparo(Disparo.SOLO);
        alternarUnico();
    }

    private int calcularDisparosPosibles(){
        return getCargadorActual() < this.numeroDisparos ? getCargadorActual() : this.numeroDisparos;
    }

    private void cambiarPorApuntado(){
        setModoDisparo(Disparo.APUNTADO);
        alternarUnico();
    }

    private void cambiarPorAutomatico(){
        setModoDisparo(Disparo.AUTOMATICO);
        alternarRafaga();
    }

    private void alternarUnico(){
        this.numeroDisparos = 1;
    }

    private void alternarRafaga(){
        this.numeroDisparos = 8;
    }

    private boolean esModoEsperado(Disparo esperado, String accion){
        if(getModoDisparo() != esperado){
            System.out.print("No se puede " + accion + "cuando modoDisparo = "
                + getModoDisparo()
            );
            return false;
        }
        return true;
    }
}