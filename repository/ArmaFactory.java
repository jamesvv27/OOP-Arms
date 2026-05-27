package repository;

import domain.model.Arma;

public class ArmaFactory {
    public static Arma crearDesdeData(
        final ArmaData data
    ){
        final Arma tipoArma = Arma.valueOf(Arma.getTipoArma());

        switch (tipoArma) {
            case RifleAsalto:
                return new Arma(tipoArma.getNombreArma());
            case Francotirador:
                return new Arma(tipoArma.getTipoArma());
            case Pistola:
                
            case AmetralladoraLigera:
                
            case Escopeta:
                
            default:
                return new Arma("Alam");
                break;
        }
        
    }
}