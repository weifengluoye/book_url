package cn.hfut.book_url.controller;

import cn.hfut.book_url.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LJH
 * @date 2019/11/11 19:07
 */

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * 根据图书的isbn返回图书的封面链接
     * @param isbn
     * @return
     */
    @RequestMapping("/getUrl")
    public String getUrl(String isbn) {
        return bookService.getUrl(isbn);
    }
}
