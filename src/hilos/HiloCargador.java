package hilos;

import vista.FrmPreLoader;
import vista.FrmPrincipal;

public class HiloCargador extends Thread {
	FrmPreLoader cargador;
	public HiloCargador(FrmPreLoader fpl) {
		cargador = fpl;
	}
	
	public void run() {
		for(int i = 1; i <= 100; i+=5) {
			FrmPreLoader.prbCarga.setValue(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		cargador.dispose();
		FrmPrincipal fp = new FrmPrincipal();
		fp.setVisible(true);
	}
}
