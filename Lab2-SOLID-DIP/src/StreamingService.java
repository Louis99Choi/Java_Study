
public class StreamingService {
	private BugsMusic bugs;
	private MelonMusic melon;

	public StreamingService() {
		this.bugs = new BugsMusic();
		this.melon = new MelonMusic();
	}

	public void setBugsMusic(BugsMusic bugs) {
		this.bugs = bugs;
	}
	
	public void setMelonMusic(MelonMusic melon) {
		this.melon = melon;
	}

	public String stream( ) {
		return bugs.stream();
	}
	
	public String stream(Music music) {
		switch (music) {
		case BUGS:	return bugs.stream();
		case MELON: return melon.stream();
		default: return null;
		}
	}
}
