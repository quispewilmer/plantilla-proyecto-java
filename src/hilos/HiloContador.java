package hilos;

import vista.Logueo;

public class HiloContador extends Thread {
	Logueo esto;
	public HiloContador(Logueo logueo) {
		esto = logueo;
	}
	public void run() {
		for(int i = 10; i >= 1; i--) {
			Logueo.lblTiempo.setText(i + "s");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		esto.dispose();
	}
}
