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
					System.out.println("t1 viva");

					synchronized (pm) {
						pm.notify();
						synchronized (cm1) {
							cm1.notify();
						}
					}

				}else if(cm2.isAlive()) {
					System.out.println("t2 viva");

					synchronized (pm) {
						pm.notify();
						synchronized (cm2) {
							cm2.notify();
						}
					}

				}else if(cm3.isAlive()) {
					System.out.println("t3 viva");

					synchronized (pm) {
						pm.notify();
						synchronized (cm3) {
							cm3.notify();
						}
					}
				}else {
					continue;
				}
			}

		}while(pm.isAlive());

	}

}
