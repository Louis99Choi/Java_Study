
public class StreamingService2 {
	private Streaming2 stream;

	public void setStream(Streaming2 stream) {
		this.stream = stream;
	}

	public String stream() {
		return stream.stream();
	}
}
