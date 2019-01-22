package com.mycloud.user.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mycloud.user.entity.Dept;
import com.mycloud.user.service.IDeptService;
import com.mycloud.user.mapper.IDeptMapper;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HOU
 * @since 2019-01-15
 */
@Service
public class DeptServiceImpl extends ServiceImpl<BaseMapper<Dept>,Dept> implements IDeptService{

	@Resource
	private IDeptMapper deptMapper;
	
}
