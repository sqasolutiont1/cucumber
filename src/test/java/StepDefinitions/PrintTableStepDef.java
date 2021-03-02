package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class PrintTableStepDef {
    @When("Print the Table")
    public void printTheTable(DataTable dataTable) {
        List<String> rows = dataTable.asList(String.class);
        List<Map<String, String>> map_rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> map :  map_rows) {
            System.out.println(map);
        }

    }
}
