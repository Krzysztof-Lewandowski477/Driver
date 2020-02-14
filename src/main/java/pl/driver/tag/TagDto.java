package pl.driver.tag;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TagDto {

    private Long id;

    private String name;

    @JsonProperty(defaultValue = "0")
    private Integer popularity;

}
