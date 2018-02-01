package cn.itcast.springboot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.springboot.domain.Notice;
import cn.itcast.springboot.mapper.NoticeMapper;
import cn.itcast.springboot.service.NoticeService;
@Service
@Transactional//事务
public class NoticeServiceImpl implements NoticeService{
	
	//注入mapper
	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public List<Notice> findAll() {
		return noticeMapper.findAll();
	}

	@Override
	public Map<String, Object> findByPage(Integer page, Integer rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		//查询总记录数
		Long count = noticeMapper.count();
		//分页查询的数据
		List<Notice> list = noticeMapper.findByPage(page, rows);
		map.put("total", count);
		map.put("rows", list);
		return map;
	}

}
