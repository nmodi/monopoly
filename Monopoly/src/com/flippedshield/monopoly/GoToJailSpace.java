package com.flippedshield.monopoly;

public class GoToJailSpace extends Space {

	public GoToJailSpace(String name)
	{
		super(name);
	}

	@Override
	public boolean onLanding(Player player) {
		player.getPlayerToken().setImprisonment(true);
		player.getPlayerToken().setPosition(Board.JAIL_INDEX);
		System.out.println(player.getName() + " is going to jail!");
		return false; 
	}

	@Override
	public void onLeaving(Player player) {
		
	}
}
