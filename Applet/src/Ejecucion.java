import java.applet.Applet;
import java.awt.*;
import javax.swing.*;

public class Ejecucion extends Applet {
	private static final long serialVersionUID = 1L;
	public static Thread hr = new MP3();
	public static Plateral pL = new Plateral();
	public static JButton bPMP3 = new JButton("PLAYMP3");
	public static JButton bNMP3 = new JButton("NEXTMP3");
	public static JButton bPVMP3 = new JButton("PREVMP3");
	public static JButton bSMP3 = new JButton("STOPMP3");

	public Ejecucion() {
		BorderLayout bol = new BorderLayout();
		setLayout(bol);
		bPMP3.addActionListener(new PlayMP3());
		bNMP3.addActionListener(new NextMP3());
		bPVMP3.addActionListener(new PrevMP3());
		bSMP3.addActionListener(new StopMP3());
		add(pL, BorderLayout.CENTER);
		pL.add(bPVMP3);
		pL.add(bPMP3);
		pL.add(bNMP3);
		pL.add(bSMP3);

	}

	public void paint(Graphics g1) {
		super.paint(g1);
	}
}