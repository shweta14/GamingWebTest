package pkr;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: shweta
 * Date: 15/09/13
 * Time: 00:23
 * To change this template use File | Settings | File Templates.
 */
public enum Elements {
    Username("Username", "ctl00_txtUserName"),
    Password("Password", "ctl00_txtPassword"),
    Login("login", "user-login-button"),
    LoginSubmit("Submit Login", "ctl00_btnLogin"),
    AboutMe("About me", "ctl00_cphMain_txtAboutMe"),
    Edit("edit", "ctl00_cphMain_lnkEdit"),
    MYPKR("MYPKR", "mypkr-link"),
    Update("update", "ctl00_cphMain_btnUpdate"),
    MoneyList("All-time money list", "ctl00_cphMain_ddlMoneyListPublicStatus"),
    Status("Show my status", "ctl00_cphMain_ddlStatusShowTo"),
    Tournament("Show my tournament page", "ctl00_cphMain_ddlTournamentsShowTo"),
    UserStatus("Profile updated", "user-status"),
    Profile("Show my profile", "ctl00_cphMain_ddlProfileShowTo");
    private final String name;
    private final String id;


    static Map<String, Elements> nameIdMap = new HashMap<String, Elements>();

    static {
        for (Elements element : values()) {
            nameIdMap.put(element.name, element);
        }
    }

    Elements(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public static Elements getElementByName(String name) {
        return nameIdMap.get(name);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}


