import java.io.ObjectInputStream;
import java.net.Socket;

public class ThreadConexaoEnviar extends Thread {
	
	private Socket client;
	private boolean continuar = true;
	public ThreadConexaoEnviar(Socket cliente) {
		this.client = cliente;
	}
	
	@Override
	public void run() {
		super.run();
		System.out.println("Novo cliente (enviar) em: " + this.client.getRemoteSocketAddress().toString());
		try {
			ObjectInputStream entrada = new ObjectInputStream(client.getInputStream());
			while(client.isConnected()) {
				String msg = (String) entrada.readObject();
				ServerSalaDeBatePapo.writeMsg(msg);
				System.out.println(msg);
			}
			entrada.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
