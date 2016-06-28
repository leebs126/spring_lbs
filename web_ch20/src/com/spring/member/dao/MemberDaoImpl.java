package com.spring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.spring.member.vo.MemberVO;

public class MemberDaoImpl implements MemberDao {
	protected final Log logger = LogFactory.getLog(getClass());
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List selectMemberList() throws DataAccessException {
		String query = "select id,name,height,weight,age"
				+ " from t_member " + " order by id desc";
		List memberList = new ArrayList();

		memberList=this.jdbcTemplate.query(query, new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setName(rs.getString("name"));
				memberVO.setHeight(rs.getInt("height"));
				memberVO.setWeight(rs.getInt("weight"));
				memberVO.setAge(rs.getInt("age"));
				return memberVO;
			}
		});
		return memberList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		 String id=memberVO.getId();
		 String name=memberVO.getName();
		 int age=memberVO.getAge();
		 int weight=memberVO.getWeight();
		 int height=memberVO.getHeight();
		String  query = "insert into t_member(id,name,age,weight,height) values  (";
		          query += "'" + id +"' ,";
				  query += "'" + name +"' ,";
				  query +=  age    +",";
				  query += "'" + weight    +"' ,";
				  query += "'" + height    +"') ";				
		System.out.println(query); 
		 int result=jdbcTemplate.update(query);
		 System.out.println(result); 
		 return result;
	}

}
