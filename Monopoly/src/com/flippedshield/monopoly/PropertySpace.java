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
	public void onLanding(Player player) {
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
			if(!owner.equals(Board.getBanker()))
			{
				if(Game.DEBUG_MODE) { System.out.println("#> " + getDeed().getName() + " owner is a player"); }
				player.setWealth(calculateRentCharge() * -1);
//				owner.setWealth(chargeRent());
//				player.setWealth(-10);
				owner.setWealth(10);
			} else if (owner.equals(Board.getBanker()))
			{
				if(Game.getDebugMode()) { System.out.println("#> "+ getDeed().getName() + " owner is banker"); }
			}
		}
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
				additionalCost = 0;
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
