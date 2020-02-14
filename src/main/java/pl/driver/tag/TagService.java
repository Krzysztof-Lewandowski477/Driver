package pl.driver.tag;

import java.util.List;

public interface TagService {
    List<Tag> find10MostPopularTags();

    Tag getOne(Long id);

    List<Tag> findTopTenTags();

    List<Tag> findAll();

    void saveTag(Tag tag);

    void updateTag(Tag tag);

    void deleteTag(Long id);

    Boolean existById(Long id);
}
