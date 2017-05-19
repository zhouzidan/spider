# 爬虫 spider
学习过程中，尝试完成的、通过JAVA实现的爬虫项目。</br>
身边有人搞爬虫的东西，有点好奇。我也想尝试着搞了一下。</br>
起初是想学习Python来实现爬虫的。</br>
但是在了解一番之后，发现自己熟悉的java也可以。好像常见的编程语言都可以，不同的是支持的开源库不同而已</br>
python收到追捧，很大的原因是它下面支持的开源库很多。</br>
我根据自身情况，选择JAVA来实现。</br>
## 项目描述
1. 通过爬虫获取网络上图片的相关信息（比如：图片的网址、分类、分组信息等），将其保存在Mysql数据库中。
2. 将Mysql数据库中的数据，转化成Sqlite3的db文件中。
3. 将db文件放在Android的Apk中
4. 最后通过手机App进行查看这些图片

> 服务器不保存图片，只是保存该图片的URL(网址)  

[GitHub - zhouzidan/spider](https://github.com/zhouzidan/spider)
当前项目就是实现第一步：通过爬虫获取网络上图片的相关信息</br>
[GitHub - zhouzidan/spider](https://github.com/zhouzidan/spider)
当前项目就是实现第一步：通过爬虫获取网络上图片的相关信息</br>
[GitHub - zhouzidan/plmm](https://github.com/zhouzidan/plmm)
这个项目实现的第2、3、4三步。是一个Android项目

使用了开源库： [GitHub - jhy/jsoup: jsoup: Java HTML Parser, with best of DOM, CSS, and jquery](https://github.com/jhy/jsoup)</br>
很好很棒很牛逼

## 项目资料
* [关于使用Java实现的简单网络爬虫Demo - 皇问天 - 博客园](http://www.cnblogs.com/huangwentian/p/6484534.html)
* [Java爬虫，信息抓取的实现 - Hongyang        - 博客频道 - CSDN.NET](http://blog.csdn.net/lmj623565791/article/details/23272657)
* [GitHub 上有哪些优秀的 Java 爬虫项目？ - 知乎](https://www.zhihu.com/question/31427895)
* [jsoup 解析和遍历一个HTML文档](http://www.open-open.com/jsoup/parsing-a-document.htm)
