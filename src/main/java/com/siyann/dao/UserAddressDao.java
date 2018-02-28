package com.siyann.dao;

import com.siyann.dao.custom.UserAddressCustomDao;
import com.siyann.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAddressDao extends JpaRepository<UserAddress, Long>, UserAddressCustomDao {
    List<UserAddress> findByUserid(Long userid) throws Exception;

    int deleteByIdAndUserid(Long id, Long userid) throws Exception;

    @Modifying
    @Query("update UserAddress ua set ua.userid=?1 , ua.address=?2,ua.receiver=?3 ,ua.default_=?4,ua.tel=?5,ua.sex=?6 where ua.id=?7")
    int update(Long userid,
               String address, String receiver, Integer default_, String tel, String sex,
               Long id) throws Exception;

    UserAddress findFirstByUseridAndDefault_(Long userid, Integer default_) throws Exception;

//    /**
//     * 修改默认地址，注解方式执行存储过程，需要结合实体类中的@NamedStoredProcedureQueries 注解
//     */
//    @Procedure(procedureName = "update_default_address")
//    void updateDefaultAddress(@Param("id") Long id, @Param("userid") Long userid);


}
