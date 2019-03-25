package com.sxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxt.dto.BasicDataDto;
import com.sxt.mapper.BasicDataMapper;
import com.sxt.pojo.BasicData;
import com.sxt.pojo.BasicDataExample;
import com.sxt.service.IBasicService;

@Service
public class BasicServiceImpl implements IBasicService {

	@Resource
	private BasicDataMapper basicDataMapper;

	@Override
	public List<BasicData> query(BasicData bd) {
		BasicDataExample example = new BasicDataExample();
		
		return basicDataMapper.selectByExample(example );
	}

	@Override
	public PageInfo<BasicData> queryPage(BasicDataDto dto) {
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		List<BasicData> list = this.query(dto.getBasic());
		return new PageInfo<>(list);
	}

	@Override
	public void addBasicData(BasicData bd) {
		// TODO Auto-generated method stub
		basicDataMapper.insertSelective(bd);
	}

	@Override
	public void deleteBasicData(int id) {
		// TODO Auto-generated method stub
		basicDataMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateBasicData(BasicData bd) {
		// TODO Auto-generated method stub
		basicDataMapper.updateByPrimaryKeySelective(bd);
	}

	@Override
	public void getUpdateInfo(Integer id, Model m) {
	BasicDataExample example = new BasicDataExample();
		example.createCriteria().andParentIdIsNull();
		List<BasicData> parents = basicDataMapper.selectByExample(example);
		m.addAttribute("parents", parents);
		if(id != null && id > 0){
			// 表示是更新数据，根据id查询出对应的数据信息
			BasicData data = basicDataMapper.selectByPrimaryKey(id);
			m.addAttribute("basic", data);
		}
	}

	/**
	 * 根据大类名查询出小类
	 */
	@Override
	public List<BasicData> getBasicDataByParentName(String basicCommonInterval) {
		// TODO Auto-generated method stub
		return basicDataMapper.getBasicDataByParentName(basicCommonInterval);
	}

}
