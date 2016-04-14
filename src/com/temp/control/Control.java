package com.temp.control;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.temp.model.Goddess;

public class Control {
	static Action action=new Action();
	public static Scanner scanner=new Scanner(System.in);
	
	//增加女神，包括编号，姓名，年龄，生日，电话和邮箱
	public void add() throws Exception {
		Goddess new2=input();//键入增加女神
		action.addGoddess(new2);
	}
	
	//删除特定编号女神信息
	public void delete() throws Exception {
		System.out.println("输入要删除女神的编号：");
		action.delGoddess(scanner.nextInt());
		System.out.println("该女神信息已经删除！");
		System.out.println("------------------------------");
	}
	
	//更新禁区的女神信息
	public void update() throws Exception {
		Goddess ngGoddess=input();
		action.updateGoddess(ngGoddess);
		System.out.println("------------------------------");
	}
	
	//查询所有女神的基本信息（即编号和姓名）
	public void query() throws Exception {
		List<Goddess> list=action.queryGoddess();
		print(list);
		System.out.println("------------------------------");
	}
	
	//查询特定编号女神详细信息
	public void idQuery() throws Exception  {
		System.out.println("输入编号获取女神详细信息：");
		Goddess detail=action.queryDetail(scanner.nextInt());
		System.out.println("下面是符合条件的女神详细信息：");
		System.out.println("------------------------------");
		tell(detail);
	}
	
	//根据名字的一部分信息查询女神的详细信息（查询信息固定）
	public void nameQuery() throws Exception {
		System.out.println("输入查询女神的名字的一部分：");
		List<Goddess> list=action.queryGoddess(scanner.next());
		System.out.println("下面是该女神的详细信息：");
		System.out.println("--------------------------");
		for (Goddess goddess2 : list) {
			tell(goddess2);//依次打印出符合条件的女神信息
		}
	}
	
	//根据名字的一部分信息查询女神的详细信息（查询信息不固定）	
	public void conditions() throws Exception {
		List<Map<String, Object>> para=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();//添加一个查询条件
		map.put("name", "name");
		map.put("relation", "like");
		map.put("value", "'%imy%'");//注意名字这里是字符型的
		para.add(map);//别忘了把map数据添加进list集合中
		map=new HashMap<>();//再添加一个查询条件
		map.put("name", "tele");
		map.put("relation", "like");
		map.put("value", "'%40445%'");//注意名字这里是字符型的
		para.add(map);
		List<Goddess> godd=action.query(para);
		System.out.println("下面是查找的女神详细信息：");
		System.out.println("--------------------------");
		for (Goddess goddess2 : godd) {
			tell(goddess2);//依次打印出符合条件的女神信息
	}
}	
	//键入女神详细信息
	public static Goddess input() {
		Goddess goddess=new Goddess();
		System.out.println("编号：");
		goddess.setId(scanner.nextInt());
		System.out.println("姓名：");
		goddess.setName(scanner.next());
		System.out.println("年龄：");
		goddess.setAge(scanner.nextInt());
		System.out.println("生日(yyyy,MM,dd)：");
		//可以将"yyyy,mm,dd"或者"yyyy-mm-dd"形式的文本构造一个日期字符串
		DateFormat format=new SimpleDateFormat("yyyy,MM,dd");
		Date birthday=new Date();
		try {
			//将该日期形式转换成Date格式日期
			birthday = format.parse(scanner.next());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		goddess.setBirthday(birthday);
		System.out.println("电话：");
		goddess.setTele(scanner.next());
		System.out.println("邮箱：");
		goddess.setEmail(scanner.next());
		return goddess;
	}
	
	//打印女神的基本信息
	public static void print(List<Goddess> list) {
		for (Goddess goddess : list) {
			System.out.println("编号："+goddess.getId()+"，"+"姓名："+goddess.getName());
		}
	}
	
	//打印女神的详细信息
	public static void tell(Goddess goddess) {
		System.out.println("编号:"+goddess.getId());
		System.out.println("姓名:"+goddess.getName());
		System.out.println("年龄:"+goddess.getAge());
		System.out.println("生日:"+goddess.getBirthday());
		System.out.println("电话:"+goddess.getTele());
		System.out.println("邮箱:"+goddess.getEmail());
		System.out.println("------------------------------");
	}
}
