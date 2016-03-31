package dk.magenta.eark.erms;

import java.security.InvalidParameterException;
import java.util.Map;

public interface PropertiesHandler {
	public Map<String, String> getProperties();
	public String getProperty(String key) throws InvalidParameterException;
	public void setProperty(String key, String value);
}
