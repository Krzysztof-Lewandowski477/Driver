package pl.driver.tag;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultTagService implements TagService {

    private final TagRepository tagRepository;

    public DefaultTagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tag> find10MostPopularTags() {
        return tagRepository.findTop10ByPopularityIsNotNullOrderByPopularityDesc();
    }

    @Override
    public Tag getOne(Long id) {
        return tagRepository.findById(id).get();
    }

    @Override
    public List<Tag> findTopTenTags() {
        return tagRepository.findTop10ByPopularityIsNotNullOrderByPopularityDesc();
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public void saveTag(Tag tag) {
        if (!tagRepository.existsByName(tag.getName())) {
            tagRepository.save(tag);
        }
    }

    @Override
    public void updateTag(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public Boolean existById(Long id){
        return tagRepository.existsById(id);
    }

}
