import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayMP3 implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		if (Ejecucion.hr.isAlive() == false) {
			Ejecucion.hr = new MP3();
			Ejecucion.hr.start();
		}
	}
}