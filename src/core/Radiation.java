package core;
import object.*;

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
		Infinity b=new Infinity();
		CircleHole ch=new CircleHole();
		OS.addSource(lsr);
		OS.addDOE(b);
		OS.addDOE(ch);
		Settings S=new Settings();
		Radiation R=new Radiation();
		R.evolve(OS,S);
		
	}
	public Radiation(){
		rays=new ArrayList<Ray>();
	}
	public void evolve(OSys OS, Settings S){		
		//Jetot metod vychisljaet mnozhestvo luchej ot istochnikov i ih parametry
		findfirstRays(OS, S);
		//teper' otpravim luchi razmnozhat'sja
		for(int i=0; i<rays.size(); i++){
			//Najdem konec lucha, zatem pereizluchim i sozdadim novye. Oni otpravjatsja v konec spiska i budut obrabotany pozzhe.
			System.out.println("Evolve: "+ i);
			rays.get(i).findEnd(OS);
			rays.get(i).interact(OS.getDOE().get(rays.get(i).getEnd()), rays, S);
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
