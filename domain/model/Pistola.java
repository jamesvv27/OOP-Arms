package domain.model;

import domain.enums.Disparo;

public class Pistola extends Arma{
    
    public Pistola(int dano, String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva,
            int porcentajePrecision, int cadenciaDisparo){
        super(dano, nombreArma, cargadorActual, dimensionCargador, municionReserva, porcentajePrecision, cadenciaDisparo, Disparo.SOLO);
    }

    @Override
    public void disparar(){
        /*
        Siempre dispara 1 bala
         */
        if(puedeDisparar()){
            // cargadorActual--
            setCargadorActual(getCargadorActual() - 1);
            System.out.print(getNombreArma() + " dispara 1 bala " + obtenerInfoDisparo());
        }
        
    }

    public int alternarModoDisparo(){

        if(esModoEsperado(Disparo.APUNTADO, "Cambiar por SOLO")){
            cambiarPorSolo();
            return 1;
        }

        if(esModoEsperado(Disparo.SOLO, "Cambiar por APUNTADO")){
            cambiarPorApuntado();
            return 2;
        }

        return 0;
    }

    public String obtenerInfoDisparo(){

        /*
        Mostrar el modo de disparo con respecto a domain/enums/Disparo
         */

        if(esModoEsperado(Disparo.APUNTADO, "Mostrar APUNTADO")){
            return "APUNTANDO";
        }

        if(esModoEsperado(Disparo.SOLO, "Mostrar SOLO")){
            return "SIN APUNTAR";
        }

        return "en disparo " + getModoDisparo();
    }

    private void cambiarPorApuntado(){
        setModoDisparo(Disparo.APUNTADO);
    }

    private void cambiarPorSolo(){
        setModoDisparo(Disparo.SOLO);
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
