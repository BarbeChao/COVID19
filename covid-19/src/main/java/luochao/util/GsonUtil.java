package luochao.util;

import com.google.gson.Gson;
import luochao.entity.Covid19_Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GsonUtil {

    //测试
    public static void main(String[] args) {
//            handleData();
            handleGraphData();
    }
    //获取疫情折现图的数据
    public static Map handleGraphData(){
        ArrayList<String> XList = new ArrayList<String>();
        ArrayList<Integer> YList = new ArrayList<Integer>();
        Map DataMap = new  HashMap();

        String url ="https://api.inews.qq.com/newsqa/v1/query/inner/publish/modules/list?limit=30&modules=chinaDayListNew,chinaDayAddListNew";
        String result = HttpClientUtil.doGet(url);
        Gson gson = new Gson();
        Map addData = gson.fromJson(result,Map.class);
        Map data = (Map)addData.get("data");
        ArrayList arrayList = (ArrayList) data.get("chinaDayAddListNew");
        for (int i =0;i<arrayList.size();i++){
            Map subDayMap = (Map)arrayList.get(i);
            double localConfirmadd = (Double) subDayMap.get("localConfirmadd");
            String date = (String) subDayMap.get("date");
            XList.add(date);
            YList.add((int)localConfirmadd);
        }
        DataMap.put("xList",XList);
        DataMap.put("yList",YList);

        return DataMap;
    }

    //获取疫情列表的数据
    public static List<Covid19_Data> handleData(){
        ArrayList<Covid19_Data> array = new ArrayList<>();
        String url = "https://api.inews.qq.com/newsqa/v1/query/inner/publish/modules/list?modules=diseaseh5Shelf";
        String result = HttpClientUtil.doGet(url);
        Gson gson = new Gson();
        Map dataMap = gson.fromJson(result, Map.class);
        Map subMap = (Map)dataMap.get("data");
        Map diseMap =(Map) subMap.get("diseaseh5Shelf");
        ArrayList arrayList =(ArrayList) diseMap.get("areaTree");
        Map subDataMap =(Map) arrayList.get(0);
        ArrayList childList = (ArrayList) subDataMap.get("children");
        for(int i =0;i<childList.size();i++){
            Map tmp = (Map) childList.get(i);
            String name =(String) tmp.get("name");
            Map todayMap =(Map) tmp.get("today");
            double local_confirm_add = (Double) todayMap.get("confirm");
            Map totalMap =(Map) tmp.get("total");
            double nowConfirm = (Double) totalMap.get("nowConfirm");
            double confirm =(Double) totalMap.get("confirm");
            double dead = (Double) totalMap.get("dead");
            Covid19_Data data = new Covid19_Data(name,(int)local_confirm_add,(int)nowConfirm,(int)confirm,(int)dead);
            array.add(data);
        }

        return array;
    }

}
