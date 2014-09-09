package jresurf.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class URLNode implements Node<URLNode> {

	private final Collection<URLNode> children;

	final RequestData data;
	final Node<?> parent;
	
	public URLNode(RequestData data, Node<?> parent) {
		this.data = data;
		this.parent = parent;
		this.children = new ArrayList<>();
	}

	@Override
	public void addChild(RequestData data) {
		URLNode newNode = new URLNode(data, this);
		this.children.add(newNode);
	}
	
	@Override
	public Collection<URLNode> getChildren() {
		return Collections.unmodifiableCollection(this.children);
	}
	
	@Override
	public int numChildren() {
		return this.children.size();
	}

	public Node<?> findNodeWithUrl(String url) {
		
		Node<?> foundNode = null;
		
		if (this.data.url.equals(url)) {
			foundNode = this;
		} else {
			for (URLNode child : children) {
				foundNode = child.findNodeWithUrl(url);
				if (foundNode != null) {
					break;
				}
			}
		}
		
		return foundNode;
	}



}