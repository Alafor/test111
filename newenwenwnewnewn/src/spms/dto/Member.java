package spms.dto;

import java.util.Date;

public class Member {
private int mno;
private String email;
private String name;
private String password;
private Date cre_date;
private Date mod_date;
public int getMno() {
	return mno;
}
public Member setMno(int mno) {
	this.mno = mno;
	return this;
}
public String getEmail() {
	return email;
}
public Member setEmail(String email) {
	this.email = email;
	return this;
}
public String getName() {
	return name;
}
public Member setName(String name) {
	this.name = name;
	return this;
}
public String getPassword() {
	return password;
}
public Member setPassword(String password) {
	this.password = password;
	return this;
}
public Date getCre_date() {
	return cre_date;
}
public Member setCre_date(Date cre_date) {
	this.cre_date = cre_date;
	return this;
}
public Date getMod_date() {
	return mod_date;
}
public Member setMod_date(Date mod_date) {
	this.mod_date = mod_date;
	return this;
}
}
