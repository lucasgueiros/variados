import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerSalaDeBatePapo {

	public static void main(String[] args) {
		mensagens.add("INÍCIO DO BATE-PAPO");
		new Thread () {
			@Override
			public void run() {
				super.run();
				int portaEntrada = 2423;
				try {
					ServerSocket server = new ServerSocket(portaEntrada);
					System.out.println("Servidor ouvindo na porta: " + portaEntrada);
					while(true) {
						Socket client = server.accept();
						new ThreadConexaoReceber(client).start();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
		new Thread () {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				int portaSaida = 2424;
				try {
					ServerSocket server = new ServerSocket(portaSaida);
					System.out.println("Servidor ouvindo na porta: " + portaSaida);
					while(true) {
						Socket client = server.accept();
						new ThreadConexaoEnviar(client).start();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				super.run();
				int i = 0;
				while(true) {
					if(i < mensagens.size()) System.out.println(mensagens.get(i++));
				}
			}
		}.start();
		
	}

	public static ArrayList<String> mensagens = new ArrayList<>();

	public static synchronized void writeMsg(String ymsg) {
		mensagens.add(ymsg);
	}
	
	public static synchronized String getMsg(int i) {
		return mensagens.get(i);
	}

	public static synchronized int lastMessageNumber() {
		return mensagens.size();
	}
}
