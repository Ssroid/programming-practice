package org.sunms.designpattern.structural.facade;

/**
 * 홈시어터의 스트리밍 플레이어입니다.
 *
 * <p><b>역할:</b> Subsystem (복잡한 내부 부품 ③)</p>
 *
 * @see HomeTheaterFacade
 */
public class StreamingPlayerFacade {

    /** 플레이어를 켭니다. */
    public void on() {
        System.out.println("    스트리밍 플레이어 ON");
    }

    /**
     * 영화를 재생합니다.
     *
     * @param movie 재생할 영화 제목
     */
    public void play(String movie) {
        System.out.println("    '" + movie + "' 재생 시작");
    }

    /** 재생을 정지합니다. */
    public void stop() {
        System.out.println("    재생 정지");
    }

    /** 플레이어를 끕니다. */
    public void off() {
        System.out.println("    스트리밍 플레이어 OFF");
    }
}
