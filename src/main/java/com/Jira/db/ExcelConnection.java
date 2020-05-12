package com.Jira.db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelConnection {
	
	
	public static List<Map<String, String>>  getAssigneeList() throws InterruptedException, FilloException {
		List<Map<String, String>> dataSet = new ArrayList<Map<String, String>>();
		Fillo file=new Fillo();
		Connection connection=file.getConnection(System.getProperty("user.dir")+"\\Shared_Automated Defect Management Scenarios.xlsx");
		String strQuery="Select AssigneeLevel,AssigneeName from MetaData";
		Recordset rs=connection.executeQuery(strQuery);
		  while(rs.next()){
		     ArrayList<String> dataColl=rs.getFieldNames();
		     Map<String, String> row = new HashMap<String, String>(dataColl.size());
	        for (int i=0; i< dataColl.size(); i++){
                String data=dataColl.get(i);
                String dataVal=rs.getField(data);
                row.put(data, dataVal);
	        }
	        dataSet.add(row);
		  }		  
		rs.close();
		connection.close();
		return dataSet;
	}
	
	public static List<Map<String, String>>  getexcelData() throws InterruptedException, FilloException {
		List<Map<String, String>> dataSet = new ArrayList<Map<String, String>>();
		Fillo file=new Fillo();
		Connection connection=file.getConnection(System.getProperty("user.dir")+"\\Shared_Automated Defect Management Scenarios.xlsx");
		String strQuery="Select Label,Status,Bugassignedto from Data";
		Recordset rs=connection.executeQuery(strQuery);
		  while(rs.next()){
		     ArrayList<String> dataColl=rs.getFieldNames();
		     Map<String, String> row = new HashMap<String, String>(dataColl.size());
	        for (int i=0; i< dataColl.size(); i++){
                String data=dataColl.get(i);
                String dataVal=rs.getField(data);
                row.put(data, dataVal);
	        }
	        dataSet.add(row);
		  }		  
		rs.close();
		connection.close();
		return dataSet;
	}
	
	public static List<Map<String, String>>  getConfigData() throws InterruptedException, FilloException {
		List<Map<String, String>> dataSet = new ArrayList<Map<String, String>>();
		Fillo file=new Fillo();
		Connection connection=file.getConnection(System.getProperty("user.dir")+"\\Shared_Automated Defect Management Scenarios.xlsx");
		String strQuery="Select * from Config";
		Recordset rs=connection.executeQuery(strQuery);
		  while(rs.next()){
		     ArrayList<String> dataColl=rs.getFieldNames();
		     Map<String, String> row = new HashMap<String, String>(dataColl.size());
	        for (int i=0; i< dataColl.size(); i++){
                String data=dataColl.get(i);
                String dataVal=rs.getField(data);
                row.put(data, dataVal);
	        }
	        dataSet.add(row);
		  }		  
		rs.close();
		connection.close();
		return dataSet;
	}
}
