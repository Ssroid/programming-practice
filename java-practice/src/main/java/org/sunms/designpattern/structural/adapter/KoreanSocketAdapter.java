package org.sunms.designpattern.structural.adapter;

/**
 * 한국 콘센트입니다. 오직 {@link Plug220vAdapter} 규격만 알고 있습니다.
 *
 * <p><b>역할:</b> Client (사용자)</p>
 *
 * <p>꽂힌 것이 선풍기인지, 변환기를 낀 드라이어인지 전혀 모르고 신경 쓰지도 않습니다.</p>
 */
public class KoreanSocketAdapter {

    /**
     * 플러그를 꽂고 220V 전기를 공급합니다.
     *
     * @param plug 220V 규격을 따르는 플러그 (기기 또는 변환기)
     */
    public void plugIn(Plug220vAdapter plug) {
        System.out.println("  [한국 콘센트] 220V 전기를 공급합니다.");
        plug.supply220v();
    }
}
