package fr.uiytt.lguhcinstaller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ExternalFile {

	private URL url;
	private String name;
	
	
	public ExternalFile(String url,String name) {
		this.setName(name);
		this.setUrl(url);
		
	}
	
	public String downloadFile(String toPath) {
		File file = new File(toPath,this.getName());
		try {
            HttpURLConnection connection = (HttpURLConnection) this.getUrl().openConnection();
            connection.setRequestMethod("GET");
            connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0");

            InputStream in = connection.getInputStream();
            OutputStream out = new BufferedOutputStream(new FileOutputStream(file));

            byte[] buffer = new byte[1024];

            int numRead;
            while ((numRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, numRead);
            }

            in.close();
            out.close();
        } catch (FileNotFoundException e) {
        	return e.getMessage();
        }catch (IOException e){
            e.printStackTrace();
            return "Une erreure est survenue";
        }
		return "OK";
		
	}
	
	
	
	
	
	protected URL getUrl() {
		return url;
	}

	protected void setUrl(String url) {
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}


	
}

