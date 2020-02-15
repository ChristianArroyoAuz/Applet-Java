import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrevMP3 implements ActionListener {
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent arg0) {
		if (Ejecucion.hr.isAlive() == true) {
			Ejecucion.hr.stop();
			MP3.player.close();
			if (NextMP3.i == 1) {
				NextMP3.i = 7;
			}
			if (NextMP3.i > 1 && NextMP3.i <= 7) {
				NextMP3.i = NextMP3.i - 1;
			}
			try {
				if (Ejecucion.hr.isAlive() == false) {
					Ejecucion.hr = new MP3();
					Ejecucion.hr.start();
				}
			} catch (Exception e) {

			}
		}
	}
}