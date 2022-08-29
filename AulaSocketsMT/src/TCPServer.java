import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class TCPServer {

	public static void main(String[] args) {
		
		
		
		try {
			
			System.out.println("+------------:------------+");
			System.out.println(":: SERVIDOR TCP INICIADO ::");
			System.out.println("+------------:------------+");
			System.out.println();
			
			int port = 5000;
			ServerSocket socketServer = new ServerSocket(port);
			Socket socketClient = socketServer.accept();
			
			PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
			
			EscutaThread escuta = new EscutaThread(in);
			
			escuta.start();
			String entrada;
			
			while(true) {
				entrada = JOptionPane.showInputDialog(null, "Mensagem p/ o cliente", "Servidor", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("(SERVIDOR) digitou: " + entrada);
				out.println(entrada);
			}
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
