package sorts;

import java.util.ArrayList;

public class SelectionSort {
	
	public static ArrayList<Integer> sort(ArrayList<Integer> array){

		for(int pos=0; pos<array.size(); pos++){
			int lowest;
			int lowestIndex=-1;
			lowest = array.get(pos);
			for(int pos2=pos+1; pos2<array.size(); pos2++){
				int testing = array.get(pos2);
				if(testing<lowest){
					lowest=array.get(pos2);
					lowestIndex = pos2;
				}
			}
			if(lowestIndex!=-1){
				int first = array.remove(pos);
				int second = array.remove(lowestIndex-1);
				array.add(pos, second);
				array.add(lowestIndex, first);
			}
		}
		System.out.println(array);		
		return array;
		
	}
}
