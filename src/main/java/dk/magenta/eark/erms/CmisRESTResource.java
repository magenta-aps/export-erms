package dk.magenta.eark.erms;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.chemistry.opencmis.client.api.Session;

@Path("cmis")
public class CmisRESTResource {

	private Session cmisSession;
	
	public CmisRESTResource() {
		CmisConnector connector = new Cmis1_1Connector();
		cmisSession = connector.getCmisSession();
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("productname")
    public JsonObject test() {
    	JsonObject json = Json.createObjectBuilder()
    			.add("productName", cmisSession.getRepositoryInfo().getProductName())
    			.build();
    	return json;
    }
    
	
}
