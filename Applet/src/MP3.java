import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MP3 extends Thread {
	static Player player;
	static String base = "sonidos/";

	public void run() {
		try {
			String ruta = base + NextMP3.i + ".mp3";
			FileInputStream fis = new FileInputStream(ruta);
			BufferedInputStream bis = new BufferedInputStream(fis);
			player = new Player(bis);
			player.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		player.close();
	}
}