import java.io.*;
import java.util.*;

public class PrintLevel {
	
	public static void main(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
		
		String line;
		
		while ( (line = br.readLine()) != null) {
			String[] rels = line.split(",");
			int gen = Integer.parseInt(rels[rels.length - 1]);
			
			Map<String,ArrayList<String>> tree = new HashMap<String,ArrayList<String>>();
			
			String root = rels[0].split("->")[0];
			
			for (int i=0; i < rels.length-1; i++) {
				String in[] = rels[i].split("->");
				String par = in[0];
				String chi = in[1];
				
				if (tree.containsKey(par)) {
					tree.get(par).add(chi);
				}
				else {
					ArrayList<String> children = new ArrayList<String>();
					children.add(chi);
					tree.put(par, children);
				}
			}
			
			System.out.println(tree);
			
			StringBuilder result = new StringBuilder();
			iterativeDepthSearch(result, tree, root, gen);
			
			System.out.println(result.deleteCharAt(result.length()-1).toString() + " \n");
		}
		
	}

	private static void iterativeDepthSearch(StringBuilder result,
			Map<String, ArrayList<String>> tree, String currentNode, int limit) {
		 
		if (limit <= 1) {
			result.append(currentNode).append(",");
			return;
		}
		else {
			for (String child : tree.get(currentNode)) {
				currentNode = child;
				iterativeDepthSearch(result, tree, currentNode, limit - 1);
			}
		}
	}

}
