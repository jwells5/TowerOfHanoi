import java.util.*;

public class Hanoi {
    
    public static List<String> getSuccessor(String[] hanoi) {
        // TO DO
        // Implement the getSuccessor method
    	
    	List<String> input = new ArrayList<>(Arrays.asList(hanoi));
    	List<String> result = new ArrayList<>();
    	
    	for (int i = 0; i < input.size(); i++) {
    		List<String> modify = new ArrayList<>(Arrays.asList(hanoi));
    		
    		if (modify.get(i).equals("0")) {
    			// do nothing
    		} else if (i == 0) {
    			int disc = Integer.parseInt(modify.get(i).substring(0, 1));
    			if (Integer.parseInt(modify.get(i+1)) == 0) {
    				modify = checkNextZero(modify, i, disc);
    				result.add(arrayToString(modify));
    				System.out.println("Modify1: " + modify);
    				modify = new ArrayList<>(Arrays.asList(hanoi));
    			} else if (Integer.parseInt(modify.get(i+1).substring(0,  1)) > disc && Integer.parseInt(modify.get(i-1)) != 0) {
    				modify = checkNext(modify, i, disc);
    				result.add(arrayToString(modify));
    				System.out.println("Modify2: " + modify);
    				modify = new ArrayList<>(Arrays.asList(hanoi));
    			}
    			
    		} else if (i == modify.size()-1) {
    			int disc = Integer.parseInt(modify.get(i).substring(0, 1));
    			if (Integer.parseInt(modify.get(i-1)) == 0) {
    				modify = checkPrevZero(modify, i, disc);
    				result.add(arrayToString(modify));
    				System.out.println("Modify3: " + modify);
    				modify = new ArrayList<>(Arrays.asList(hanoi));
    			} else  if (Integer.parseInt(hanoi[i-1].substring(0,  1)) > disc && Integer.parseInt(modify.get(i-1)) != 0) {
    				modify = checkPrevious(modify, i, disc);
    				result.add(arrayToString(modify));
    				System.out.println("Modify4: " + modify);
    				modify = new ArrayList<>(Arrays.asList(hanoi));

    			}
    			
    		} else if (i > 0 && i < modify.size()-1){
    			int disc = Integer.parseInt(modify.get(i).substring(0, 1));
    			
    			if (Integer.parseInt(modify.get(i+1)) == 0) {
    				modify = checkNextZero(modify, i, disc);
    				result.add(arrayToString(modify));
    				System.out.println("Modify5: " + modify);
    				modify = new ArrayList<>(Arrays.asList(hanoi));
    			}
    			if (Integer.parseInt(modify.get(i+1).substring(0,  1)) > disc && Integer.parseInt(modify.get(i-1)) != 0) {
    				modify = checkNext(modify, i, disc);
    				result.add(arrayToString(modify));
    				System.out.println("Modify6: " + modify);
    				modify = new ArrayList<>(Arrays.asList(hanoi));
    			}

    			if (Integer.parseInt(modify.get(i-1)) == 0) {
    				modify = checkPrevZero(modify, i, disc);
    				result.add(arrayToString(modify));
    				System.out.println("Modify7: " + modify);
    				modify = new ArrayList<>(Arrays.asList(hanoi));
    			}
    			if (Integer.parseInt(hanoi[i-1].substring(0,  1)) > disc && Integer.parseInt(modify.get(i-1)) != 0) {
    				modify = checkPrevious(modify, i, disc);
    				result.add(arrayToString(modify));
    				System.out.println("Modify8: " + modify);
    				modify = new ArrayList<>(Arrays.asList(hanoi));
    				
    			}
    		}
    	
    	}
        return result;    
    }
    
    private static List<String> checkPrevious(List<String> input, int i, int disc) {
    	input.set(i-1, disc + "" + input.get(i-1));
		if (input.get(i).length() == 1) {
			input.set(i, "0");
		} else {
			input.set(i, input.get(i).substring(1));
		}
    	return input;
    }
    
    private static List<String> checkNext(List<String> input, int i, int disc) {
    	input.set(i+1, disc + "" + input.get(i+1));
		if (input.get(i).length() == 1) {
			input.set(i, "0");
		} else {
			input.set(i, input.get(i).substring(1));
		}
		return input;
    }
    
    private static List<String> checkPrevZero(List<String> input, int i, int disc) {
    	input.set(i-1, disc+"");
		if (input.get(i).length() == 1) {
			input.set(i, "0");
		} else {
			input.set(i, input.get(i).substring(1));
		}
    	return input;
    }
    
