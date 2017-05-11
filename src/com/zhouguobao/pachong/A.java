package com.zhouguobao.pachong;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.text.html.HTML.Tag;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.zhouguobao.pachong.db.ImgDbUtil;
import com.zhouguobao.pachong.db.ImgGroupDbUtil;
import com.zhouguobao.pachong.db.ImgTagDbUtil;
import com.zhouguobao.pachong.db.ImgTagPageDbUtil;
import com.zhouguobao.pachong.db.PaChongDbUtil;
import com.zhouguobao.pachong.model.ImgGroup;
import com.zhouguobao.pachong.model.ImgModel;
import com.zhouguobao.pachong.model.ImgTag;
import com.zhouguobao.pachong.model.ImgTagPage;
import com.zhouguobao.pachong.util.StringUtil;

public class A {
	public static void main(String[] args) {
		initTag();
		initTagPage();
		initImgGroup();
		initEveryImgGroup();
		PaChongDbUtil.get().closeConn();
	}

	private static void initTag() {
		ArrayList<ImgTag> tagList = getAllClassLink();
		ImgTagDbUtil.get().insetTag(tagList);
	}

	private static void initTagPage() {
		ArrayList<ImgTag> imgTags = ImgTagDbUtil.get().geImgTags();
		System.out.println("imgTags.size():" + imgTags.size());
		for (ImgTag imgTag : imgTags) {
			ArrayList<ImgTagPage> tagPages = getAllClassPageLink(imgTag);
			ImgTagPageDbUtil.get().insetTag(tagPages);
		}
	}

	private static void initImgGroup() {
		ArrayList<ImgTagPage> imgTagPages = ImgTagPageDbUtil.get().geImgTagPages();
		for (ImgTagPage imgTagPage : imgTagPages) {
			ArrayList<ImgGroup> imgGroups = getImgGroupLinkList(imgTagPage);
			ImgGroupDbUtil.get().insetTag(imgGroups);
		}
	}

	/**
	 * 初始化每一个图片组
	 */
	private static void initEveryImgGroup() {
		ArrayList<ImgGroup> imgGroups = ImgGroupDbUtil.get().getImgGroups();
		for (ImgGroup imgGroup : imgGroups) {
			ArrayList<String> links = getAllSecondNextPageLink(imgGroup.getUrl());
			ArrayList<String> imgUrl = new ArrayList<>();
			for (String string : links) {
				imgUrl.addAll(getImgList(string));
			}
			ArrayList<ImgModel> imgModels = new ArrayList<>();
			for (String string : imgUrl) {
				imgModels.add(new ImgModel(string, imgGroup.getId()));
			}
			ImgDbUtil.get().insetTag(imgModels);
		}
	}

	private static ArrayList<ImgTag> getAllClassLink() {
		ArrayList<ImgTag> imgTags = new ArrayList<>();
		try {
			Document document = Jsoup.connect("http://www.xiumm.org").get();
			Elements elements = document.select("li a[href~=\\.html?]");
			System.out.println(elements.size());
			for (Element element : elements) {
				String title = element.attr("title");
				String url = element.absUrl("href");
				ImgTag imgTag = new ImgTag(title, url);
				imgTags.add(imgTag);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imgTags;
	}

	private static ArrayList<ImgTagPage> getAllClassPageLink(ImgTag imgTag) {
		ArrayList<ImgTagPage> imgTagPages = new ArrayList<>();
		ArrayList<String> links = getAllSecondNextPageLink(imgTag.getUrl());
		for (String string : links) {
			imgTagPages.add(new ImgTagPage(imgTag.getId(), string));
		}
		return imgTagPages;
	}

	/**
	 * 获取所以的二级页面 那些分页显示的页面的链接
	 * 
	 * @param url
	 * @return
	 */
	private static ArrayList<String> getAllSecondNextPageLink(String url) {
		ArrayList<String> links = new ArrayList<>();
		links.add(url);
		try {
			Document document = Jsoup.connect(url).get();
			Elements elements = document.select("div.paginator span.next a[href~=\\.html?]");
			System.out.println(elements.size());
			String pageUrl = null;
			for (Element element : elements) {
				pageUrl = element.absUrl("href");
				if (StringUtil.isEmpty(pageUrl) == false) {
					break;
				}
			}
			if (StringUtil.isEmpty(pageUrl)) {
				return links;
			}
			System.out.println(pageUrl);
			Elements countElements = document.select("div.paginator span.count");
			int count = Integer.parseInt(countElements.text().replaceAll("\\D", ""));
			for (int i = 2; i < count + 1; i++) {
				String temp = pageUrl.replaceFirst("-\\d\\.html", "-" + i + ".html");
				System.out.println(temp);
				links.add(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return links;

	}

	/**
	 * 获取页面上的图片，主要的内容图片
	 * 
	 * @param url
	 * @return
	 */
	private static ArrayList<String> getImgList(String url) {
		ArrayList<String> imgList = new ArrayList<>();
		try {
			Document document = Jsoup.connect(url).get();
			Elements imgs = document.select("img[src~=\\.jpe?g]");
			for (Element element : imgs) {
				String imgUrl = element.attr("abs:src");
				System.out.println(imgUrl);
				imgList.add(imgUrl);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return imgList;
	}

	/**
	 * 获取各个图片组的URL
	 * 
	 * @param tagPage
	 * @return
	 */
	private static ArrayList<ImgGroup> getImgGroupLinkList(ImgTagPage tagPage) {
		ArrayList<ImgGroup> imgGroups = new ArrayList<>();
		try {
			Document document = Jsoup.connect(tagPage.getUrl()).get();
			Elements elements = document.select("a:has(img)[href~=\\.html?]");
			for (Element element : elements) {
				String htmlLink = element.absUrl("href");
				String alt = null;
				Elements altElements = element.select("img[src]");
				for (Element element2 : altElements) {
					if (StringUtil.isEmpty(element2.attr("alt")) == false) {
						alt = element2.attr("alt");
						break;
					}
				}
				System.out.println(htmlLink + "\t" + alt);
				imgGroups.add(new ImgGroup(tagPage.getTagId(), htmlLink, alt));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imgGroups;
	}

}
