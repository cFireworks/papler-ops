package com.papler.devops.platform.infrastructure.datasource.mysql;

import javax.inject.Singleton;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class DatabaseBoundary {

    public Connection getConnection(String databaseName) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","123456");
        return connection;

    }

    public List<List<String>> executeSql(Connection connection, String sql) throws SQLException {
        //创建数据库操作对象
        Statement statement = connection.createStatement();
        //执行sql语句，返回结果
        ResultSet resultSet = statement.executeQuery(sql);
        List<List<String>> result = new ArrayList<>();
        ResultSetMetaData meta = resultSet.getMetaData();
        int columnCount = meta.getColumnCount();
        while (resultSet.next()){
            List<String> row = new ArrayList<>();
            for (int i=0; i < columnCount; ++i) {
                row.add(resultSet.getString(i));
            }
            result.add(row);
        }
        return result;
    }
}
