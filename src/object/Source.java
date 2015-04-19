package object;

import java.util.*;

import core.Settings;
public class Source {
	double x, y;	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	enum Type{laser, bulb}
	public void emit(ArrayList A, Settings S){
		//Jetot metod dopisyvaet v konec  massiva luchi. vypushhennye istochnikom
		//Napishu poka dlja lazera
		Ray lsr=new Ray();
		lsr.setXs(x);
		lsr.setYs(y);
		A.add(lsr);
		
	}
}
