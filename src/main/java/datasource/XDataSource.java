package datasource;

import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class XDataSource implements DataSource {
	private static LinkedList<Connection> ll = new LinkedList<Connection>();

	static {
		InputStream in = XDataSource.class.getClassLoader().getResourceAsStream("jdnc.properties");
		Properties p = new Properties();
		try {
			p.load(in);
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			int initSize = Integer.parseInt(p.getProperty("jdbcPoolInitSize"));
			Class.forName(driver);
			for (int i = 0; i < initSize; i++) {
				// Connection c=DriverManager.getConnection(url, p);
				Connection c = DriverManager.getConnection(url, username, password);
				ll.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		if (ll.size() > 0) {
			final Connection conn = ll.removeFirst();
			Connection connProxy = (Connection) Proxy.newProxyInstance(this.getClass().getClassLoader(),
					conn.getClass().getInterfaces(), new InvocationHandler() {

						public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
							// TODO Auto-generated method stub
							//without reflection, we can not control the close method
							//override is not a good way
							if (arg1.getName().equals("close")) {
								ll.add(conn);
								return null;
							} else {
								return arg1.invoke(conn, arg2);
							}
						}

					});
			return connProxy;
		} else {
			throw new RuntimeException("database is busy!");
		}
	}

	public Connection getConnection(String arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
