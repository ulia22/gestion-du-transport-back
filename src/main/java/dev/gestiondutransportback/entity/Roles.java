package dev.gestiondutransportback.entity;

public enum Roles {
	ADMINISTRATEUR("Administrateur"), COLLABORATEUR("Collaborateur"), CHAUFFEUR("Chauffeur");
	
	private String roleString;

	private Roles(String roleString) {
		this.roleString = roleString;
	}

	@Override
	public String toString() {
		return roleString;
	}
}
