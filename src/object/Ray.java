package object;

import core.OSys;


public class Ray {
		//Jetot klass soderzhit parametry odnogo konkretnogo uchastka lucha
		double xs, ys;//koordinaty nachala
		double xe, ye;//koordinaty konca
		DOE end;//Kuda upjorsja
		public DOE getEnd() {
			return end;
		}
		public void setEnd(DOE end) {
			this.end = end;
		}
		public double getPhi() {
			return phi;
		}
		public void setPhi(double phi) {
			this.phi = phi;
		}
		boolean endFound;
		double phi;//Luch imeet napravlenie. Vozmozhno,u nego est' konec.
		double lambda;//u lucha est' dlina volny v metrah
		Object source;
		public DOE findEnd(OSys OS){
			//Metod ishhet konec lucha
			//Otpravljaet luch v beskonechnost'
			return OS.getDOE().get(0);}
		
		public boolean isEndFound() {
			return endFound;
		}
		public void setEndFound(boolean endFound) {
			this.endFound = endFound;
		}
		public double getXs() {
			return xs;
		}
		public Object getSource() {
			return source;
		}
		public void setSource(Object source) {
			this.source = source;
		}
		public void setXs(double xs) {
			this.xs = xs;
		}
		public double getYs() {
			return ys;
		}
		public void setYs(double ys) {
			this.ys = ys;
		}
		public double getXe() {
			return xe;
		}
		public void setXe(double xe) {
			this.xe = xe;
		}
		public double getYe() {
			return ye;
		}
		public void setYe(double ye) {
			this.ye = ye;
		}
		public double getLambda() {
			return lambda;
		}
		public void setLambda(double lambda) {
			this.lambda = lambda;
		}
}
