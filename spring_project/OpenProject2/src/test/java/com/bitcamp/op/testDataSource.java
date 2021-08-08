package com.bitcamp.op;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;

public class testDataSource {

	   
    @Inject
    private DataSource ds;
   
   
    @Test
    public void testDS() throws Exception{

       
        try(Connection con = ds.getConnection()){
            System.out.println("dataSource설정 성공");
            System.out.println(con);
        }catch(Exception e){
            System.out.println("실패");
            e.printStackTrace();
        }
    }
  
}
