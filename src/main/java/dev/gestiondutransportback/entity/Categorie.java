package dev.gestiondutransportback.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Categorie {
	MICRO_URBAINES("Micro-urbaines"), MINI_CITADINES("Mini-citadines"), CITADINES_POLYVALENTES("Citadines polyvalentes"), COMPACTES("Compactes"), BERLINES_TAILLE_S("Berlines Taille S"), BERLINE_TAILLE_M("Berlines Taille M"), BERLINES_TAILLE_L("Berlines Taille L"), SUV_TOUT_TERRAINS_ET_PICK_UP("SUV, Tout-terrains et Pick-up");

	private String categorieString;

	private Categorie(String categorieString) {
		this.categorieString = categorieString;
	}

	@Override
	public String toString() {
		return categorieString;
	}
	
	public static Categorie toCategorie(String s){
		for(Categorie c:values()){
			if(c.categorieString.equals(s))
				return c;
		}
		return null;
	}
	
	
			  
	public static List<String> getEnum ()
	{
		
		return Arrays.asList(Categorie.values()).stream().map(c -> c.toString()).collect(Collectors.toList());
	}
}
