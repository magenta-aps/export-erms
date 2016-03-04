package dk.magenta.eark.erms;

import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	private List<String> acceptedExtractionFormats;
	
	public MyResource() {
		acceptedExtractionFormats = new ArrayList<String>();
		acceptedExtractionFormats.add(Constants.EXTRACTION_FORMAT_EARKSIP);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("save-extraction-format")
	public JsonObject saveExtractionFormat(@QueryParam("format") String format) {
		
		JsonObjectBuilder builder = Json.createObjectBuilder();
		if (acceptedExtractionFormats.contains(format)) {
			builder.add(Constants.SUCCESS, true);
		} else {
			builder.add(Constants.SUCCESS, false);
			builder.add(Constants.ERRORMSG, "Invalid extraction format");
		}

		return builder.build();
	}
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it YES sir hut hurra...Ihh jep igen kkjubiiiii kk nnnn mmmm!";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("test")
    public JsonObject test() {
    	JsonObject json = Json.createObjectBuilder()
    			.add("success", false)
    			.build();
    	return json;
    }
    
}
