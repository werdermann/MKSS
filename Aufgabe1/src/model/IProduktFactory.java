package model;

import model.IProdukt;

public interface IProduktFactory {
    IProdukt createIProdukt();
    String getName();
}
