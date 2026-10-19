package org.sunms.designpattern.structural.adapter;

/**
 * 한국산 선풍기입니다. 처음부터 220V 규격이라 변환기 없이 바로 꽂을 수 있습니다.
 *
 * <p><b>역할:</b> 비교용 (원래부터 Target 규격을 따르는 클래스)</p>
 *
 * @see Plug220vAdapter
 */
public class KoreanFanAdapter implements Plug220vAdapter {

    /**
     * 220V로 바로 작동합니다.
     */
    @Override
    public void supply220v() {
        System.out.println("  [한국 선풍기] 220V 로 바로 작동! 시원한 바람~");
    }
}
