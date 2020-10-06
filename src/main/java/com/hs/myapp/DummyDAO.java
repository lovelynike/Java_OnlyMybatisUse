package com.hs.myapp;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Repository;

@Repository
public class DummyDAO {
	private SqlSession sqlSession;
	
	public DummyDAO() throws IOException {		
		InputStream inputStream = Resources.getResourceAsStream("/mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sqlSessionFactory.openSession(true);//true=auto commit;
	}    
 
    // 실제 파일 : mappers/example.xml
    // namespace: mappers.example.쿼리아이디
    private final String NAMESPACE = "com.hs.";
    
    
    public int selectTest() throws Exception {        
        return sqlSession.selectOne(NAMESPACE+"selectTest");
    }
    public DummyDTO selectTest2(int idx) throws Exception {  
    	return sqlSession.selectOne(NAMESPACE+"selectTest2",idx);
    }
    public DummyDTO selectTest3(int idx, String content) throws Exception {   
		
		/* 매개변수가 많으면 맵으로 만들어도 되고 객체로 만들어도 됨. */
    	
		/*
		 * MyParameter param = new MyParameter(2, "111"); return
		 * sqlSession.selectOne(NAMESPACE+"selectTest2",param);
		 */
		 
		
			
			  Map<String,Object> param = new HashMap<String, Object>();
			  param.put("idx",idx); param.put("content", content);
			  
			  return sqlSession.selectOne(NAMESPACE+"selectTest3",param);
			         
    }
    public List<DummyDTO> selectTest4() throws Exception {        
        return sqlSession.selectList(NAMESPACE+"selectTest4");
    }
    
    public int delete(String idx) {
    	return sqlSession.delete(NAMESPACE+"deleteTest",idx);    	
    }
    public int insert(String content) {
    	return sqlSession.insert(NAMESPACE+"insertTest",content);
    }
}