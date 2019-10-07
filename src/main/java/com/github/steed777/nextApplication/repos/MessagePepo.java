package com.github.steed777.nextApplication.repos;

import com.github.steed777.nextApplication.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessagePepo extends CrudRepository<Message, Integer> {
    List<Message>findByTag(String tag);
}
