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

		int x = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de mensagens que deseja adicionar"));

		for(int a=0; a<x; a++) {
			String msg = JOptionPane.showInputDialog("Informe a mensagem");
			try {	
				synchronized (this) {
					mensagens.add(msg);
					System.out.println("foi dormir");
					this.wait();
					
				}

			} catch (InterruptedException e) {
				System.out.println("entrou no catch Produtora");
			}
		}
	}
	public List<String> getMensagens(){
		return this.mensagens;
	}
}
