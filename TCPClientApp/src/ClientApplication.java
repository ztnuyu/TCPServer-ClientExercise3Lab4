

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This method launch the frame and manage the connection to the server.
 * 
 * @author emalianakasmuri
 *
 */

public class ClientApplication {
	
	static String  i = "IZZATISUHAIMI";

	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		
		// Launch client-side frame
		ClientFrame clientFrame = new ClientFrame();
		clientFrame.setVisible(true);
		
		// Connect to the server @ localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		
		// Update the status of the connection
		clientFrame.updateConnectionStatus(socket.isConnected());
		
		// Read from network
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		// Display the current date
		int counter = bufferedReader.read();
		//clientDateFrame.updateServerDate(currentDate);
		
		clientFrame.updateTestOutput(counter);
		
		// Close everything
		bufferedReader.close();
		socket.close();

	}

}