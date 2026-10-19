package org.sunms.designpattern.structural.decorator;

/**
 * 휘핑크림 추가 토핑입니다. (+700원)
 *
 * <p><b>역할:</b> Concrete Decorator (구체적인 포장지)</p>
 */
public class WhippedCreamDecorator extends ToppingDecorator {

    /**
     * 음료를 휘핑크림 토핑으로 감쌉니다.
     *
     * @param beverage 감쌀 음료
     */
    public WhippedCreamDecorator(BeverageDecorator beverage) {
        super(beverage);
    }

    /**
     * 안쪽 음료 설명 뒤에 ", 휘핑크림"을 덧붙입니다.
     *
     * @return 휘핑크림이 추가된 설명
     */
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 휘핑크림";
    }

    /**
     * 안쪽 음료 가격에 700원을 더합니다.
     *
     * @return 휘핑크림 가격이 더해진 가격
     */
    @Override
    public int getCost() {
        return beverage.getCost() + 700;
    }
}
