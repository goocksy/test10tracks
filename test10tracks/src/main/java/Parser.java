import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {
    private URL url;
    private String regEx;
    private String DBTable;

    public Parser(URL ur, String reg, String DBtab) {
        this.url = ur;
        this.regEx = reg;
        this.DBTable = DBtab;
    }

    public void parse() throws SQLException, IOException {
        Pattern regex = Pattern.compile(regEx);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        DBworker dbworker = new DBworker();

        Statement statement = dbworker.getConnection().createStatement();
        int i = 1;
        while ((line = reader.readLine()) != null) {
            Matcher  matcher = regex.matcher(line);
            if (matcher.find()){
                statement.execute("INSERT INTO "+DBTable+" VALUES ("+i+",'"+matcher.group()+"')");
            }
            i = i + 1;
        }

        dbworker.getConnection().close();
        url.openStream().close();
    }

}
