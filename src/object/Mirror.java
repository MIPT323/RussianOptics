package object;

<<<<<<< HEAD
public class Mirror {

	public Mirror() {
		
=======
public class Mirror extends OptObj {
	
	private double n;
	private double r;//refract
	private double p;//pass
	
//	public Mirror() {
//		
//	}
	
	public void setOptDen(double opticalDensity){
		n = opticalDensity;
>>>>>>> origin/PDA
	}
	public double getOptDen(){
		return n;
	}
	public void setReflectivity(double reflect){
		r=reflect;
	}
	public double getReflectivity(){
		return r;
	}
	public void setTransmittance(double capacity){
		p = capacity;
	}
	public double getTransmittance(){
		return p;
	}
	
}
