package object;

public class CircleHole extends DOE{
	
	private double r;
	
	public CircleHole() {
		cg.setZ(100);
		r=30;
	}
	
	public void setRadius(double rad){
		r=rad;
	}
	
	public double getRadius(){
		return r;
	}
	
	

}
