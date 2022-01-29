package com.textgeek.webserver.repository;

import com.textgeek.webserver.model.Book;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;

public class BookCustomRepositoryImpl implements BookCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Book> findAllWithParams(Map<String, String> allParams) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery query = qb.createQuery();
        Root<Book> root = query.from(Book.class);
        query.select(root);

        int offset = 0;
        int limit = 25;

        if (allParams.containsKey("genre")) {
            query.where(qb.equal(root.get("genre"), allParams.get("genre")));
        }

        if (allParams.containsKey("offset")) {
            offset = Integer.valueOf(allParams.get("offset")) - 1;
        }

        if (allParams.containsKey("limit")) {
            limit = Integer.valueOf(allParams.get("limit"));
        }

        return entityManager.createQuery(query).setFirstResult(offset).setMaxResults(limit)
            .getResultList();
    }
}
