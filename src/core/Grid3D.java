package core;

public class Grid3D {
	
	double z;
	double y;
	double x;
	
	public Grid3D(){
		z=0;y=0;x=0;
	}
	public Grid3D(double w){
		z=w;y=0;x=0;
	}
	public Grid3D(double w, double h){
		z=w;y=h;
	}
	public Grid3D(double w, double h, double l){
		z=w;y=h;x=l;
	}
	
	//void sinchronize(){}
	
	public void setZ(double w){
		z=w;
	}
	public void setY(double h){
		y=h;
	}
	public void setX(double l){
		x=l;
	}
	public double getZ(){
		return z;
	}
	public double getY(){
		return y;
	}
	public double geyX(){
		return x;
	}
	
}
