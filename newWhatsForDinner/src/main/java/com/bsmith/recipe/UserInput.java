package com.bsmith.recipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInput {

    Logger logger = LoggerFactory.getLogger(UserInput.class);
    
	final Pantry pantry = new Pantry();

	protected HashSet<String> userInput() {
		

	    //Enter data using BufferReader 
	    BufferedReader reader =  
	               new BufferedReader(new InputStreamReader(System.in)); 
	    HashSet<String> inputSet = new HashSet<String>();
	    String input = " ";
	    
	    // Continues loop until user enters no data
	    while (!input.equals("")) {
		    try {
				input = reader.readLine().trim().toLowerCase();
			} catch (NullPointerException | IOException e) {
				logger.error("Can not add NULL");
			}
		    if (!input.equals("")) {
			    inputSet.add(input); 
		    }
	    }
		return inputSet;

	}
	
	

}
