package org.sunms.designpattern.structural.facade;

/**
 * 홈시어터의 조명입니다.
 *
 * <p><b>역할:</b> Subsystem (복잡한 내부 부품 ④)</p>
 *
 * @see HomeTheaterFacade
 */
public class LightsFacade {

    /**
     * 조명 밝기를 조절합니다.
     *
     * @param percent 밝기 (0~100%)
     */
    public void dim(int percent) {
        System.out.println("    조명 밝기 " + percent + "% 로 조절");
    }

    /** 조명을 100%로 켭니다. */
    public void on() {
        System.out.println("    조명 100% 켜기");
    }
}
