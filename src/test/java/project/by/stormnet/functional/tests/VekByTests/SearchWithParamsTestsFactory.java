package project.by.stormnet.functional.tests.VekByTests;

import org.testng.annotations.Factory;

public class SearchWithParamsTestsFactory {

        @Factory
        public Object[] provideParams() {
            return new Object[]{
                    new SearchWithParamsTests("телевизор", "300", "700"),
                    new SearchWithParamsTests("телефон", "100", "1000"),
                    new SearchWithParamsTests("пылесос", "50", "600")
            };
        }

}
