package Thread;

import javax.swing.JOptionPane;

public class ConsumidoraDeMensagens extends Thread{

	static ProdutoraDeMensagens pm = new ProdutoraDeMensagens();
	
	public ConsumidoraDeMensagens() {

	}
	@Override
	public void run() {
		inicia();
		
	}
	public synchronized void inicia() {
		

			if(pm.getMensagens().size() == 0) {

				try {		
					this.wait();

				} catch (InterruptedException e) {
					System.out.println("Entrou no catch");
				}	
			}
				String msg = pm.getMensagen();
				JOptionPane.showMessageDialog(null, msg);
				System.out.println(msg);
				System.out.println(pm.getMensagens().size());
			
			
			
	}
}

