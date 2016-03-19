package ca.clinitouch.dao;
/**
 * @author dine
 */
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ClinicalService {
	private static DataSource clinicalDataSource = null;
	private static Context context = null;

	public static DataSource clinicalConn() throws Exception {
		try {
			if (context == null) {
				context = new InitialContext();
			}
			clinicalDataSource = (DataSource) context.lookup("java:/comp/env/jdbc/clinicaldb");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clinicalDataSource;
	}
}
