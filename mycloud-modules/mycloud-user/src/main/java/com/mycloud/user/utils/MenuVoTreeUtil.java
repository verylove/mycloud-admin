package com.mycloud.user.utils;




import com.mycloud.common.model.MenuVo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MenuVoTreeUtil {

    public static Map<String,Object> mapArray = new LinkedHashMap<String, Object>();
    public List<MenuVo> menusCommon;

    public List<MenuVo> menusList(List<MenuVo> menus){
        List<MenuVo> list = new ArrayList<MenuVo>();
        MenuVo m = null;
        this.menusCommon = menus;
        for (MenuVo x : menus) {
            m = new MenuVo();
            if(x.getParentId().equals("0")){
                m.setId(x.getId());
                m.setName(x.getName());
                m.setCode(x.getCode());
                m.setPath(x.getPath());
                m.setComponent(x.getComponent());
                m.setMeta(x.getMeta());
                m.setKeepalived(x.isKeepalived());
                m.setParentId(x.getParentId());
                m.setEnabled(x.isEnabled());
                m.setChildren(menusChild(x.getId()));
                list.add(m);
            }

        }
        return list;
    }


    public List<MenuVo> menusChild(String id){
        List<MenuVo> lists = new ArrayList<MenuVo>();
        MenuVo menus = null;
        for(MenuVo a:menusCommon){
            menus = new MenuVo();
            if(a.getParentId().equals(id) ){
                menus.setId(a.getId());
                menus.setName(a.getName());
                menus.setCode(a.getCode());
                menus.setPath(a.getPath());
                menus.setComponent(a.getComponent());
                menus.setMeta(a.getMeta());
                menus.setKeepalived(a.isKeepalived());
                menus.setParentId(a.getParentId());
                menus.setEnabled(a.isEnabled());
                menus.setChildren(menusChild(a.getId()));
                lists.add(menus);
            }
        }
        return lists;

    }
}
