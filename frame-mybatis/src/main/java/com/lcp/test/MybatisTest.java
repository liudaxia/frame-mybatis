package com.lcp.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lcp.model.Role;

public class MybatisTest {
	
	public static void main(String[] args) {
		//配置文件路径
		String resource="mybatis/mybatis.xml";
		
		InputStream is=MybatisTest.class.getClassLoader().getResourceAsStream(resource);
		
		SqlSessionFactory sf=new SqlSessionFactoryBuilder().build(is);
		
		SqlSession s=sf.openSession();
		
		String mapper="com.lcp.role.";
		
		List<Role> roleList=s.selectList(mapper+"getRole");
		
		for(Role role:roleList){
			System.out.println(role.getRoleName());
		}
	}

}
