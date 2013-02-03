package sample.http.ds;

public class UserHelper {

	public UserHelper() {
	}

	private static UserHelper INSTANCE;

	public static UserHelper getInstance() {
		return INSTANCE;
	}

	protected void activate() {
		System.out.println("activate "  + this);
		INSTANCE = this;
	}

	protected void deactivate() {
		System.out.println("deactivate "  + this);
		INSTANCE = null;
	}

	private UserService service;

	public UserService getService() {
		return service;
	}

	protected void setService(UserService manager) {
		System.out.println("register user-service : " + manager);
		this.service = manager;
	}

	protected void unSetService(UserService manager) {
		System.out.println("unregister user-service : " + manager);
		this.service = null;
	}

}
