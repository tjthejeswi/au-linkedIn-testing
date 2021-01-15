package config;

public final class AutomationProperties {

    private static String linkedInUrl = "https://www.linkedin.com/login";
    private static String driverLocation = "<Your Chrome Driver Location>";
    private static String linkedInProfileFullName = "<Your LinkedIn Profile Full Name>";
    private static String linkedInUsername = "<Your LinkedIn Username>";
    private static String linkedInPassword = "<Your LinekdIn Password>";
    private static int waitForElementToLoad = 40;

    public static String getDriverLocation() throws Exception {
        return driverLocation;
    }

    public static String getLinkedInUrl() throws Exception {
        return linkedInUrl;
    }

    public static String getLinkedInUsername() throws Exception {
        return linkedInUsername;
    }

    public static String getLinkedInPassword() throws Exception {
        return linkedInPassword;
    }

    public static String getLinkedInProfileFullName() throws Exception {
        return linkedInProfileFullName;
    }

    public static int getWaitTimeOut() throws Exception {
        return waitForElementToLoad;
    }

}
