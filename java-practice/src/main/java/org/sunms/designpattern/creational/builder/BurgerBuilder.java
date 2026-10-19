package org.sunms.designpattern.creational.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 햄버거 재료를 하나씩 받아 두었다가, {@link #build()}를 부르면 완성품을 만들어 줍니다.
 *
 * <p><b>역할:</b> Builder (조립 담당)</p>
 *
 * <h2>핵심 포인트: 메서드 체이닝(Method Chaining)</h2>
 * <p>각 메서드가 {@code return this;}로 자기 자신을 돌려주기 때문에
 * 점({@code .})으로 계속 이어 쓸 수 있습니다.</p>
 * <pre>{@code
 * new BurgerBuilder("참깨빵", "소고기 패티")
 *         .cheese()
 *         .tomato()
 *         .sauce("케첩")
 *         .build();
 * }</pre>
 *
 * @see BurgerProductBuilder
 */
public class BurgerBuilder {

    // 아래 필드들은 같은 패키지의 BurgerProductBuilder 가 값을 읽어 갈 수 있도록 package-private 입니다.

    /** 빵 (필수) */
    final String bun;
    /** 패티 (필수) */
    final String patty;
    /** 치즈 추가 여부 (기본값: 추가 안 함) */
    boolean cheese = false;
    /** 양상추 추가 여부 (기본값: 추가 안 함) */
    boolean lettuce = false;
    /** 토마토 추가 여부 (기본값: 추가 안 함) */
    boolean tomato = false;
    /** 소스 (기본값: 없음) */
    String sauce = null;
    /** 추가 토핑 목록 */
    final List<String> extras = new ArrayList<>();

    /**
     * 필수 값(빵, 패티)을 받아 빌더를 만듭니다.
     * 빵이나 패티 없는 햄버거는 애초에 만들 수 없도록 생성자로 받습니다.
     *
     * @param bun   빵 종류
     * @param patty 패티 종류
     */
    public BurgerBuilder(String bun, String patty) {
        this.bun = bun;
        this.patty = patty;
    }

    /**
     * 치즈를 추가합니다.
     *
     * @return 이 빌더 자신 (체이닝용)
     */
    public BurgerBuilder cheese() {
        this.cheese = true;
        return this;            // ← 자기 자신을 반환해야 체이닝 가능!
    }

    /**
     * 양상추를 추가합니다.
     *
     * @return 이 빌더 자신 (체이닝용)
     */
    public BurgerBuilder lettuce() {
        this.lettuce = true;
        return this;
    }

    /**
     * 토마토를 추가합니다.
     *
     * @return 이 빌더 자신 (체이닝용)
     */
    public BurgerBuilder tomato() {
        this.tomato = true;
        return this;
    }

    /**
     * 소스를 선택합니다.
     *
     * @param sauce 소스 이름
     * @return 이 빌더 자신 (체이닝용)
     */
    public BurgerBuilder sauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    /**
     * 추가 토핑을 넣습니다. 여러 번 호출하면 여러 개가 들어갑니다.
     *
     * @param topping 토핑 이름
     * @return 이 빌더 자신 (체이닝용)
     */
    public BurgerBuilder extra(String topping) {
        this.extras.add(topping);
        return this;
    }

    /**
     * 조립을 완료하고 최종 제품을 만들어 반환합니다.
     * 여기서 "값 검증"을 하기 좋습니다.
     *
     * @return 완성된 햄버거
     * @throws IllegalStateException 빵이나 패티가 없을 때
     */
    public BurgerProductBuilder build() {
        if (bun == null || patty == null) {
            throw new IllegalStateException("빵과 패티는 필수입니다!");
        }
        return new BurgerProductBuilder(this);
    }
}
