package com.bsmith.recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Ingredient {

	String name;
	Boolean available = true;
	List<Recipe> listRecipe = new ArrayList<Recipe>();
	
	protected void createListRecipe (List<String[]> listStr, HashMap<String, Recipe> recipeMap, HashMap<String, Ingredient> ingredientMap) {
		for (String[] temp1 : listStr) {
			for (int i = 1; i < temp1.length; i++) {
				Ingredient ingredient = ingredientMap.get(temp1[i]);
				ingredient.listRecipe.add(recipeMap.get(temp1[0]));
			}
		}
	}
	
	protected void changeAvailable(HashSet<String> unavailableIngredients, HashMap<String, Ingredient> ingredientMap) {

		for (String ingredient : unavailableIngredients) {

			// Changes available flag for ingredient
			if (ingredientMap.containsKey(ingredient)) {
				ingredientMap.get(ingredient).available = false;
				
				// Changes available flag for recipes that contain ingredient
				for(Recipe recipe : ingredientMap.get(ingredient).listRecipe) {
					recipe.available = false;
				}
			}
		}
	}
}
