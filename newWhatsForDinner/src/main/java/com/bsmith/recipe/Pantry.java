package com.bsmith.recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pantry {
	
	private HashMap<String, Recipe> recipeMap = new HashMap<String, Recipe>();
	HashMap<String, Ingredient> ingredientMap = new HashMap<String, Ingredient>();
	
	// Creates recipe map of recipe names
	protected HashMap<String, Recipe> createRecipeMap(List<String[]> listStr) {
		for (String[] temp1 : listStr) {
			Recipe recipe = new Recipe();
			recipe.name = temp1[0];
			recipeMap.putIfAbsent(temp1[0], recipe);	
		}
		return recipeMap;
	}
	
	// Creates recipe map of ingredient names
	protected HashMap<String, Ingredient> createIngredientMap(List<String[]> listStr) {
		for (String[] temp1 : listStr) {
			for (int i = 1; i < temp1.length; i++) {
				Ingredient ingredient = new Ingredient();
				ingredient.name = temp1[i];
				ingredientMap.putIfAbsent(temp1[i], ingredient);	
			}
		}
		return ingredientMap;
	}
	
	// Creates list of available recipes
	protected List<Recipe> availableRecipes(HashMap<String, Recipe> recipeMap) {
		List<Recipe> recipeList = new ArrayList<Recipe>();
		for ( Recipe recipe : recipeMap.values()) {
			if (recipe.available == true) {
				recipeList.add(recipe);
			}
		}
		return recipeList;
	}
	
}
