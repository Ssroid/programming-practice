package org.sunms.designpattern.creational.builder;

/**
 * 자주 주문되는 "정해진 메뉴"의 조립 순서를 알고 있는 담당자입니다.
 *
 * <p><b>역할:</b> Director (감독, 선택 사항)</p>
 *
 * <p>손님이 "불고기버거 주세요"라고만 하면, 재료를 일일이 말하지 않아도 됩니다.
 * Director는 GoF 원본 빌더 패턴의 구성 요소지만,
 * 실무(Lombok {@code @Builder} 등)에서는 생략하는 경우가 많습니다.</p>
 *
 * @see BurgerBuilder
 */
public class BurgerDirectorBuilder {

    /**
     * 정해진 레시피로 불고기버거를 만듭니다.
     *
     * @return 완성된 불고기버거
     */
    public BurgerProductBuilder makeBulgogiBurger() {
        return new BurgerBuilder("참깨빵", "불고기 패티")
                .lettuce()
                .sauce("불고기 소스")
                .build();
    }

    /**
     * 정해진 레시피로 치즈버거를 만듭니다.
     *
     * @return 완성된 치즈버거
     */
    public BurgerProductBuilder makeCheeseBurger() {
        return new BurgerBuilder("브리오슈빵", "소고기 패티")
                .cheese()
                .extra("치즈 한 장 더")
                .sauce("케첩")
                .build();
    }
}
