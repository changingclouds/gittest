package com.bqz.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bqz.entity.Product;
import com.bqz.entity.Spec;

public class ProductTest {

	public static void main(String[] args) {

		// mybatis的配置文件
		String resource = "conf.xml";
		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		InputStream is = ProductTest.class.getClassLoader().getResourceAsStream(
				resource);
		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(is);
		// 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
		// Reader reader = Resources.getResourceAsReader(resource);
		// 构建sqlSession的工厂
		// SqlSessionFactory sessionFactory = new
		// SqlSessionFactoryBuilder().build(reader);
		// 创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "com.bqz.mapping.productMapper.getProductList";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		List<Product> list = session.selectList(statement);
		
		for( Product temp : list){
			
			System.out.println("productName:"+temp.getName());
			for( Spec spec : temp.getSpec()){
				System.out.println("    spec : "+spec.getProductid() + spec.getSpecname());
			}
			
		}
		System.out.println(list.size());
		
		
//		String statement = "com.bqz.mapping.specMapper.getSpecList";
//		
//		List<Spec> list = session.selectList(statement);
//		
//		for( Spec spec : list){
//			System.out.println(" guige:"+spec.getSpecname() +" product:"+spec.getProduct().getName());
//		}
		
		
	}
}
