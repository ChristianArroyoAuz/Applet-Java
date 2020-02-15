import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopMP3 implements ActionListener {
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent arg0) {
		if (Ejecucion.hr.isAlive() == true) {
			Ejecucion.hr.stop();
			MP3.player.close();
			NextMP3.i = 1;
		}
	}
}