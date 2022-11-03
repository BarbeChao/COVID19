package luochao.task;

import luochao.dao.DataDao;
import luochao.entity.Covid19_Data;
import luochao.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
public class DataTask {
    @Autowired
    private DataDao dataDao;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void handleData(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String dataStr = dateFormat.format(new Date());
        System.out.println("当前时间："+dataStr);

        dataDao.deleteAll();
        List<Covid19_Data> list = GsonUtil.handleData();
        for(Covid19_Data data :list){
            dataDao.insertData(data);
        }

        System.out.println(list.size()+"条数据更新完成！");
    }
}
