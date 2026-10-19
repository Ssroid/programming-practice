package org.sunms.designpattern.creational.factorymethod;

/**
 * 라떼 전용 머신입니다.
 *
 * <p><b>역할:</b> Concrete Creator (구체적인 생성자)</p>
 *
 * <p>새 메뉴를 추가하고 싶다면? 이런 클래스를 하나 더 만들기만 하면 됩니다.
 * ({@link CoffeeMachineFactoryMethod}의 코드는 한 줄도 고칠 필요 없음!)</p>
 *
 * @see LatteFactoryMethod
 */
public class LatteMachineFactoryMethod extends CoffeeMachineFactoryMethod {

    /**
     * 카페라떼를 만듭니다.
     *
     * @return 새 {@link LatteFactoryMethod} 객체
     */
    @Override
    protected CoffeeFactoryMethod createCoffee() {
        return new LatteFactoryMethod();
    }
}
