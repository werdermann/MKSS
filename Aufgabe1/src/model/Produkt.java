package model;

import model.IProdukt;

public abstract class Produkt implements IProdukt {
	private String name;

	public Produkt(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public abstract int gibPreis();
	public abstract String ausgeben();
}