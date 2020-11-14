package com.sh2004.util;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//分页工具类
public class PageHelpUtil {

	/**
	 * 向前台返回分页字符串信息
	 * 
	 * @param url
	 *            Controller中指定
	 * @param pageInfo
	 * @param paramMap
	 *            各种条件拼接
	 * @return
	 */
	public static String bootStrapPage(String url, PageInfo<?> pageInfo, Map<String, Object> paramMap) {
		StringBuffer sb = new StringBuffer();
		// 需要定义表单中的name属性值为map的key
		String param = "";
		if (paramMap != null) {
			Set<String> keySet = paramMap.keySet();
			for (String key : keySet) {
				if(paramMap.get(key) != null){
					param += "&" + key + "=" + paramMap.get(key);
				}
			}
		}
		// 自定义 上一页
		int prePage = 1;
		// 排除首页情况下点击上一页异常
		if (pageInfo.getPageNum() != 1) {
			prePage = pageInfo.getPrePage();
		}
		// 自定义 下一页
		int nextPage = pageInfo.getNextPage();
		// 排除尾页情况下点击下一页异常
		if (pageInfo.getPageNum() == pageInfo.getPages()) {
			nextPage = pageInfo.getPages();
		}

		String prev = "";
		if(pageInfo.getPageNum() == 1){
			//首页禁用
			prev = "<nav style=padding:0;font-size:16px;text-align:center aria-label=Page navigation>" +
					"<ul class=pagination pagination-md><li class=disabled>" +
					"<a href=" + url + "?page=" + prePage + "" + param + " aria-label=Previous>" +
					"<span aria-hidden=true>&laquo;</span></a></li>";
		}else{
			prev = "<nav style=padding:0;font-size:16px;text-align:center aria-label=Page navigation>" +
					"<ul class=pagination pagination-md><li>" +
					"<a href=" + url + "?page=" + prePage + "" + param + " aria-label=Previous>" +
					"<span aria-hidden=true>&laquo;</span></a></li>";
		}
		sb.append(prev);

		// 若总页数大于十页
		if (pageInfo.getPages() >= 10) {
			if (pageInfo.getPageNum() <= 6) {
				for (int i = 1; i <= 10; i++) {
					if (i == pageInfo.getPageNum()) {
						sb.append("<li class=active><a href=" + url + "?page=" + i + "" + param
								+ ">" + i + "</li></a>");
					} else {
						sb.append("<li><a href=" + url + "?page=" + i + "" + param
								+ ">" + i
								+ "</a>");
					}
				}
			} else if (pageInfo.getPages() - pageInfo.getPageNum() <= 4) {
				for (int i = pageInfo.getPages() - 9; i <= pageInfo.getPages(); i++) {
					if (i == pageInfo.getPageNum()) {
						sb.append("<li class=active><a href=" + url + "?page=" + i + "" + param
								+ ">" + i + "</li></a>");
					} else {
						sb.append("<li><a href=" + url + "?page=" + i + "" + param
								+ ">" + i + "</li></a>");
					}
				}
			} else {
				for (int i = pageInfo.getPageNum() - 5; i <= pageInfo.getPageNum() + 4; i++) {
					if (i == pageInfo.getPageNum()) {
						sb.append("<li class=active><a href=" + url + "?page=" + i + "" + param
								+ ">" + i + "</li></a>");
					} else {
						sb.append("<li><a href=" + url + "?page=" + i + "" + param
								+ ">" + i + "</li></a>");
					}
				}
			}
		}
		// 若总页数不大于十页
		else {
			// 有几页来几页
			for (int i = 1; i <= pageInfo.getPages(); i++) {
				if(i == pageInfo.getPageNum()){
					sb.append("<li class=active><a style=color:white href=" + url + "?page=" + i + "" + param
							+ ">" + i + "</li></a>");
				}else{
					sb.append("<li><a href=" + url + "?page=" + i + "" + param
							+ ">" + i + "</li></a>");
				}
			}
		}
		String next = "";
		if(pageInfo.getPageNum() == pageInfo.getPages()){
			//尾页禁用
			next = "<li class=disabled><a href="+url+"?page="+nextPage+""+param+" " +
					"aria-label=Next>" +
					"<span aria-hidden=true>&raquo;</span>" +
					"</a></li></ul></nav>";
		}else{
			next = "<li><a href="+url+"?page="+nextPage+""+param+" aria-label=Next>" +
					"<span aria-hidden=true>&raquo;</span>" +
					"</a></li></ul></nav>";
		}
		sb.append(next);
		return sb.toString();
	}


	/***
	 * 需要定义表单中的name属性值为paramMap的key
	 * 
	 * @param url
	 * @param paramMap
	 * @return
	 */
	public static Map<String, Object> pageMap(String url, PageInfo<?> pageInfo, Map<String, Object> paramMap) {
		// 需要定义表单中的name属性值为map的key
		String param = "";
		Set<String> keySet = paramMap.keySet();
		for (String key : keySet) {
			param += "&" + key + "=" + paramMap.get(key);
		}

		String first = "<a href=" + url + "?cpage=1" + param + ">首页</a>";
		String prev = "<a href=" + url + "?cpage=" + pageInfo.getPrePage() + param + ">上一页</a>";
		String next = "<a href=" + url + "?cpage=" + pageInfo.getNextPage() + param + ">下一页</a>";
		String last = "<a href=" + url + "?cpage=" + pageInfo.getPages()+ param + ">尾页</a>";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cpage", pageInfo.getPageNum());
		map.put("count", pageInfo.getTotal());
		map.put("pagecount", pageInfo.getPages());
		map.put("page", first + " " + prev + " " + next + " " + last);
		return map;
	}

}
