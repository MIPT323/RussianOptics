package object;

import java.util.ArrayList;

import core.OSys;
import core.Settings;


public class Ray {
		//Jetot klass soderzhit parametry odnogo konkretnogo uchastka lucha
		double zs, rs;//koordinaty nachala
		double ze, re;//koordinaty konca
		int end;//Kuda upjorsja-№ DOE v arrayliste OS.getDOE()
		double phi;//Luch imeet napravlenie. Vozmozhno,u nego est' konec.
		double lambda;//u lucha est' dlina volny v metrah
		Object source;					
		public void findEnd(OSys OS){
			//Metod ishhet konec lucha
			ArrayList<DOE> A=OS.getDOE();
			//default: 0-infinity; 
			int minD=0;
			double min=Double.MAX_VALUE;
			for(int i=0;i<A.size(); i++){
				if(intersect(A.get(i))==true){
				//if ray does go through we need to check isn`t it the closest DOE
					double l=(zs-ze)*(zs-ze)+(rs-re)*(rs-re);
					if(l<min&&l>0){
						//if it is closer, we`ll remember that
						min=l;
						minD=i;
					}
				}
			}
			//vystavlyaem xe ye end
			end=minD;
			intersect(A.get(1));
			
			//default: 0-infinity; 
		}
		public boolean intersect(DOE D){
			//This method checks if this ray goes through DOE D
			//If it does, method returns true AND
			//sets ze,re
			if(CircleHole.class==D.getClass()){
					//ray always touches circlehole screen. intercacts in different wayz
					double z=D.getZ();
					re=(z-zs)*Math.tan(phi)+rs;
					ze=z;	
					return true;
				};			
			if(FlatLens.class==D.getClass()){
					double z=D.getZ();
					double retemp=(z-zs)*Math.tan(phi)+rs;
					if(((FlatLens) D).getRadius()>retemp){
						re=retemp;
						ze=z;						
						return true;
					}								
			}	
				
			return false;
		}
		public void interact(DOE D, ArrayList<Ray> A, Settings S){
			System.out.println("Interacted with #"+end+ " DOE");
			if(Infinity.class==D.getClass()){//Бесконечность
				return;}
			
			if(CircleHole.class==D.getClass()){
				if(Math.abs(re)<((CircleHole) D).getRadius()){
					//Luch popal v dirku
						Ray New=new Ray();
						New.setRs(re);
						New.setZs(ze);
						New.setPhi(phi);
						New.setLambda(lambda);
						A.add(New);
				}// Если луч не попал - не будет других лучей
				return;
			}
			if(FlatLens.class==D.getClass()){
				//Ray R uzhe poluchil svoi ze, re v metode findEnd();
				//Poka bagovannyj metod prelomlenija
				Ray New=new Ray();
				New.setLambda(lambda);
				New.setZs(ze);
				New.setRs(re);
				//Ishhu tangens ugla naklona novogo lucha
				double tg=Math.tan(phi)-re/((FlatLens) D).getF();
				New.setPhi(Math.atan(tg));
				A.add(New);		
				return;
			}
			
			
			
			
			
		}
		public void setEnd(int end) {
			this.end = end;
		}
		public double getPhi() {
			return phi;
		}
		public void setPhi(double phi) {
			this.phi = phi;
		}		
		public int getEnd() {
			return end;
		}
		public double getZs() {
			return zs;
		}
		public Object getSource() {
			return source;
		}
		public void setSource(Object source) {
			this.source = source;
		}
		public void setZs(double zs) {
			this.zs = zs;
		}
		public double getRs() {
			return rs;
		}
		public void setRs(double rs) {
			this.rs = rs;
		}
		public double getZe() {
			return ze;
		}
		public void setZe(double ze) {
			this.ze = ze;
		}
		public double getRe() {
			return re;
		}
		public void setRe(double re) {
			this.re = re;
		}
		public double getLambda() {
			return lambda;
		}
		public void setLambda(double lambda) {
			this.lambda = lambda;
		}
}
