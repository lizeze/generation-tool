package com.github.lizeze.generationtool.service;

import com.github.lizeze.generationtool.vo.TableInfoVO;
import com.github.lizeze.generationtool.vo.TableTreeVO;

import java.util.List;

/**
 * @author lzz
 */
public interface BaseService {


    /**
     * 获取数据库中的表信息
     *
     * @return
     */
    List<TableInfoVO> getTableList();


    /**
     * 获取树结构的表信息
     * @return
     */
    List<TableTreeVO> getTableTree();


}
