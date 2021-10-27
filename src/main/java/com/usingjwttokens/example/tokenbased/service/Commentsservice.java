package com.usingjwttokens.example.tokenbased.service;

import com.usingjwttokens.example.tokenbased.models.Comments;
import com.usingjwttokens.example.tokenbased.repository.Commentsrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Commentsservice {
    @Autowired
    private Commentsrepo commentsrepo;

    public Comments saveme(Comments comments)
    {
       return commentsrepo.save(comments);
    }
    public List<Comments> findingall()
    {
       return commentsrepo.findAll();
    }
}
