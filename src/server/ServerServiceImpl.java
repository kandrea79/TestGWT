package server;

import client.ServerService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import dto.Server;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by karanmalhi on 9/14/15.
 */
public class ServerServiceImpl extends RemoteServiceServlet implements ServerService {
    @Override
    public TreeSet<Server> getServers() {
        System.out.println("Call to getServers()");
        TreeSet<Server> servers = new TreeSet<Server>();
        for(int i=0;i<4;i++){
            Set<Server> children = new TreeSet<Server>();
            for(int j=0;j<5;j++) {
                children.add(new Server());
            }
            Server server = new Server(children);
            servers.add(server);
        }
        return servers;
    }
}