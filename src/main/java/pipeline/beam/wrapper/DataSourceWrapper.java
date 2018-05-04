package pipeline.beam.wrapper;

import com.netcracker.mediation.common.spring.CommonContextProvider;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class DataSourceWrapper implements DataSource, Serializable {

    @Override
    public Connection getConnection() throws SQLException {
        return CommonContextProvider.provide().defaultDataSource().getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return CommonContextProvider.provide().defaultDataSource().getConnection(username, password);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return CommonContextProvider.provide().defaultDataSource().getLogWriter();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        CommonContextProvider.provide().defaultDataSource().setLogWriter(out);
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        CommonContextProvider.provide().defaultDataSource().setLoginTimeout(seconds);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return CommonContextProvider.provide().defaultDataSource().getLoginTimeout();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return CommonContextProvider.provide().defaultDataSource().getParentLogger();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return CommonContextProvider.provide().defaultDataSource().unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return CommonContextProvider.provide().defaultDataSource().isWrapperFor(iface);
    }
}
