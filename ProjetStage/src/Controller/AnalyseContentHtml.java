package Controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
public class AnalyseContentHtml {
        public void analyse() {
            String htmlContent = "<html><head><title>Example</title></head><body><h1>Hello, World!</h1></body></html>";
            Document document = Jsoup.parse(htmlContent);
            String title = document.title();
            Element heading = document.selectFirst("h1");
            System.out.println("Title: " + title);
            System.out.println("Heading: " + heading.text());
        }
    }

