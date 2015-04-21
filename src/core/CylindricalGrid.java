package core;

public class CylindricalGrid {
	
	double z;
	double r;
	double q;
	
	public CylindricalGrid(double w){
		z=w;r=0;q=0;
	}
	public CylindricalGrid(double w, double h){
		z=w;r=h;q=0;
	}
	public CylindricalGrid(double w, double h, double a){
		z=w;r=h;q=a;
	}
	public CylindricalGrid(){
		z=0;r=0;q=0;
	}
	
	//void sinchronize(){}
	
	public void setZ(double w){
		z=w;
	}
	public void setR(double h){
		r=h;
	}
	public void setQ(double a){
		q=a;
	}
	public double getZ(){
		return z;
	}
	public double getR(){
		return r;
	}
	public double getQ(){
		return q;
	}
	
}
