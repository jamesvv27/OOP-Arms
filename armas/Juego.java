package armas;

import domain.enums.Accesorio;
import domain.model.FnFal;

public class Juego {
    
    public static void main(String[] args) {
        FnFal fal = new FnFal();
        fal.desplegarEstado();

        fal.recargar();

        fal.desplegarEstado();

        fal.disparar();

        fal.desplegarEstado();

        fal.cambiarModoDisparo();

        fal.disparar();

        fal.desplegarEstado();

        fal.cambiarModoDisparo();

        fal.desplegarEstado();

        fal.disparar();

        fal.desplegarEstado();

        fal.recargar();

        fal.agregarAccesorio(Accesorio.HPFA);
        
        fal.desplegarEstado();

        fal.disparar();

        fal.desplegarEstado();

        fal.agregarAccesorio(Accesorio.MIRA_NOCTURNA);

        fal.cambiarModoDisparo(); // cambiarModoDisparo es un toggle para 3 opciones

        fal.cambiarModoDisparo();

        fal.disparar();

        fal.desplegarEstado();
    }
}
