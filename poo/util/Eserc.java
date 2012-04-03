package poo.util;

public class Eserc {
	public static void compatta( Vector v ){
		int incr=0;
		while(incr!=v.size()){
			for(int i=1;i<v.size();i++){
				if(v.get(incr).equals(v.get(i)))
					v.remove(i);	
			}//for
			incr++;
		}//while
		System.out.println("Non ci sono doppioni!");
	}//compatta il quale toglie gli elementi doppi
		
	public static void main( String[] args){
		int []a={13,2,10,4,9,5};
		Vector<Double> v1=new ArrayVector();
		Vector<Double> v2=new ArrayVector();
		v1.add(5.0);v1.add((double)2);v1.add(5.0);v1.add(5.0);
		v2.add(4.0);v2.add(74.0);v2.add(7.0);v2.add(12.5);
		compatta(v1);
              System.out.println("Vettore senza doppioni "+v1);
}
}
