package org.taylorj.discworldnovellist;

public class element {
	private String name;
	private boolean own;	//whether the user owns this item
	
	/**
	 * Constructor for element object. Assume that the element
	 * is not owned by the user in the first instance.
	 * @param nameOfElement used as the name value for the element
	 */
	public element (String nameOfElement)
	{
		this.name = nameOfElement;
		this.own = false;
	}
	
	/*
	 * Begin GET methods
	 */
	public String getName()
	{
		return this.name;
	}
	
	public boolean getOwn()
	{
		return this.own;
	}
	/*
	 * End GET methods
	 */
	
	/*
	 * Begin SET methods
	 */
	public void setName(String nameOfElement)
	{
		this.name = nameOfElement;
	}
	
	public void setOwn(boolean ownage)
	{
		this.own = ownage;
	}
	/*
	 * End GET methods
	 */
}
