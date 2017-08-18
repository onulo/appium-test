package config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Environment {
	private final static Logger log = Logger.getLogger(Environment.class);

	private static final String DEFAULT_ENVIRONMENT_PROPERTIES = "src/default.environment.properties";
	private static final String USER_ENVIRONMENT_PROPERTIES = "src/user.environment.properties";

	private static Environment env;
	private String executeRemote;
	private String localAppiumServerUrl;
	private String remoteGridUrl;
	private String defaultAppPackage;
	private String executeRemoteSauceLab;
	private String executeLocal;
	private String remoteSauceLabServerUrl;
	

	private Environment() {
		Properties envProp = loadEnvironmentProperties();
		this.executeRemote = envProp.getProperty("executeRemote");
		this.localAppiumServerUrl = envProp.getProperty("localAppiumServerUrl");
		this.remoteGridUrl = envProp.getProperty("remoteGridUrl");
		this.defaultAppPackage = envProp.getProperty("defaultAppPackage");
		this.executeRemoteSauceLab = envProp.getProperty("executeRemoteSauceLab");
		this.executeLocal = envProp.getProperty("executeLocal");
		this.remoteSauceLabServerUrl = envProp.getProperty("remoteSauceLabServerUrl");
		log.info("Loaded environment properties: " + envProp);
	}

	public static Environment getInstance() throws FileNotFoundException, IOException {
		if (env == null) {
			return new Environment();
		}
		return env;
	}

	public String getExecuteRemote() {
		return executeRemote;
	}

	public String getLocalAppiumServerUrl() {
		return localAppiumServerUrl;
	}

	public String getRemoteGridUrl() {
		return remoteGridUrl;
	}

	public String getDefaultAppPackage() {
		return defaultAppPackage;
	}
	
	public String getExecuteRemoteSauceLab() {
		return executeRemoteSauceLab;
	}
	
	public String getExecuteLocal() {
		return executeLocal;
	}
	
	public String getRemoteSauceLabServerUrl() {
		return remoteSauceLabServerUrl;
	}
	
	private Properties loadEnvironmentProperties() {
		PropertiesLoader propLoader = new PropertiesLoader();
		Properties envProp;
		try {
			envProp = propLoader.loadProperties(DEFAULT_ENVIRONMENT_PROPERTIES, USER_ENVIRONMENT_PROPERTIES);
			return envProp;
		} catch (FileNotFoundException e) {
			log.error("Can not find the properties files");
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

}
