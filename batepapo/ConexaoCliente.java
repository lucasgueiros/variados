import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ConexaoCliente {

	public static void main(String[] args) {
		String servidor = JOptionPane.showInputDialog("Enderco IP");
		String nome = JOptionPane.showInputDialog("Seu nome: ");
		new Thread() {
			@Override
			public void run() {
				super.run();
				try {
					Socket cliente = new Socket(servidor,2423);
				
					ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
					while(true) {
						String obj = (String) entrada.readObject();
						System.out.println(obj);
					}
				} catch (Exception e ) {
					e.printStackTrace();
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				super.run();
				try {
					Socket cliente = new Socket(servidor,2424);
				
					ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
					while(cliente.isConnected()) {
						String obj = JOptionPane.showInputDialog("Digite uma mensagem");
						saida.writeObject(nome + ":: " + obj);
					}
				} catch (Exception e ) {
					e.printStackTrace();
				}
			}
		}.start();
	}

}
