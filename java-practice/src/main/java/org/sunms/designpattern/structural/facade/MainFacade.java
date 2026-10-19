package org.sunms.designpattern.structural.facade;

/**
 * 퍼사드 패턴 실행 예제입니다. (▶ 버튼으로 실행해 보세요)
 */
public class MainFacade {

    /**
     * <b>퍼사드 패턴(Facade Pattern)</b>: 복잡한 여러 부품을 다루는 일을,
     * 간단한 "창구(정문)" 하나로 묶어 주는 구조 패턴입니다. (Facade = 건물의 정면, 정문이라는 뜻)
     *
     * <h4>어떤 문제를 해결하나?</h4>
     * <p>홈시어터로 영화를 보려면...<br>
     * 조명 어둡게 → 프로젝터 켜기 → 와이드 모드 → 앰프 켜기 → 서라운드 설정
     * → 볼륨 조절 → 플레이어 켜기 → 영화 재생</p>
     * <p>→ 8단계를 매번 순서대로 직접 해야 합니다! 순서를 틀리면 오류, 사용자는 모든 기기를 알아야 합니다.</p>
     *
     * <h4>해결 방법</h4>
     * <p>"영화 보기" 버튼 하나({@code watchMovie})를 만들어서,
     * 그 안에서 복잡한 순서를 대신 처리해 줍니다.</p>
     *
     * <h4>실생활 비유</h4>
     * <ul>
     *   <li>만능 리모컨의 "영화 모드" 버튼</li>
     *   <li>식당에서 "A 세트 주세요" 한마디 → 주방(부품들)이 알아서 요리</li>
     * </ul>
     *
     * <h4>역할 정리</h4>
     * <ul>
     *   <li><b>Facade</b>: {@link HomeTheaterFacade} (간단한 창구)</li>
     *   <li><b>Subsystems</b>: {@link ProjectorFacade}, {@link AmplifierFacade},
     *       {@link StreamingPlayerFacade}, {@link LightsFacade}</li>
     *   <li><b>Client</b>: 퍼사드만 사용 (부품들을 몰라도 됨)</li>
     * </ul>
     * <p>※ 퍼사드는 "단순화"가 목적이라 인터페이스가 필수는 아닙니다. ({@link HomeTheaterFacade} 주석 참고)</p>
     *
     * <h4>주의</h4>
     * <p>퍼사드는 부품을 "숨기는" 게 아니라 "편한 길을 하나 더" 만드는 것입니다.
     * 세밀한 조정이 필요하면 부품을 직접 써도 됩니다.</p>
     *
     * <h4>장단점</h4>
     * <ul>
     *   <li><b>장점</b>: 사용이 간단해짐, 클라이언트와 내부 부품 사이의 의존성 감소</li>
     *   <li><b>단점</b>: 퍼사드에 기능이 너무 몰리면 "모든 걸 다 하는 거대한 클래스"가 될 수 있음</li>
     * </ul>
     *
     * <h4>실무 예시</h4>
     * <ul>
     *   <li>스프링의 Service 계층: 여러 Repository, 외부 API 호출을 하나의 메서드로 묶음<br>
     *       예) {@code orderService.placeOrder()} → 재고 확인 + 결제 + 배송 등록 + 알림 발송</li>
     *   <li>SLF4J: 여러 로깅 라이브러리를 하나의 간단한 API로 사용</li>
     * </ul>
     *
     * @param args 실행 인자 (사용하지 않음)
     */
    public static void main(String[] args) {
        // 부품 준비
        LightsFacade lights = new LightsFacade();
        ProjectorFacade projector = new ProjectorFacade();
        AmplifierFacade amplifier = new AmplifierFacade();
        StreamingPlayerFacade player = new StreamingPlayerFacade();

        System.out.println("===== 1. 퍼사드 없이 직접 조작 (사용자가 모든 순서를 알아야 함) =====");
        lights.dim(10);
        projector.on();
        projector.setWideScreenMode();
        amplifier.on();
        amplifier.setSurroundSound();
        amplifier.setVolume(7);
        player.on();
        player.play("인터스텔라");
        System.out.println("  → 영화 하나 보는데 8줄... 다른 화면에서도 쓰려면 또 복사해야 함");

        System.out.println();
        System.out.println("===== 2. 퍼사드 사용 (버튼 하나!) =====");
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(lights, projector, amplifier, player);
        homeTheater.watchMovie("인터스텔라");   // ← 한 줄!

        System.out.println();
        homeTheater.endMovie();                 // ← 한 줄!
    }
}
