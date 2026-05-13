
package domain.model;

import domain.enums.Disparo;

public abstract class Arma
{
    private int dano;
    private final String nombreArma;
    private int cargadorActual;
    private int dimensionCargador;
    private int municionReserva;
    private int porcentajePrecision;
    private int cadenciaDisparo;
    private Disparo modoDisparo;

    public Arma(int dano, String nombreArma, int cargadorActual, int dimensionCargador, int municionReserva, int porcentajePrecision, int cadenciaDisparo, Disparo modoDisparo)
    {
        this.dano = dano;
        this.nombreArma = nombreArma;
        this.cargadorActual = cargadorActual;
        this.dimensionCargador = dimensionCargador;
        this.municionReserva = municionReserva;
        this.porcentajePrecision = porcentajePrecision;
        this.cadenciaDisparo = cadenciaDisparo;
        this.modoDisparo = modoDisparo;
    }

    public int getDano(){
        return dano;
    }
    
    public String getNombreArma() {
    	return nombreArma;
    }

    public Disparo getModoDisparo(){
        return modoDisparo;
    }

    public int getCargadorActual()
    {
        return cargadorActual;
    }

    public void setCargadorActual(int cargadorActual){
        this.cargadorActual = cargadorActual;
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

    public void setDano(int nuevoDano){
        this.dano = nuevoDano;
    }

    public void setDimensionCargador(int nuevaDimension){
        this.dimensionCargador = nuevaDimension;
    }

    public void setPorcentajePrecision(int nuevaPrecision){
        this.porcentajePrecision = nuevaPrecision;
    }

    public void setCadenciaDisparo(int nuevaCadencia){
        this.cadenciaDisparo = nuevaCadencia;
    }

    public void agregarReserva(int balas){
        // municionReserva += balas
        setMunicionReserva(getMunicionReserva() + balas);
    }
    
    public int getCadenciaDisparo() {
    	return cadenciaDisparo;
    }
    
    public boolean puedeDisparar(){
        return !cargadorEstaVacio();
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

    private boolean cargadorEstaVacio(){
        return this.cargadorActual == 0;
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

    public void setModoDisparo(Disparo nuevoModo){
        this.modoDisparo = nuevoModo;
    }

    private void setMunicionReserva(int nuevaMunicion){
        this.municionReserva = nuevaMunicion;
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
    			+ "\nEl cargador esta lleno: " + cargadorEstaLleno() +
    			"\nHay municion en la reserva: " + tieneReserva() +
    			"\nDimension del cargador: " + this.dimensionCargador +
                "\nModo de disparo: " + getModoDisparo() + "\n");
    }
    
}
