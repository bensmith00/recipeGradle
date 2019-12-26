package com.bsmith.recipe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartApp {
	private static final String FILE_NAME = "src/main/resources/recipe";
	
	public static void main(String[] args) {
		
	    Logger logger = LoggerFactory.getLogger(StartApp.class);

		final File fileObj = new File();
		final Pantry pantry = new Pantry();
		final UserInput uI = new UserInput();
		final List<String> list = fileObj.read(FILE_NAME);
		final List<String[]> listStr = fileObj.createListStringArr(list);		

		final HashMap<String, Recipe> recipeMap = pantry.createRecipeMap(listStr);
		final HashMap<String, Ingredient> ingredientMap = pantry.createIngredientMap(listStr);
	    
	    for (Ingredient ingred : pantry.ingredientMap.values()) {
	    	logger.info(ingred.name + "\n");
	    }

    	final Ingredient ingredient = new Ingredient();
	    ingredient.createListRecipe(listStr, recipeMap, ingredientMap);
	    
	    logger.info("\nEnter in the ingredients that are missing from the pantry");
		final HashSet<String> input = uI.userInput();

		ingredient.changeAvailable(input, ingredientMap);
		final List<Recipe> availableRecipes = pantry.availableRecipes(recipeMap);

		logger.info("The available recipes are: ");
		for (Recipe recipe : availableRecipes) {
			logger.info(recipe.name);
		}
	}
}

