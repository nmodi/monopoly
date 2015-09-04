package com.flippedshield.monopoly;

public class TaxSpace extends Space {
	
	private static final int TAX_COST = 120;
	
	private int taxCost;

	public TaxSpace(String name) {
		super(name);
		setTaxCost(TAX_COST);
	}

	@Override
	public boolean onLanding(Player player) {
		return false;
		
	}

	@Override
	public void onLeaving(Player player) {
		
	}

	public int getTaxCost() {
		return taxCost;
	}

	public void setTaxCost(int taxCost) {
		this.taxCost = taxCost;
	}

}
