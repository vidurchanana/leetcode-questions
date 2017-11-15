/**
 * Date 11/14/2017
 * @author Vidur Chanana
 *
 * All test cases covered. 
 */
 
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MeanMedianMode {

	public double mean(List<Integer> list){
		if(list.size() == 0) return 0;
		long sum = 0;
		for(int i = 0; i < list.size(); i++){
			sum += list.get(i);
		}
		return (double) sum/list.size();
	}
	
	public double median(List<Integer> list){
		if(list.size() == 0) return 0;
		Collections.sort(list);
		if(list.size() % 2 == 1) return list.get((list.size() / 2));
		return ((list.get(list.size()/2) + list.get(list.size()/2 - 1)) / 2.0);
	}
	
	public List<Integer> mode(List<Integer> list){
    // Bucket sort is the best way to find the mode
    // You can use the same for finding top k elements
		List<Integer> res = new ArrayList<>();
		if(list.size() == 0) return res;
		
		List<Integer>[] bucket = new List[list.size()];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < list.size(); i++){
			map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
		}
		
		for(int key : map.keySet()){
			int value = map.get(key);
			if(bucket[value] == null){
				bucket[value] = new ArrayList<>();
			}
			bucket[value].add(key);
		}

		int i = bucket.length - 1;
		while(bucket[i] == null){
			i--;
			if(bucket[i] != null){
				res.addAll(bucket[i]);	
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		list.add(0);
		list.add(0);
		list.add(1);
		list.add(1);
		list.add(2);
		System.out.println(new MeanMedianMode().median(list));
	}
}
