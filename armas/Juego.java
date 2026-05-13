package armas;

import domain.enums.Accesorio;
import domain.model.Caws;
import domain.model.FnFal;
import domain.model.LaserRifle;
import domain.model.LightSupport;
import domain.model.NineMauser;

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

        fal.removerAccesorio(Accesorio.HPFA);

        fal.desplegarEstado();

        LightSupport ls = new LightSupport();

        ls.desplegarEstado();

        ls.recargar();

        ls.desplegarEstado();

        ls.disparar();

        ls.desplegarEstado();

        ls.disparar();

        ls.disparar();

        ls.desplegarEstado();

        ls.recargar();

        ls.desplegarEstado();

        LaserRifle laser = new LaserRifle();

        laser.desplegarEstado();

        laser.recargar();

        laser.disparar();

        laser.desplegarEstado();

        laser.agregarAccesorio(Accesorio.CARGADOR_EXPANDIDO);

        laser.desplegarEstado();

        Caws hkCaws = new Caws();

        hkCaws.desplegarEstado();

        hkCaws.recargar();

        hkCaws.disparar();

        hkCaws.cambiarModoDisparo();

        hkCaws.disparar();

        hkCaws.desplegarEstado();

        NineMauser mauser = new NineMauser();

        mauser.agregarAccesorio(Accesorio.BROOMHANDLE);

        mauser.recargar();

        mauser.desplegarEstado();

        mauser.disparar();

        mauser.desplegarEstado();
    }
}
