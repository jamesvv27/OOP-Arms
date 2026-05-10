
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
    
    public String getNombreArma() {
    	return nombreArma;
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
    
    public int getCadenciaDisparo() {
    	return cadenciaDisparo;
    }
    
    private void vaciarReserva() {
    	this.cargadorActual += this.municionReserva;
    	this.municionReserva = 0;
    }
    
    private void llenarCargadorActual(int necesaria) {
    	this.cargadorActual += necesaria;
    	this.municionReserva -= necesaria;
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
 
    public abstract void disparar();
    
    public void recargar(){
        while(puedeRecargar()){
        	int municionNecesaria = (this.dimensionCargador - this.cargadorActual);
            if(this.cargadorActual > this.municionReserva) {
            	vaciarReserva();
            }
            else { // (cargadorActual <= municionReserva)
            	llenarCargadorActual(municionNecesaria);
            }
        }
    }
    	
    public void desplegarEstado() {
    	System.out.println("Municion: " + this.cargadorActual + "/" + this.municionReserva
    			+ "El cargador esta lleno: " + cargadorEstaLleno() +
    			"\nHay municion en la reserva: " + tieneReserva() +
    			"Dimension del cargador: " + this.dimensionCargador);
    }
    
}
