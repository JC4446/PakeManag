package com.auc.service.impl;

import com.auc.mapper.AdminMapper;
import com.auc.pojo.Admin;
import com.auc.pojo.LayuiData;
import com.auc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    public AdminMapper adminMapper;

    //查询管理员列表表格数据
    @Override
    public LayuiData<Admin> selectAdminList(Map<String, String> condition, Integer curPage, Integer pageSize) {
        LayuiData<Admin> layuiData = new LayuiData();
        Integer record = adminMapper.selectAdminCount(condition);
        List<Admin> adminList = adminMapper.selectAdmin(condition, curPage, pageSize, record);
        layuiData.setData(adminList);
        layuiData.setMsg("");
        layuiData.setCode(0);
        layuiData.setCount(record);
        layuiData.setCurrPage(curPage);
        return layuiData;
    }

}
