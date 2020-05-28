package com.wch.service;

import com.wch.mapper.SUserMapper;
import com.wch.entity.SUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class SUserServiceImpl implements SUserService{


    private final SUserMapper sUserMapper;

    @Override
    public SUser getSUserById(int id) {
        //System.out.println("ces");
        return sUserMapper.selectById(id);
    }
}
