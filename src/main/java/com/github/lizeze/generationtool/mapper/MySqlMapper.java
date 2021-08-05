package com.github.lizeze.generationtool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.lizeze.generationtool.vo.TableInfoVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lzz
 */
public interface MySqlMapper extends BaseMapper {


    @Select("select   TABLE_SCHEMA as db_name,TABLE_NAME,TABLE_COMMENT as  remark from information_schema.tables where   TABLE_TYPE='BASE TABLE' and TABLE_SCHEMA not in ('performance_schema','mysql','sys')")
    List<TableInfoVO> tableName();
}
