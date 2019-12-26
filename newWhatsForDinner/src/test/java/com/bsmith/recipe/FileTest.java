package com.bsmith.recipe;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

class FileTest {

	@Test
	void testRead() {
//		fail("Not yet implemented");
	}

	@Test
	void testCreateListStringArr() {
		File file = new File();
		
		List<String> recipes = Arrays.asList("r1,i1,i2,i3","r2,i1,i4,i5");
		List<String[]> strArr = file.createListStringArr(recipes);
		
		assertEquals("r1", strArr.get(0)[0]);
		assertEquals("i1", strArr.get(0)[1]);
		assertEquals("i2", strArr.get(0)[2]);
		assertEquals("i3", strArr.get(0)[3]);
		
		assertEquals("r2", strArr.get(1)[0]);
		assertEquals("i1", strArr.get(1)[1]);
		assertEquals("i4", strArr.get(1)[2]);
		assertEquals("i5", strArr.get(1)[3]);


	}

}
 