import util.Constants;

public class Main {

    public static void main(String[] args) {

        System.out.println("Creating web server...");
        WebServer webServer = new WebServer(Constants.PORT);
        System.out.println("Web server created!");

        webServer.start();

    }

}
