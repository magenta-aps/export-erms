package dk.magenta.eark.erms;

import org.apache.chemistry.opencmis.client.api.Session;

public interface CmisConnector {
	public Session getCmisSession();
}
