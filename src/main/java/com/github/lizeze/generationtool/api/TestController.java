package com.github.lizeze.generationtool.api;

import com.github.lizeze.generationtool.service.BaseService;
import com.github.lizeze.generationtool.vo.TableInfoVO;
import com.github.lizeze.generationtool.vo.TableTreeVO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lzz
 */
@RestController
@RequestMapping("/api/mysql/")
public class TestController {


    BaseService mysqlService;

    public TestController(@Qualifier("mysql") BaseService mysqlService) {
        this.mysqlService = mysqlService;
    }

    @GetMapping("table")
    public List<TableInfoVO> ll() {


        return mysqlService.getTableList();
    }

    @GetMapping("table/tree")
    public List<TableTreeVO> treeList() {

        return mysqlService.getTableTree();

    }


}
