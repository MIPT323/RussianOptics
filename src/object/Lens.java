package object;

public class Lens extends DOE {
	
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
	public double getHeigth(){
		//PRIBLIZHENNO vozvraschaet diameter linsi
		double sinbsinb=2*width/(radius2*radius2/radius1+radius2);
		return 2*radius2*Math.sqrt(sinbsinb);
	}
	public double getAngle2(){
		//vozvraschaet ugol po kotorim viidna linza iz centra 2
		double sinbsinb=2*width/(radius2*radius2/radius1+radius2);
		return Math.asin(Math.sqrt(sinbsinb));
	}
	public double getAngle1(){
		//vozvraschaet ugol po kotorim viidna linza iz centra 1
		double sinbsinb=2*width/(radius2*radius2/radius1+radius2);
		return Math.asin(radius2*Math.sqrt(sinbsinb)/radius1);
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

	}
}
