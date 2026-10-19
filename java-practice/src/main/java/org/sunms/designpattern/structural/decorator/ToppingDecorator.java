package org.sunms.designpattern.structural.decorator;

/**
 * 우유, 샷, 휘핑크림 같은 모든 "토핑 포장지"의 부모 클래스입니다.
 *
 * <p><b>역할:</b> Decorator (포장지의 공통 틀)</p>
 *
 * <h2>두 가지 특징을 동시에 가집니다</h2>
 * <ol>
 *   <li>{@code implements BeverageDecorator} → 나 자신도 "음료"다 (그래서 또 포장될 수 있음)</li>
 *   <li>{@code BeverageDecorator} 필드를 가짐 → 안쪽에 "다른 음료"를 품고 있다</li>
 * </ol>
 *
 * <h2>왜 인터페이스가 아니라 "추상 클래스"인가?</h2>
 * <p>모든 포장지는 "안쪽 음료를 보관하는 필드 + 그걸 받는 생성자"가 똑같이 필요합니다.
 * 인터페이스는 필드(상태)를 가질 수 없기 때문에, 이 공통 코드를 담으려면 추상 클래스가 필요합니다.</p>
 *
 * <h2>왜 추상화가 필요한가? (추상 클래스가 없다면?)</h2>
 * <p>{@link MilkDecorator}, {@link ShotDecorator}, {@link WhippedCreamDecorator}가
 * 각자 똑같은 필드와 생성자를 반복 작성해야 합니다.
 * 또한 {@code abstract}이므로 "그냥 토핑"이라는 실체 없는 객체를 {@code new}로 만드는 실수도 막아 줍니다.</p>
 *
 * @see BeverageDecorator
 */
public abstract class ToppingDecorator implements BeverageDecorator {

    /** 감싸고 있는 안쪽 음료 (자식 클래스가 쓸 수 있도록 {@code protected}) */
    protected final BeverageDecorator beverage;

    /**
     * 안쪽 음료를 받아 보관합니다.
     *
     * @param beverage 감쌀 음료 (기본 음료 또는 이미 포장된 음료)
     */
    protected ToppingDecorator(BeverageDecorator beverage) {
        this.beverage = beverage;
    }
}
