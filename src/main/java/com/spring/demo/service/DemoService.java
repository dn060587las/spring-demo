package com.spring.demo.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * DemoService.
 * 
 * @author alitvinov
 */
@Component
public class DemoService {
    
    @Autowired
    private DataSource datasource;
    
    public List<String[]> readDataFromDatabase() throws SQLException {
        List<String[]> result = new LinkedList<>();
        
        try(Connection conn = datasource.getConnection();) {
            ResultSet rs = conn.prepareStatement("select * from account").executeQuery();
            while (rs.next()) {
                int columns = rs.getMetaData().getColumnCount();
                String [] dataRow = new String[columns];
                for (int i =0 ; i< columns; i++) {
                    dataRow[i] = rs.getString(i + 1);
                }   
                result.add(dataRow);
            }
            return result;
        }                
    }
}
