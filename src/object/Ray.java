package object;

import java.util.ArrayList;

import core.OSys;
import core.Settings;


public class Ray extends OptObj {
		//Jetot klass soderzhit parametry odnogo konkretnogo uchastka lucha
		double zs, rs;//koordinaty nachala
		double ze, re;//koordinaty konca
		int end=-1;//Kuda upjorsja-№ DOE v arrayliste OS.getDOE()
		double phi;//Luch imeet napravlenie. Vozmozhno,u nego est' konec.
		double lambda;//u lucha est' dlina volny v metrah
		double bones;
		Object source;					
		public void findEnd(OSys OS, Settings S){
			//Metod ishhet konec lucha
			ArrayList<DOE> A=OS.getDOE();
			//default: 0-infinity; 
			int minD=0;
			double min=Double.MAX_VALUE;
			for(int i=0;i<A.size(); i++){
				if(intersect(A.get(i),S)==true){
				//if ray does go through we need to check isn`t it the closest DOE
					double l=(zs-ze)*(zs-ze)+(rs-re)*(rs-re);
					if(S.isDebug())System.out.println("l="+l);
					double temp=(ze-zs)*Math.cos(phi)+(re-rs)*Math.sin(phi);
					//temp>0 если луч направлен в стороны объекта а не от него
					if(l<min&&l>0&&temp>0){
						//if it is closer, we`ll remember that
						min=l;
						minD=i;
					}
				}
			}
			//vystavlyaem xe ye end
			end=minD;
			intersect(A.get(minD),S);
			if(S.isDebug())System.out.println("End of ray found. It`s " + minD);
			if(S.isDebug())System.out.println("ze=" +ze+"; re="+re);
			
			//default: 0-infinity; 
		}
		public boolean intersect(DOE D, Settings S){
			//This method checks if this ray goes through DOE D
			//If it does, method returns true AND
			//sets ze,re
			if(CircleHole.class==D.getClass()){
					if(S.isDebug())System.out.println("Checked CircleHole");
					//ray always touches circlehole screen. intercacts in different wayz
					double z=D.getZ();
					re=(z-zs)*Math.tan(phi)+rs;
					ze=z;	
					if(S.isDebug())System.out.println("ze="+ze);
					return true;
				};			
			if(FlatLens.class==D.getClass()){
					if(S.isDebug())System.out.println("Checked FlatLens");
					double z=D.getZ();
					double retemp=(z-zs)*Math.tan(phi)+rs;
					if(S.isDebug())System.out.println("z="+z+"; retemp= "+retemp);
					if(((FlatLens) D).getRadius()>retemp){
						re=retemp;
						ze=z;						
						return true;
					}								
			}	
			if(Lens.class==D.getClass()){}
			return false;
		}
		public void interact(DOE D, ArrayList<Ray> A, Settings S){
			if(S.isDebug())System.out.println("Interacted with #"+end+ " DOE");
			if(Infinity.class==D.getClass()){//Бесконечность
				return;}
			
			if(CircleHole.class==D.getClass()){
				if(Math.abs(re)<((CircleHole) D).getRadius()){
					//Luch popal v dirku
						Ray New=new Ray(ze,re,phi);
						New.setLambda(lambda);
						A.add(New);
				}// Если луч не попал - не будет других лучей
				return;
			}
			if(FlatLens.class==D.getClass()){
				//Ray R uzhe poluchil svoi ze, re v metode findEnd();
				//Poka bagovannyj metod prelomlenija
				double tg=Math.tan(phi)-re/((FlatLens) D).getF();
				Ray New=new Ray(ze,re,Math.atan(tg));
				New.setLambda(lambda);
				A.add(New);		
				return;
			}
		}
		public Ray(double z, double r, double phi){
				   zs=z;
				   rs=r;
				   this.phi=phi;   
				   end=-1;
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
			if(end<=0){return 1000000*Math.cos(phi);}else
			return ze;
		}
		public void setZe(double ze) {
			this.ze = ze;
		}
		public double getRe() {
			if(end<=0){return 1000000*Math.sin(phi);}else
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
