package com.temp.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.temp.control.Control;
import com.temp.model.Goddess;

public class view {
	private static final String MENU="欢迎来到女神禁区！\n以下是本禁区的功能列表：\n"
			+"------------------------------\n"
			+"【main】      ：返回主菜单\n"
			+"【query】   ：查看禁区女神基本信息\n"
			+"【detail】：查看某位禁区女神详细信息\n"
			+"【add】         ：添加自己心仪禁区女神\n"
			+"【detel】   ：删除禁区女神信息\n"
			+"【update】：更新禁区女神基本信息，即修改\n"
			+"【mquery】：通过某个信息查询女神基本信息(编号或者姓名)\n"
			+"【break】   ：退出女神禁区\n"
			+"【exit】      ：退出当前功能，返回主菜单\n"
			+"-------------------------------";
	private static final String MAIN="main";
	private static final String QUERY="query";
	private static final String DETAIL="detail";
	private static final String ADD="add";
	private static final String DELET="detel";
	private static final String UPDATE="update";
	private static final String MOREQUERY="mquery";
	private static final String BREAK="break";
	private static final String EXIT="exit";
	
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		Control control=new Control();
		System.out.println(MENU);
		while(scan.hasNext()){
			String in=scan.next().toString();
			if(MAIN.equals(in)||MAIN.equals(in.toLowerCase())||EXIT.equals(in)||EXIT.equals(in.toLowerCase())){
				System.out.println(MENU);
			}else if (QUERY.equals(in)||QUERY.equals(in.toLowerCase())) {
				try {
					control.query();
				} catch (Exception e) {
					System.out.println("查询女神信息失败。");
					e.printStackTrace();
				}
			}else if (UPDATE.equals(in)||UPDATE.equals(in.toLowerCase())) {
				try {
					System.out.println("输入要更新女神的编号：");
					control.update();
					System.out.println("更新女神信息成功。");
				} catch (Exception e) {
					System.out.println("更新女神信息失败。");
					e.printStackTrace();
				}
			}else if (DELET.equals(in)||DELET.equals(in.toLowerCase())) {
				try {
					control.delet();
				} catch (Exception e) {
					System.out.println("删除女神信息失败。");
					e.printStackTrace();
				}
			}else if (ADD.equals(in)||ADD.equals(in.toLowerCase())) {
				try {
					System.out.println("输入要增加女神的信息：");
					control.add();
					System.out.println("增加女神信息成功。");
				} catch (Exception e) {
					System.out.println("增加女神信息失败。");
					e.printStackTrace();
				}
			}else if (DETAIL.equals(in)||DETAIL.equals(in.toLowerCase())) {
				try {
					control.idQuery();;
				} catch (Exception e) {
					System.out.println("查询女神信息失败。");
					e.printStackTrace();
				}
			}else if (MOREQUERY.equals(in)||MOREQUERY.equals(in.toLowerCase())) {
				System.out.println("根据女神的编号(id)、姓名(name)或者其他(other)查找：");
				in=scan.next().toString();
				if ("name".equals(in)) {//根据女神的姓名(name)查找
					try {
						control.nameQuery();
					} catch (Exception e) {
						System.out.println("查询女神信息失败。");
						e.printStackTrace();
					}
				}else if ("id".equals(in)) {//根据女神的编号(id)查找
					try {
						control.idQuery();
					} catch (Exception e) {
						System.out.println("查询女神信息失败。");
						e.printStackTrace();
					}
				}else {
					System.out.println("根据多个条件查询:");
					try {
						control.conditions();
					} catch (Exception e) {
						System.out.println("查询女神信息失败。");
						e.printStackTrace();
					}
				}
			}else if (BREAK.equals(in)||BREAK.equals(in.toLowerCase())) {
				break;
			}else {
				System.out.println("您输入的信息为："+in);
			}
		}
		System.out.println("退出女神禁区成功。");
	}

}
