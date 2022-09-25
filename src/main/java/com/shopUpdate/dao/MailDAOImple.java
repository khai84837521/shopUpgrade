package com.shopUpdate.dao;

import com.shopUpdate.domain.MailDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class MailDAOImple implements MailDAO{

    @Inject
    private SqlSession sqlSession;
    private static final String namespace = "com.shopUpdate.mappers.mailMapper";

    @Override
    public MailDTO emailCheck(MailDTO mailDTO) {
        System.out.println("MailDAOImpl::emailCheck");
        return sqlSession.selectOne(namespace+".emailCheck",mailDTO);
    }

    @Override
    public int mailCodeInsert(MailDTO mailDTO) {
        System.out.println("MailDAOImpl::mailCodeInsert");
        return sqlSession.insert(namespace+".mailCodeInsert",mailDTO);
    }

    @Override
    public int mailCodeUpdate(MailDTO mailDTO) {
        System.out.println("MailDAOImpl::mailCodeUpdate");
        return sqlSession.update(namespace+".mailCodeUpdate",mailDTO);
    }

    @Override
    public String MailSelectOne(MailDTO mailDTO) {
        System.out.println("MailDAOImpl::mailSelectOne");
        return sqlSession.selectOne(namespace+".mailSelectOne", mailDTO);
    }
}
