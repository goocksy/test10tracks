import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException, IOException {


        URL ur = new URL("http://www.youtube.com/");
        String regLinks = "<link[^`>]*>";
        String DBtab = "LINKS";

        Parser parser = new Parser(ur,regLinks,DBtab);
        parser.parse();

        String regTitls = "title=\"[^`\"]*" ;
        String TabTitles = "TITLES";

        Parser parserTitle = new Parser(ur,regTitls,TabTitles);
        parserTitle.parse();


    }
}
