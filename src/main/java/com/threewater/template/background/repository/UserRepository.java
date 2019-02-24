package com.threewater.template.background.repository;

import com.threewater.template.background.domain.UserInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * 用于elasticsearch使用
 */
@Component
//@Repository
public interface UserRepository extends ElasticsearchRepository<UserInfo, String> {
}
