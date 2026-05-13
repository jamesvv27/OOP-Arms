package domain.model;

import domain.enums.*;
import domain.util.interfaces.Personalizable;

public class DesertEagle extends Pistola implements Personalizable{

    // Alternar entre Variante Default/(Accesorio.NINGUNO) y Accesorio.CARGADOR_EXPANDIDO

    private Accesorio accesorioActual; // Una sola ranura de accesorios

    public DesertEagle(int dano, String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva,
            int porcentajePrecision, int cadenciaDisparo, Disparo modoDisparo,
            Accesorio accesorioActual) {
        super(32, "Desert Eagle", 0, 8,
            16, 70,
            7,
                Disparo.SOLO);
                this.accesorioActual = Accesorio.NINGUNO;
    }

    public Accesorio getAccesorioActual(){
        return accesorioActual;
    }

    /*
        Comparar el accesorio deseado ciclando en agregarAccesorio(); verificar si 
        el Accesorio deseado es igual a cada uno de los accesorios disponibles

        Verificar si el accesorio a agregar es distinto al actual en estaAccesorioOcupado()
        --> Asegurarse de que CARGADOR_EXPANDIDO no se encuentre activado.

        Si se va a agregar un accesorio, solo podra ser CARGADOR_EXPANDIDO
     */

    @Override
    public int agregarAccesorio(Accesorio deseado) {
        if(esMismoAccesorio(deseado, Accesorio.CARGADOR_EXPANDIDO)){
            agregarAccesorioMag();
            return 1; // Detener cuando se encuentra una coincidencia
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
        setDimensionCargador(8);
    }

    // Unico accesorio disponible para Desert Eagle
    private void agregarAccesorioMag(){ // Mag => CARGADOR_EXPANDIDO
        if(!estaAccesorioOcupado(Accesorio.CARGADOR_EXPANDIDO, "Agregar Cargador Ext")){
            setAccesorio(Accesorio.CARGADOR_EXPANDIDO);
            setDimensionCargador(20);
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
