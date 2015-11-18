package dto;

import com.extjs.gxt.ui.client.data.BaseTreeModel;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by karanmalhi on 9/14/15.
 */
public class Server extends BaseTreeModel implements Serializable,Comparable<Server> {
    private String id;
    private String name;
    private static long ID = 0;

    public Server() {
        String s = String.valueOf(++ID);
        this.id = s;
        this.name = "Server "+ s;
    }
    public Server(Set<Server> children){
        this();
        for (Server child : children) {
            add(child);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Server server = (Server) o;

        return id.equals(server.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Server{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Server server) {
        return this.getName().compareTo(server.getName());
    }
}
