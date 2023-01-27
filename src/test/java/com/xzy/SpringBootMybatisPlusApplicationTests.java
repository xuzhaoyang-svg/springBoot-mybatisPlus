package com.xzy;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzy.dao.BookDao;
import com.xzy.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMybatisPlusApplicationTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void testSelectAll() {
        List<Book> books = bookDao.selectList(null);
        System.out.println(books);
    }

    @Test
    void testGetByPage() {

        IPage page = new Page(1,2);
        bookDao.selectPage(page,null);
        System.out.println("当前页码值：" +page.getCurrent());
        System.out.println("每页显示条数：" +page.getSize());
        System.out.println("一共多少页：" +page.getPages());
        System.out.println("一共多少条：" +page.getTotal());
        System.out.println("数据：" +page.getRecords());
    }

}
