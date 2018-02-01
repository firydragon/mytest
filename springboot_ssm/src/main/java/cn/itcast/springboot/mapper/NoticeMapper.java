package cn.itcast.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.itcast.springboot.domain.Notice;
/**
 * 声明Mapper接口
 * @author Administrator
 *
 */
@Mapper
public interface NoticeMapper {
	@Select("select * from notice")
	public List<Notice> findAll();
	/*统计查询*/
	public Long count();
	
	/**分页查询*/
	public List<Notice> findByPage(@Param("page")Integer page,@Param("rows")Integer rows);

}
