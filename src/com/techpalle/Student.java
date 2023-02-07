package com.techpalle;

import java.sql.*;
import java.util.ArrayList;

public class Student 
{
	Connection con = null;
	Statement s = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public static String url = "jdbc:mysql://localhost:3306/palle";
//	By default MySQL Server name is localhost or 127.0.0.1
//	We can give or assign any server name or host name
	public static String username = "root";
	public static String password = "admin";
	
	public void creating ()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			String qry = "create table Student (sno int primary key auto_increment, sname varchar(50), sub varchar(50), email varchar(50))";
			s = con.createStatement();
			
			s.executeUpdate(qry);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (s != null)
				{
					s.close();
				}
				if (con != null)
				{
					con.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public void inserting (String sname, String sub, String email)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			String qry = "insert into Student(sname, sub, email) values (?, ?, ?)";
			ps = con.prepareStatement(qry);
			ps.setString(1, sname);
			ps.setString(2, sub);
			ps.setString(3, email);
			
			ps.executeUpdate();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (ps != null)
				{
					ps.close();
				}
				if (con != null)
				{
					con.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
 
	public void update (int sno, String email, String sub)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			String qry = "update Student set email = ?,sub = ? where sno = ? ";
			ps = con.prepareStatement(qry);
			ps.setString(1, email);
			ps.setString(2, sub);
			ps.setInt(3, sno);
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (ps != null)
				{
					ps.close();
				}
				if (con != null)
				{
					con.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void delete (int sno)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			String qry = "delete from Student where sno =?";
			ps = con.prepareStatement(qry);
			ps.setInt(1, sno);
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (ps != null)
				{
					ps.close();
				}
				if (con != null)
				{
					con.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public void read()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			s = con.createStatement();
			
			String qry = "select * from Student";
			rs = s.executeQuery(qry);
			
			while(rs.next())
			{
				System.out.print(rs.getInt(1)+" ");
				System.out.print(rs.getString(2)+ " ");
				System.out.print(rs.getString(3)+ " ");
				System.out.println(rs.getString(4));
				System.out.println();
			}
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();
				}
				if (s != null)
				{
					s.close();
				}
				if (con != null)
				{
					con.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public ArrayList<Collections> Reading()
	{
		ArrayList<Collections> al = new ArrayList<Collections>();

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			s = con.createStatement();
			
			String qry = "select * from Student";
			rs = s.executeQuery(qry);
			
			while (rs.next())
			{
				int id = rs.getInt(1);
				String n = rs.getString(2);
				String s = rs.getString(3);
				String e = rs.getString(4);
				
				Collections c = new Collections(id, n, s, e);
				al.add(c);
			}
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if (rs != null)
				{
					rs.close();
				} 
				if (s != null)
				{
					s.close();
				} 
				if (con != null)
				{
					con.close();
				}
			}
			 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return al;
		
		
	}
}
