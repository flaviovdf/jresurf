package jresurf.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tree {

	private final Map<Integer, IPNode> ipRoots;
	
	public Tree() {
		this.ipRoots = new HashMap<>();
	}
	
	public Tree buildFromData(List<RequestData> requests) {
		
		for (RequestData data : requests) {
			this.addRequest(data);
		}
		
		return this;
	}
	
	public Tree buildFromReader(Reader reader, LineParser parser) 
			throws IOException {
		BufferedReader buffReader = new BufferedReader(reader);
		String line;
		while ((line = buffReader.readLine()) != null) {
			RequestData data = parser.parse(line);
			this.addRequest(data);
		}
		
		return this;
	}
	
	private void addRequest(RequestData data) {
		int ipHash = data.ipHash;
		
		IPNode ipRoot = null;
		if (this.ipRoots.containsKey(ipHash)) {
			ipRoot = this.ipRoots.get(ipHash);
		} else {
			ipRoot = new IPNode(ipHash);
			this.ipRoots.put(ipHash, ipRoot);
		}
		
		ipRoot.addChild(data);
	}

	public Tree reSurfPrune(double minTime, double minSize,
			int minChildren) {
		
		return this;
	}
	
}
