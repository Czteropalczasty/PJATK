import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

     final int port_id = 5050;  //deklaracja jakiego id używasz


    public static void probablyRequired(BufferedReader bufferedReader,PrintWriter printWriter) throws IOException {
        //Wczytanie 1 lini od klienta i wypisanie jej
        System.out.println(bufferedReader.readLine());
        System.out.println(bufferedReader.readLine());
    }


    public  static void ExampleServerFunction(BufferedReader bufferedReader,PrintWriter printWriter) throws IOException {
        // Np zadanie jedno wymaga odebranie linijki i odesłanie jej skonkatenowanej 8 razy
        String lineToConcatate = bufferedReader.readLine();
        int howManyTimes = 0;

        for(int i = 0; i <= howManyTimes;i++){
            lineToConcatate += lineToConcatate;
        }
        printWriter.println(lineToConcatate);
    }
    //Definicja wymaganych zadań funkcji
    public static void serverFunction_1(BufferedReader bufferedReader,PrintWriter printWriter) throws IOException {}
    public static void serverFunction_2(BufferedReader bufferedReader,PrintWriter printWriter) throws IOException{}
    public static void serverFunction_3(BufferedReader bufferedReader,PrintWriter printWriter) throws IOException{}
    public static void serverFunction_4(BufferedReader bufferedReader,PrintWriter printWriter) throws IOException{}
    public static void serverFunction_5(BufferedReader bufferedReader,PrintWriter printWriter) throws IOException{}
    public static void serverFunction_6(BufferedReader bufferedReader,PrintWriter printWriter) throws IOException{}

    // In here put everything server should do
    public static void ServerFunction (Socket socket) throws IOException {}

    public static class ServerThread extends Thread {
        private final Socket socket;

        public ServerThread(Socket socket) {
            super();
            this.socket = socket;
        }

        public void run() {
            try {


                //Basic initialization
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                // Uncomment if required
                //probablyRequired(bufferedReader,printWriter);

                //Functions
                serverFunction_1(bufferedReader,printWriter);
                serverFunction_2(bufferedReader,printWriter);
                serverFunction_3(bufferedReader,printWriter);
                serverFunction_4(bufferedReader,printWriter);
                serverFunction_5(bufferedReader,printWriter);
                serverFunction_6(bufferedReader,printWriter);


            } catch (Exception e1) {
                // do nothing
                System.out.println('1');
            }

            try {
                socket.close();
            } catch (IOException e) {
                // do nothing
                System.out.println('2');
            }

        }
    }

    public void listenSocket(int port){
        ServerSocket serverSocket = null;
        Socket client = null;
        try {
            serverSocket = new ServerSocket(port);

        } catch (IOException e) {
            System.out.println("Could not listen");
            System.exit(-1);
        }
        System.out.println("Server listens on port: " + serverSocket.getLocalPort());
        while(true) {

            try {
                client = serverSocket.accept();
                System.out.println("[S] connecting with:" + client.getPort());
            }
            catch (IOException e) {
                System.out.println("Accept failed");
                System.exit(-1);
            }

            (new ServerThread(client)).start();
        }

    }

    public static void main(String[] args) {
        Server server = new Server();
        server.listenSocket(server.port_id);
    }


}
