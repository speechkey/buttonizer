package myapp;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

// _ah/api/buttonizer/v0.0.0.1/bpreading/1
@Api(name = "buttonizer",
        version = "v0.0.0.1",
        description = "Buttonizer Api")
public class ButtonizerEndpoint {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    //curl -X POST --header "Content-Type: application/json" -d '{"buttonId": "Foo"}' https://dashboard-button
    // .appspot.com/_ah/api/buttonizer/v0.0.0.1/fire
    @ApiMethod(
            name = "event.fire",
            path = "fire",
            httpMethod = ApiMethod.HttpMethod.POST)
    public void add(ButtonizerEvent event) {
        System.out.println("Event fired: " + event);
    }

    //curl -X POST --header "Content-Type: application/json" -d '{"buttonId": "Foo", "eventId": "doIt"}' https://dashboard-button.appspot.com/_ah/api/buttonizer/v0.0.0.1/pair
    @ApiMethod(
            name = "event.pair",
            path = "pair",
            httpMethod = ApiMethod.HttpMethod.POST)
    public void pair(ButtonizerPair pair) {
        Entity entity = new Entity("ButtonizerPair");
        entity.setProperty("buttonId", pair.getButtonId());
        entity.setProperty("eventId", pair.getEventId());
        datastore.put(entity);

        System.out.println("Button paired: " + pair);
    }

}