    private static List<String> checkNextZero(List<String> input, int i, int disc) {
    	input.set(i+1, disc+"");
		if (input.get(i).length() == 1) {
			input.set(i, "0");
		} else {
			input.set(i, input.get(i).substring(1));
		}
    	return input;
    }
    
    private static String arrayToString(List<String> input) {
    	
    	String toAdd = "";
    	for (int i = 0; i < input.size(); i++) {
    		if (i != input.size()-1) {
    			toAdd += input.get(i) + " ";
    		} else {
    			toAdd += input.get(i);
    		}
    	}
    	return toAdd;
    }

    public static void main(String[] args) {
        if (args.length < 3) {
	        return;
	    }
        
        List<String> sucessors = getSuccessor(args);
        for (int i = 0; i < sucessors.size(); i++) {
            System.out.println(sucessors.get(i));
        }    
    }
 
}

/**
import java.util.*;

public class Hanoi {
    
    public static List<String> getSuccessor(String[] hanoi) {
        // TO DO
        // Implement the getSuccessor method
    	
    	List<String> result = new ArrayList<>();

    	String[] original = new String[hanoi.length];
    	System.arraycopy(hanoi, 0, original, 0, hanoi.length);
    	
    	
    	for (int i = 0; i < hanoi.length; i++) {
    		
    		//hanoi = original;
    		System.out.println("Original: " + arrayToString(original));
    		System.out.println("Hanoi: " + arrayToString(hanoi));
    		//System.out.println("Current: " + hanoi[i]);
    		
    		if (hanoi[i].equals(0 + "")) {
    			// do nothing
    		} else if (i == 0) {
    			int disc = Integer.parseInt(hanoi[i].substring(0, 1));
    			if (Integer.parseInt(hanoi[i+1]) == 0) {
    				hanoi[i+1] = disc + "";
    				hanoi[i] = hanoi[i].substring(1);
    				result.add(arrayToString(hanoi));
    			} else if (Integer.parseInt(hanoi[i+1].substring(0,  1)) > disc) {
    				hanoi[i+1] = disc + "" + hanoi[i+1];
    				hanoi[i] = hanoi[i].substring(1);
    				result.add(arrayToString(hanoi));
    			}
    		} else if (i == hanoi.length-1) {
    			int disc = Integer.parseInt(hanoi[i].substring(0, 1));
    			if (Integer.parseInt(hanoi[i-1]) == 0) {
    				hanoi[i-1] = disc + "";
    				hanoi[i] = hanoi[i].substring(1);
    				result.add(arrayToString(hanoi));
    			} else  if (Integer.parseInt(hanoi[i-1].substring(0,  1)) < disc) {
    				hanoi[i-1] = disc + "" + hanoi[i-1];
    				hanoi[i] = hanoi[i].substring(1);
    				result.add(arrayToString(hanoi));
    			}
    		} else {
    			int disc = Integer.parseInt(hanoi[i].substring(0, 1));
    			if (Integer.parseInt(hanoi[i+1]) == 0) {
    				hanoi[i+1] = disc + "";
    				hanoi[i] = hanoi[i].substring(1);
    				result.add(arrayToString(hanoi));
    			} else if (Integer.parseInt(hanoi[i+1].substring(0,  1)) > disc) {
    				hanoi[i+1] = disc + "" + hanoi[i+1];
    				hanoi[i] = hanoi[i].substring(1);
    				result.add(arrayToString(hanoi));
    			}
    			
    			if (Integer.parseInt(hanoi[i-1]) == 0) {
    				hanoi[i-1] = disc + "";
    				hanoi[i] = hanoi[i].substring(1);
    				result.add(arrayToString(hanoi));
    			} else  if (Integer.parseInt(hanoi[i+1].substring(0,  1)) < disc) {
    				hanoi[i-1] = disc + "" + hanoi[i-1];
    				hanoi[i] = hanoi[i].substring(1);
    				result.add(arrayToString(hanoi));
    			}
    		}
    		
    	}
    	
        return result;    
    }
    
    public static String arrayToString(String[] add) {
    	
    	String toAdd = "";
    	for (int i = 0; i < add.length; i++) {
    		if (i != add.length-1) {
    			toAdd += add[i] + " ";
    		} else {
    			toAdd += add[i];
    		}
    	}
    	return toAdd;
    }

    public static void main(String[] args) {
        if (args.length < 3) {
	        return;
	    }

        
        List<String> sucessors = getSuccessor(args);
        for (int i = 0; i < sucessors.size(); i++) {
            System.out.println(sucessors.get(i));
        }    
    }
 
}
*/