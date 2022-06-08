package com.aleDev.democriteriaAPI;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomSearchBookRepositoryImpl implements CustomSearchBookRepository {

    private final EntityManager em;

    public CustomSearchBookRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Book> getBooksByAuthorNameAndTitle(String authorName, String title) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> book = criteriaQuery.from(Book.class);
        List<Predicate> predicates = new ArrayList<>();
        if (authorName != null)
            predicates.add(criteriaBuilder.equal(book.get("author"), authorName));
        if (title != null)
            predicates.add(criteriaBuilder.like(book.get("title"), "%" + title + "%"));
        criteriaQuery.where(predicates.toArray(Predicate[]::new));
        TypedQuery<Book> typedQuery = em.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
