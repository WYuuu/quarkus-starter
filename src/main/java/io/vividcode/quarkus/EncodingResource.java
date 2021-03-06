package io.vividcode.quarkus;

import io.vertx.axle.core.eventbus.EventBus;
import io.vertx.axle.core.eventbus.Message;
import java.util.concurrent.CompletionStage;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/encoding")
public class EncodingResource {
  @Inject
  EventBus eventBus;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public CompletionStage<String> encode(@QueryParam("data") String data) {
    return eventBus.<String>request("encoding", data).thenApply(Message::body);
  }
}
