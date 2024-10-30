package commons;

public class GlobalConstants {
    // System Infor
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String SEPARATOR = System.getProperty("file.separator");
    // App Infor User
    public static final String DEV_USER_URL = "http://demo.nopcommerce/";
    public static final String STAGING_USER_URL = "https://demo.nopcommerce.com/";
    public static final String LIVE_USER_URL = "https://live.nopcommerce.com/";
    // App Infor Admin
    public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com/";
    public static final String STAGING_ADMIN_URL = "https://admin-demo.nopcommerce.com/";
    public static final String LIVE_ADMIN_URL = "https://admin-live.nopcommerce.com/";
    public static final String ADMIN_USERNAME = "admin@yourstore.com";
    public static final String ADMIN_PASSWORD = "admin";

    // Wait Infor
    public static final long SHORT_TIME = 10;
    public static final long LONG_TIME = 30;

    // Download/Upload file

    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles" + SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "downloadFiles" + SEPARATOR;

    // Retry Case Failed
    public static final int RETRY_NUMBER = 3;
    // Browser Logs/ Extension
    public static final String BROWSER_LOG_PATH = PROJECT_PATH + SEPARATOR + "browserLogs" + SEPARATOR;
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + "/browserExtensions/" + SEPARATOR;
    // HTML Report Folder
    public static final String REPORTING_PATH = PROJECT_PATH + SEPARATOR + "htmlReportNG" + SEPARATOR;
    public static final String EXTENT_PATH = PROJECT_PATH + SEPARATOR + "htmlExtent" + SEPARATOR;
    public static final String ALLURE_PATH = PROJECT_PATH + "/htmlAllure/";
    // Data Test/ Environment
    public static final String DATA_TEST_PATH = PROJECT_PATH + "/dataTest/";
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + "/environmentConfig/";

    public static final String JIRA_SITE_URL = "https://hungautomatiom.atlassian.net";
    public static final String JIRA_USERNAME = "hung211196@gmail.com";
    public static final String JIRA_API_KEY = "ATATT3xFfGF0I3c79i8p3zXqmxq8nGXN5T9OrE0KWJsGEEgyxf_d-p7EY_rMjVkcl8w6lS1ZweQhlK42XJQmXSrs55qLsOaK6fO6S1XO4QDYAd5VpRCwiq72M1cQuxLJ5EzUO22xqJPQOJClCkwOQAy33vyu2of2WjfWhxlBucRCEr_IZRmPlmM=0CBCE78C";
    public static final String JIRA_PROJECT_KEY = "KAN";
}
