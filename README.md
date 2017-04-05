# AprilDragonSpring

master
---

- 修正了对Dao层的注解 
* 新增异步处理，封装了对AJAX的请求 
	* 页面调用getData(url, data)和postData(url, data)两种请求方式 
	* 后端使用ajaxSuccess(Object msg)、ajaxError(Object msg)、ajaxParam(String flag, Object msg, Object param)三种处理方式
* 新增分页功能，详见page 
	* 入口 page.do 或 page.do?pageNum=1 

beta
---

- 添加了GenericDao，现可以通过继承此基类来实现CURD 
- 更正了注解，现可以自动注入Dao和Service 

alpha
---

- 框架环境：Spring Boot + JPA(Hibernate) 
- 配置了支持JSP的依赖 
- 配置了Druid连接池 
