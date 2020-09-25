package com.syntax.class11;

public class advancedXpath {
	
	/**
	 * Advanced xpath is based on parent and child, sibling relationships
	 * 
	 * example: identifying the element by its following sibling
	 * //label[@id = 'nav-search-label']/following-sibling::input
	 * //input[@id = 'calFromDate']/following-sibling::img
	 * 
	 * example: identifying the element by its preceding sibling 
	 * //span[text() = '& Orders']/preceding-sibling::span
	 * 
	 * example: identifying the element by its parent 
	 * //span[text() = '& Orders']/parent::a
	 * 
	 * example: identifying the element by its ancestor
	 * //input[@id = 'calFromDate']/ancestor::form
	 * 
	 * example: identifying the element by its following sibling index
	 * //div[@id = 'divPassword']/following-sibling::div[2]
	 * 
	 * 
	 * <li> --> list
	 * <ol> --> ordered list
	 * <ul> --> unordered list
	 * <div> --> division 
	 * <img> --> image 
	 * <p> --> paragraph
	 * <h> --> header
	 */

}
