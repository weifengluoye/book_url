package cn.hfut.book_url.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

/**
 * @author LJH
 * @date 2019/11/11 19:11
 */

@Service
public class BookService {

    /**
     * 根据图书的isbn返回图书的封面链接
     * @param isbn
     * @return
     */
    public String getUrl(String isbn) {
        Connection connection = Jsoup.connect("http://douban.com/isbn/" + isbn);

        Connection.Response response = null;
        try {
            response = connection.method(Connection.Method.GET).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Document document = Jsoup.parse(response.body());
        String url = document.select("#mainpic > a > img").attr("src");
        return url;
    }
}
