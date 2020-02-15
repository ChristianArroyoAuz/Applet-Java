import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextMP3 implements ActionListener {
	static int i = 1;

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent arg0) {
		if (Ejecucion.hr.isAlive() == true) {
			Ejecucion.hr.stop();
			MP3.player.close();
			if (i == 3) {
				i = 0;
			}
			if (i < 3) {
				i = i + 1;
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