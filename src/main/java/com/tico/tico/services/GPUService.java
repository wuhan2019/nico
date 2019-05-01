package com.tico.tico.services;

import com.tico.tico.entities.GPU;
import com.tico.tico.mapper.GPUMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GPUService {
    @Autowired
    GPUMapper gpuMapper;
    public List<GPU> getAll(){
        return gpuMapper.getAll();
    }
    public GPU getGpuByName(String name){return gpuMapper.getGPUByName(name);}
    public List<GPU> getGPULikeBrand(String brand){return  gpuMapper.getGPULikeBrand(brand);}
    public List<GPU> getGPULikeType(String type){return  gpuMapper.getGPULikeType(type);}
    public List<GPU> getGPULikeBrandAndType(String brand,String type){return gpuMapper.getGPULikeBrandAndType(brand,type);}
    public List<GPU> searchGPU(String key){return gpuMapper.searchGPU(key);}
}
