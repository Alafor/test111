package com.hk.ansdtos;

import java.io.Serializable;
import java.util.Date;

//DTO?´?˜?Š¤ êµ¬í˜„: dataë¥? ?‹´?•„?„œ ? „?‹¬?•˜?Š” ê°ì²´[?œ1,?œ2,...]
public class AnsDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private int seq;
	private String id;
	private String title;
	private String content;
	private Date regdate;
	private int refer;
	private int step;
	private int depth;
	private int readcount;
	private String deflag;
	public AnsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnsDto(int seq, String id, String title, String content, Date regdate, int refer, int step, int depth,
			int readcount, String deflag) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.refer = refer;
		this.step = step;
		this.depth = depth;
		this.readcount = readcount;
		this.deflag = deflag;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getRefer() {
		return refer;
	}
	public void setRefer(int refer) {
		this.refer = refer;
	}
	public int getstep() {
		return step;
	}
	public void setstep(int step) {
		this.step = step;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getreadcount() {
		return readcount;
	}
	public void setreadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getDeflag() {
		return deflag;
	}
	public void setDeflag(String deflag) {
		this.deflag = deflag;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "AnsDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", regdate="
				+ regdate + ", refer=" + refer + ", step=" + step + ", depth=" + depth + ", readcount=" + readcount
				+ ", deflag=" + deflag + "]";
	}
	public AnsDto(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	
}
