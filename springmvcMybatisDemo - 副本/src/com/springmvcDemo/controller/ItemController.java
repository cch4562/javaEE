package com.springmvcDemo.controller;

import com.springmvcDemo.pojo.Item;
import com.springmvcDemo.pojo.QueryVo;
import com.springmvcDemo.service.ItemService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;
    @RequestMapping("itemList")
    public ModelAndView itemList(){
        //创建模型对象
        ModelAndView mav=new ModelAndView();
        List<Item> list = itemService.getItemList();
        mav.addObject("itemList", list);
        mav.setViewName("itemList");
        return mav;
    }

//    @RequestMapping("itemEdit")
//    public ModelAndView itemEdit(HttpServletRequest request, HttpServletResponse response, HttpSession session){
//        //获取提交的id
//        String id = request.getParameter("id");
//        ModelAndView mav=new ModelAndView();
//        //查询id对应商品的信息
//        Item item = itemService.getItemById(new Integer(id));
//        //设置商品数据返回首页
//        mav.addObject("item", item);
//        mav.setViewName("itemEdit");
//        return mav;
//    }
//    @RequestMapping("itemEdit")
//    //简单参数的传递
//    public ModelAndView itemEdit(@RequestParam(value = "id",required = true,defaultValue = "1")Integer ids){
//        ModelAndView mav=new ModelAndView();
//        Item item = itemService.getItemById(ids);
//        mav.addObject("item", item);
//        mav.setViewName("itemEdit");
//        return mav;
//    }
    @RequestMapping("itemEdit")
    //返回String类型 用modelMap/model返回数据模型
    public String itemEdit(@RequestParam(value = "id")Integer ids, ModelMap model){
        //获取商品
        Item item = itemService.getItemById(ids);
        model.addAttribute("item", item);
        return "itemEdit";
    }
//    @RequestMapping("updateItem")
//    //绑定pojo对象
//    public String updateItem(Item item,ModelMap model){
//        itemService.updateItem(item);
//        model.addAttribute("item", item);
//        model.addAttribute("msg", "修改商品成功");
//        return "itemEdit";
//    }
    @RequestMapping("queryItem")
    //传递包装的pojo 数组形式的绑定
    public String queryItem(QueryVo vo,ModelMap model){
        System.out.println(vo);
        if(vo.getIds()!=null&&vo.getIds().length>0){
            for(Integer id:vo.getIds()){
                System.out.println(id);
            }
        }
        return "itemList";
    }
    @RequestMapping("updateItem")
    //上传图片
    public String updateItem(Item item, MultipartFile picFile,ModelMap model) throws Exception {
        //图片新名字
        String newName = UUID.randomUUID().toString();
        //图片原名字
        String oldName = picFile.getOriginalFilename();
        //图片后缀名
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        //保存图片到本地磁盘
        File pic =new File("D:\\javatest\\WebWork\\"+newName+suffix);
        picFile.transferTo(pic);
        //更新数据库的图片信息
        item.setPic(newName+suffix);
        itemService.updateItem(item);
        model.addAttribute("item", item);
        model.addAttribute("msg", "修改商品成功");
        return "itemEdit";
    }
//    @RequestMapping("updateItem")
//    public String updateItem(Item item,MultipartFile picFile,ModelMap model) throws IOException {
//        //图片新名字
//        String newName = UUID.randomUUID().toString();
//        //图片原来的名字
//        String oldName = picFile.getOriginalFilename();
//        //后缀名
//        String suffix = oldName.substring(oldName.lastIndexOf("."));
//        //上传至本地磁盘
//        File file=new File("D:\\javatest\\WebWork\\"+newName+suffix);
//        picFile.transferTo(file);
//        //更新数据库
//        item.setPic(newName+suffix);
//        itemService.updateItem(item);
//        model.addAttribute("item", item);
//        model.addAttribute("msg", "修改商品成功");
//        return "itemEdit";
//    }
}
