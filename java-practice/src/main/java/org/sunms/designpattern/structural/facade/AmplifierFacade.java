package org.sunms.designpattern.structural.facade;

/**
 * 홈시어터의 앰프(스피커)입니다.
 *
 * <p><b>역할:</b> Subsystem (복잡한 내부 부품 ②)</p>
 *
 * @see HomeTheaterFacade
 */
public class AmplifierFacade {

    /** 앰프를 켭니다. */
    public void on() {
        System.out.println("    앰프 ON");
    }

    /** 5.1 채널 서라운드 모드로 설정합니다. */
    public void setSurroundSound() {
        System.out.println("    앰프 5.1 채널 서라운드 모드 설정");
    }

    /**
     * 볼륨을 설정합니다.
     *
     * @param level 볼륨 크기
     */
    public void setVolume(int level) {
        System.out.println("    앰프 볼륨 " + level + " 으로 설정");
    }

    /** 앰프를 끕니다. */
    public void off() {
        System.out.println("    앰프 OFF");
    }
}
