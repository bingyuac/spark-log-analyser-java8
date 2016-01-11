import java.io.File;
import java.util.Scanner;

import org.junit.Test;

import com.databricks.apps.logs.ApacheAccessLog;

public class SSLAccessLogTest {

	@Test
	public void testStuff() {
		
	      // 1:IP  2:client 3:user 4:date time                   5:method 6:req 7:proto   8:respcode 9:size

		String line1 = "86.20.239.98 - - [01/Jan/2016:14:22:41 +0100] \"OPTIONS /autocomplete/entry.json?filter=&order=&quality=gold&query=trans&sort= HTTP/1.1\" 204 - \"https://search.nextprot.org/\" \"Mozilla/5.0 (Linux; U; Android 4.2.2; en-gb; HSG1281 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30\"";
		String line2 = "86.20.239.98 - - [01/Jan/2016:14:22:30 +0100] \"GET /release-info.json HTTP/1.1\" 200 7841 \"https://search.nextprot.org/\" \"Mozilla/5.0 (Linux; U; Android 4.2.2; en-gb; HSG1281 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30\"";

		System.out.println(ApacheAccessLog.parseFromLogLine(line1));

	}

	@Test
	public void test() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("ssl_access_log").getFile());
		String line = "";

		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				ApacheAccessLog log = ApacheAccessLog.parseFromLogLine(line);
				System.out.println(log.getMethod());

			}
			scanner.close();
		} catch (Exception e) {
			System.err.println(line);
			e.printStackTrace();
		}

	}

}
