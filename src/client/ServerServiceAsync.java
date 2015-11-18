package client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import dto.Server;

import java.util.TreeSet;

/**
 * Created by karanmalhi on 9/14/15.
 */
public interface ServerServiceAsync {
    void getServers(AsyncCallback<TreeSet<Server>> async);
}
