package luochao.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupUtil {

    private static String url = "https://ncov.dxy.cn/ncovh5/view/pneumonia";


    public static void main(String[] args) throws Exception {
        Document document = Jsoup.connect(url).get();
        Elements elements = document.getElementsByTag("Script");
        Element element = document.getElementById("getAreaStat");
        System.out.println();
    }
}
