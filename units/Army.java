package units;

import java.util.ArrayList;

import org.hamcrest.core.Is;

import engine.City;
import exceptions.MaxCapacityException;


public class Army{
	private Status currentStatus;
	private ArrayList<Unit> units;
	private int distancetoTarget;
	private String target;
	private String currentLocation;
	private final int maxToHold=10;
	private int turn=0;

	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public Army(String currentLocation) {
		this.currentLocation=currentLocation;
		currentStatus=Status.IDLE;
		units=new ArrayList<Unit>();
		distancetoTarget=-1;
		target="";
		
	}
	public String[][] display(){
		String l[][]=new String[units.size()][4];
		int i=0;
		for (Unit unit : units) {
			String l1[]=new String[4];
			String type="";
			if (unit instanceof Archer)
				type="Archer";
			if (unit instanceof Cavalry)
				type="Cavalry";
			if (unit instanceof Infantry)
				type="Infantry";
			l1[0]=type;
			l1[1]=""+unit.getLevel();
			l1[2]=""+unit.getCurrentSoldierCount();
			l1[3]=""+unit.getMaxSoldierCount();
			l[i++]=l1;
		}
		return l;
	}
public String[][] displayIdle(){
		
		String l[][]=new String[units.size()+1][4];
		String [] tmp={"Type","Level","CurrentCount","MaxCount"};
		l[0]=tmp;
		int i=1;
		for (Unit unit : units) {
			String l1[]=new String[4];
			String type="";
			if (unit instanceof Archer)
				type="Archer";
			if (unit instanceof Cavalry)
				type="Cavalry";
			if (unit instanceof Infantry)
				type="Infantry";
			l1[0]=type;
			l1[1]=""+unit.getLevel();
			l1[2]=""+unit.getCurrentSoldierCount();
			l1[3]=""+unit.getMaxSoldierCount();
			l[i++]=l1;
			
		}
		return l;
	}
public String[][] displayMarching(){
		
		String l[][]=new String[units.size()+1][6];
		String [] tmp={"Type","Level","CurrentCount","MaxCount","Target City","Turns to reach"};
		l[0]=tmp;
		int i=1;
		for (Unit unit : units) {
			String l1[]=new String[6];
			String type="";
			if (unit instanceof Archer)
				type="Archer";
			if (unit instanceof Cavalry)
				type="Cavalry";
			if (unit instanceof Infantry)
				type="Infantry";
			l1[0]=type;
			l1[1]=""+unit.getLevel();
			l1[2]=""+unit.getCurrentSoldierCount();
			l1[3]=""+unit.getMaxSoldierCount();
			l1[4]=""+this.getTarget();
			l1[5]=""+this.distancetoTarget;
			l[i++]=l1;
			
		}
		return l;
	}
public String[][] displaySeige(ArrayList<City> cities){
	
	String l[][]=new String[units.size()+1][6];
	int i=1;
	String [] tmp={"Type","Level","CurrentCount","MaxCount","City under Seige","Turns under seige"};
	l[0]=tmp;
	for (Unit unit : units) {
		String l1[]=new String[6];
		String type="";
		if (unit instanceof Archer)
			type="Archer";
		if (unit instanceof Cavalry)
			type="Cavalry";
		if (unit instanceof Infantry)
			type="Infantry";
		l1[0]=type;
		l1[1]=""+unit.getLevel();
		l1[2]=""+unit.getCurrentSoldierCount();
		l1[3]=""+unit.getMaxSoldierCount();
		l1[4]=""+this.getCurrentLocation();
		String c="";
		
//		if(this.getCurrentLocation().equalsIgnoreCase("Cairo"))
//			c="Cairo";
//		if(this.getCurrentLocation().equalsIgnoreCase("Rome"))
//			c="Rome";
//		else
//			c="Sparta";
//		for (City cc : cities) {
//			if(cc.getName().equals(c)) {
//				l1[5]=""+cc.getTurnsUnderSiege();
//			System.out.println(getCurrentLocation() +" "+cc.getTurnsUnderSiege());}
//		}
	l[i++]=l1;
//		
	}
	return l;
}
	public void relocateUnit(Unit unit) throws MaxCapacityException
	{
		if(units.size()==maxToHold)
			throw new MaxCapacityException("Maximum capacity reached");
		units.add(unit);
		unit.getParentArmy().units.remove(unit);
		unit.setParentArmy(this);
	}
	
	

	public Status getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(Status currentStatus) {
		this.currentStatus = currentStatus;
	}

	public ArrayList<Unit> getUnits() {
		return units;
	}

	public void setUnits(ArrayList<Unit> units) {
		this.units = units;
	}

	public int getDistancetoTarget() {
		return distancetoTarget;
	}

	public void setDistancetoTarget(int distancetoTarget) {
		this.distancetoTarget = distancetoTarget;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	public int getMaxToHold() {
		return maxToHold;
	}
	public double foodNeeded()
	{
		double sum=0;
		for(Unit u: units)
		{
			if(currentStatus==Status.IDLE)
				sum+=(u.getIdleUpkeep()*u.getCurrentSoldierCount());
			else if(currentStatus==Status.MARCHING)
				sum+=(u.getMarchingUpkeep()*u.getCurrentSoldierCount());
			else 
				sum+=(u.getSiegeUpkeep()*u.getCurrentSoldierCount());
			
		}
		return sum;
		
	}
	public void handleAttackedUnit(Unit u) {
		if(u.getCurrentSoldierCount()<=0)
		{
			u.setCurrentSoldierCount(0);
		units.remove(u);
		}
		
	}
	

}
