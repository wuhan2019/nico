package com.tico.tico.services;

import com.tico.tico.entities.Panel;
import com.tico.tico.mapper.PanelMapper;
import com.tico.tico.mapper.PhoneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanelService {
    @Autowired
    PanelMapper panelMapper;
    public List<Panel> getAll(){
        return panelMapper.getAll();
    }
    public Panel getPanelByName(String name){return panelMapper.getPanelByName(name);}
    public  List<Panel> getPanelLikeBrand(String brand){return panelMapper.getPanelLikeBrand(brand);}
    public List<Panel> getPanelLikeType(String type){return panelMapper.getPanelLikeType(type);}
    public  List<Panel> getPanelLikeBrandAndType( String brand, String type){return panelMapper.getPanelLikeBrandAndType(brand, type);}
    public  List<Panel> searchPanel(String key){return panelMapper.searchPanel(key);}

}
