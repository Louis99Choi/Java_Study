// Java21-2-HW3-32184731-��âȯ
public interface Subject {
	void addObserver(Observer o);
	void removeObserver(Observer o);
	void notifyObservers(Animal animal, boolean flag);
}
