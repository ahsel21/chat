package com.example.chat.filter.specification;

import com.example.chat.model.RoomRole;
import com.example.chat.model.RoomRole_;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

@UtilityClass
public class RoomRoleSpecification {

    public static Specification<RoomRole> findByName(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(RoomRole_.NAME), name);
    }

}