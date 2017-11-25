package com.mk.manik.mosquelocator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Manik on 11/25/2017.
 */

public class DataParser {
    
    private HashMap<String,String> getPlaces(JSONObject googlePlaceJson){
        HashMap<String,String> googlePlacesMap = new HashMap<>();
        String placeName = "-NA-";
        String vicinity = "-NA-";
        String latitude = "";
        String longitude = "";
        String reference = "";
        try {
            if(!googlePlaceJson.isNull("name")){
            
                placeName = googlePlaceJson.getString("name");
                
                } 
            if(!googlePlaceJson.isNull("vicinity")){
                      vicinity = googlePlaceJson.getString("vicinity");
            }
            
            latitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lat");
            longitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lng");
            reference = googlePlaceJson.getString("reference");
            
            googlePlacesMap.put("place_name",placeName);
            googlePlacesMap.put("vicinity",vicinity);
            googlePlacesMap.put("lat",latitude);
            googlePlacesMap.put("lng",longitude);
            googlePlacesMap.put("reference",reference);
            
                    
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return googlePlacesMap;
    }
    
    
}
