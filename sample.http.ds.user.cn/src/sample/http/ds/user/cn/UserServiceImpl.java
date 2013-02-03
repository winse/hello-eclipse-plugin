package sample.http.ds.user.cn;

import sample.http.ds.UserService;

public class UserServiceImpl implements UserService {
	public String sayHello(String username) {
		return "你好， " + username;
	}
}