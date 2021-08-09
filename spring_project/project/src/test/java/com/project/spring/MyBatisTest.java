package com.project.spring;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;


import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:web/WEB-INF/applicationContext.xml"})
public class MyBatisTest {
    @Inject
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testFactory(){
        System.out.println(sqlSessionFactory);
    }

    @Test
    public void testSession() throws Exception{
        try{
            SqlSession sqlSession = sqlSessionFactory.openSession();
            System.out.println(sqlSession);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}