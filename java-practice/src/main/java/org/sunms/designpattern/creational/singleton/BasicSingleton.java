package org.sunms.designpattern.creational.singleton;

/**
 * 싱글톤 패턴의 원리를 보여주는 가장 기본적인 형태입니다.
 *
 * <p><b>역할:</b> Singleton (원리 이해용 기본형)</p>
 *
 * <p>"이 클래스의 객체는 프로그램 전체에서 딱 1개만 존재한다."<br>
 * 패턴 전체 설명은 {@link MainSingleton#main(String[])}의 주석을 참고하세요.</p>
 *
 * <h2>싱글톤을 만드는 3가지 핵심 규칙</h2>
 * <ol>
 *   <li>생성자를 {@code private}으로 막는다 → 밖에서 {@code new}로 만들 수 없게</li>
 *   <li>자기 자신을 담는 {@code static} 변수를 둔다 → 유일한 객체를 보관할 곳</li>
 *   <li>{@code static getInstance()} 메서드를 둔다 → 그 유일한 객체를 꺼내 주는 창구</li>
 * </ol>
 *
 * <h2>주의!</h2>
 * <p>이 기본 형태는 "멀티 스레드" 환경에서 안전하지 않습니다.
 * 두 스레드가 동시에 {@link #getInstance()}를 호출하면 객체가 2개 만들어질 수 있습니다.</p>
 * <ul>
 *   <li>실무에서는 {@link AppConfigSingleton}처럼 만드는 것을 권장합니다.</li>
 *   <li>이 클래스는 "원리 이해용"입니다.</li>
 * </ul>
 *
 * @see AppConfigSingleton
 * @see MainSingleton
 */
public class BasicSingleton {

    /**
     * [규칙 2] 유일한 객체를 저장할 {@code static} 변수입니다.
     * <ul>
     *   <li>{@code static}: 클래스에 딱 하나만 존재하는 변수 (객체마다 따로 생기지 않음)</li>
     *   <li>처음에는 {@code null} (아직 안 만들어짐)</li>
     * </ul>
     */
    private static BasicSingleton instance;

    /**
     * [규칙 1] {@code private} 생성자입니다.
     *
     * <p>다른 클래스에서 {@code new BasicSingleton()}을 하면 컴파일 에러가 납니다.
     * 즉, 객체를 만들 수 있는 곳은 "이 클래스 내부"뿐입니다.</p>
     */
    private BasicSingleton() {
        System.out.println("  [BasicSingleton] 객체가 생성되었습니다! (이 메시지는 딱 한 번만 보여야 함)");
    }

    /**
     * [규칙 3] 유일한 객체를 돌려주는 창구입니다.
     *
     * <p>{@code static}이므로 객체 없이 {@code BasicSingleton.getInstance()}로 호출할 수 있습니다.
     * 처음 호출될 때 비로소 객체를 만드는 이 방식을 "게으른 초기화(Lazy Initialization)"라고 합니다.</p>
     *
     * @return 프로그램 전체에서 하나뿐인 {@code BasicSingleton} 객체
     */
    public static BasicSingleton getInstance() {
        // 아직 객체가 없을 때만 새로 만든다
        if (instance == null) {
            instance = new BasicSingleton();   // 클래스 내부라서 private 생성자 호출 가능
        }
        // 이미 있으면 기존 객체를 그대로 돌려준다
        return instance;
    }

    /**
     * 하나뿐인 객체가 인사말을 출력합니다.
     */
    public void hello() {
        System.out.println("  [BasicSingleton] 안녕하세요! 저는 하나뿐인 객체입니다.");
    }
}
