package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

	private Properties properties;

	public Properties loadProperties(String... propertiesFiles) throws FileNotFoundException, IOException {
		properties = new Properties();
		for (String propFile : propertiesFiles) {
			properties.load(new FileInputStream(propFile));
		}
		return properties;
	}
}
