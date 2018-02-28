package com.siyann.dao;

import com.siyann.entity.User;
import com.siyann.view.VUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User, Long> {
//    @Query(value = "select v from VUser v where v.phone = ?1 and v.password=?2")
//    VUser getFirstByPhoneAndPassword(String phone, String password) throws Exception;

    User findFirstByPhoneAndPassword(String phone, String password) throws Exception;

    @Query(value = "select v from VUser v where v.id = ?1")
    VUser getFirstById(Long id) throws Exception;

    User findFirstByPhone(String phone) throws Exception;

    @Modifying
    @Query(value = "update User set password = ?2 where id=?1")
    int updateByIdAndPassowrd(Long id, String passowrd) throws Exception;

    User findFirstByIdAndPassword(Long id, String password) throws Exception;

    @Modifying
    @Query(value = "update User set nickname = ?2 where id=?1")
    int updateByIdAndNickname(Long id, String nickname) throws Exception;

    @Modifying
    @Query(value = "update User set headUrl=?1 where id=?2")
    int updateByHeadUrl(String url, Long userid) throws Exception;

    @Query("select v from VUser v ")
    Page<VUser> getAll(Pageable pageable);

    @Query("select v from VUser v where v.isFree = :isFree")
    Page<VUser> getAllByIsFree(Integer isFree, Pageable pageable);

    Long countByIsFree(Integer isFree);

    @Query("select v from VUser v where v.phone = :phone")
    Page<VUser> getAllByPhone(String phone, Pageable pageable);

    Long countByPhone(String phone);

    int updateByIdAnd(Integer isFree , Long userid);
}
