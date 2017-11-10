package Thread;

public class Main {

	public static void main(String[] args) {

		ProdutoraDeMensagens pm = new ProdutoraDeMensagens();

		ConsumidoraDeMensagens cm1 = new ConsumidoraDeMensagens();
		ConsumidoraDeMensagens cm2 = new ConsumidoraDeMensagens();
		ConsumidoraDeMensagens cm3 = new ConsumidoraDeMensagens();

		pm.start();

		while(true) {
			cm1.start();
			cm1.notify();
			cm2.start();
			cm2.notify();
			cm3.start();
			cm3.notify();
		}


	}

}
