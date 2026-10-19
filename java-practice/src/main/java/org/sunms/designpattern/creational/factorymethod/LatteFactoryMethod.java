package org.sunms.designpattern.creational.factorymethod;

/**
 * 실제로 만들어지는 커피 ② 카페라떼입니다.
 *
 * <p><b>역할:</b> Concrete Product (구체적인 제품)</p>
 *
 * @see CoffeeFactoryMethod
 * @see LatteMachineFactoryMethod
 */
public class LatteFactoryMethod implements CoffeeFactoryMethod {

    /**
     * {@inheritDoc}
     *
     * @return "카페라떼"
     */
    @Override
    public String getName() {
        return "카페라떼";
    }

    /**
     * 에스프레소 샷에 스팀 우유를 부어 카페라떼를 만듭니다.
     */
    @Override
    public void brew() {
        System.out.println("  에스프레소 샷 + 스팀 우유 → 카페라떼 완성");
    }
}
