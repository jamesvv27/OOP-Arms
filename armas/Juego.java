package armas;

import domain.model.FnFal;

public class Juego {
    
    public static void main(String[] args) {
        FnFal fal = new FnFal();
        fal.desplegarEstado();

        fal.recargar();

        fal.desplegarEstado();

        fal.disparar();

        fal.desplegarEstado();

        System.out.println("Disparos: " + fal.getNumeroDisparos());
    }
}
