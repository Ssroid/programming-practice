package org.sunms.designpattern.creational.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 앱 전체가 함께 쓰는 "설정 정보"를 보관하는 단 하나뿐인 객체입니다.
 *
 * <p><b>역할:</b> Singleton (실무형, 홀더 방식)<br>
 * 패턴 전체 설명은 {@link MainSingleton#main(String[])}의 주석을 참고하세요.</p>
 *
 * <h2>왜 인터페이스가 없나?</h2>
 * <p>싱글톤은 "객체를 몇 개 만들 것인가"를 통제하는 패턴이지,
 * "여러 구현을 바꿔 끼우는" 패턴이 아니기 때문에 추상화가 필수는 아닙니다.
 * 다만 실무에서는 테스트 때 가짜 설정으로 바꿔 끼우기 위해
 * {@code interface AppConfig}를 따로 두고 싱글톤 클래스가 그것을 구현하게 하기도 합니다.</p>
 *
 * <h2>홀더(Holder) 방식이란? (실무 권장)</h2>
 * <p>{@link BasicSingleton}의 문제(멀티 스레드에서 객체가 2개 생길 수 있음)를
 * 자바의 "클래스 로딩 규칙"을 이용해 깔끔하게 해결합니다.</p>
 * <ul>
 *   <li>안쪽 {@code static} 클래스({@code Holder})는 처음 사용될 때 딱 한 번만 로딩됩니다.</li>
 *   <li>클래스 로딩은 JVM이 알아서 스레드 안전하게 처리해 줍니다.</li>
 *   <li>→ {@code synchronized} 같은 복잡한 코드 없이도 안전하고, 필요할 때 생성(Lazy)됩니다.</li>
 * </ul>
 *
 * <p>(참고) 가장 간단하고 안전한 방법으로 enum 싱글톤도 있습니다.</p>
 * <pre>{@code
 * public enum AppConfig { INSTANCE; ... }
 * }</pre>
 *
 * @see BasicSingleton
 * @see MainSingleton
 */
public class AppConfigSingleton {

    /** 설정 값을 저장하는 공간입니다. (키 → 값) */
    private final Map<String, String> settings = new HashMap<>();

    /**
     * [1] {@code private} 생성자: 외부에서 {@code new} 금지!
     *
     * <p>기본 설정값(언어, 테마)을 로딩합니다. 딱 한 번만 실행됩니다.</p>
     */
    private AppConfigSingleton() {
        System.out.println("  [AppConfig] 설정 객체 생성 & 기본값 로딩 (딱 한 번만 실행됨)");
        settings.put("language", "한국어");
        settings.put("theme", "라이트 모드");
    }

    /**
     * [2] 유일한 객체를 품고 있는 홀더 클래스입니다.
     *
     * <p>{@link #getInstance()}가 처음 호출될 때 비로소 이 클래스가 로딩되면서
     * {@code INSTANCE}가 만들어집니다.</p>
     */
    private static class Holder {
        /** 유일한 객체. {@code final}이므로 한 번 만들어지면 절대 바뀌지 않습니다. */
        private static final AppConfigSingleton INSTANCE = new AppConfigSingleton();
    }

    /**
     * [3] 유일한 객체를 꺼내 주는 창구입니다.
     *
     * @return 프로그램 전체에서 하나뿐인 설정 객체
     */
    public static AppConfigSingleton getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 설정 값을 조회합니다.
     *
     * @param key 설정 이름 (예: {@code "language"})
     * @return 설정 값. 없으면 {@code null}
     */
    public String get(String key) {
        return settings.get(key);
    }

    /**
     * 설정 값을 변경합니다.
     *
     * @param key   설정 이름 (예: {@code "language"})
     * @param value 새로운 설정 값
     */
    public void set(String key, String value) {
        System.out.println("  [AppConfig] '" + key + "' 변경: " + settings.get(key) + " → " + value);
        settings.put(key, value);
    }
}
