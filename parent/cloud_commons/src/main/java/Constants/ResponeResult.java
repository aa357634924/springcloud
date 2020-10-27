package Constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className Result
 * @package Constants
 * @describe
 * @author hua.yang
 * @date 2020/10/27 11:40:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponeResult<T> {

    private Integer code;
    private String message;
    private T data;

    public ResponeResult(Integer code, String message){
        this(code,message,null);
    }
}
