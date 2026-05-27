package repository;

import java.util.List;

import domain.model.Arma;
import exceptions.ArchivoArmaException;

public interface ArmaRepository {
    List<Arma> getListaArma() throws ArchivoArmaException;
}