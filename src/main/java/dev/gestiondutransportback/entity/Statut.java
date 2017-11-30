package dev.gestiondutransportback.entity;

public enum Statut {
	EN_SERVICE("En service"), EN_REPARATION("En réparation"), HORS_SERVICE("Hors service");
	
	private String statutString;

	private Statut(String statutString) {
		this.statutString = statutString;
	}

	@Override
	public String toString() {
		return statutString;
	}
}
