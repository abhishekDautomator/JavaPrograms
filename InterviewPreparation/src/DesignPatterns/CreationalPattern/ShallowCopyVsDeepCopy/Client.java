package DesignPatterns.CreationalPattern.ShallowCopyVsDeepCopy;

public class Client {

    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
        System.out.println("Creating object using Prototype design");

        NetworkConnection connection = new NetworkConnection();
        connection.setIp("1.82.37.00");
        connection.loadConnection();

        System.out.println(connection);

        connection.getDomains().remove(0);

        NetworkConnection networkConnection2 = (NetworkConnection) connection.clone(); //deep copy
        System.out.println(networkConnection2);
    }
}
