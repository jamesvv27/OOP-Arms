package domain.model;

import domain.enums.Accesorio;
import domain.util.interfaces.Personalizable;

public class LaserRifle extends Francotirador implements Personalizable{

    private Accesorio accesorioActual;

    public LaserRifle() {
        super(50, "Wattz 2000 Laser Rifle", 0,
                12, 24,
                90, 10
            );
    }
    
    public Accesorio getAccesorioActual(){
        return accesorioActual;
    }

    @Override
    public int agregarAccesorio(Accesorio deseado) {
        if(esMismoAccesorio(deseado, Accesorio.CARGADOR_EXPANDIDO)){
            agregarAccesorioMag();
            return 1;
        }
        return 0;
    }

    public void removerAccesorio(){
        if(estaAccesorioOcupado(Accesorio.CARGADOR_EXPANDIDO, "Remover Accesorio")){
            removerAccesorioMag();
        }
    }

    public void removerAccesorioMag(){
        setAccesorio(Accesorio.NINGUNO);
        setDimensionCargador(12);
    }
    

    // Accesorio para Rifle laser
    private void agregarAccesorioMag(){ //
        if(!estaAccesorioOcupado(Accesorio.CARGADOR_EXPANDIDO, "Agregar Cargador Ext")){
            setAccesorio(Accesorio.CARGADOR_EXPANDIDO);
            setDimensionCargador(24);
        }
    }

    private void setAccesorio(Accesorio nuevoAccesorio){
        this.accesorioActual = nuevoAccesorio;
    }

    private boolean esMismoAccesorio(Accesorio deseado, Accesorio solicitado){
        return deseado == solicitado;
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

}
