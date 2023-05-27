package com.example.sep6_backend.repository;

import com.example.sep6_backend.api.model.Bookmark;
import com.example.sep6_backend.api.model.Movie;
import org.springframework.stereotype.*;
import javax.persistence.*;
import javax.transaction.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class BookmarkRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Bookmark> getBookmarksByUserId(int user_id) {
        Query query = entityManager.createNativeQuery("SELECT b.* FROM bookmark b where b.user_id=:id");
        query.setParameter("id", user_id);
        List<Object[]> results = query.getResultList();

        List<Bookmark> bookmarks = new ArrayList<>();
        for (Object[] result : results) {
            Bookmark bookmark = new Bookmark((int) result[0],(int) result[1]);
            bookmarks.add(bookmark);
        }
        return bookmarks;
    }

    public Bookmark saveBookmark(Bookmark bookmark) {
        try {
            entityManager.persist(bookmark);
            System.out.println("Bookmark saved successfully!");
            return bookmark;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteBookmarkByUserIdAndMovieId(int user_id, int movie_id) {
        Query query = entityManager.createNativeQuery("DELETE FROM bookmark WHERE user_id = :userId AND movie_id = :movieId");
        query.setParameter("userId", user_id);
        query.setParameter("movieId", movie_id);
        query.executeUpdate();
    }

    public boolean existsBookmarkByUserIdAndMovieId(int user_id, int movie_id) {
        Query query = entityManager.createNativeQuery("SELECT COUNT(*) FROM bookmark WHERE user_id = :userId AND movie_id = :movieId");
        query.setParameter("userId", user_id);
        query.setParameter("movieId", movie_id);
        int count = ((Number) query.getSingleResult()).intValue();
        return count > 0;
    }

    public Bookmark getBookmarkByUserIdAndMovieId(int user_id, int movie_id) {
        Query query = entityManager.createNativeQuery("SELECT b.* FROM bookmark b WHERE b.user_id = :userId AND b.movie_id = :movieId");
        query.setParameter("userId", user_id);
        query.setParameter("movieId", movie_id);
        List<Object[]> results = query.getResultList();

        for (Object[] result : results) {
            Integer bookmarkId = (int) result[0];
            Bookmark bookmark = new Bookmark(Long.valueOf(bookmarkId.toString()),movie_id,user_id);
            return bookmark;
        }
        return null;
    }

}
