package domain.model;

import domain.enums.Accesorio;
import domain.enums.Disparo;
import domain.util.interfaces.Personalizable;

public class NineMauser extends Pistola implements Personalizable{

    private Accesorio accesorioActual;

    public NineMauser(String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva,
            int porcentajePrecision, int cadenciaDisparo, Disparo modoDisparo,
            Accesorio accesorioActual) {
        super("9mm Mauser", 0, 7,
            14, 60,
            4,
                Disparo.SOLO);
                this.accesorioActual = Accesorio.NINGUNO;
    }

    @Override
    public int agregarAccesorio(Accesorio deseado) {
        if(esMismoAccesorio(deseado, Accesorio.BROOMHANDLE)){
            agregarAccesorioBroom();
            return 1; // Detener cuando se encuentra una coincidencia
        }
        return 0;
    }

    public Accesorio getAccesorioActual(){
        return accesorioActual;
    }

    // Accesorio para 9mm Mauser
    private void agregarAccesorioBroom(){ // => Broomhandle
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
