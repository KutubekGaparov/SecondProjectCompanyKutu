package azamat.FileInformation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomPage {

    private Long totalElements;

    private int totalPages;

    private int number;

    private int size;

}
