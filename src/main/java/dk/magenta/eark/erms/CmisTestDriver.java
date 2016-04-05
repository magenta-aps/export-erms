/**
 * Just for doing a few quick tests that should be inspected manually
 * TODO: write proper unit tests
 */

package dk.magenta.eark.erms;

import org.apache.chemistry.opencmis.client.api.Session;

public class CmisTestDriver {

	public static void main(String[] args) {
		
		CmisConnector connector = new Cmis1_1Connector();
		Session cmisSession = connector.getCmisSession();

		System.out.println("name = " + cmisSession.getRepositoryInfo().getProductName());
		
		

	}

}
