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
}
