package domain.model;

import domain.enums.Accesorio;
import domain.enums.Disparo;
import domain.util.interfaces.Personalizable;

public class Ak112 extends RifleAsalto implements Personalizable{
    
    private Accesorio accesorioActual;
    
    public Ak112(String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva,
            int porcentajePrecision, int cadenciaDisparo, Disparo modoDisparo, int numeroDisparos) {
        super("AK-112", 0,
                24, 48,
                65, 3,
                modoDisparo, numeroDisparos
            );
            this.accesorioActual = Accesorio.NINGUNO;
    }

    @Override
    public int agregarAccesorio(Accesorio deseado) {
        if(esMismoAccesorio(deseado, Accesorio.BROOMHANDLE)){
            agregarAccesorioMag();
            return 1;
        }
        return 0;
    }

    public void removerAccesorio(){
        if(!estaAccesorioOcupado(Accesorio.NINGUNO, "Remover Accesorio")){
            setAccesorio(Accesorio.NINGUNO);
        }
    }

    public Accesorio getAccesorioActual(){
        return accesorioActual;
    }

    private void agregarAccesorioMag(){
        if(!estaAccesorioOcupado(Accesorio.CARGADOR_EXPANDIDO, "Agregar Cargador Ext"))
            setAccesorio(Accesorio.CARGADOR_EXPANDIDO);
    }

    private void setAccesorio(Accesorio nuevoAccesorio){
        this.accesorioActual = nuevoAccesorio;
    }

    private boolean estaAccesorioOcupado(Accesorio esperado, String accion){
        if(getAccesorioActual() == esperado){
            System.out.print("No se puede " + accion + " cuando accesorioActual = " +
                getAccesorioActual() + ". Esperado = " + esperado
            );
            return true;
        }
        return false;
    }

    private boolean esMismoAccesorio(Accesorio deseado, Accesorio buscado){
        return deseado == buscado;
    }

}
