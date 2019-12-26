package com.bsmith.recipe;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

class IngredientTest {

	@Test
	void testCreateSetRecipe() {
		Ingredient ingredient = new Ingredient();
		Pantry pantry = new Pantry();
		
		List<String[]> list = new ArrayList<>();
		String[] strArr = {"r1","i1","i2","i3"};
		list.add(strArr);
		
		HashMap<String, Ingredient> ingredientMap = pantry.createIngredientMap(list);
		HashMap<String, Recipe> recipeMap = pantry.createRecipeMap(list);
		
		ingredient.createListRecipe(list, recipeMap, ingredientMap);
		
		assertEquals(true , ingredientMap.get("i1").listRecipe.contains(recipeMap.get("r1")));
	}

	@Test
	void testChangeAvailable() {
		Ingredient ingredient = new Ingredient();
		Pantry pantry = new Pantry();
		
		List<String[]> list = new ArrayList<>();
		String[] strArr = {"r1","i1","i2","i3"};
		String[] strArr2 = {"r2","i1","i4","i5"};

		list.add(strArr);
		list.add(strArr2);
		
		HashMap<String, Ingredient> ingredientMap = pantry.createIngredientMap(list);
		HashMap<String, Recipe> recipeMap = pantry.createRecipeMap(list);

		ingredient.createListRecipe(list, recipeMap, ingredientMap);
		
		HashSet<String> unavailableIngredients = new HashSet<String>();
		unavailableIngredients.add("i2");
		
		ingredient.changeAvailable(unavailableIngredients, ingredientMap);
		
		assertEquals(false, ingredientMap.get("i2").available);
		assertEquals(true, ingredientMap.get("i1").available);
		assertEquals(false, ingredientMap.get("i2").listRecipe.get(0).available);
		assertEquals(false, ingredientMap.get("i1").listRecipe.get(0).available);
		assertEquals(true, ingredientMap.get("i1").listRecipe.get(1).available);
		
	}

}
