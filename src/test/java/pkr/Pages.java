package pkr;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: shweta
 * Date: 14/09/13
 * Time: 23:17
 * To change this template use File | Settings | File Templates.
 */
public enum Pages {
    PKR("PKR", "http://www.pkr.com/en/"),
    MyPKR("MyPKR", "https://www.pkr.com/en/mypkr/"),
    Profile("Profile", "https://www.pkr.com/en/mypkr/profile/");

    private static Map<String, Pages> pageNameMap = new HashMap<String, Pages>();

    static {
        for (Pages page : values()) {
            pageNameMap.put(page.getPageName(), page);
        }
    }

    private final String pageName;
    private final String pageUrl;


    Pages(String pageName, String pageUrl) {
        //To change body of created methods use File | Settings | File Templates.
        this.pageName = pageName;
        this.pageUrl = pageUrl;

    }
    public String getPageName() {
        return pageName;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public static Pages getPageByName(String pageName) {
        return pageNameMap.get(pageName);
    }
}




















