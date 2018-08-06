package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        JSONObject currentSandwich;
        JSONObject names;

        try {
            currentSandwich = new JSONObject(json);
            names = currentSandwich.getJSONObject("name");
            JSONArray arrayKnownAs = names.getJSONArray("alsoKnownAs");
            JSONArray arrayIngredients = currentSandwich.getJSONArray("ingredients");

            List<String> alsoKnownAs= new ArrayList<>();
            List<String> ingredients= new ArrayList<>();

            for (int i = 0, l = arrayKnownAs.length(); i < l; i++) {
                alsoKnownAs.add(arrayKnownAs.getString(i));
            }

            for (int i = 0, l = arrayIngredients.length(); i < l; i++) {
                ingredients.add(arrayIngredients.getString(i));
            }



           Sandwich thisSandwich =  new Sandwich(

                   names.getString("mainName"),
                   alsoKnownAs,
                   ""+currentSandwich.getString("placeOfOrigin"),
                   ""+currentSandwich.getString("description"),
                   ""+currentSandwich.getString("image"),
                   ingredients

            );
            return thisSandwich;

        } catch (org.json.JSONException e) {

        }
        return null;
    }
}
