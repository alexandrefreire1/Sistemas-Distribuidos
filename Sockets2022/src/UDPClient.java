import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JOptionPane;

public class UDPClient {

	public static void main(String[] args) {

		try {
			
			DatagramSocket clientSocket = new DatagramSocket();
			
			byte[] sendData = new byte[1024];
			
			InetAddress IpAddress = InetAddress.getByName("BRADDOCK");
			
			int port = 5000;
			
			while(true) {
				String sentence = JOptionPane.showInputDialog("Digite:");
				
				if(sentence.equalsIgnoreCase("sair")) {
					break;
				}
				String texto = " (XAND�O AVENTURAS) " + sentence;
				
				sendData = texto.getBytes();
				
				DatagramPacket sendPacket = new DatagramPacket(sendData, texto.length(), IpAddress, port);
				
				clientSocket.send(sendPacket);
				
				
				
			}
			//fecho a conex�o
			clientSocket.close();
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
			e.printStackTrace();
		}
	}

}