import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


public class SwingObserverFrame implements ActionListener{
	public SwingObserverFrame(String name) {
		super(name);
		
		JButton button = new JButton("정말 해도 될까?");
		
		button.addActionListener(event -> System.out.println("할지 말지 고민이네~"));
		
		this.getContentPane().add(BorderLayout.CENTER, button);
		this.setSize(200,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		System.out.println();
	}

}
