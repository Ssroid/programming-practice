package org.sunms.designpattern.creational.factorymethod;

/**
 * 아메리카노 전용 머신입니다.
 *
 * <p><b>역할:</b> Concrete Creator (구체적인 생성자)</p>
 *
 * <p>부모의 공통 흐름({@link CoffeeMachineFactoryMethod#order()})은 그대로 물려받고,
 * "무엇을 만들지({@link #createCoffee()})"만 결정합니다.</p>
 *
 * @see AmericanoFactoryMethod
 */
public class AmericanoMachineFactoryMethod extends CoffeeMachineFactoryMethod {

    /**
     * 아메리카노를 만듭니다. {@code new}는 오직 여기서만!
     *
     * @return 새 {@link AmericanoFactoryMethod} 객체
     */
    @Override
    protected CoffeeFactoryMethod createCoffee() {
        return new AmericanoFactoryMethod();
    }
}
