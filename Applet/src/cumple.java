import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class cumple extends Applet implements ActionListener, Runnable {
	private static final long serialVersionUID = 1L;
	boolean continuar = false;
	Label labelReturnedDay;
	Button buttonCompute;
	TextField textMonth;
	TextField textYear;
	TextField textDay;
	String menuTitle;
	int radio = 0;
	Label zodiaco;
	Label cumple;
	Button Stop;
	int d2 = 0;
	int depth;
	Thread ir;

	public cumple() {
		cumple = new Label("Para Su Cumpleaños Faltan ?");
		zodiaco = new Label("Su Signo Zodiacal es:");
		labelReturnedDay = new Label("Fecha de Nacimiento");
		textDay = new TextField(10);
		textMonth = new TextField(10);
		textYear = new TextField(10);
		buttonCompute = new Button("Calcular Día");
	}

	public void init() {
		setBackground(Color.orange);
		setLayout(new BorderLayout());
		add(createSwings(), "Center");
		textDay.requestFocus();
	}

	public void paint(Graphics g) {
		Image imagen = getImage(getDocumentBase(), "Imagenes/epn.png");
		g.drawImage(imagen, 0, radio, getWidth(), getHeight(), this);
	}

	private Panel createSwings() {

		// para el recuadro de ingreso de texto.....
		Panel pane = new Panel();
		GridBagLayout g1 = new GridBagLayout();
		GridBagConstraints gb = new GridBagConstraints();
		g1.setConstraints(textDay, gb);
		pane.add(textDay);
		gb.gridx = 2;
		gb.gridy = 2;
		gb.gridwidth = 1;
		g1.setConstraints(textMonth, gb);
		pane.add(textMonth);
		gb.gridx = 3;
		gb.gridy = 2;
		gb.gridwidth = 1;
		g1.setConstraints(textYear, gb);
		pane.add(textYear);
		gb.ipady = 0;
		gb.weighty = 0.5D;
		gb.gridx = 2;
		gb.gridy = 3;
		gb.gridwidth = 1;
		gb.anchor = 10;
		g1.setConstraints(labelReturnedDay, gb);
		pane.add(labelReturnedDay);
		gb.ipady = 0;
		gb.weighty = 0.5D;
		gb.gridx = 2;
		gb.gridy = 10;
		gb.gridwidth = 1;
		gb.anchor = 10;
		g1.setConstraints(zodiaco, gb);
		pane.add(zodiaco);
		gb.ipady = 0;
		gb.weighty = 0.5D;
		gb.gridx = 2;
		gb.gridy = 14;
		gb.gridwidth = 1;
		gb.anchor = 10;
		g1.setConstraints(cumple, gb);
		pane.add(cumple);
		buttonCompute.addActionListener(this);
		gb.weighty = 0.12D;
		gb.ipady = 10;
		gb.gridx = 2;
		gb.gridy = 4;
		gb.gridwidth = 1;
		g1.setConstraints(buttonCompute, gb);
		pane.add(buttonCompute);
		return pane;
	}

	private String dayAsString(int j) {
		switch (j) {
		case 2: // '\002'
			return "Lunes";

		case 3: // '\003'
			return "Martes";

		case 4: // '\004'
			return "Miercoles";

		case 5: // '\005'
			return "Jueves";

		case 6: // '\006'
			return "Viernes";

		case 7: // '\007'
			return "Sabado";

		case 1: // '\001'
			return "Domingo";
		}
		return "";
	}

	public void actionPerformed(ActionEvent e) {
		if (ir == null) {
			ir = new Thread(this);
			if (!ir.isAlive()) {
				ir.start();
				continuar = true;
				buttonCompute.setEnabled(true);
			} else {
				continuar = false;
				repaint();
				ir.start();
			}
			// reinicio.repaint();
		}
	}

	public void run() {
		while (continuar) {

			int dayNumber = 99;
			int d = 99;
			int m = 99;
			int y = 99;
			try {
				d = Integer.parseInt(textDay.getText());
				m = Integer.parseInt(textMonth.getText());
				y = Integer.parseInt(textYear.getText());
			} catch (NumberFormatException err) {
				labelReturnedDay.setText("Fecha Invalida");
				continue;
			}
			if (d > 0 && d < 32 && m > 0 && m < 13 && y > 999 && y < 10000) {
				m--;
				Calendar calendar = new GregorianCalendar(y, m, d);
				dayNumber = calendar.get(7);
				d2 = calendar.get(Calendar.DAY_OF_YEAR);
				labelReturnedDay.setText("Usted Nacio un Día : " + dayAsString(dayNumber));
			} else {
				labelReturnedDay.setText("Fecha Invalida");
				continue;
			}
			m++;
			if ((d >= 22 && m == 1) || (d <= 21 && m == 2)) {
				zodiaco.setText("Su Signo Es Acuario");
			}
			if ((d >= 22 && m == 2) || (d <= 20 && m == 3)) {
				zodiaco.setText("Su Signo Es Piscis");
			}
			if ((d >= 21 && m == 3) || (d <= 20 && m == 4)) {
				zodiaco.setText("Su Signo Es Aries");
			}
			if ((d >= 21 && m == 4) || (d <= 20 && m == 5)) {
				zodiaco.setText("Su Signo Es Tauro");
			}
			if ((d >= 21 && m == 5) || (d <= 21 && m == 6)) {
				zodiaco.setText("Su Signo Es Geminis");
			}
			if ((d >= 22 && m == 6) || (d <= 22 && m == 7)) {
				zodiaco.setText("Su Signo Es Cancer");
			}
			if ((d >= 23 && m == 7) || (d <= 22 && m == 8)) {
				zodiaco.setText("Su Signo Es Leo");
			}
			if ((d >= 23 && m == 8) || (d <= 21 && m == 9)) {
				zodiaco.setText("Su Signo Es Virgo");
			}
			if ((d >= 22 && m == 9) || (d <= 22 && m == 10)) {
				zodiaco.setText("Su Signo Es Libra");
			}
			if ((d >= 23 && m == 10) || (d <= 21 && m == 11)) {
				zodiaco.setText("Su Signo Es Escorpion");
			}
			if ((d >= 22 && m == 11) || (d <= 22 && m == 12)) {
				zodiaco.setText("Su Signo Es Sagitario");
			}
			if ((d >= 23 && m == 12) || (d <= 21 && m == 1)) {
				zodiaco.setText("Su Signo Es Capricornio");
			}

			GregorianCalendar calendar1 = new GregorianCalendar();
			int d1 = calendar1.get(Calendar.DAY_OF_YEAR);

			if ((d2 - d1) <= 0) {
				cumple.setText("Su Cumpleaños Es En " + (365 + (d2 - d1)) + " Días Mas");
			} else {
				cumple.setText("Su Cumpleaños Es En " + (d2 - d1) + " Días Mas");
			}
		}

	}

}