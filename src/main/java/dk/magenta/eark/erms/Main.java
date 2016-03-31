package dk.magenta.eark.erms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import oracle.jdbc.proxy.annotation.GetCreator;

public class Main {

	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		String s = new String();
		InputStream in = Main.class.getClassLoader().getResourceAsStream("settings.properties");
		properties.load(in);
		
		System.out.println(properties.getProperty("extractionFormat"));
	}

}
