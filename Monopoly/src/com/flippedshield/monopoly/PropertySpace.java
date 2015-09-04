package com.flippedshield.monopoly;

import java.util.ArrayList;

public class PropertySpace extends Space implements Improvable, Ownable {
	
	private static final int MAX_CITY_BLOCKS = 4;

	private ArrayList<BuildingToken> buildingTokenList;
	private Deed deed;
	private boolean isPurchased;
	private boolean hasKeyToTheCity;
	private long cost;
	private int cityBlocks;
	
	public PropertySpace(Deed deed){
		super(deed.getName());
		setDeed(deed);
		hasKeyToTheCity(false);
		incrementCityBlocks();
		
		buildingTokenList = new ArrayList<BuildingToken>();
	}
	
	public long getCost()
	{
		return cost;
	}
	
	public void setCost(long cost)
	{
		this.cost = cost;
	}
	
	public ArrayList<BuildingToken> getBuildingTokenList() {
		return buildingTokenList;
	}
	
	public Deed getDeed()
	{
		return deed;
	}
	
	public void setDeed(Deed deed)
	{
		this.deed = deed;
	}
	
	public void hasKeyToTheCity(boolean hasKeyToTheCity)
	{
		this.hasKeyToTheCity = hasKeyToTheCity;
	}
	
	public boolean hasKeyToTheCity()
	{
		return hasKeyToTheCity;
	}
	
	public void incrementCityBlocks()
	{
		cityBlocks++;
	}

	@Override
	public boolean onLanding(Player player) {
		Player owner = getDeed().getOwner();
		//check owner
		//if player is not owner
			//if owner is not banker
				//remove wealth from player
				//give wealth to owner
			//if owner is banker
				//random to decide if player will buy
		//if player is owner do something that isn't something else
		
		if(!owner.equals(player))
		{
			if(!owner.equals(BankerPlayer.getBanker()))
			{
				player.adjustWealth(calculateRentCharge() * -1);
				owner.adjustWealth(calculateRentCharge());
				
				System.out.println("- paid $" + calculateRentCharge() + " in rent to " + owner.getName());
				
				if(Game.DEBUG_MODE) { System.out.println("#> " + getDeed().getName() + " owner is a player"); }

			} else if (owner.equals(BankerPlayer.getBanker()))
			{
				// purchase property 
				long purchasePrice = getDeed().getPurchasePrice(); 
				
				if (purchasePrice > player.getWealth()) {
					return true; 
				}
				
				player.adjustWealth(purchasePrice*-1);
				
				player.addOwnedDeeds(getDeed());
				owner.removeDeed(getDeed()); 
				getDeed().setOwner(player);
				
				System.out.println("- purchased " + getDeed().getName() + " from the Bank for $" + purchasePrice);
				
				if(Game.getDebugMode()) { System.out.println("#> "+ getDeed().getName() + " owner is banker"); }
			}
		}
		
		return false; 
	}

	@Override
	public void onLeaving(Player player) {
		
	}

	@Override
	public boolean isPurchased() {
		return isPurchased;
	}

	@Override
	public void isPurchased(boolean isPurchased) {
		this.isPurchased = isPurchased;
	}

	@Override
	public void changeOwner(Player owner) {
		getDeed().setOwner(owner);
	}

	@Override
	public void addCityBlock(int cityBlocks) {
		
	}

	@Override
	public void addKeyToTheCity(int keyToTheCity) {
		
	}

	@Override
	public void removeCityBlock(int cityBlocks) {
		
	}

	@Override
	public void removeKeyToTheCity(int keyToTheCity) {
		
	}

	@Override
	public int calculateRentCharge() {
		
		int rentCost = (int) getDeed().getBaseRent();
		int cityBlocks  = 0;
		int additionalCost = 0;
		
		for(BuildingToken t :  getBuildingTokenList())
		{
			if(t.equals(HouseToken.class))
			{
				cityBlocks++;
			}
			
			if(t.equals(HotelToken.class) && cityBlocks == MAX_CITY_BLOCKS)
			{
				hasKeyToTheCity(true);
			}
		}
		
		switch(cityBlocks)
		{
			case 1:
				additionalCost += getDeed().getOneBlock();
				break;
				
			case 2:
				additionalCost += getDeed().getOneBlock();
				break;
				
			case 3:
				additionalCost += getDeed().getOneBlock();
				break;
				
			case 4:
				additionalCost += getDeed().getOneBlock();
				break;
		
			default:
				additionalCost = (int) getDeed().getBaseRent();
		}
		
		if(hasKeyToTheCity())
		{
			rentCost = (int) getDeed().getKeyToCity();
		} else 
		{
			rentCost = additionalCost;
		}
		
		return rentCost;
	}
}
