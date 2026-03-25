package utilities;

public class Environment_Variable {

	public static String getUsername()
	{
		return System.getenv("OC_USERNAME");
	}
	public static String getPassword() {
		return System.getenv("OC_PASSWORD");
	}
}
