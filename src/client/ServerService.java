package client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import dto.Server;

import java.util.TreeSet;

/**
 * Created by karanmalhi on 9/14/15.
 */
@RemoteServiceRelativePath("ServerService")
public interface ServerService extends RemoteService {
    /**
     * Utility/Convenience class.
     * Use ServerService.App.getInstance() to access static instance of ServerServiceAsync
     */
    public static class App {
        private static final ServerServiceAsync ourInstance = (ServerServiceAsync) GWT.create(ServerService.class);

        public static ServerServiceAsync getInstance() {
            return ourInstance;
        }
    }
    public TreeSet<Server> getServers();
}
