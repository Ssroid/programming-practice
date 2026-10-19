package org.sunms.designpattern.structural.facade;

/**
 * 프로젝터, 앰프, 플레이어, 조명을 대신 조작해 주는 "영화 보기 버튼"입니다.
 * 사용자는 {@link #watchMovie(String)}, {@link #endMovie()} 두 개만 알면 됩니다.
 *
 * <p><b>역할:</b> Facade (간단한 창구)<br>
 * 패턴 전체 설명은 {@link MainFacade#main(String[])}의 주석을 참고하세요.</p>
 *
 * <h2>왜 인터페이스가 없나?</h2>
 * <p>퍼사드 패턴의 목적은 "구현을 바꿔 끼우기"가 아니라 "복잡한 사용법을 단순하게 만들기"입니다.
 * 그래서 클래스 하나로도 패턴이 완성됩니다.
 * 다만 실무(스프링 Service 등)에서는 테스트나 교체를 위해
 * {@code interface HomeTheater { void watchMovie(String movie); ... }}를 두기도 합니다.</p>
 *
 * @see ProjectorFacade
 * @see AmplifierFacade
 * @see StreamingPlayerFacade
 * @see LightsFacade
 */
public class HomeTheaterFacade {

    // 퍼사드는 내부 부품들을 모두 알고 있습니다

    /** 조명 */
    private final LightsFacade lights;
    /** 프로젝터 */
    private final ProjectorFacade projector;
    /** 앰프 */
    private final AmplifierFacade amplifier;
    /** 스트리밍 플레이어 */
    private final StreamingPlayerFacade player;

    /**
     * 홈시어터를 구성하는 부품들을 받아 퍼사드를 만듭니다.
     *
     * @param lights    조명
     * @param projector 프로젝터
     * @param amplifier 앰프
     * @param player    스트리밍 플레이어
     */
    public HomeTheaterFacade(LightsFacade lights, ProjectorFacade projector,
                             AmplifierFacade amplifier, StreamingPlayerFacade player) {
        this.lights = lights;
        this.projector = projector;
        this.amplifier = amplifier;
        this.player = player;
    }

    /**
     * "영화 보기" 버튼 하나로 복잡한 과정을 순서대로 처리합니다.
     *
     * @param movie 볼 영화 제목
     */
    public void watchMovie(String movie) {
        System.out.println("  [홈시어터] 영화 볼 준비를 합니다...");
        lights.dim(10);
        projector.on();
        projector.setWideScreenMode();
        amplifier.on();
        amplifier.setSurroundSound();
        amplifier.setVolume(7);
        player.on();
        player.play(movie);
    }

    /**
     * "영화 끝" 버튼 하나로 정리합니다. (켤 때의 반대 순서)
     */
    public void endMovie() {
        System.out.println("  [홈시어터] 영화를 종료합니다...");
        player.stop();
        player.off();
        amplifier.off();
        projector.off();
        lights.on();
    }
}
