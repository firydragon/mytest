package cn.itcast.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * 控制器
 * @author Administrator
 *
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.springboot.domain.Notice;
import cn.itcast.springboot.service.NoticeService;
@Controller
public class NoticeController {
	//注入service
	@Autowired
	private NoticeService noticeService;
	/**
	 * 查询所有记录
	 * @return
	 */
	@GetMapping("/findAll")
	@ResponseBody
	public List<Notice> findAll(){
		List<Notice> list = noticeService.findAll();
		return list;
	}
	/**
	 * 跳转到分页面
	 * @return
	 */
	@RequestMapping("/toNotice")
	public String toNotice() {
		return "/notice.html";
	}
	
	/**
	 * 分页进行查询
	 * @return
	 */
	@RequestMapping("/findByPage")
	@ResponseBody
	public Map<String,Object> findByPage(@RequestParam(value="page",defaultValue="1",required=false)Integer page,
			@RequestParam(value="rows",defaultValue="15",required=false)Integer rows){
		return noticeService.findByPage((page-1)*rows, rows);
	}
	

}
