package pl.driver.tag;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tag")
@Secured("ROLE_USER")
public class TagController {

    private final ModelMapper mapper;
    private final TagService tagService;

    public TagController(ModelMapper mapper, TagService tagService) {
        this.mapper = mapper;
        this.tagService = tagService;
    }

    @GetMapping("/get")
    public TagDto getOne(Long id) {
        return mapper.map(tagService.getOne(id), TagDto.class);
    }

    @GetMapping("/get/most-popular-10")
    public List<TagDto> getTenMostPopularTags() {
        return tagService.find10MostPopularTags()
                .stream()
                .map(t -> mapper.map(t, TagDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/all")
    public List<TagDto> getAllTags() {
        return tagService.findAll()
                .stream()
                .map(t -> mapper.map(t, TagDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/add")
    public TagDto addTag() {
        return new TagDto();
    }

    @PostMapping("/add")
    public void saveTag(@RequestBody TagDto tagDto) {
        tagService.saveTag(mapper.map(tagDto, Tag.class));
    }

    @PutMapping("/update")
    public void updateTag(@RequestBody TagDto tagDto) {
        tagService.updateTag(mapper.map(tagDto, Tag.class));
    }

    @DeleteMapping("/delete")
    public void deleteTag(Long id) {
        tagService.deleteTag(id);
    }


}
