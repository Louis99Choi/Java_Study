// Java21-2-Lab2-32184731-��âȯ


// interface for Image Processor.
import java.awt.image.BufferedImage;

public interface IProcessor {
	public BufferedImage process(BufferedImage image); // abstract method for Image Process.
	public String name();

}
