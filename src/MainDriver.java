import java.io.IOException;


public class MainDriver {

	public static void main(String args[]) throws IOException {
		String params[] = new String[]{"1.in","2.in"};
		for (String f : params)
			PrintLevel.main(f);
	}
}
