
package domain.model;


public abstract class Arma
{
    private String nombreArma;
    private int cargadorActual;
    private int dimensionCargador;
    private int municionReserva;
    private int porcentajePrecision;
    private int cadenciaDisparo;

    public Arma(String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva, int porcentajePrecision, int cadenciaDisparo)
    {
        this.nombreArma = nombreArma;
        this.cargadorActual = cargadorActual;
        this.dimensionCargador = dimensionCargador;
        this.municionReserva = municionReserva;
        this.porcentajePrecision = porcentajePrecision;
        this.cadenciaDisparo = cadenciaDisparo;
    }

    public int getCargadorActual()
    {
        return cargadorActual;
    }

    public int getDimensionCargador()
    {
        return dimensionCargador;
    }

    public int getMunicionReserva()
    {
        return municionReserva;
    }

    public int getPorcentajePrecision()
    {
        return porcentajePrecision;
    }
    
    public abstract void disparar();
    
    public void recargar(){
        if(puedeRecargar()){
            
        }
    }
    
    private boolean cargadorEstaLleno(){
        return this.cargadorActual == this.dimensionCargador;
    }
    
    private boolean tieneReserva(){
        return this.municionReserva > 0;
    }
    
    private boolean puedeRecargar(){
        if(cargadorEstaLleno()){
            return false;
        }
        return tieneReserva();
    }
    
}
