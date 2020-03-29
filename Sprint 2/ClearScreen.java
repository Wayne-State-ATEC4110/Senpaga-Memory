import java.io.IOException;
public class ClearScreen {
	public static void Clear() {
		try {
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
