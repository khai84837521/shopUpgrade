package com.shopUpdate.dao;

import com.shopUpdate.domain.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class MemberDAOImpl implements MemberDAO {
    @Inject
    private SqlSession sqlSession;
    private static final String namespace = "com.shopUpdate.mappers.memberMapper";

    @Override
    public MemberDTO loginPro(MemberDTO memberDTO) {
        System.out.println("MemberDAOImple::loginPro");
        return sqlSession.selectOne(namespace+".loginPro",memberDTO);
    }

    @Override
    public String userSelectOne(MemberDTO memberDTO) {
        System.out.println("MemberDAOImple::userSelectOne");
        return sqlSession.selectOne(namespace+".userSelectOne",memberDTO);
    }

    @Override
    public int insertMember(MemberDTO memberDTO) {
        System.out.println("MemberDAOImple::insertMember");
        return sqlSession.insert(namespace+".insertMember", memberDTO);
    }

    @Override
    public String findId(MemberDTO memberDTO) {
        System.out.println("MemberDAOImple::findId");
        return sqlSession.selectOne(namespace+".findId", memberDTO);
    }

    @Override
    public int deleteMember(MemberDTO memberDTO) {
        System.out.println("MemberDAOImple::deleteMember");
        return sqlSession.delete(namespace+".deleteMember", memberDTO);
    }

    @Override
    public int memberPassChange(MemberDTO memberDTO) {
        System.out.println("MemberDAOImple::memberPassChange");
        return sqlSession.update(namespace+".memberPassChange", memberDTO);
    }
}
