package dk.magenta.eark.erms;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTestDriver {

	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		String s = new String();
		InputStream in = PropertiesTestDriver.class.getClassLoader().getResourceAsStream("settings.properties");
		properties.load(in);
		
		System.out.println(properties.getProperty("extractionFormat"));
	}

}
