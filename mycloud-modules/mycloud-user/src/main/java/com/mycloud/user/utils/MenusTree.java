package com.mycloud.user.utils;



import com.mycloud.user.entity.Menus;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MenusTree {

    public static Map<String,Object> mapArray = new LinkedHashMap<String, Object>();
    public List<Menus> menusCommon;


    public List<Menus> menusList(List<Menus> menus){
        List<Menus> list = new ArrayList<Menus>();
        Menus m = null;
        this.menusCommon = menus;
        for (Menus x : menus) {
            m = new Menus();
            if(x.getParentId().equals("0")){
                m.setId(x.getId());
                m.setName(x.getName());
                m.setCode(x.getCode());
                m.setPath(x.getPath());
                m.setComponent(x.getComponent());
                m.setTitle(x.getTitle());
                m.setIcon(x.getIcon());
                m.setHidden(x.isHidden());
                m.setKeepalived(x.isKeepalived());
                m.setParentId(x.getParentId());
                m.setRedirect(x.getRedirect());
                m.setEnabled(x.isEnabled());
                m.setAlwaysShow(x.isAlwaysShow());
                m.setChildren(this.menusChild(x.getId()));
                list.add(m);
            }

        }
        return list;
    }


    public List<Menus> menusChild(String id){
        List<Menus> lists = new ArrayList<Menus>();
        Menus menus = null;
        for(Menus a:menusCommon){
            menus = new Menus();
            if(a.getParentId() .equals(id) ){
                menus.setId(a.getId());
                menus.setName(a.getName());
                menus.setCode(a.getCode());
                menus.setPath(a.getPath());
                menus.setComponent(a.getComponent());
                menus.setTitle(a.getTitle());
                menus.setIcon(a.getIcon());
                menus.setHidden(a.isHidden());
                menus.setKeepalived(a.isKeepalived());
                menus.setParentId(a.getParentId());
                menus.setRedirect(a.getRedirect());
                menus.setEnabled(a.isEnabled());
                menus.setAlwaysShow(a.isAlwaysShow());
                menus.setChildren(menusChild(a.getId()));
                lists.add(menus);
            }
        }
        return lists;

    }
}
