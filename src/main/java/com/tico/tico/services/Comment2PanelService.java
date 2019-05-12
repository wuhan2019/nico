package com.tico.tico.services;

import com.tico.tico.entities.Comment2Panel;
import com.tico.tico.mapper.Comment2PanelMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Comment2PanelService {
    @Autowired
    Comment2PanelMapper comment2PanelMapper;
    public List<Comment2Panel> getAll(){
        return comment2PanelMapper.getAll();
    }
    public List<Comment2Panel> getByName(String name){return comment2PanelMapper.getByName(name);}
    public Double price_mark(String name){return comment2PanelMapper.price_mark(name);}
    public Double screen_mark(String name){return comment2PanelMapper.screen_mark(name);}
    public Double workspeed_mark(String name){return comment2PanelMapper.workspeed_mark(name);}
    public Double battery_mark(String name){return comment2PanelMapper.battery_mark(name);}
    public Double appearance_mark(String name){return comment2PanelMapper.appearance_mark(name);}
    public void addPanelComment(@Param("panelComment") Comment2Panel panelComment){comment2PanelMapper.addPanelComment(panelComment);}
}
