package luochao.dao;

import luochao.entity.Covid19_Data;

import java.util.List;

public interface DataDao {

    //查询数据库中的疫情数据
    public List<Covid19_Data> selectData(Integer PageIndex);

    //查询数据库中的疫情数据
    public List<Covid19_Data> selectList();

    //插入疫情数据
    public void insertData(Covid19_Data covid19_data);

    //删除疫情所有数据
    public void deleteAll();

}
