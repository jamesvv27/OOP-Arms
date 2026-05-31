package repository;

import domain.model.AmetralladoraLigera;
import domain.model.Arma;
import domain.model.Escopeta;
import domain.model.Francotirador;
import domain.model.Pistola;
import domain.model.RifleAsalto;

public class ArmaFactory {
    public static Arma crearDesdeData(
        final ArmaData data
    ){
        final String tipoArma = (data.getTipoArma());

        switch (tipoArma) {
            case "RifleAsalto":
                return new RifleAsalto(
                    data.getDano(), data.getNombreArma(), 0,
                    data.getDimensionCargador(), data.getMunicionReserva(),
                    data.getPorcentajePrecision(), data.getCadenciaDisparo());
            case "Francotirador":
                return new Francotirador(
                    data.getDano(), data.getNombreArma(), 0,
                    data.getDimensionCargador(), data.getMunicionReserva(),
                    data.getPorcentajePrecision(), data.getCadenciaDisparo());
            case "Pistola":
                return new Pistola(
                    data.getDano(), data.getNombreArma(), 0,
                    data.getDimensionCargador(), data.getMunicionReserva(),
                    data.getPorcentajePrecision(), data.getCadenciaDisparo());
            case "AmetralladoraLigera":
                return new AmetralladoraLigera(
                    data.getDano(), data.getNombreArma(), 0,
                    data.getDimensionCargador(), data.getMunicionReserva(),
                    data.getPorcentajePrecision(), data.getCadenciaDisparo());
            case "Escopeta":
                return new Escopeta(
                    data.getDano(), data.getNombreArma(), 0,
                    data.getDimensionCargador(), data.getMunicionReserva(),
                    data.getPorcentajePrecision(), data.getCadenciaDisparo());
            default:
                return new Pistola(0, tipoArma, 0, 0, 0, 0, 0);
        }
        
    }
}