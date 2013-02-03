hello
=====

记录学习过程中的入门实践代码

OSGi HTTP DS
----

### 使用方法：

> 1 导入到Eclipse工作空间，打开/sample.server/server-web.product，点击“Launch an Eclipse Application”；
> 
> 2 打开浏览器，查看[HelloServlet](http://localhost/helloworld?username=winse)
> 
> 3 动态切换服务
>
> > 进入到Console命令窗口，使用ls 查看服务，使用stop来停止插件
>
		osgi> register user-service : sample.http.ds.user.en.UserServiceImpl@25140d
		activate sample.http.ds.UserHelper@47898f
		osgi> ls
		All Components:
		ID	State			Component Name			Located in bundle
		1	Active		sample.http.ds.UserHelper			sample.http(bid=41)
		2	Active		sample.http.en.userService			sample.http.ds.user.en(bid=44)
		3	Active		sample.http.cn.userService			sample.http.ds.user.cn(bid=45)
		osgi> stop 44
		deactivate sample.http.ds.UserHelper@47898f
		unregister user-service : sample.http.ds.user.en.UserServiceImpl@25140d
		register user-service : sample.http.ds.user.cn.UserServiceImpl@1bfa6f9
		activate sample.http.ds.UserHelper@16b430d


OSGi HTTP Simple
----

### 使用方法：

> 1 导入到Eclipse工作空间，打开/sample.server/server-web.product，点击“Launch an Eclipse Application”；
> 
> 2 打开浏览器，查看[HelloServlet](http://localhost/helloworld), [HelloHtml](http://localhost/helloworld.html)
