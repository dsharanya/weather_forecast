package sharanya.weather;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.util.ArrayList;

	import javax.ws.rs.Consumes;
	import javax.ws.rs.DELETE;
	import javax.ws.rs.FormParam;
	import javax.ws.rs.GET;
	import javax.ws.rs.NotFoundException;
	import javax.ws.rs.POST;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;
	import javax.ws.rs.core.Response;
	import javax.ws.rs.core.Response.Status;

	import org.glassfish.jersey.server.JSONP;
	//import org.json.simple.JSONArray;
	//import org.json.simple.JSONObject;


	import javax.ws.rs.GET;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;

	import sharanya.weather.service;
	import sharanya.weather.Getter;

	@ Path("temp")

	public class weatherresource {
		
	service service= new service();

		@GET
		@Path("historical")
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<getclass> getMessage() throws Exception{

		
		return sharanya.weather.service.getAllWeathers();
	}
		
		@GET
	    @Path("/historical/{date}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response dateClimate(@PathParam("date") int date) throws Exception {
	    	return service.getDate(date);
	    }    
		
		@POST
	    @Path("/historical")
	    @Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public Response addClimate (@FormParam("date") int date,@FormParam("tmax") double tmax,@FormParam("tmin") double tmin)
		{
			return service.updateClimate(date,tmax,tmin);
			
		}
	    
		//DELETE particular data method
	    @DELETE
	    @Path("/historical/{date}")
	    @Produces(MediaType.TEXT_PLAIN)
	    public String deleteClimate(@PathParam("date") int date) {
	    	return service.deleteClimate(date);
	    }
		
	}


