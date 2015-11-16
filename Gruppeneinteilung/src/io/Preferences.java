package io;

import java.io.FileWriter;

import org.json.JSONObject;
import org.junit.Test;


public class Preferences {
	
	public Preferences() {
		try {
		JSONObject preferences = new JSONObject();
		JSONObject rel = new JSONObject();
		
		for(int i = 0; i < 5; i=i+4) {
			rel.put("S" + (i+1), 0.9);
			rel.put("S" + (i+2), 0.5);
			rel.put("S" + (i+3), 0.0);
			preferences.put("S" + (i), rel);
			rel = new JSONObject();
			rel.put("S" + (i), 0.9);
			preferences.put("S" + (i+1), rel);
			rel = new JSONObject();
			rel.put("S" + (i), 0.5);
			preferences.put("S" + (i+2), rel);
			rel = new JSONObject();
			rel.put("S" + (i), 0.0);
			preferences.put("S" + (i+3), rel);
		}
		
		String ausgabe = preferences.toString();
		ausgabe = ausgabe.replaceAll("\\{", "\\{\n\t");
		ausgabe = ausgabe.replaceAll("\\}", "\n\t\\}");
		ausgabe = ausgabe.replaceAll(",", ",\n\t");
		//System.out.println(ausgabe);
		
		try (FileWriter file = new FileWriter("preferences.json")) {
			file.write(ausgabe);
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 */
	@Test
	public void testPreferences() {
		Preferences bp = new Preferences();
	}
	
}
