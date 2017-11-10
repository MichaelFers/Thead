package Thread;

import java.util.List;

import javax.swing.JOptionPane;

public class ConsumidoraDeMensagens extends Thread{

	List<String> lista;
	public ConsumidoraDeMensagens() {

	}
	@Override
	public void run() {

		System.out.println("entrou no run Consumidora");

		synchronized (this) {
			ProdutoraDeMensagens pm = new ProdutoraDeMensagens();
			lista = pm.getMensagens();
			System.out.println(lista.size());
			if(lista.size() == 0) {
				System.out.println("entrou no if");
				try {
					System.out.println("foi dormir");
					this.wait();
				} catch (InterruptedException e) {
					System.out.println("Entrou no catch");
				}

			}
			System.out.println("saiu do if");
				JOptionPane.showMessageDialog(null, lista.get(1));
				System.out.println("entrou no else");
				lista.remove(1);
		}
		System.out.println("saiu do run");
	}
}
