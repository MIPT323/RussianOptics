package core;
import object.*;
//import core.*;

import java.util.*;

import object.Ray;
public class Radiation {
	//Jetot klass soderzhit informaciju ob izluchenii. 	
	ArrayList<Ray> rays;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Klass main poka chto prednaznachen dlja testirovanija. On ne budet tochkoj vhoda.		
		OSys OS=new OSys();
		
		Source lsr=new Source();
		OS.addSource(lsr);

	}
	public void evolve(OSys OS, Settings S){
		//Jetot metod vychisljaet mnozhestvo luchej ot istochnikov i ih parametry
		findfirstRays(OS, S);
		//teper' otpravim luchi razmnozhat'sja
		for(int i=0; i<rays.size(); i++){
			//Najdem konec lucha, zatem pereizluchim i sozdadim novye. Oni otpravjatsja v konec spiska i budut obrabotany pozzhe.
			DOE d = rays.get(i).findEnd(OS);
			
		}
	}
	private void findfirstRays(OSys OS, Settings S) {
		// TODO Auto-generated method stub
		//Jetot metod nahodit luchi, ishodjashhie ot istochnikov.
		ArrayList src=OS.getSources();
		for(int i=0; i<src.size();i++){
			((Source) src.get(i)).emit(rays,S);
			//Teper' v spiske rays lezhat luchi, sozdannye istochniami i ne pereizluchennye.
		}		
	}	
}
