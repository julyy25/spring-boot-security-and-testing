package in.project.myproject.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostModal {
    private int userId;
    private int id;
    private String title;
    private String body;
}
