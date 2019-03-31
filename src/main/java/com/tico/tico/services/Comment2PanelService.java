package com.tico.tico.services;

import com.tico.tico.entities.Comment2Panel;
import com.tico.tico.mapper.Comment2PanelMapper;
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
}
