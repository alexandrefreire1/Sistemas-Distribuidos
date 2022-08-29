import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		
		System.out.println("+----------:----------+");
		System.out.println(":: SERVIDOR INICIADO ::");
		System.out.println("+----------:----------+");
		System.out.println();
		
		int port = 5000;
		
		ServerSocket socketServidor = new ServerSocket(port);
		Socket socketCliente = socketServidor.accept();
		
		PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
		
		String entrada;
		
		while((entrada=in.readLine()) != null) {
			System.out.println("Mensagem do cliente: " + entrada);
			out.println(entrada.toUpperCase());
			if(entrada.equalsIgnoreCase("sair")) {
				break;
			}
		}
		out.close();
		in.close();
		socketCliente.close();
		socketServidor.close();
		
		System.out.println();
		System.out.println("+---------:-----------+");
		System.out.println(":: CONEXÃO ENCERRADA ::");
		System.out.println("+---------:-----------+");
		
	}

}
