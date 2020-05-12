//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Map;
//
//import org.json.simple.parser.ParseException;
//
//import com.ciox.db.DBConnection;
//import com.ciox.db.DBDataRetreival;
//import com.ciox.db.DBSource;
//import com.ciox.db.Vendor;
//import com.ciox.utils.DBDataSourcesConfig;
//
//import junit.framework.TestCase;
//
//public class DBTest extends TestCase{
//	
//	/*public void testDBConnection()
//	{
//		DBConnection dbCoonecton = new DBConnection("QA01");
//    	Connection conn = dbCoonecton.getConnection();
//    	System.out.println("conn:"+conn);
//    	if(conn!=null)
//    	{
//    		try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//    	}
//	}
//	
//	public void testJSONParser()
//	{
//		DBDataSourcesConfig dbSC = new DBDataSourcesConfig();
//		List<DBSource> dbSources = dbSC.getDBSources();
//		for(DBSource dbSource : dbSources)
//		{
//			System.out.println("Name:"+dbSource.getName());
//			System.out.println("PortNumber:"+dbSource.getPortNumber());
//			System.out.println("Vendor:"+dbSource.getVendor());
//			
//		}
//	}
//	
//	public void testConnectionByDSName()
//	{
//		DBDataSourcesConfig dbSC = new DBDataSourcesConfig();
//		List<DBSource> dbSources = dbSC.getDBSources();
//		DBSource dbS = new DBSource();
//		dbS.setName("QA01");
//		
//		System.out.println(dbSources.contains(dbS));
//		
//		DBSource expDBS = dbSources.get(dbSources.indexOf(dbS));
//		System.out.println("Vendor:"+expDBS.getVendor());
//		System.out.println("Vendor:"+expDBS.getDbName());
//	}*/
//	
///*	public void testQuery()
//	{
//		DBDataRetreival dbDataRetreival;
//		try {
//			DBSource dbSource = new DBSource(Vendor.valueOf("ORACLE"), "smlgqa01.smartcorp.net", 1528, "smlogqa1", "CONNEX", "C0nnexqa_2013");
//			dbDataRetreival = new DBDataRetreival(dbSource);
//			List<String[]> data = dbDataRetreival.getQueryDataAsStringByIndex("select * from erequest where nlp_input_file_id = 22317020");
//			
//			for(String[] vals:data)
//			{
//				System.out.println("Value:"+vals[0]);
//			}
//		} catch (IOException | ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
//	public void testQueryByColumnName()
//	{
//		DBDataRetreival dbDataRetreival;
//		try {
//			DBSource dbSource = new DBSource(Vendor.valueOf("ORACLE"), "smlgqa01.smartcorp.net", 1528, "smlogqa1", "CONNEX", "C0nnexqa_2013");
//			dbDataRetreival = new DBDataRetreival(dbSource);
//			List<Map<String,String>> data = dbDataRetreival.getQueryDataAsStringByColumnName("select * from erequest where nlp_input_file_id = 22317020");
//			System.out.println("*************** By String ************************");
//			for(Map<String,String> vals:data)
//			{
//				System.out.println("EREQUEST_ID:"+vals.get("EREQUEST_ID"));
//				System.out.println("UPDATED_DT:"+vals.get("UPDATED_DT"));
//				System.out.println("PATIENT_MBI:"+vals.get("PATIENT_MBI"));				
//			}
//		} catch (IOException | ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
//	
//	public void testQueryDataAsObjectByColumnName()
//	{
//		DBDataRetreival dbDataRetreival;
//		try {
//			DBSource dbSource = new DBSource(Vendor.valueOf("ORACLE"), "smlgqa01.smartcorp.net", 1528, "smlogqa1", "CONNEX", "C0nnexqa_2013");
//			dbDataRetreival = new DBDataRetreival(dbSource);
//			List<Map<String,Object>> data = dbDataRetreival.getQueryDataAsObjectByColumnName("select * from erequest where nlp_input_file_id = 22317020");
//			System.out.println("*************** By Object ************************");
//			for(Map<String,Object> vals:data)
//			{
//				System.out.println("EREQUEST_ID:"+vals.get("EREQUEST_ID"));
//				System.out.println("UPDATED_DT:"+vals.get("UPDATED_DT"));
//				System.out.println("PATIENT_MBI:"+vals.get("PATIENT_MBI"));				
//			}
//		} catch (IOException | ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	*/
//	public void testMySQLQuery()
//	{
//		DBDataRetreival dbDataRetreival;
//		try {
//			DBSource dbSource = new DBSource(Vendor.valueOf("MYSQL"), "alpqtestcv01.smartcorp.net", 3306, "qa01", "svc_auto", "Auto@123");
//			dbDataRetreival = new DBDataRetreival(dbSource);
//			List<String[]> data = dbDataRetreival.getQueryDataAsStringByIndex("select * from AUTO_GENERAL_INFO");
//			
//			for(String[] vals:data)
//			{
//				for(String val:vals)
//				{
//					System.out.println("Value:"+val);
//				}
//			}
//		} catch (IOException | ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
//	
//	public void testMYSQLQueryByColumnName()
//	{
//		DBDataRetreival dbDataRetreival;
//		try {
//			DBSource dbSource = new DBSource(Vendor.valueOf("MYSQL"), "alpqtestcv01.smartcorp.net", 3306, "QA01", "svc_auto", "Auto@123");
//			dbDataRetreival = new DBDataRetreival(dbSource);
//			List<Map<String,String>> data = dbDataRetreival.getQueryDataAsStringByColumnName("select * from AUTO_GENERAL_INFO");
//			System.out.println("*************** By String ************************");
//			for(Map<String,String> vals:data)
//			{
//				System.out.println("SCENARIO_ID:"+vals.get("SCENARIO_ID"));
//				System.out.println("GENERAL_INFO_ID:"+vals.get("GENERAL_INFO_ID"));
//				System.out.println("RETURNRECORDSTOFACILITY:"+vals.get("RETURNRECORDSTOFACILITY"));				
//			}
//		} catch (IOException | ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
//
//}
