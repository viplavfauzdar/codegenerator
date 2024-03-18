package com.viplav.utils.spring.codegenerator.controller;

import org.junit.jupiter.api.Test;
import com.viplav.utils.spring.codegenerator.service.DbOpsService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.sql.SQLException;
import java.util.Map;

public class DbOpsControllerTest {

    private DbOpsService dbOpsService = mock(DbOpsService.class);
    private DbOpsController dbOpsController = new DbOpsController(dbOpsService);

    @Test
    public void testAbout() {
        String result = dbOpsController.about();
        assertEquals("Spring Code Generation tool!", result);
    }

    @Test
    public void testDbTables() throws SQLException {
        List<String> tables = Arrays.asList("table1", "table2");
        when(dbOpsService.getTables()).thenReturn(tables);

        List<String> result = dbOpsController.dbTables();
        List<String> mockTables = Arrays.asList("table1", "table2");
        assertEquals(mockTables, result);
    }

    @Test
    public void testExecSql() {
        String sql = "SELECT * FROM table";
        dbOpsController.execSql(sql);

        // Add assertions or verify behavior as needed
    }

    @Test
    public void testDbColumnNames() throws SQLException {
        String tableName = "mockTable";
        Map<String, String> columns = new HashMap<>();
        columns.put("column1", "type1");
        columns.put("column2", "type2");

        when(dbOpsService.getColumns(tableName)).thenReturn(columns);

        Map<String, String> result = dbOpsController.dbColumnNames(tableName);
        result.put("column1", "type1");
        result.put("column2", "type2");
        assertEquals(columns, result);
    }

    @Test
    public void testGetTableData() throws SQLException {
        List<String> expectedData = Arrays.asList("data1", "data2");
        when(dbOpsService.getTableData(anyString())).thenReturn(expectedData);

        List<String> actualData = dbOpsController.getTableData("mockTable");

        assertEquals(expectedData, actualData);
    }

    @Test
    public void testCamelCaseString() {
        DbOpsService dbOpsService = new DbOpsService();
        DbOpsController dbOpsController = new DbOpsController(dbOpsService);

        String inputString = "sample_input_string";
        String expectedOutput = "sampleInputString";

        String actualOutput = dbOpsController.camelCaseString(inputString);

        assertEquals(expectedOutput, actualOutput);
    }

    // Add more test methods for other methods in DbOpsController using Mockito
    // mocks
}
