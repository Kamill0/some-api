package com.potato.interview.control.repository;

import com.potato.interview.entity.Card;
import com.potato.interview.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findAllByUser(User user);
}
