package org.sunms.designpattern.creational.builder;

import java.util.List;

/**
 * 빌더({@link BurgerBuilder})가 조립을 끝내고 {@code build()} 했을 때 나오는 "완성된 햄버거"입니다.
 *
 * <p><b>역할:</b> Product (완성품)<br>
 * 패턴 전체 설명은 {@link MainBuilder#main(String[])}의 주석을 참고하세요.</p>
 *
 * <h2>특징</h2>
 * <ul>
 *   <li>모든 필드가 {@code final} + setter 없음 → 한 번 만들어지면 바꿀 수 없는 "불변 객체"</li>
 *   <li>생성자가 package-private → 빌더를 거치지 않고는 만들 수 없음</li>
 * </ul>
 *
 * <h2>왜 인터페이스가 없나?</h2>
 * <p>빌더 패턴의 목적은 "여러 구현을 바꿔 끼우기"가 아니라 "복잡한 객체를 읽기 쉽게 조립하기"입니다.
 * 그래서 제품도, 빌더도 구체 클래스 하나로 충분한 경우가 많습니다.</p>
 *
 * @see BurgerBuilder
 * @see BurgerDirectorBuilder
 */
public class BurgerProductBuilder {

    /** 빵 (필수) */
    private final String bun;
    /** 패티 (필수) */
    private final String patty;
    /** 치즈 추가 여부 (선택) */
    private final boolean cheese;
    /** 양상추 추가 여부 (선택) */
    private final boolean lettuce;
    /** 토마토 추가 여부 (선택) */
    private final boolean tomato;
    /** 소스 (선택, 없으면 {@code null}) */
    private final String sauce;
    /** 추가 토핑 목록 (선택) */
    private final List<String> extras;

    /**
     * 빌더에 모아 둔 재료로 햄버거를 완성합니다.
     *
     * <p>생성자를 {@code public}이 아닌 "package-private"(접근제어자 없음)으로 둡니다.
     * 같은 패키지의 {@link BurgerBuilder}만 호출할 수 있으므로,
     * "빌더를 통해서만" 버거를 만들 수 있게 강제합니다.</p>
     *
     * @param builder 재료가 담긴 빌더
     */
    BurgerProductBuilder(BurgerBuilder builder) {
        this.bun = builder.bun;
        this.patty = builder.patty;
        this.cheese = builder.cheese;
        this.lettuce = builder.lettuce;
        this.tomato = builder.tomato;
        this.sauce = builder.sauce;
        this.extras = List.copyOf(builder.extras); // 복사본을 저장 → 빌더를 나중에 바꿔도 영향 없음
    }

    /**
     * 빵 종류를 알려줍니다. (getter만 있고 setter는 없음 → 완성 후 변경 불가)
     *
     * @return 빵 종류
     */
    public String getBun() { return bun; }

    /**
     * 패티 종류를 알려줍니다.
     *
     * @return 패티 종류
     */
    public String getPatty() { return patty; }

    /**
     * 햄버거 구성을 보기 좋게 문자열로 만듭니다.
     *
     * @return 햄버거 구성 정보
     */
    @Override
    public String toString() {
        return "햄버거 [빵=" + bun
                + ", 패티=" + patty
                + ", 치즈=" + (cheese ? "O" : "X")
                + ", 양상추=" + (lettuce ? "O" : "X")
                + ", 토마토=" + (tomato ? "O" : "X")
                + ", 소스=" + (sauce == null ? "없음" : sauce)
                + ", 추가토핑=" + extras + "]";
    }
}
