package Framework;

import java.io.FileReader;
import java.util.Properties;

public class FrameworkConstants {
  //  Logger
   private static FrameworkConstants instance=null;

    private  static String timeout;
    private static String browser;


    public static FrameworkConstants getInstance() {
        if(instance==null) {
            instance = new FrameworkConstants();
            loadProperties();
        }
        return  instance;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }


    public Integer getTimeout() {
        return Integer.parseInt(timeout);
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }
    public void setTimeout(Integer timeout) {
        this.timeout = timeout.toString();
    }



    private FrameworkConstants()  {


    }

    protected static void loadProperties()  {
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("selenium.properties"));
            browser = prop.getProperty("browser");
            timeout = prop.getProperty("timeout", "60");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
