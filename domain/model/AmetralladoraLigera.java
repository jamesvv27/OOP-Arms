package domain.model;

import domain.util.interfaces.ModoAutomatico;
import domain.enums.Disparo;

public class AmetralladoraLigera extends Arma implements ModoAutomatico{

    private int numeroDisparos;

    public AmetralladoraLigera(String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva,
            int porcentajePrecision, int cadenciaDisparo, Disparo modoDisparo,
            int numeroDisparos){
            super(nombreArma, cargadorActual, dimensionCargador, municionReserva, porcentajePrecision, cadenciaDisparo, Disparo.AUTOMATICO);
            this.numeroDisparos = 14;
    } 

    @Override
    public void disparar(){
        int n_Balas = calcularDisparos();
        if(puedeDisparar()){
            // cargadorActual -= disparosPosibles
            setCargadorActual(getCargadorActual() - n_Balas);
        }
        System.out.print(getNombreArma() + "dispara " + n_Balas + " balas en " + obtenerModoDisparo());
    }

    @Override
    public int cambiarModoDisparo(){

        if(!esModoEsperado(Disparo.AUTOMATICO, "Cambiar por AUTOMATICO")){
            alternarModoDisparo();
            return 0;
        }

        return 1;

    }

    @Override
    public String obtenerModoDisparo(){

        if(esModoEsperado(Disparo.AUTOMATICO, "Mostrar disparo AUTOMATICO")){
            return "RAFAGA";
        }
        return "DISPARO " + getModoDisparo(); //Retorna cualesquiera que el modo sea

    }

    public int getNumeroDisparos(){
        return numeroDisparos;
    }

    private int calcularDisparos(){
        return getCargadorActual() < this.numeroDisparos ? getCargadorActual() : this.numeroDisparos;
    }

    private void alternarModoDisparo(){
        setModoDisparo(Disparo.AUTOMATICO);
        alternarARafaga();
    }

    private void alternarARafaga(){
        this.numeroDisparos = 14;
    }

    private boolean esModoEsperado(Disparo esperado, String accion){
        if(getModoDisparo() != esperado){
            System.out.print("modoDisparo actual " + getModoDisparo() +
                " es distinto a " + esperado + ". Se va a " + accion
            );
            return false;
        }
        return true;
    }

}