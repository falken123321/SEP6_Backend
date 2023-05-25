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


}
