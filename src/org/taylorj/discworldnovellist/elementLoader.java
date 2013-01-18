package org.taylorj.discworldnovellist;

public class elementLoader {
	public element[] listOfElements;
	
	/* 
	 * GET method
	 */
	public element getElement(int index)
	{
		/*
		 * Check that the list of elements is neither
		 * NULL nor 0 in length 
		 */
		
		if (listOfElements != null)
		{
			if (listOfElements.length > 0)
			{
				/*
				 * If the index does not fall within the list
				 * of available elements, then return the value
				 * of the first element in the list.
				 * Otherwise, return the value of the element
				 * found at the index
				 */
				
				if (index < listOfElements.length)
				{
					return listOfElements[index];
				}
				else
				{
					return listOfElements[0];
				}
			}
		}
		
		/*
		 * If we get here, then the list is empty. Return a new
		 * element (with a blank name)
		 */
		
		return new element("someName");
	}
	
	/*
	 * SET methods
	 */
	
	public boolean setElementName(int index, String newName)
	{
		/*
		 * Check that the list of elements is neither
		 * NULL nor 0 in length 
		 */
		
		if (listOfElements != null)
		{
			if (listOfElements.length > 0)
			{
				/*
				 * If the index does not fall within the list
				 * of available elements, then return false to
				 * indicate that we were unable to set the new
				 * element name
				 */
				if (listOfElements.length < index)
				{
					listOfElements[index].setName(newName);
				}
				else
				{
					return false;
				}
			}
		}
		
		/*
		 * The list of elements seems to be null (hasn't been
		 * instantiated before being used), so return false.
		 */
		
		return false;
	}
	
	public boolean setElementOwnage(int index, boolean ownage)
	{
		/*
		 * Check that the list of elements is neither
		 * NULL nor 0 in length 
		 */
		
		if (listOfElements != null)
		{
			if (listOfElements.length > 0)
			{
				/*
				 * If the index does not fall within the list
				 * of available elements, then return false to
				 * indicate that we were unable to set the new
				 * element ownage state
				 */
				if (listOfElements.length < index)
				{
					listOfElements[index].setOwn(ownage);
				}
				else
				{
					return false;
				}
			}
		}
		
		/*
		 * The list of elements seems to be null (hasn't been
		 * instantiated before being used), so return false.
		 */
		
		return false;
	}
}

