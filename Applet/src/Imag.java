import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Imag extends Applet {
	private static final long serialVersionUID = 1L;
	Scrollbar sbRadio = new Scrollbar();
	BorderLayout borderLayout1 = new BorderLayout();
	int radio = 0;
	Image img1, img2, img3, img6, img8, img9;

	public void init() {
		sbRadio.setOrientation(1);
		sbRadio.setValue(0);
		sbRadio.setMaximum(800);
		sbRadio.setUnitIncrement(0);
		sbRadio.setBlockIncrement(0);
		sbRadio.setMinimum(0);
		sbRadio.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent ev) {
				sbRadio_adjustmentValueChanged(ev);
			}
		});

		this.setLayout(borderLayout1);
		this.add(sbRadio, BorderLayout.WEST);
		img1 = getImage(getDocumentBase(), "imagenes/1.jpg");
		img3 = getImage(getDocumentBase(), "imagenes/2.jpg");
		img6 = getImage(getDocumentBase(), "imagenes/3.jpg");
		img8 = getImage(getDocumentBase(), "imagenes/4.jpg");
		img9 = getImage(getDocumentBase(), "imagenes/1.jpg");

	}

	void sbRadio_adjustmentValueChanged(AdjustmentEvent ev) {
		radio = sbRadio.getValue();
		repaint();
	}

	public void paint(Graphics g) {
		g.drawImage(img1, 0, radio, getWidth(), getHeight(), this);
		g.drawImage(img3, 0, radio - 200, getWidth(), getHeight(), this);
		g.drawImage(img6, 0, radio - 400, getWidth(), getHeight(), this);
		g.drawImage(img8, 0, radio - 600, getWidth(), getHeight(), this);
		g.drawImage(img9, 0, radio - 800, getWidth(), getHeight(), this);
	}
}