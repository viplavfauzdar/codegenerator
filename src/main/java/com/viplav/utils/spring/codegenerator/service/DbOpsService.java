package com.viplav.utils.spring.codegenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException; // Added import for SQLException

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import lombok.NonNull;

@Service
@Slf4j
public class DbOpsService {

    @Autowired
    JdbcTemplate jdbcTemplate;
   
    @Value("${codegenerator.schema}")
    private String SCHEMA;

    @PostConstruct
    public void init() throws SQLException{
        jdbcTemplate.execute("SET SCHEMA " + SCHEMA+ ";");
        log.info("Changed schema to value in app.prop: " + SCHEMA);
        getConnection();
    }

    public void execute(@NonNull String sql){
        jdbcTemplate.execute(sql);
    }

    Connection connection=null;

    private void getConnection() throws SQLException {
        DataSource dataSource = jdbcTemplate.getDataSource();
        if (dataSource != null) {
            connection=dataSource.getConnection();
        } else {
            throw new SQLException("DataSource is null");
        }
    }

    public List<String> getTables() throws SQLException {
        List<String> tables = new ArrayList<>();
        //Connection connection = getConnection(); // Use getConnection() method
        if (connection != null) {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            try (ResultSet resultSet = databaseMetaData.getTables(null, "TEMP", null, new String[]{"TABLE"})) {
                while (resultSet.next()) {
                    String tableName = resultSet.getString("TABLE_NAME");
                    tables.add(tableName);
                }
            }
        } else {
            log.info("DataSource is null");
        }
        return tables;
    }
    
    public Map<String, String> getColumns(String tableName) throws SQLException {
        Map<String, String> columns = new HashMap<>();
        //Connection connection = getConnection(); // Use getConnection() method
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from " + tableName + " FETCH FIRST 1 ROW ONLY");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int c = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= c; i++) {
                String columnName = resultSetMetaData.getColumnName(i);
                String dataType = resultSetMetaData.getColumnTypeName(i);
                columns.put(columnName, dataType);
            }
        }
        return columns;
    }
    
    public List<String> getTableData(String tableName) throws SQLException {
        List<String> tableData = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;
        //Connection connection = getConnection(); // Use getConnection() method
        if (connection != null) {
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                while (resultSet.next()) {
                    StringBuilder rowData = new StringBuilder();
                    for (int i = 1; i <= columnCount; i++) {
                        rowData.append(metaData.getColumnName(i)).append(": ").append(resultSet.getString(i)).append(", ");
                    }
                    tableData.add(rowData.toString());
                }
            }
        }
        return tableData;
    }

    public String camelCaseString(String notCamelString){
        String[] words = notCamelString.toLowerCase().split("_");
        StringBuilder camelCaseString = new StringBuilder(words[0]);
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            camelCaseString.append(word.substring(0, 1).toUpperCase()).append(word.substring(1));
        }
        return camelCaseString.toString();
    }

    public String generateClassFromColumnNames(String tableName) throws SQLException {
        Map<String,String> columns = getColumns(tableName);
        StringBuilder classCode = new StringBuilder("@Data\npublic class ");
        classCode.append(tableName.substring(0,1)).append(tableName.substring(1).toLowerCase()).append(" {\n");
        for (String columnName : columns.keySet()) {
            classCode.append("\tprivate ").append(columns.get(columnName)).append(" ").append(camelCaseString(columnName)).append(";\n");
        }

        classCode.append("}");
        return classCode.toString();
    }

    public String generateEntityClass(String tableName) throws SQLException {
        Map<String, String> columns = getColumns(tableName);
        StringBuilder classCode = new StringBuilder("@Entity\n@Data\npublic class ");
        classCode.append(tableName.substring(0, 1).toUpperCase()).append(tableName.substring(1).toLowerCase()).append(" {\n");
        
        for (String columnName : columns.keySet()) {
            classCode.append("\t@Column(name = \"").append(columnName).append("\")\n");
            classCode.append("\tprivate ").append(columns.get(columnName)).append(" ").append(camelCaseString(columnName)).append(";\n");
        }
    
        classCode.append("}");
    
        return classCode.toString();
    }
    
}
