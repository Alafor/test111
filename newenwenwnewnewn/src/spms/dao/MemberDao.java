package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import spms.dto.Member;

public class MemberDao {
	Connection conn =null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	String sql="";
	public void setConnection(Connection conn){
		this.conn = conn;
	}
	
	public List<Member> selectList() {
		sql = " select MNO,MNAME,EMAIL,CRE_DATE from members ";
		List<Member> members = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				members.add(new Member().setMno(rs.getInt("MNO"))
						.setName(rs.getString("MNAME"))
						.setEmail(rs.getString("EMAIL"))
						.setCre_date(rs.getDate("CRE_DATE")));
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return members;
	}
	
	public Member selectOne(int mno) {
		sql = " select MNO,MNAME,EMAIL,CRE_DATE from members where Mno="+mno;
		Member member = new Member();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			member.setMno(rs.getInt("MNO"))
					.setName(rs.getString("MNAME"))
					.setEmail(rs.getString("EMAIL"))
					.setCre_date(rs.getDate("CRE_DATE"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return member;			
	}
	
	public void insert(Member member) {
		try {
			pstmt = conn.prepareStatement(" insert into members(MNO,EMAIL,MNAME,PWD,CRE_DATE,MOD_DATE) values(BOARD_SEQ.nextval,?,?,?,SYSDATE,SYSDATE) ");
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
	}
	
	public int update(Member member) {
		int result=0;
		try {
			pstmt =conn.prepareStatement(" update members set EMAIL=?,MNAME=?,PWD=?,MOD_DATE=sysdate) ");
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return result;
	}
	public int delete(int mno) {
		int result =0;
		try {
			pstmt = conn.prepareStatement(" delete members where MNO="+mno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return result;
	}
	public Member exist(String email,String password) {
		Member member = new Member();
		try {
			sql=" select email,mname from members where email='"+email+"' and pwd='"+password+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				member.setName(rs.getString("email")).setName(rs.getString("mname"));
				
			}else {
				close();
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return member;
		
		
	}
		
	
	public void close() {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
