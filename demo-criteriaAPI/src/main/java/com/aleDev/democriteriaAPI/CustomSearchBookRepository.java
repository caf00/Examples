package com.aleDev.democriteriaAPI;

import java.util.List;

public interface CustomSearchBookRepository {
    List<Book> getBooksByAuthorNameAndTitle(String authorName, String title);
}
