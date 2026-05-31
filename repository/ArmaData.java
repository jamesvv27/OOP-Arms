package repository;

public class ArmaData {
    
    private String tipoArma;
    private String nombreArma;
    private int dano;
    private int dimensionCargador;
    private int municionReserva;
    private int porcentajePrecision;
    private int cadenciaDisparo;

    public ArmaData(String tipoArma, String nombreArma, int dano, int dimensionCargador, int municionReserva,
            int porcentajePrecision, int cadenciaDisparo) {
        this.tipoArma = tipoArma;
        this.nombreArma = nombreArma;
        this.dano = dano;
        this.dimensionCargador = dimensionCargador;
        this.municionReserva = municionReserva;
        this.porcentajePrecision = porcentajePrecision;
        this.cadenciaDisparo = cadenciaDisparo;
    }


    public String getNombreArma() {
        return nombreArma;
    }


    public String getTipoArma() {
        return tipoArma;
    }

    public int getDano() {
        return dano;
    }


    public int getDimensionCargador() {
        return dimensionCargador;
    }


    public int getMunicionReserva() {
        return municionReserva;
    }


    public int getPorcentajePrecision() {
        return porcentajePrecision;
    }


    public int getCadenciaDisparo() {
        return cadenciaDisparo;
    }

}