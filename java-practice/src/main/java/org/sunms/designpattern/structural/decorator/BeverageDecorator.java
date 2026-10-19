package org.sunms.designpattern.structural.decorator;

/**
 * "음료라면 설명({@link #getDescription()})과 가격({@link #getCost()})을 알려줄 수 있어야 한다"는 규격입니다.
 *
 * <p><b>역할:</b> Component (알맹이와 포장지의 공통 규격)<br>
 * 패턴 전체 설명은 {@link MainDecorator#main(String[])}의 주석을 참고하세요.</p>
 *
 * <h2>이 인터페이스는 무엇인가?</h2>
 * <p>기본 음료(아메리카노)도, 토핑 포장지(우유, 샷, 휘핑)도 모두 이 규격을 구현합니다.</p>
 *
 * <h2>왜 인터페이스가 필요한가? ★ 데코레이터 패턴의 핵심 ★</h2>
 * <p>알맹이와 포장지가 "같은 타입"이어야 겹겹이 감쌀 수 있기 때문입니다.</p>
 * <pre>{@code
 * BeverageDecorator coffee = new AmericanoDecorator();   // 음료
 * coffee = new MilkDecorator(coffee);                     // 포장된 것도 음료
 * coffee = new ShotDecorator(coffee);                     // 또 포장해도 여전히 음료
 * }</pre>
 * <ul>
 *   <li>포장지의 생성자는 {@code BeverageDecorator}를 받음 → 알맹이든 이미 포장된 것이든 다 받을 수 있음</li>
 *   <li>포장지 자신도 {@code BeverageDecorator} → 다른 포장지에 또 들어갈 수 있음</li>
 * </ul>
 *
 * <h2>왜 추상화가 필요한가? (인터페이스가 없다면?)</h2>
 * <p>{@code MilkDecorator}가 {@code new MilkDecorator(AmericanoDecorator americano)}처럼 구체 클래스를 받으면
 * "우유 추가한 아메리카노"에 다시 샷을 추가할 수 없습니다. (타입이 안 맞으니까)</p>
 * <ul>
 *   <li>→ 결국 {@code AmericanoWithMilkAndShot} 같은 조합 클래스를 일일이 만들어야 하는 "클래스 폭발"로 돌아갑니다.</li>
 *   <li>→ 공통 인터페이스 덕분에 사용하는 쪽({@code printOrder})도 몇 겹 포장됐는지 신경 쓰지 않고
 *       {@code getCost()} 한 번만 호출하면 됩니다.</li>
 * </ul>
 *
 * @see AmericanoDecorator
 * @see ToppingDecorator
 */
public interface BeverageDecorator {

    /**
     * 음료 설명을 알려줍니다.
     *
     * @return 음료 설명 (예: "아메리카노, 우유")
     */
    String getDescription();

    /**
     * 음료 가격을 알려줍니다.
     *
     * @return 가격 (원)
     */
    int getCost();
}
