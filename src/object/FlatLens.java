package object;
import core.*;

import java.util.ArrayList;

import core.Settings;
public class FlatLens extends DOE{
	double F,x,y, D;
	//D-diametr linzy
	@Override
	public void interact(Ray R, ArrayList<Ray> A, Settings S) {
		// TODO Auto-generated method stub
		//Ray R uzhe poluchil svoi xe, ye, i b end v metode R.findEnd();
		//Poka bagovannyj metod prelomlenija
		Ray New=new Ray();
		New.setLambda(R.getLambda());
		New.setXs(R.getXe());
		New.setYs(R.getYe());
		//Ishhu tangens ugla naklona novogo lucha
		double tg=Math.tan(R.getPhi())-(R.getYe()-y)/F;
		New.setPhi(Math.atan(tg));
		A.add(New);
	}
	public double getF() {
		return F;
	}
	public void setF(double f) {
		F = f;
	}
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
	public double getD() {
		return D;
	}
	public void setD(double d) {
		D = d;
	}
	public double getRadius() {
		return D/2;
	}
	public void setRadius(double d) {
		D = d*2;
	}
	@Override
	public void intersect(Ray R) {
		// TODO Auto-generated method stub
		
	}	
}
