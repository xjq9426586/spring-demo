package com.example.demo.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.bean.PageBean;
import com.example.demo.bean.User;
import com.example.demo.dao.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @PersistenceContext
    private EntityManager em;
    @Override
    public PageBean getUsersPage(PageBean pb, String nickName) {
        //规格定义
        Specification<User> specification = new Specification<User>() {

            /**
             * 构造断言
             * @param root 实体对象引用
             * @param query 规则查询对象
             * @param cb 规则构建对象
             * @return 断言
             */
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>(); //所有的断言
                if(StringUtils.isNotBlank(nickName)){ //添加断言
                    Predicate likeNickName = cb.like(root.get("nickName").as(String.class),nickName+"%");
                    predicates.add(likeNickName);
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                //query.groupBy(root.get("regTime"));
                return query.getRestriction();
            }
        };
        //分页信息
        Sort sort = new Sort(Direction.DESC, "nickName");
        Pageable pageable = new PageRequest(pb.getCurPage()-1,pb.getPageSize(),sort); //页码：前端从1开始，jpa从0开始，做个转换
        //查询
        Page<User> page = userRepository.findAll(specification,pageable);
        pb.setPage(page);
        
        return pb;
    }
	@Override
	public User getUser() {
		String sql = "select count(*) from user u where u.id=5";
		int count = ((BigInteger)em.createNativeQuery(sql).getSingleResult()).intValue();
		System.out.println(count);
		return null;
	}

}
