package core;
import java.util.*;
import object.*;
public class OSys {
	ArrayList<DOE> DOE;
	ArrayList<Source> Sources;
	//Nulevym jelementom v spiske DOJe dolzhen byt' jelement infinity. Drugih infinity byt' ne dolzhno.
	//Razdelenie na 2 massiva sdelano potomu. chto DOJe pereizluchajut, a istochniki sveta sozdajut novye luchi.
	public void addDOE(DOE b){
		DOE.add(b);		
	}
	public ArrayList<DOE> getDOE() {
		return DOE;
	}
	public ArrayList<Source> getSources() {
		return Sources;
	}
	public void addSource(Source b){
		Sources.add(b);
	}
}
