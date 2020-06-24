package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.HomeHelper;

public class LamodaSearchTest {
    private HomeHelper homeHelper = new HomeHelper();
    private String searchkey = "jeans";

    @Test
    public void performSearch(){
        int countPerPage = homeHelper.search(searchkey).getSearchResultsCountPerPage();
        Assert.assertTrue(countPerPage > 0 ,"No results were found!");
    }

    @AfterClass
    public void tearDown(){
        homeHelper.quit();
    }
}
