package org.springframework.luna.domain.anno;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author chenzhangyue
 * 2023/3/10
 */
@Component
@Data
public class Age {

	private Integer number;

	public Age() {
		System.out.println("age empty constructor");
	}

}
