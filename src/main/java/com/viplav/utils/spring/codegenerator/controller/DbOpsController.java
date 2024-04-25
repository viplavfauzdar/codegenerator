package com.viplav.utils.spring.codegenerator.controller;

import org.h2.tools.DeleteDbFiles;
import java.util.List; // Corrected import statement
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viplav.utils.spring.codegenerator.misc.Employees;
import com.viplav.utils.spring.codegenerator.misc.EmployeesRepository;
import com.viplav.utils.spring.codegenerator.service.DbOpsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PathVariable; // Added import statement

import java.sql.SQLException;

import java.util.Map;

@Tag(name = "DbOpsController", description = "Operations related to database operations")
@RestController
public class DbOpsController {

    public DbOpsController(DbOpsService dbOps) {
        this.dbOps = dbOps;
    }

    @Autowired
    DbOpsService dbOps;

    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = DbOpsService.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found", content = @Content) })
    @GetMapping("/about")
    public String about() {
        return "Spring Code Generation tool!";
    }

    @GetMapping("/dbtables")
    public List<String> dbTables() throws SQLException { // Corrected method signature
        return dbOps.getTables();
    }

    @PostMapping("/execsql")
    public void execSql(@RequestBody String sql) {
        sql = sql.toUpperCase();
        dbOps.execute(sql);
    }

    @DeleteMapping("/dbdelete")
    public void dbDelete() {
        DeleteDbFiles.execute("~/tmp/", "codegenerator", false);
    }

    @GetMapping("/gdbcolumns/{tableName}")
    public Map<String, String> dbColumnNames(@PathVariable String tableName) throws SQLException {
        tableName = tableName.toUpperCase();
        return dbOps.getColumns(tableName);
    }

    @GetMapping(value = "/tabledata/{tableName}")
    public List<String> getTableData(@PathVariable String tableName) throws SQLException {
        tableName = tableName.toUpperCase();
        return dbOps.getTableData(tableName);
    }

    @GetMapping("/camelcase/{inputString}")
    public String camelCaseString(@PathVariable String inputString) {
        return dbOps.camelCaseString(inputString);
    }

    @GetMapping("/generateclass/{tableName}")
    public String generateClass(@PathVariable String tableName) throws SQLException {
        tableName = tableName.toUpperCase();
        return dbOps.generateClassFromColumnNames(tableName);
    }

    @GetMapping("/generateEntityClass/{tableName}")
    public String generateEntityClass(@PathVariable String tableName) throws SQLException {
        tableName = tableName.toUpperCase();
        return dbOps.generateEntityClass(tableName);
    }
}
