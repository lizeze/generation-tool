package com.github.lizeze.generationtool.service.impl;

import com.github.lizeze.generationtool.mapper.MySqlMapper;
import com.github.lizeze.generationtool.service.BaseService;
import com.github.lizeze.generationtool.vo.TableInfoVO;
import com.github.lizeze.generationtool.vo.TableTreeVO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lzz
 */
@Service
@Qualifier("mysql")
@SuppressWarnings("all")
public class MysqlServiceImpl implements BaseService {

    private final MySqlMapper mapper;

    public MysqlServiceImpl(MySqlMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<TableInfoVO> getTableList() {
        return mapper.tableName();
    }

    @Override
    public List<TableTreeVO> getTableTree(String dbName, String tableName) {
        List<TableTreeVO> tableTreeVOS = new ArrayList<>();
        List<TableInfoVO> list = this.getTableList();
        Map<String, String> dbMap = new HashMap();
        list.forEach(item -> {
            if (!dbMap.containsKey(item.getDbName())) {
                dbMap.put(item.getDbName(), "");
            }
        });
        dbMap.entrySet().forEach(item -> {
            TableTreeVO tableTreeVO = new TableTreeVO(item.getKey());
            List<TableInfoVO> tableInfoVOS = new ArrayList<>();
            list.stream().filter(t -> t.getDbName().equals(item.getKey())).collect(Collectors.toList()).forEach(table -> {
                tableTreeVO.getTables().add(table);
            });
            tableTreeVOS.add(tableTreeVO);

        });
        return tableTreeVOS;
    }
}
