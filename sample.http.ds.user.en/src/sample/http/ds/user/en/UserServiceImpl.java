package sample.http.ds.user.en;

import sample.http.ds.UserService;

public class UserServiceImpl implements UserService {
	public String sayHello(String username) {
		return "hello, " + username;
	}
}