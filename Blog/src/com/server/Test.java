package com.server;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.model.B_article;
import com.model.Blogger;
import com.model.Visitor;
import com.util.ApplicationContextUtil;

public class Test {
public static void main(String[] args) throws SQLException {
	ApplicationContext ac= ApplicationContextUtil.getApplicationContext();
//	if(ac==null)
//	{System.out.println("¿Õ");}
//	else{
//		System.out.println("bukong");
//	}
//	a.get();
//	Blogger b=new Blogger();
//	List<Blogger> gb = new ArrayList<Blogger>();
//	Admin_server ad=new Admin_server();
//	b.setBlogger_id(1);
//	b.setBlogger_name("Ðí");
//	b.setBlogger_password("1931");
//	b.setBlogger_sex("ÈËÑý");
//	b.setBlogger_age(10);
//	b.setBlogger_birth(new Date(1995,2,01));
//	ad.addBlogger(b);
////	ad.delBlogger(1);
//	ad.updateBlogger(b);
//	gb=ad.queryAllblogger();
//	for (Blogger b1 : gb) {
//		System.out.println(b1.toString());
//	}
//	Admin_Inter adi=(Admin_Inter) ac.getBean("admin_server");
//	adi.addBlogger(b);
	Blogger_inter bi=(Blogger_inter) ac.getBean("blogger_server");
	bi.setBlogger_id(2);
	
	String [] review=bi.getreview("111111");
	for (String string : review) {
		System.out.println(string.substring(string.indexOf("[")+1, string.indexOf("]")));
	}
//	.substring(string.indexOf("[")+1, string.indexOf("]"))
//	Blogger_server bs=new Blogger_server();
//	bs.setBlogger_id(2);
//	B_article ba=(B_article) ac.getBean("b_article");
//	ba.setArticle_title("32rfwf");
//	ba.setArticle_content("fwefew");
//	ba.setArticle_type("xk");
//	bi.setBlogger_id(2);
//	bs.addArticle(ba);
//	bs.delArticle("1uhohi");
//	List<String> ts = new ArrayList<String>();
//	ts=bi.showAlltitle();
//	ac.getBean("blogger_inter");
//	for (String string : ts) {
//		System.out.println(string);
////	}
//	Map<String,String> ms=new HashMap<String, String>();
//	ms=bs.showAll("1uhohi");
	
//	bs.editArticle(ba, ms);
//	String s="hello";
//	Visitor vi=new Visitor();
//	vi.setVisitor_message(s);
//	Visitor_inter v= (Visitor_inter) ac.getBean("visitor_server");
//	v.addMessage(vi,"111111");
//	String s="youke[24dfafff]wfewfewfrw";
//	String s1=s.substring(s.indexOf("[")+1, s.indexOf("]"));
//	System.out.println(s1);
	
}
}
