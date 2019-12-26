package com.bsmith.recipe;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

class PantryTest {

	@Test
	void testCreateRecipeMap() {
		Pantry pantry = new Pantry();
		List<String[]> list = new ArrayList<>();
		String[] strArr = {"r1","i1","i2","i3"};
		list.add(strArr);
		HashMap<String, Recipe> rMap = pantry.createRecipeMap(list);
		Recipe recipe = rMap.get("r1");
		
		assertEquals("r1", recipe.name);

	}

	@Test
	void testCreateIngredientMap() {
		Pantry pantry = new Pantry();
		List<String[]> list = new ArrayList<>();
		String[] strArr = {"r1","i1","i2","i3"};
		list.add(strArr);
		HashMap<String, Ingredient> iMap = pantry.createIngredientMap(list);
		Ingredient ingredient = iMap.get("i1");
		
		assertEquals("i1", ingredient.name);
	}

	@Test
	void testAvailableRecipes() {
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
		
		List<Recipe> availableRecipes = pantry.availableRecipes(recipeMap);
		
		assertEquals("r2", availableRecipes.get(0).name);
		assertEquals(1, availableRecipes.size());

	}

}
