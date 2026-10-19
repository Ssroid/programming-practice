package org.sunms.designpattern.structural.decorator;

/**
 * 우유 추가 토핑입니다. (+500원)
 *
 * <p><b>역할:</b> Concrete Decorator (구체적인 포장지)</p>
 *
 * <h2>동작 방식: "안쪽 음료의 결과" + "내 몫"</h2>
 * <ul>
 *   <li>설명: 안쪽 설명 + ", 우유"</li>
 *   <li>가격: 안쪽 가격 + 500</li>
 * </ul>
 */
public class MilkDecorator extends ToppingDecorator {

    /**
     * 음료를 우유 토핑으로 감쌉니다.
     *
     * @param beverage 감쌀 음료
     */
    public MilkDecorator(BeverageDecorator beverage) {
        super(beverage);   // 감쌀 음료를 부모에게 전달해서 보관
    }

    /**
     * 안쪽 음료 설명 뒤에 ", 우유"를 덧붙입니다.
     *
     * @return 우유가 추가된 설명
     */
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 우유";   // 안쪽에 먼저 물어보고 + 내 것 덧붙이기
    }

    /**
     * 안쪽 음료 가격에 500원을 더합니다.
     *
     * @return 우유 가격이 더해진 가격
     */
    @Override
    public int getCost() {
        return beverage.getCost() + 500;
    }
}
