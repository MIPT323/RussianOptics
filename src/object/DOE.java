package object;
import core.*;

import java.util.*;

import core.*;;
//Jeto klass difrakcionnyh opticheskih jelementov 
public abstract class DOE {
	//Uznat', peresekaetsja li luch s dannym doje. Esli da. to gde?
	public abstract void intersect(Ray R);
	//Luch taki peresekaetsja s nekotorymi jelementami. Togda jelement pereizluchit novye luchi
	public abstract void interact(Ray R, ArrayList<Ray> A, Settings S);
	
}
