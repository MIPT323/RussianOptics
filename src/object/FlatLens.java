package object;
import core.*;

import java.util.ArrayList;

import core.Settings;
public class FlatLens extends DOE{
	double F, D;
	//D-diametr linzy
	
	public double getF() {
		return F;
	}
	public void setF(double f) {
		F = f;
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
	

}
