package org.sunms.designpattern.creational.factorymethod;

/**
 * "공장(커피 머신)에서 만들어질 물건"의 공통 규격입니다.
 *
 * <p><b>역할:</b> Product (제품의 공통 규격)<br>
 * 패턴 전체 설명은 {@link MainFactoryMethod#main(String[])}의 주석을 참고하세요.</p>
 *
 * <h2>이 인터페이스는 무엇인가?</h2>
 * <p>아메리카노든 라떼든, 모든 커피는 이 인터페이스를 구현합니다.</p>
 *
 * <h2>왜 인터페이스가 필요한가?</h2>
 * <p>커피 머신의 {@link CoffeeMachineFactoryMethod#order()}는 "어떤 커피가 나올지" 미리 알 수 없습니다.
 * (그건 자식 머신이 {@code createCoffee()}에서 결정하니까요)
 * 그래서 {@code order()}는 "아무 커피나 받을 수 있는 타입"이 필요하고, 그게 바로 이 인터페이스입니다.</p>
 * <pre>{@code
 * CoffeeFactoryMethod coffee = createCoffee();   // 아메리카노든 라떼든 OK
 * coffee.brew();                                 // 각자 알아서 자기 방식으로 추출
 * }</pre>
 *
 * <h2>왜 추상화가 필요한가? (인터페이스가 없다면?)</h2>
 * <p>{@code createCoffee()}의 반환 타입을 {@code AmericanoFactoryMethod}로 적어야 하고,
 * 그러면 라떼 머신은 아예 만들 수 없습니다.<br>
 * → "구체적인 것"이 아니라 "공통 규격"에 의존해야 새 커피를 자유롭게 추가할 수 있습니다.</p>
 *
 * @see AmericanoFactoryMethod
 * @see LatteFactoryMethod
 * @see CoffeeMachineFactoryMethod#order()
 */
public interface CoffeeFactoryMethod {

    /**
     * 커피 이름을 알려줍니다.
     *
     * @return 커피 이름 (예: "아메리카노")
     */
    String getName();

    /**
     * 커피를 추출합니다(만듭니다).
     */
    void brew();
}
