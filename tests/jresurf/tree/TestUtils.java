package jresurf.tree;

import java.util.Arrays;
import java.util.List;

public class TestUtils {

	public static List<RequestData> fakeTrace() {
		RequestData req1 = new RequestData(0, "1", "0", "text/html", 
				3 * 1024, System.currentTimeMillis() / 1000);
		
		RequestData req2 = new RequestData(0, "2", "0", "text/html", 
				4 * 1024, System.currentTimeMillis() / 1000);

		RequestData req3 = new RequestData(0, "3", "0", "text/html", 
				4 * 1024, System.currentTimeMillis() / 1000);

		RequestData req4 = new RequestData(0, "4", "1", "text/html", 
				4 * 1024, System.currentTimeMillis() / 1000);
		
		RequestData req5 = new RequestData(1, "5", "1", "text/html", 
				4 * 1024, System.currentTimeMillis() / 1000);
		
		RequestData req6 = new RequestData(1, "6", "5", "text/html", 
				4 * 1024, System.currentTimeMillis() / 1000);
		
		RequestData req7 = new RequestData(1, "7", "5", "text/html", 
				4 * 1024, System.currentTimeMillis() / 1000);
		
		return Arrays.asList(req1, req2, req3, req4, req5, req6, req7);
	}
	
}
