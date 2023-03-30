package org.springframework.context;

import org.springframework.beans.factory.Aware;

/**
 * @author chenzhangyue
 * 2023/3/30
 */
public interface LyaAware extends Aware {

	void setLunaContext();
}
