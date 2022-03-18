package com.textgeek.webserver.repository;

import com.textgeek.webserver.model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;
import javax.persistence.criteria.Subquery;
import com.textgeek.webserver.model.BookRating;
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

        List<Predicate> predicates = new ArrayList<Predicate>();

        int offset = 0;
        int limit = 25;

        if (allParams.containsKey("top_sellers") && allParams.get("top_sellers")
            .equalsIgnoreCase("true")) {
            query.orderBy(qb.desc(root.get("copiesSold")));
            limit = 10;
        }

        if (allParams.containsKey("genre")) {
            predicates.add(qb.equal(root.get("genre"), allParams.get("genre")));
        }

        if(allParams.containsKey("min_rating")){
            predicates.add(qb.greaterThanOrEqualTo(root.get("averageRating"), allParams.get("min_rating")));
        }

        query.where(predicates.toArray(new Predicate[]{}));

        if (allParams.containsKey("offset")) {
            offset = Integer.valueOf(allParams.get("offset")) - 1;
        }

        if (allParams.containsKey("limit")) {
            limit = Integer.valueOf(allParams.get("limit"));
        }

        List<Book> returning = entityManager.createQuery(query).setFirstResult(offset).setMaxResults(limit)
            .getResultList();

        return returning;
    }
}
