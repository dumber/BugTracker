/**
 * 
 */
package helper;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dumber
 *
 */
public class PropertyManager {
	List<Map<String, List<Map<String,String>>>> table_colums_n_types;
	/**
	 * @throws SQLException 
	 * 
	 */
	public PropertyManager(Connection conn) throws SQLException {
		DatabaseMetaData meta = conn.getMetaData();
		String[] types = {"TABLE"};
		ResultSet rs_t = meta.getTables(null, null, "%", types);
		table_colums_n_types = new ArrayList<Map<String, List<Map<String,String>>>>();
		while (rs_t.next()) {
			String table = rs_t.getString("TABLE_NAME");
//			System.out.println("table " + table + " has the following columns");
			ResultSet rs_c = meta.getColumns(null, null, table, null);
			List<Map<String,String>> cts = new ArrayList<Map<String,String>>();
			int i = 0;
			while (rs_c.next()) {				
				String col = rs_c.getString("COLUMN_NAME");
				String typ = rs_c.getString("TYPE_NAME");
				Map<String, String> ct = new HashMap<String,String>();
				ct.put(col,typ);
//				System.out.println("c: " + col + " t: " + typ );
				cts.add(ct);
//				System.out.println("debuuug: " + cts.get(i));
				i+=1;
			}
//			System.out.println("deb:  " + cts);
			Map<String, List<Map<String,String>>> tct = new HashMap<String, List<Map<String,String>>>();
			tct.put(table, cts);
			table_colums_n_types.add(tct);
		}
	}
	
	public void printTableData() {
		for (Map<String, List<Map<String,String>>> tct : table_colums_n_types) {			
			for (Map.Entry<String, List<Map<String,String>>> tab_col_typ : tct.entrySet()) {
				String table = tab_col_typ.getKey();
				System.out.println("table " + table + " has the following columns");
				List<Map<String,String>> col_typ = tab_col_typ.getValue();
				for (Map<String,String> pair : col_typ) {
					for (Map.Entry<String, String> p : pair.entrySet()) {
						String col = p.getKey();
						String typ = p.getValue();
						System.out.println("c: " + col + " t: " + typ );
					}
					
				}
			}
		}
	}
}
