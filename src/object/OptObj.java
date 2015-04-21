package object;

import core.*;
//Kakoj eto klass?//
// eto samyj obzhij klass  ego obxectov my delatj ne budem
public class OptObj {
	protected CylindricalGrid cg;

	
	OptObj(){
		cg = new CylindricalGrid();
	}
	OptObj(double w){
		cg = new CylindricalGrid(w);	
	}
	OptObj(double w,double h){
		cg = new CylindricalGrid(w,h);
	}
	OptObj(double w,double h,double a){
		cg = new CylindricalGrid(w,h,a);
	}
	
	
	public void setCoordinate(double w,double h,double a){
		cg.setZ(w);
		cg.setR(h);
		cg.setQ(a);
	}
	void setCoordinate(CylindricalGrid grid){
		cg = grid;
	}
	CylindricalGrid getCoordinate(){
		return cg;
	}
	public double getZ(){
		return cg.getZ();
	}

}
