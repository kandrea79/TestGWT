package client;

import com.extjs.gxt.ui.client.data.ModelStringProvider;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.TreePanelEvent;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanelSelectionModel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import dto.Server;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by karanmalhi on 9/14/15.
 */
public class Main implements EntryPoint {
    private final ArrayList<Server> servers = new ArrayList<Server>();
    public void onModuleLoad() {
        FlowPanel panel = new FlowPanel();

        final  TreeStore<Server> store = new TreeStore<Server>();
//        store.add(model.getChildren(), true);

        final TreePanel<Server> tree = new TreePanel<Server>(store);
        tree.setWidth(300);
        tree.setLabelProvider(new ModelStringProvider<Server>() {
            @Override
            public String getStringValue(Server model, String property) {
                return model.getName();
            }
        });
        tree.setSelectionModel(new TreePanelSelectionModel<Server>(){
            @Override
            protected void onMouseClick(TreePanelEvent e) {
                Server item = (Server)e.getItem();
                GWT.log(item.getName() + " is clicked");
                super.onMouseClick(e);
            }

        });
//        tree.setDisplayProperty("name");
//        tree.getStyle().setLeafIcon(Resources.ICONS.music());

        ButtonBar buttonBar = new ButtonBar();

        buttonBar.add(new Button("Expand All", new SelectionListener<ButtonEvent>() {
            public void componentSelected(ButtonEvent ce) {
                tree.expandAll();
            }
        }));
        buttonBar.add(new Button("Collapse All", new SelectionListener<ButtonEvent>() {
            public void componentSelected(ButtonEvent ce) {
                tree.collapseAll();
            }
        }));
        ServerServiceAsync service = ServerService.App.getInstance();
        service.getServers(new AsyncCallback<TreeSet<Server>>() {
            @Override
            public void onFailure(Throwable caught) {
                GWT.log(caught.getMessage());
            }

            @Override
            public void onSuccess(TreeSet<Server> result) {
                servers.clear();
                store.removeAll();
                for (Server server : result) {
                    servers.add(server);
                    GWT.log("Added server " + server.getName());
                }
                store.add(servers, true);

            }
        });


        panel.add(buttonBar);
        panel.add(tree);
        panel.add(new Text("This is one text"));
        panel.add(new Text("This is another text"));
        panel.add(new Text("third"));
        panel.add(new Text("fourth"));
        RootPanel.get().add(panel);
    }
    private void init(){

    }
}
