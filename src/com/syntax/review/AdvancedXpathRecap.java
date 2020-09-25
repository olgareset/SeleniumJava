package com.syntax.review;

public class AdvancedXpathRecap extends CommonMethods{
	
	/* We may be able to locate page objects with any of locators including Xpath
	 * What will be our solution?  --> Advanced xpath
	 * What is the idea of using advanced xpath? 
	 * 	1. Use parent/child or sibling relations between the tags
	 * 	2. find a unique locator for parent/child or sibling tags 
	 *  3. Access requested object by using relationship
	 */
	
	/* if parent tag has unique indentification
	 * 	parentXpath/childTag
	
	 */

	public static void main(String[] args) {
		
		
		setUp("chrome", SyntaxPrctice_URL);
		
		/* if parent tag has unique indentification
	parentXpath/childTag   */
		String xpath="//div[@id='navbar-brand-centered']/ul[1]/li[1]/a";

		/* If immediate child has unique identification 
			childXpath/..  */
		
		String xpath1="//span[text()='Toggle navigation']/../../..";

		/* if next element has unique identification
		 * nextElementXpath/preceding-sibling::tagName
		 */
		
		String xpath2="//div[@id='content']/preceding-sibling::div[1]";
		
		/* if previous element has unique identification
		 * previousElementXpath/following-sibling::tagName
		 */
		
		String xpath3="//div[@id='mainMenu']/following-sibling::div";
	}
}

