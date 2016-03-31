package dk.magenta.eark.erms;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class PropertiesHandlerImpl implements PropertiesHandler {

	private Map<String, String> properties;
	
	public PropertiesHandlerImpl() {
		properties = new HashMap<String, String>();
		// TO-DO: load properties from file
	}
	
	@Override
	public Map<String, String> getProperties() {
		return properties;
	}

	@Override
	public String getProperty(String key) throws InvalidParameterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperty(String key, String value) {
		// TO-DO: write properties to file also

	}

}
