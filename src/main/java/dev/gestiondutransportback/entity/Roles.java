package dev.gestiondutransportback.entity;

public enum Roles {
	ADMINISTRATEUR("Administrateur"), UTILISATEUR("Utilisateur"), CHAUFFEUR("Chauffeur");
	
	private String roleString;

	private Roles(String roleString) {
		this.roleString = roleString;
	}

	@Override
	public String toString() {
		return roleString;
	}
}
