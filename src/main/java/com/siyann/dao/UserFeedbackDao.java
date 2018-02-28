package com.siyann.dao;

import com.siyann.entity.UserFeedback;
import com.siyann.view.VUserFeedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFeedbackDao extends JpaRepository<UserFeedback, Integer> {
    @Query("select v from VUserFeedback v where v.read  = :read")
    Page<VUserFeedback> getAllByRead(Integer read, Pageable pageable);

    Long countByRead(Integer read);

    @Modifying
    @Query("update UserFeedback set read =1 where id = ?1")
    int updateById(Integer id);
}
