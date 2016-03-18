import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadConexaoReceber extends Thread{

	private Socket cliente;
	private boolean continuar = true;
	private int nextmsgtoread = 0;
	
	public ThreadConexaoReceber(Socket cliente) {
		this.cliente = cliente;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
			saida.flush();

			System.out.println("Novo cliente (receber) em: " + this.cliente.getRemoteSocketAddress().toString());
			String array = "Bem-vindo a sala de bate-papo da turma.";
			saida.writeObject(array);
			while(cliente.isConnected()) {
				if (nextmsgtoread < ServerSalaDeBatePapo.lastMessageNumber()) {
					String msg = ServerSalaDeBatePapo.getMsg(nextmsgtoread++);
					saida.writeObject(msg);
				}
			}
			saida.close();
			cliente.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
