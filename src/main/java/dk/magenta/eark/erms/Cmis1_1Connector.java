package dk.magenta.eark.erms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.Repository;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.enums.BindingType;

public class Cmis1_1Connector implements CmisConnector {

	private PropertiesHandler cmisProperties;
	private String atomPubURL;

	public Cmis1_1Connector() {

		// Get the CMIS properties, username, password,...
		cmisProperties = new CmisPropertiesHandler(
				Constants.CMIS_SETTINGS_PATH);

		// TODO: refactor this into generic method
		// Construct the AtomPubURL
		atomPubURL = new StringBuilder()
			.append(cmisProperties.getProperty("protocol"))
			.append("://")
			.append(cmisProperties.getProperty("host"))
			.append(":")
			.append(cmisProperties.getProperty("port"))
			.append("/")
			.append(cmisProperties.getProperty("AlfrescoApiURL"))
			.append(cmisProperties.getProperty("CmisURL"))
			.toString();
		
		System.out.println(atomPubURL);
	}

	@Override
	public Session getCmisSession() {

		SessionFactory sessionFactory = SessionFactoryImpl.newInstance();

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(SessionParameter.ATOMPUB_URL, atomPubURL);
		parameters.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
		parameters.put(SessionParameter.AUTH_HTTP_BASIC, "true"); // Should probably go into CMIS properties file
		parameters.put(SessionParameter.USER, cmisProperties.getProperty("user"));
		parameters.put(SessionParameter.PASSWORD, cmisProperties.getProperty("password"));
		
		// This parameter may be necessary later on
		// parameter.put(SessionParameter.OBJECT_FACTORY_CLASS, "org.alfresco.cmis.client.impl.AlfrescoObjectFactoryImpl");
		
		List<Repository> repositories = sessionFactory.getRepositories(parameters);
		
		return repositories.get(0).createSession();
	}

}
