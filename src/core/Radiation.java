package core;
import object.*;
import gui.*;
import java.util.*;

public class Radiation {
	//Jetot klass soderzhit informaciju ob izluchenii. 	
	ArrayList<Ray> rays;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Klass main poka chto prednaznachen dlja testirovanija. On ne budet tochkoj vhoda.			
		OSys OS=new OSys();		
		RadSource lsr=new RadSource();
		Infinity b=new Infinity();
		CircleHole ch=new CircleHole();
		FlatLens fl=new FlatLens();
		fl.setF(-7);
		fl.setCoordinate(60, 0, 0);
		OS.addSource(lsr);
		OS.addDOE(b);
		OS.addDOE(ch);
		OS.addDOE(fl);
		fl.setD(50);
		Settings S=new Settings();		
		S.Debug(true);
		S.setBones(false);
		Radiation R=new Radiation();
		R.evolve(OS,S);
		DrawingFrame fr=new DrawingFrame(OS,R.rays, S);
		fr.setVisible(true);		
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
			if(S.isDebug())System.out.println("Evolve: "+ i);
			rays.get(i).findEnd(OS,S);
			rays.get(i).interact(OS.getDOE().get(rays.get(i).getEnd()), rays, S);
		}
	}
	private void findfirstRays(OSys OS, Settings S) {
		// TODO Auto-generated method stub
		//Jetot metod nahodit luchi, ishodjashhie ot istochnikov.
		ArrayList<RadSource> src=OS.getSources();
		for(int i=0; i<src.size();i++){
			((RadSource) src.get(i)).emit(rays,S);
			//Teper' v spiske rays lezhat luchi, sozdannye istochniami i ne pereizluchennye.
		}		
	}	
}
