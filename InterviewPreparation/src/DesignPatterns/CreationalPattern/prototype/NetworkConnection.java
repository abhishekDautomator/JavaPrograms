package DesignPatterns.CreationalPattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class NetworkConnection implements Cloneable{
    //This design pattern is used when we have a scenario where object creation is costing
    // heavy resource and takes time to create. It copies an existing object rather than creating a new object
    // from the scratch.

    private String ip;
    private String connection; // suppose this connection takes time to load
    private List<String> domains = new ArrayList<>();

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void loadConnection() throws InterruptedException {
       this.connection = "loading connection";
       domains.add("www.abc.com");
       domains.add("www.xyz.com");
       domains.add("www.google.com");
       Thread.sleep(3000);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "NetworkConnection{" +
                "ip='" + ip + '\'' +
                ", connection='" + connection + '\'' +
                ", domains=" + domains +
                '}';
    }
}
