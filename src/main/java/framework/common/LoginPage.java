package framework.common;

import framework.interfaces.IClickable;
import framework.interfaces.IValuable;

public class LoginPage {
    public static void Login(String URL) throws Exception {
//        (new RepositoryParser()).ParseXML();
        Driver.CurrentDriver.navigate().to(URL);
//        Driver.CurrentDriver.get(URL);
        Synchronization.waitPageReadyState();
        Synchronization.waitPageSource();
        Page.currentPageLabel = "Login";
        IValuable loginUser = Factory.CreateControl("loginUser");
        loginUser.setValue(Configurations.GetValueByKey("loginUser"));
        IValuable loginPW = Factory.CreateControl("loginPW");
        loginPW.setValue(Configurations.GetValueByKey("loginPW"));
        IClickable loginButton = Factory.CreateControl("loginButton");
        loginButton.click();
        Synchronization.wait(1);
        Synchronization.waitPageSource();
        Driver.CurrentDriver.navigate().refresh();
        Synchronization.waitPageReadyState();
        Synchronization.wait(3);
        Synchronization.waitPageSource();
    }

    public static void Login() throws Exception {
        Login(Configurations.GetValueByKey("URL"));
    }
}
