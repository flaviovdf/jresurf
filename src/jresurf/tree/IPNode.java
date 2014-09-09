package jresurf.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class IPNode implements Node<URLNode> {

	private final Collection<URLNode> children;
	final int ipHash;
	
	IPNode(int ipHash) {
		this.ipHash = ipHash;
		this.children = new ArrayList<>();
	}
	
	@Override
	public void addChild(RequestData data) {
		
		Node<?> parent = null;
		for (URLNode candidateParent : this.children) {
			parent = candidateParent.findNodeWithUrl(data.referrer);
			if (parent != null) {
				break;
			}
		}
		
		if (parent != null) {
			parent.addChild(data);
		} else {
			URLNode newNode = new URLNode(data, this);
			this.children.add(newNode);
		}
	}
	
	@Override
	public Collection<URLNode> getChildren() {
		return Collections.unmodifiableCollection(this.children);
	}
	
	@Override
	public int numChildren() {
		return this.children.size();
	}
}