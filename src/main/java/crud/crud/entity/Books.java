package crud.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    @Id
    private String id;
    private String title;
    private String description;
    private String author;
    private String publicDate;
    private String editorial;

}
