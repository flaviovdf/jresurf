package jresurf.tree;

public class RequestData {

	public final int ipHash;
	public final String url;
	public final String referrer;
	public final String contentType;
	public final double contentSize;
	public final double timeStamp;

	public RequestData(int ipHash, String url, String referrer,
			String contentType, double contentSize, double timeStamp) {
		this.ipHash = ipHash;
		this.url = url;
		this.referrer = referrer;
		this.contentType = contentType;
		this.contentSize = contentSize;
		this.timeStamp = timeStamp;
	}
}
