package com.ebay.Utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ObjectRepository {

    // Search screen and Home page objects

    public static final String searchTextBox_ID = "com.ebay.mobile:id/search_box";
    public static final String searchkeyTextBox_ID = "com.ebay.mobile:id/search_src_text";
    public static final String firstItemAutoSuggest_XPATH = "//android.widget.RelativeLayout[1]/android.widget.TextView";
    public static final String WelcomeMessage_XPATH = "//android.widget.RelativeLayout/android.widget.TextView";
    public static final String menuButton_ID = "com.ebay.mobile:id/home";
    public static final String signInMenuButton_ID = "com.ebay.mobile:id/textview_sign_out_status";
    public static final String moreButton_XPATH = "//android.widget.Button[@content-desc=\"more Featured Sales & Events\"]";


    // Login and Registration page objects

    public static final String registerButton_ID = "com.ebay.mobile:id/button_register";
    public static final String firstNameTextfield_ID = "firstname";
    public static final String lastNameTextfield_ID = "lastname";
    public static final String emailTextfield_ID = "email";
    public static final String passwordTextfield_ID = "PASSWORD";
    public static final String signInButton_ID = "ppaFormSbtBtn";


    public static final String usernameTextfield_XPATH = "//android.widget.LinearLayout/android.widget.EditText[1]";
    public static final String passwordTextField_XPATH = "//android.widget.LinearLayout/android.widget.EditText[@text='Password']";

    public static final String submitButton_ACCESSIBILITY = "Submit";


    // Product listing page objects

    public static final String itemContainer_ID = "com.ebay.mobile:id/cell_collection_item";

    // Product descripting page objects

    public static final String addtoCartButton_ID = "com.ebay.mobile:id/button_add_to_cart";
    public static final String buyItNowButton_ID = "com.ebay.mobile:id/button_bin";


}




