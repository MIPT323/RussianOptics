package object;

<<<<<<< HEAD
public class Lens {

	public Lens() {
		
=======
public class Lens extends OptObj {
	
	private double radius1;
	private double radius2;
	private double n;//opticheskaja plotnostj
	private double focus;
	private double width;
	
//	public Lens() {
//		
//	}
	
	public void setRadius1(double rad1){
		radius1=rad1;
	}
	public double getRadius1(){
		return radius1;
	}
	public void setRadius2(double rad2){
		radius2 = rad2;
	}
	public double getRadius2(){
		return radius2;
	}
	public void setOptDensity(double opticalDensity){
		n = opticalDensity;
	}
	public double getOptDensity(){
		return n;
	}
	public void setFocus(double foc){
		focus = foc;
	}
	public double getFocus(){
		return focus;
	}
	public void setWidth(double w){
		width = w;
	}
	public double getWidth(){
		return width;
>>>>>>> origin/PDA
	}
}
