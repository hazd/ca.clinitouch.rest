/**
 * @author dine
 */
package ca.clinitouch.rest.status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ca.clinitouch.dao.ClinicalService;

@Path("/v1/status")
public class V1Status {
	private static final String API_VERSION = "00.01.00";

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle() {
		return "<strong>Java Web Service</strong>";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/all")
	public String returnAll() {
		return "<strong>Java Web Service, Version:" + API_VERSION + ", Date: 2016-03-19</strong>";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/version")
	public String returnVersion() {
		return "<strong>Version:" + API_VERSION + "</strong>";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/db")
	public String returnDBStatus() throws Exception {
		PreparedStatement query = null;
		String myString = null;
		String returnString = null;
		Connection conn = null;
		try {
			conn = ClinicalService.clinicalConn().getConnection();
			query = conn.prepareStatement("SELECT SYSDATE() DATETIME");
			ResultSet rs = query.executeQuery();
			while (rs.next()) {
				myString = rs.getString("DATETIME");
			}
			returnString = "<strong>Clinical DB Status</strong><BR>DataBase Date Time return:" + myString;
			query.close();
		} catch (Exception e) {
			returnString= "<strong>Clinical DB Status</strong><BR>DataBase Error returned:" + e.getMessage();
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
		}
		return returnString;
	}
}
