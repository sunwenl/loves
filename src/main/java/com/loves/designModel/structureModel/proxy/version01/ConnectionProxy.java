package com.loves.designModel.structureModel.proxy.version01;

import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionProxy implements  Connection{

    private Connection connection;

    public ConnectionProxy(Connection connection) {
        super();
        this.connection = connection;
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public void close() throws SQLException{
        System.out.println("不真正关闭连接，归还给连接池");
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
