package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {


    //Tweetów dla zadanego id użytkownika.

    List<Tweet> findAllByUser(List<User> user_id);


    //Tweetów o tytule, który zaczyna się od ciągu znaków, np. Programo , posortowane od najnowszego względem daty utworzenia.

    @Query("Select t from Tweet t where t.title like :title% order by t.created desc")
    List<Tweet> getByTitleStartingWith(@Param("title") String title);

}
