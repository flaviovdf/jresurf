package jresurf.tree;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class URLNodeTest {

	@Test
	public void testCreation() {
		IPNode parent = new IPNode(0);
		
		RequestData data = new RequestData(0, "google.com", 
				"bing.com", "text/html", 
				3 * 1024, System.currentTimeMillis() / 1000);
		
		URLNode node = new URLNode(data, parent);
		assertEquals(data, node.data);
		assertEquals(parent, node.parent);
	}

	@Test
	public void testAddChild() {
		IPNode parent = new IPNode(0);
		
		RequestData data = new RequestData(0, "google.com", 
				"bing.com", "text/html", 
				3 * 1024, System.currentTimeMillis() / 1000);
		
		URLNode node = new URLNode(data, parent);
		assertEquals(data, node.data);
		assertEquals(parent, node.parent);
		
		assertEquals(0, node.getChildren().size());
		
		RequestData childData = new RequestData(1, "yahoo.com", 
				"google.com", "text/html", 
				4 * 1024, System.currentTimeMillis() / 1000);
		
		node.addChild(childData);
		assertEquals(1, node.getChildren().size());
		
		URLNode next = node.getChildren().iterator().next();
		assertEquals(childData, next.data);
	}
	
	@Test
	public void testFindNodeWithUrl() {
		IPNode parent = new IPNode(0);
		
		List<RequestData> fakeTrace = TestUtils.fakeTrace();
		Tree tree = new Tree().buildFromData(fakeTrace);
		
		
		//URLNode node = new URLNode(data, parent);
		//assertEquals(data, node.data);
		//assertEquals(parent, node.parent);
	}
	
}
