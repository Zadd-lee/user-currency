package com.sparta.currency_user.repository;

import com.sparta.currency_user.dto.ExchangeGroupsInfoResponseDto;
import com.sparta.currency_user.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ExchangeRepository extends JpaRepository<Exchange,Long> {
    List<Exchange> findAllByUserId(Long userId);

    @Query("select new com.sparta.currency_user.dto.ExchangeGroupsInfoResponseDto(count(e.id),sum(e.amountInKRW))" +
            " from Exchange e" +
            " where e.user.id=:userId and e.status='normal' ")
    ExchangeGroupsInfoResponseDto findAllInfoByUserId(@Param("userId") Long userId);
}
