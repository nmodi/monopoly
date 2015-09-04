package com.flippedshield.monopoly;

public class Deed {

	private boolean isMortgaged;
	private Player owner;
	private String name;
	private String color;
	private long mortgage;
	private long blockCost;
	private long keyCost;
	private long baseRent;
	private long oneBlock;
	private long twoBlock;
	private long threeBlock;
	private long fourBlock;
	private long keyToCity;
	private long purchasePrice; 
	
	public Deed(
			String name, String owner, String color, long mortgage, long blockCost, 
			long keyCost, long baseRent, long oneBlock, long twoBlock, long threeBlock, 
			long fourBlock, long keyToCity)
	{
		setOwner(owner);
		isMortgaged(false);
		setName(name);
		setColor(color);
		setMortgage(mortgage);
		setBlockCost(blockCost);
		setKeyCost(keyCost);
		setBaseRent(baseRent);
		setOneBlock(oneBlock);
		setTwoBlock(twoBlock);
		setThreeBlock(threeBlock);
		setFourBlock(fourBlock);
		setKeyToCity(keyToCity);
		setPurchasePrice(mortgage); 
	}
	
	private void setPurchasePrice(long mortgage) {
		this.purchasePrice = mortgage * 2; 
	}

	public Deed()
	{
		
	}

	public Player getOwner() { return owner; }
	
	/**
	 * Set owner for setting initial owner
	 * @param owner
	 */
	public void setOwner(String owner)
	{
		if(owner.equalsIgnoreCase("bank"))
		{
			this.owner = BankerPlayer.getBanker();
			
		} else
		{
			this.owner = new Player(owner);
		}
		
	}
	
	/**
	 * Set owner for changing owners
	 * @param owner
	 */
	public void setOwner(Player owner)
	{
		this.owner = owner;
		
	}
	
	public boolean isMortgaged() { return isMortgaged; }
	
	public void isMortgaged(boolean isMortgaged)
	{
		this.isMortgaged = isMortgaged;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public long getMortgage() {
		return mortgage;
	}

	public void setMortgage(long mortgage) {
		this.mortgage = mortgage;
	}

	public long getBlockCost() {
		return blockCost;
	}

	public void setBlockCost(long blockCost) {
		this.blockCost = blockCost;
	}

	public long getKeyCost() {
		return keyCost;
	}

	public void setKeyCost(long keyCost) {
		this.keyCost = keyCost;
	}

	public long getBaseRent() {
		return baseRent;
	}

	public void setBaseRent(long baseRent) {
		this.baseRent = baseRent;
	}

	public long getOneBlock() {
		return oneBlock;
	}

	public void setOneBlock(long oneBlock) {
		this.oneBlock = oneBlock;
	}

	public long getTwoBlock() {
		return twoBlock;
	}

	public void setTwoBlock(long twoBlock) {
		this.twoBlock = twoBlock;
	}

	public long getThreeBlock() {
		return threeBlock;
	}

	public void setThreeBlock(long threeBlock) {
		this.threeBlock = threeBlock;
	}

	public long getFourBlock() {
		return fourBlock;
	}

	public void setFourBlock(long fourBlock) {
		this.fourBlock = fourBlock;
	}

	public long getKeyToCity() {
		return keyToCity;
	}

	public void setKeyToCity(long keyToCity) {
		this.keyToCity = keyToCity;
	}

	public long getPurchasePrice() {
		return purchasePrice; 
	}
}
