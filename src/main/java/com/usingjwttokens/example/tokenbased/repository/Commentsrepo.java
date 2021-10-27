package com.usingjwttokens.example.tokenbased.repository;

import com.usingjwttokens.example.tokenbased.models.Cart;
import com.usingjwttokens.example.tokenbased.models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Commentsrepo extends JpaRepository<Comments,Long> {
}
