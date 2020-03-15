import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Parsing {
    private ArrayList<Article> articles = new ArrayList<Article>();
    private ArrayList<Cases> cases = new ArrayList<Cases>();

    public Parsing () throws IOException {
        parseKZAIF();
        parseTengriNews();
        parseNumberOfCases();
    }
    public void parseKZAIF() throws IOException {

        Document document = Jsoup.connect("https://kzaif.kz/tag/koronavirus").get();

        Elements elements = document.getElementsByAttributeValue("class", "box_info");

        for (int i = 0; i < elements.size(); i++) {

            Element element = elements.get(i);
            Element aElement = element.child(0);
            String url = aElement.attr("href");
            Element hElement = aElement.child(0);
            String text = hElement.text();
            Article article = new Article(url, text);
//            System.out.println(url + " " + text);
            articles.add(article);
        }
//


    }

    public void parseTengriNews() throws IOException {

        Document document = Jsoup.connect("https://tengrinews.kz/tag/%D0%9A%D0%BE%D1%80%D0%BE%D0%BD%D0%B0%D0%B2%D0%B8%D1%80%D1%83%D1%81-%D0%B2-%D0%9A%D0%B0%D0%B7%D0%B0%D1%85%D1%81%D1%82%D0%B0%D0%BD%D0%B5/").get();

        Elements elements = document.getElementsByAttributeValue("class", "tn-link");

        for (int i = 0; i < elements.size(); i++) {

            Element aElement = elements.get(i);
            String url = "https://tengrinews.kz/" + aElement.attr("href");
            Element hElement = aElement.child(0);
            String text = hElement.text();
            Article article = new Article(url, text);
//            System.out.println(url + " " + text);
            articles.add(article);
        }
    }

    public void parseNumberOfCases() throws IOException {
        Document document = Jsoup.connect("https://www.worldometers.info/coronavirus/").get();

        Element table = document.getElementById("main_table_countries");
        Element tbody = table.getElementsByTag("tbody").first();
        Elements elements = tbody.getElementsByTag("tr");
        System.out.println(elements.size());
        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);
            Element name = element.child(0);
            Element number = element.child(1);
            Element number2 = element.child(2);

            cases.add(new Cases(name.text(), number.text(), number2.text()));
        }
    }

    public String[] getArticles() {

        String[] arr = new String[articles.size()];
        for (int i = 0; i < articles.size() ; i++) {
            arr[i] = articles.get(i).toString();
        }
        return arr;
    }

    public String getConfirms() {
        String[] arr = new String[4];
        for (int i = 0; i < 3 && i < cases.size() ; i++) {
            arr[i] = cases.get(i).toString();
        }
        for (int i = 0; i < cases.size(); i++) {
            if (cases.get(i).getCountryName().equalsIgnoreCase("Kazakhstan")) {
                arr[3] = cases.get(i).toString();
                break;
            }
        }
        String txt = "";
        for (int i = 0; i < arr.length; i++) {
            txt += arr[i] + "\n";
        }
        return txt;
    }
}

class Cases {
    private String countryName;
    private String countOfConfirmed;
    private String countOfAdded;

    public Cases(String countryName, String countOfConfirmed, String countOfAdded) {
        this.countryName = countryName;
        this.countOfConfirmed = countOfConfirmed;
        this.countOfAdded = countOfAdded;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountOfConfirmed() {
        return countOfConfirmed;
    }

    public void setCountOfConfirmed(String countOfConfirmed) {
        this.countOfConfirmed = countOfConfirmed;
    }

    public String getCountOfAdded() {
        return countOfAdded;
    }

    public void setCountOfAdded(String countOfAdded) {
        this.countOfAdded = countOfAdded;
    }

    @Override
    public String toString() {
        return getCountryName() + " число зараженных: " + getCountOfConfirmed() + ", изменения за последнее сутки: " + getCountOfAdded();
    }
}

class Article {
    private String url;
    private String text;

    public Article(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return getText() + "... \n" + getUrl();
    }
}