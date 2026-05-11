package domain.model;

import domain.util.interfaces.ModoAutomatico;
import domain.enums.Disparo;

public class RifleAsalto extends Arma implements ModoAutomatico{

    private int numeroDisparos;

    /*
    numeroDisparos => Cantidad de tiros que se disparan en funcion de si se esta en RAFAGA
    o en DISPARO UNICO.
    */

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
            // cargadorActual -= disparosPosibles
            setCargadorActual(getCargadorActual() - n_Balas);
        }
        System.out.print(getNombreArma() + "dispara " + n_Balas + " balas en " + obtenerModoDisparo());
    }

    @Override
    public int cambiarModoDisparo(){

        /*
        Toggle que:
        Cicla por los modos posibles de disparo y los cambia en funcion del modo de disparo actual;
        Solo se puede cambiar a AUTOMATICO si el modo de disparo actual es APUNTADO.

        Cuando se haga un cambio, retorna algo para detener la funcion.
        */

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

        /*
        Cicla por los modos de disparo. RAFAGA unicamente puede estar asociado a AUTOMATICO.
        Si el modo actual es distinto a AUTOMATICO, para RifleAsalto, siempre sera DISPARO UNICO.
        */

        if(esModoEsperado(Disparo.AUTOMATICO, "Mostrar disparo AUTOMATICO")){
            return "RAFAGA";
        }
        return "DISPARO UNICO";
    }

    public int getNumeroDisparos(){
        return numeroDisparos;
    }

    // En el modo rafaga se disparan 8 balas. Si en el cargadorActual solo hay 7, los disparos posibles son 7.
    private int calcularDisparosPosibles(){
        return getCargadorActual() < this.numeroDisparos ? getCargadorActual() : this.numeroDisparos;
    }

    private void cambiarPorApuntado(){
        setModoDisparo(Disparo.APUNTADO);
        alternarUnico(); // DISPARO UNICO esta asociado a APUNTADO
    }

    private void cambiarPorAutomatico(){
        setModoDisparo(Disparo.AUTOMATICO);
        alternarRafaga(); // RAFAGA esta asociado a AUTOMATICO
    }

    private void cambiarPorSolo(){
        setModoDisparo(Disparo.SOLO);
        alternarUnico();
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