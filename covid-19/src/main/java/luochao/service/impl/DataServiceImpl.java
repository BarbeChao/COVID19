package luochao.service.impl;

import luochao.dao.Covid19GraphdataMapper;
import luochao.dao.DataDao;
import luochao.entity.Covid19Graphdata;
import luochao.entity.Covid19_Data;
import luochao.service.DataService;
import luochao.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataDao dataDao;

    @Autowired
    private Covid19GraphdataMapper graphdataMapper;


    //查询整体数据
    @Override
    public List<Covid19_Data> getDataList() {
        List<Covid19_Data> dataList= dataDao.selectList();
        return dataList;
    }

    //按页数获取数据
    @Override
    public List<Covid19_Data> getDataList(String Page) {
        Integer PageIndex = (Integer.parseInt(Page)-1)*5;
        List<Covid19_Data> dataList= dataDao.selectData(PageIndex);
        return dataList;
    }
    //查询折线图数据
    @Override
    public List<Covid19Graphdata> getGraphdata() {
        List<Covid19Graphdata> graphdataList = graphdataMapper.selectAll();
        return graphdataList;
    }

    //初始化插入疫情数据
//    @PostConstruct
    public void  initData() {
        List<Covid19_Data> list = GsonUtil.handleData();
        for(Covid19_Data data :list){
            dataDao.insertData(data);
        }
    }



}
