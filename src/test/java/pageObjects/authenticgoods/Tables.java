package pageObjects.authenticgoods;

public class Tables extends CommonPage{
    String url = "http://authenticgoods.co/wrapbootstrap/themes/neuboard-v1.4.3/Angular_full_version/#/tables/basic";
    public Tables(){
        super();
    }

    public void navToTables(){
        navigate(url);
    }
}
