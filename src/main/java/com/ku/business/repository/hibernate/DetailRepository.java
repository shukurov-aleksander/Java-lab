package com.ku.business.repository.hibernate;

import com.ku.business.HibernateUtil;
import com.ku.business.entity.Detail;
import com.ku.business.exception.RepositoryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DetailRepository {
    public static final String FIND_BY_ID_QUERY = """
        FROM Detail d
            LEFT JOIN FETCH d.company
            LEFT JOIN FETCH d.order
        WHERE d.id = :id
    """;
    public static final String FIND_ALL_QUERY = "FROM Detail";
    public static final String INSERT_QUERY = """
        INSERT INTO details(operation_type)
                VALUES(:type\\:\\:operation_type_enum)
    """;
    public static final String UPDATE_QUERY = """
        UPDATE details
        SET operation_type = :type\\:\\:operation_type_enum
        WHERE id = :id
    """;
    private final SessionFactory sessionFactory;

    public DetailRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Detail findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(FIND_BY_ID_QUERY, Detail.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception s) {
            throw new RepositoryException(String.format("Can't find detail with id=%d!", id), s);
        }
    }

    public List<Detail> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(FIND_ALL_QUERY, Detail.class).list();
        } catch (Exception e) {
            throw new RepositoryException("Table details is empty!", e);
        }
    }

    public void save(Detail detail) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                session.beginTransaction();
                session.createQuery(INSERT_QUERY, Detail.class)
                        .setParameter("type",detail.getOperationType().toString())
                        .executeUpdate();
                session.getTransaction().commit();
            } catch (RepositoryException e) {
                session.getTransaction().rollback();
                throw new RepositoryException(String.format("Failed to save detail where id = %d!", detail.getId()), e);
            }
        }
    }

    public void update(Detail detail) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                session.beginTransaction();
                session.createQuery(UPDATE_QUERY, Detail.class)
                        .setParameter("type",detail.getOperationType().toString())
                        .setParameter("id",detail.getId())
                        .executeUpdate();
                session.getTransaction().commit();
            } catch (RepositoryException e) {
                session.getTransaction().rollback();
                throw new RepositoryException(String.format("Can't update detail with id=%d. This detail is not exist!", detail.getId()), e);
            }
        }
    }

    public void delete(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                session.beginTransaction();
                Detail detail = session.getReference(Detail.class, id);
                session.remove(detail);
                session.getTransaction().commit();
            } catch (RepositoryException e) {
                session.getTransaction().rollback();
                throw new RepositoryException(String.format("Can't delete detail with id=%d. This detail is not exist!", id), e);
            }
        }
    }
}
