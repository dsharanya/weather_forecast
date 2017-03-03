
package sharanya.weather;

import java.util.List;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import sharanya.weather.Getter;

//import org.weather.weather.SQLException;
//import org.weather.weather.Statement;
//import org.weather.weather.datatest;
//import org.weather.weather.model.WeatherVO;

public class service {

	static String connectionURL = "jdbc:mysql://localhost:3306/weather_db";
	static Connection connection = null;
	static Getter get = new Getter();

	
	
	public static ArrayList<getclass> getAllWeathers() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(connectionURL, "root", "sai5kala");
		ArrayList<getclass> weatherList = new ArrayList<getclass>();
		try {
		getclass getc = new getclass();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM new_table");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		
		getc.setDATE(rs.getInt(1));
		//weathervo.setTmax(rs.getDouble(2));
		//weathervo.setTmin(rs.getDouble(3));
		weatherList.add(getc);
		//System.out.println(get.getDATE());

		}
		return weatherList;
		} 
		catch (Exception e) {
		throw e;
		}
	}

 
	public static Response getDate(int date) throws Exception
	{
		
    	
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "sai5kala");
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM new_table where date="+date);
			ResultSet rs = ps.executeQuery();
			if(!rs.isBeforeFirst())
			{
				return Response.status(Status.NOT_FOUND).entity("").build();
			} 
			else{				
				
			
					while (rs.next())
					{
						
						get.setDATE(rs.getInt(1));
						get.setTmax(rs.getDouble(2));
						get.setTmin(rs.getDouble(3));
						//System.out.println(weathervo.getDate());

				}
				return Response.status(Status.OK).entity(get).build();
			}	
			
			
		}
		
		catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
      
			
		
	}
	
	
	public static  Response updateClimate(int date, double tmax, double tmin) {
		try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(connectionURL, "root", "sai5kala");
		
    	
    	List<Getter> lt=new ArrayList<Getter>();
    	Getter data = new Getter();
    	data.setDATE(date);
    	data.setTmax(tmax);
    	data.setTmin(tmin);
    	
    	System.out.println("   "+date+"   "+tmax+"  "+tmin);
    	lt.add(data);
		String query="INSERT INTO new_table(date,tmax,tmin) VALUES("+date+","+tmax+","+tmin+")";
			java.sql.Statement stt=connection.createStatement();
			stt.executeUpdate(query);	
			return Response.status(Status.CREATED)
			.entity(data)
			.build();
				
		} 
		catch (Exception e) {
				e.printStackTrace();
				return Response.status(Status.CONFLICT)
						.entity(e)
						.build();
			}
    }
	
    public static String deleteClimate(int date) {
    
    	String query="DELETE FROM new_table WHERE date="+date;	
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "sai5kala");
				
			Statement stt=connection.createStatement();
			int a=stt.executeUpdate(query);
			if(a==1){
			System.out.println("Executed  "+a);
				return "SUCCESS";
			}
			else
				throw new SQLException();
		} 
		catch (Exception e) {
				e.printStackTrace();
				return "NO_DATA for given input";
			}
    }
     
	

}