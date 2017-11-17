package Thread;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		ProdutoraDeMensagens pm = new ProdutoraDeMensagens();

		ConsumidoraDeMensagens cm1 = new ConsumidoraDeMensagens();
		ConsumidoraDeMensagens cm2 = new ConsumidoraDeMensagens();
		ConsumidoraDeMensagens cm3 = new ConsumidoraDeMensagens();

		pm.start();

		cm1.start();
		cm2.start();
		cm3.start();

		do {

			if(pm.getMensagens().size()!=0) {
				if(cm1.isAlive()) {
					synchronized (cm1) {
						cm1.notify();
					}

				}else if(cm2.isAlive()) {
					synchronized (cm2) {
						cm2.notify();		
					}
				}else if(cm3.isAlive()) {
					synchronized (cm3) {
						cm3.notify();
					}
				}
			}
			synchronized (pm) {
				pm.notify();
			}

		}while(pm.isAlive());

	}

}
