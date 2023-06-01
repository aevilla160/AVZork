
public class Npc {
private  String Name;
private double Health;
private String Description;
private double damage;
	public Npc(String N, double H, String desc, double d){
		Name = N;
		Health = H;
		Description = desc;
		damage = d;
	}
	public   String getName(){
		return Name;
	}
	
	public double getHealth(){
		return Health;
	}
	
	public String getDescription(){
		return Description;
	}
	
	public double getDamage(){
		return damage;
	}
	
	public void setHealth(double input){
		Health = Health - input;
	}
}
