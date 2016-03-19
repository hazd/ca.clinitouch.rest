package ca.clinitouch.rest.status;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/status")
public class V1Status {
	private static final String API_VERSION="00.01.00";
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle() {
		return "<strong>Java Web Service</strong>";
	}
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/all")
	public String returnAll() {
		return "<strong>Java Web Service, Version:"+API_VERSION+", Date: 2016-03-19</strong>";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/version")
	public String returnVersion() {
		return "<strong>Version:"+API_VERSION+"</strong>";
	}
}
