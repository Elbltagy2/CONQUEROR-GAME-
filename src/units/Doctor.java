package units;

import exceptions.UnitFullCapacityException;

public class Doctor  extends Unit{

	public Doctor(int level, int maxSoldierConunt, double idleUpkeep, double marchingUpkeep, double siegeUpkeep) {
		super(level, maxSoldierConunt, idleUpkeep, marchingUpkeep, siegeUpkeep);
	}
public void heal(Unit healedUint) throws UnitFullCapacityException {
	if (healedUint.getCurrentSoldierCount()==healedUint.getMaxSoldierCount())
		throw new UnitFullCapacityException();
	if (healedUint.getCurrentSoldierCount()==0)
		return ;
	double factor=0;
	if(getLevel()==1)
		factor=0.2;
	else if(getLevel()==2)
		factor=0.3;
	else
		factor=0.4;
	healedUint.setCurrentSoldierCount(healedUint.getCurrentSoldierCount()+(int)(factor*healedUint.getMaxSoldierCount()
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			));
	if (healedUint.getCurrentSoldierCount()>healedUint.getMaxSoldierCount()) {
		healedUint.setCurrentSoldierCount(healedUint.getMaxSoldierCount());
	}
	
}

}
