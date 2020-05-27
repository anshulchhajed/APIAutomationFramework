package Utils;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {


	private Properties properties;
	private final String propertyFilePath= "config//config.properties";


	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		} 
	}

	public String getBaseUrl() {
		String url = properties.getProperty("baseurl");
		if(url != null) return url;
		else throw new RuntimeException("BaseURL is  not specified in the config.properties file.");
	}

		
	public String getBasePath() {
		String url = properties.getProperty("basepath");
		if(url != null) return url;
		else throw new RuntimeException("Base Path not specified in the config.properties file.");
	}
	

	
}

