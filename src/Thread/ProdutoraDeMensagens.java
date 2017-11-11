package Thread;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ProdutoraDeMensagens extends Thread{


	public static List<String> mensagens = new ArrayList();


	public ProdutoraDeMensagens() {
	}
	@Override
	public void run() {

		synchronized(this) {

			int x = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de mensagens que deseja adicionar"));
			for(int z=0; z<x; z++) {
				String msg = JOptionPane.showInputDialog("Informe a mensagem");
				try {	
					mensagens.add(msg);
					this.wait();

				}catch (InterruptedException e) {
					System.out.println("entrou no catch Produtora");
				}
			}	
		}
	}
	public synchronized String getMensagen(){
		for(String t: mensagens) {
			mensagens.remove(t);
			return t;
		}
		return null;
	}
	public synchronized List<String> getMensagens() {
		return mensagens;
	}
}

