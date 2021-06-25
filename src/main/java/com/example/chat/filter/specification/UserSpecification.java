package com.example.chat.filter.specification;

import com.example.chat.model.User;
import com.example.chat.model.User_;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

@UtilityClass
public class UserSpecification {

    public static Specification<User> findByUsername(String username) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(User_.USERNAME), username));
    }

}