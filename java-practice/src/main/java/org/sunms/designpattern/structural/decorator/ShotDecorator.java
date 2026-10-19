package org.sunms.designpattern.structural.decorator;

/**
 * 에스프레소 샷 추가 토핑입니다. (+600원)
 *
 * <p><b>역할:</b> Concrete Decorator (구체적인 포장지)</p>
 */
public class ShotDecorator extends ToppingDecorator {

    /**
     * 음료를 샷 추가 토핑으로 감쌉니다.
     *
     * @param beverage 감쌀 음료
     */
    public ShotDecorator(BeverageDecorator beverage) {
        super(beverage);
    }

    /**
     * 안쪽 음료 설명 뒤에 ", 샷 추가"를 덧붙입니다.
     *
     * @return 샷이 추가된 설명
     */
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 샷 추가";
    }

    /**
     * 안쪽 음료 가격에 600원을 더합니다.
     *
     * @return 샷 가격이 더해진 가격
     */
    @Override
    public int getCost() {
        return beverage.getCost() + 600;
    }
}
