package project.by.stormnet.functional.entities.pages;

public class HomePage extends AbstractPage {
    private static String logo = "/html/body/div[1]/div[2]/a";
    private String searchField = "//input[@class = 'text-field text-field_large search__input js-search-field']";
    private String searchButton = "//div[@class = 'search__button-logo']";

    public static HomePage getHomePage(){
        HomePage homePage = new HomePage();
        waitForElementVisible(getElementBy(logo));
        System.out.println("HomePage is opened!");
        return homePage;
    }

    public HomePage navigateToHomePage(){
        openUrl(baseUrl);
        return getHomePage();
    }

    public HomePage fillSearchField(String searchKey){
        getElement(searchField).sendKeys(searchKey);
        return getHomePage();
    }

    public SearchPage clickSearchButton(){
        getElement(searchButton).click();
        return SearchPage.getSearchPage();
    }
}
