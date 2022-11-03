package luochao.controller;

import com.google.gson.Gson;
import luochao.bean.MapBean;
import luochao.entity.Covid19Graphdata;
import luochao.entity.Covid19_Data;
import luochao.service.DataService;
import luochao.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class DataController {
    @Autowired
    private DataService dataService;


    //获取标准疫情数据
        @RequestMapping(value ="/getData",produces = "application/json;charset=utf-8")
    public String getData(String lan, Model model, HttpSession httpSession,String Page){
            if(Page==null){
                Page="1";
            }
        List<Covid19_Data> dataList= dataService.getDataList(Page);
        model.addAttribute("dataList",dataList);
        if(!StringUtils.isEmpty(lan)){
            String[] split = lan.split("_");
            Locale locale = new Locale(split[0],split[1]);
            httpSession.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
        }
        return "dataList";
    }

    //获取页数
    @RequestMapping(value = "/getPage",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Integer getPage(){
        List<Covid19_Data> dataList= dataService.getDataList();
        return dataList.size();
    }

    //获取折线图疫情数据
    @RequestMapping(value = "/getGraphData",produces = "application/json;charset=utf-8")
    public String getGraphData(Model model){
        Map DataMap = GsonUtil.handleGraphData();
        ArrayList<String> XList = (ArrayList)DataMap.get("xList");
        ArrayList<Integer> YList = (ArrayList)DataMap.get("yList");
        model.addAttribute("xList",XList);
        model.addAttribute("yList",YList);
        return "GraphData";
    }

    //从数据库中获取折线图数据
    @RequestMapping(value = "/graph",produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Covid19Graphdata> getGraph(){
        List<Covid19Graphdata> graphdataList = dataService.getGraphdata();
        return graphdataList;
    }


    //获取地图有疫情数据
    @RequestMapping(value = "/getMapData",produces = "application/json;charset=utf-8")
    public String getMapData(Model model){
        //获取所有的疫情数据
        List<Covid19_Data> dataList= dataService.getDataList();
        //装载新增的疫情数据
        List<MapBean> addList = new ArrayList<>();
        //转载现有的疫情数据
        List<MapBean> nowList = new ArrayList<>();

        for (Covid19_Data data:dataList){
            MapBean mapBean = new MapBean(data.getName(),data.getLocal_confirm_add());
            MapBean mapBean2 = new MapBean(data.getName(),data.getNowConfirm());
            addList.add(mapBean);
            nowList.add(mapBean2);
        }
        model.addAttribute("addList",new Gson().toJson(addList));
        model.addAttribute("nowList",new Gson().toJson(nowList));
        return "MapData";
    }


    //测试Thymeleaf
    @RequestMapping(value = "/thyme",produces = "application/json;charset=utf-8")
    public String thyme(Model model){
        model.addAttribute("name","罗超");
        return "index";
    }

}
