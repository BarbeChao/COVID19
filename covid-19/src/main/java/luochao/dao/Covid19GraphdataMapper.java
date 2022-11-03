package luochao.dao;

import com.luochao.entity.Covid19Graphdata;

import java.util.List;

public interface Covid19GraphdataMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Covid19Graphdata record);

    Covid19Graphdata selectByPrimaryKey(Long id);

    List<Covid19Graphdata> selectAll();

    int updateByPrimaryKey(Covid19Graphdata record);
}