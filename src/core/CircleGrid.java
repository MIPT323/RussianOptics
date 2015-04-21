package core;

public class CircleGrid {
	
	double r;
	double q;
	double p;
	
	public CircleGrid(){
		r=0;q=0;p=0;
	}
	public CircleGrid(double rad, double phi, double teta){
		r=rad;p=phi;q=teta;
	}
	
	//void sinchronize(){}
	
	public void setR(double rad){
		r=rad;
	}
	public void setPhi(double phi){
		p=phi;
	}
	public void setTeta(double teta){
		q=teta;
	}
	public double getR(){
		return r;
	}
	public double getPhi(){
		return p;
	}
	public double getTeta(){
		return q;
	}

}
