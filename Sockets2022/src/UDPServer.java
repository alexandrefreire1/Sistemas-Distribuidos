import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

	public static void main(String[] args) {

		System.out.println("-----------------------");
		System.out.println(":: SERVIDOR INICIADO ::");
		System.out.println("-----------------------");
		
		int port = 2300;
		
		try {
			DatagramSocket serverSocket = new DatagramSocket(port);
			
			while(true) {
				
				//vetor para armazenar as informa��es
				byte[] receiveData = new byte[1024];
				//receber as informa��es e jogar no vetor
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				
				//escuta a porta 1450 e oq vier dela ser� armazenado no receivePacket
				serverSocket.receive(receivePacket);
				
				//converto p/ string
				String sentence = new String(receivePacket.getData());
				
				
				if(sentence.substring(0,4).equalsIgnoreCase("sair")) {
					break;
				}
				InetAddress IpAddress = receivePacket.getAddress();
				System.out.println(IpAddress.getHostAddress()+" - Mensagem: "+sentence.trim());
			}
			//fecha a conex�o
			serverSocket.close();
			System.out.println("\n-------------------");
			System.out.println("Servidor finalidado.");
		
		} catch (Exception e) {
			System.out.println("ERRO: "+e.getMessage());
			e.printStackTrace();
		}

	}

}