package jresurf.tree;

import java.util.Collection;

public interface Node<T extends Node<?>> {

	public void addChild(RequestData data);
	
	public Collection<T> getChildren();
	
	public int numChildren();

}
