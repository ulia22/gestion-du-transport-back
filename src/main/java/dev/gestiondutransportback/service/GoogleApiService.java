package dev.gestiondutransportback.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.gestiondutransportback.utils.Utils;

@Service
public class GoogleApiService {

	public JsonNode list(String keywords) throws IOException{
		String keyword = keywords.replaceAll(" ", "%20");
		String url = "https://maps.googleapis.com/maps/api/geocode/json?region=fr&address="+keyword+"&key="+ResourceBundle.getBundle("application").getString("googleApi_key");
		String str = Utils.get(url);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(str);
		return jsonNode.get("results");
	}
	
	public Map<String, String> dureeEtDistance(String villeDepart, String villeArrive) throws IOException{
		String villeDepartFormat = villeDepart.replaceAll(" ", "%20");
		String villeArriveFormat = villeArrive.replaceAll(" ", "%20");
		String url = "https://maps.googleapis.com/maps/api/directions/json?origin="+villeDepartFormat+"&destination="+villeArriveFormat+"&key="+ResourceBundle.getBundle("application").getString("googleApi_key");
		String str = Utils.get(url);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(str);
		String distance = jsonNode.get("routes").get(0).get("legs").get(0).get("distance").get("text").asText();
		int minute = jsonNode.get("routes").get(0).get("legs").get(0).get("duration").get("value").asInt() /60 % 60;
		int heure =  jsonNode.get("routes").get(0).get("legs").get(0).get("duration").get("value").asInt() / 3600;
		String duree = heure+" h et "+minute+" min"; 
		Map <String, String> map = new HashMap<>();
		map.put("duree", duree);
		map.put("distance", distance);
		return map;
	}
}
