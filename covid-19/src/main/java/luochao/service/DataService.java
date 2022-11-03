package luochao.service;

import luochao.entity.Covid19Graphdata;
import luochao.entity.Covid19_Data;

import java.util.List;

public interface DataService {

    //获取整体数据
    List<Covid19_Data> getDataList(String Page);

    List<Covid19_Data> getDataList();

    //获取折线图数据
    List<Covid19Graphdata> getGraphdata();

    //初始化数据
    void initData();
}
