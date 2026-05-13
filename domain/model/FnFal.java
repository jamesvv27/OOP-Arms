package domain.model;

import domain.enums.Accesorio;
import domain.enums.Disparo;
import domain.util.interfaces.Personalizable;

public class FnFal extends RifleAsalto implements Personalizable{

    /*
        A cada ranura le corresponde un accesorio

        ranura1 => HPFA
        ranura 2 => MIRA_NOCTURNA
    */

    private Accesorio ranura1;
    private Accesorio ranura2;

    public FnFal(String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva,
            int porcentajePrecision, int cadenciaDisparo, Disparo modoDisparo, int numeroDisparos,
            Accesorio ranura1, Accesorio ranura2    
        ) {
        super("FN FAL", 0,
                20, 40,
                70, 2,
                modoDisparo, numeroDisparos);
        this.ranura1 = Accesorio.NINGUNO;
        this.ranura2 = Accesorio.NINGUNO;
    }

    @Override
    public int agregarAccesorio(Accesorio accesorio) {
        if(esMismoAccesorio(accesorio, Accesorio.HPFA)){
            agregarAccesorioHpfa();
            return 1;
        }
        if(esMismoAccesorio(accesorio, Accesorio.MIRA_NOCTURNA)){
            agregarAccesorioMira();
            return 2;
        }
        return 0;
    }

    public Accesorio getRanura1(){
        return ranura1;
    }

    public Accesorio getRanura2(){
        return ranura2;
    }

    private void agregarAccesorioHpfa(){ // => HPFA High Power Full Automatic
        if(!estaRanura1Ocupada(Accesorio.HPFA, "Agregar HPFA"))
            setRanura1(Accesorio.HPFA);
    }

    private void agregarAccesorioMira(){ // => MIRA_NOTCURNA
        if(!estaRanura2Ocupada(Accesorio.MIRA_NOCTURNA, "Agregar Nightsight"))
            setRanura2(Accesorio.MIRA_NOCTURNA);
    }

    private void setRanura1(Accesorio nuevoAccesorio){ // Corresponde a HPFA
        this.ranura1 = nuevoAccesorio;
    }

    private void setRanura2(Accesorio nuevoAccesorio){ // Corresponde a MIRA_NOCTURNA
        this.ranura2 = nuevoAccesorio;
    }

    private boolean esMismoAccesorio(Accesorio deseado, Accesorio comparado){
        return deseado == comparado;
    }

    private boolean estaRanura1Ocupada(Accesorio solicitado, String accion){
        if(getRanura1() != solicitado){
            return false;
        }
            System.out.print("No se puede " + accion + 
            "mientras Ranura1 este ocupada por " + getRanura1()
            + " Solicitado = " + solicitado
            );

        return true;
    }

    private boolean estaRanura2Ocupada(Accesorio solicitado, String accion){
        if(getRanura2() != solicitado){
            return false;
        }
            System.out.print("No se puede " + accion + 
            "mientras Ranura2 este ocupada por " + getRanura2()
            + " Solicitado = " + solicitado
            );

        return true;
    }

}
